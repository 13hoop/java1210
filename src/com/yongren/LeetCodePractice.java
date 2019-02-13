package com.yongren;

class Dog {
    private final String name;

    Dog(String name) {
        this.name = name;
    }

//    public void setName(String name) {
//        this.name = name;
//    }

    public String getName() {
        return name;
    }
}

class Person {

    private String name;
    Person(Dog dog) {
        this.dog = dog;
    }

    void setName(String str) {
        this.name = str;
        this.add();
    }
    String getName() {
        return this.name;
    }

    // 不要尝试对 可变类 声明为final，即 如果想使用final，一定要确认使用者 是 基本数据类型 或 不可变的类
    final Dog dog;

    public static int getNum() {
        return num;
    }

    // static 标示了 类领
    static int num = 0;
    void add() {
        num += 1;
    }
}

public class LeetCodePractice {


    static void staticDemo() {
        Dog d = new Dog("aaaa");
        Person p = new Person(d);
        System.out.println(p.dog);

        Dog e = p.dog;
//        e.setName("bbbbb");
        System.out.println(" --->" + p.dog.getName());

//        System.out.println(Person.num);
    }

    static int[] twoSumDemo() {
        int[] nums = {3,2,5};
        int target = 6;

        for (int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length ; j++) {
                System.out.println("[ " + i +" ~~" + j +" ]");
                if(nums[i] + nums[j] == target) {
                    System.out.println("[ " + i +" ," + j +" ]");
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    static int[] twoSumDemo2() {
        int[] nums = {3,2,5};
        int target = 6;

        for (int i = 0; i < nums.length; i++) {

        }
        return null;
    }

    public static void main(String[] args) {
//        twoSumDemo2();
        staticDemo();
    }
}
