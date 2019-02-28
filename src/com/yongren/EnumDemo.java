package com.yongren;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;
import javax.swing.Timer;

enum YRSize {
    SMALL("S"),NORMAL("N"),LARGE("L"),EXTRA_LARGE("EL");

    private String addrevitation;
    YRSize(String addrevitation) {
        this.addrevitation = addrevitation;
    }
    public String getAddrevitation() {
        return addrevitation;
    }

    @Override
    public String toString() {
        return "~~ " + this.addrevitation;
    }
}

class YRPerson {

    private String name;
    private int age;

    YRPerson(String name, int age) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}

class TalkingClock {
    private int inteval;
    private boolean isBeeping;
    class TimerPrint implements ActionListener { // inner 实现了接口，而不是 outter
        @Override
        public void actionPerformed(ActionEvent e) {
            Date now = new Date();
            System.out.println(" --- " + now);
            if(isBeeping) Toolkit.getDefaultToolkit().beep(); // inner 访问到了 outter属性， 即便它是 private的
        }
    }

    TalkingClock(int inteval, boolean isBeeping) {
        this.inteval = inteval;
        this.isBeeping = isBeeping;
    }

    void start() {
        TimerPrint tpLister = new TimerPrint();

        System.out.println(" --- start --- " + tpLister.getClass().getName());
        Timer t = new Timer(inteval, tpLister);
        t.start();
    }
}

class TranceHandler implements InvocationHandler{

    private Object target;
    public TranceHandler (Object t){
        this.target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(target + " " + method.getName() + " " + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print("" + args[i]);
                if(i < args.length - 1) System.out.print(", ");
            }
        }
        System.out.println(")");
        return method.invoke(target, args);
    }
}

public class EnumDemo {

    public static void main(String[] args) {
        proxyDemo();
//        innnerClassDemo();
//        reflectionDemo();
//        enmuDemo();

    }

    static void proxyDemo() {

        Object[] el = new Object[100];
        for (int i = 0; i < el.length; i++) {
            Integer v = i + 1;
            InvocationHandler handler = new TranceHandler(v);
            Object proxy = Proxy.newProxyInstance(null, new Class[] {Comparable.class}, handler);
            el[i] = proxy;
        }

        Integer key = new Random().nextInt(el.length) + 1;
        int result = Arrays.binarySearch(el, key);
        if(result >= 0) System.out.println(el[result]);
    }

    static void innnerClassDemo() {
        TalkingClock clock = new TalkingClock(2,true);
        clock.start();
    }

    static void reflectionDemo() {

        YRPerson p = new YRPerson("KOBE", 36);

        Class aClass = p.getClass();
        String name = aClass.getName();
        System.out.println("----- " + name +  " extended: " + aClass.getSuperclass().getName() +"-------");

        // 类的信息查看
        for(Field af: aClass.getDeclaredFields()) {
            String modifier = Modifier.toString(af.getModifiers());
            System.out.println("[F]--> " + modifier + " " + af.getName());
        }

        for(Constructor aC: aClass.getDeclaredConstructors()) {
            System.out.println("[C]--> " + Modifier.toString(aC.getModifiers()) + aC.getName());
        }

        for(Method aM: aClass.getMethods()) {
            System.out.println("[M]--> " + Modifier.toString(aM.getModifiers()) + " " + aM.getReturnType().getName() + " " + aM.getName());
        }

        // 方法调用
        try {
            Method m = aClass.getMethod("setName", String.class);
            try {
                m.invoke(p, "LAKERS");
                System.out.println("invoke test here: " + p.getName());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }


    static void enmuDemo() {

//        YRSize s = new YRSize("EL");

        YRSize[] els = YRSize.values();
        for (YRSize el: els) {
            System.out.println(el.ordinal() + " " + el.toString());
        }

//        ERROR: IllegalArgumentException: No enum constant com.yongren.YRSize.a
//        System.out.println(YRSize.valueOf(YRSize.class, "a").toString());
        System.out.println(YRSize.valueOf(YRSize.class, "SMALL").toString());

        Scanner in = new Scanner(System.in);
        System.out.println(" --- input a :");
        String input = in.next();

        switch (Integer.parseInt(input)) {
            case 0:
                System.out.println(YRSize.SMALL);
                break;
            case 1:
                System.out.println(YRSize.NORMAL);
                break;
            case 2:
                System.out.println(YRSize.LARGE);
                break;
            default:
                System.out.println(YRSize.EXTRA_LARGE);
                break;
        }
    }
}
