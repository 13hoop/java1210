package com.yongren;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static java.lang.System.out;

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
        out.println(" --->" + p.dog.getName());

//        System.out.println(Person.num);
    }



    /// 时间复杂度：O(n2)
    /// 空间复杂度：O(1)
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

    /// 时间复杂度：O(n)
    /// 空间复杂度：O(n)
    static int[] twoSumDemo2() {
        int[] nums = {3,3};
        int target = 6;
        Map<Integer, Integer> map= new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i=0; i<nums.length;i++) {
            int other = target - nums[i];
            if(map.containsKey(other) && map.get(other) != i) {
                System.out.println("[ " + i +" ," + map.get(other) +" ]");
                return new int[]{i, map.get(other)};
            }
        }
        return null;
    }

    /// 时间复杂度：O(n)
    /// 空间复杂度：O(n)
    static int[] twoSumDemo3() {
        int[] nums = {3, 3};
        int target = 6;
        Map<Integer, Integer> map= new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {

            int other = target - nums[i];
            if(map.containsKey(other)) {
                System.out.println("[ " + i +" ," + map.get(other) +" ]");
                return new int[]{i, map.get(other)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static void main(String[] args) {

//        addTwoLinklineNumsDemo();
//        twoSumDemo3();
//        twoSumDemo2();
//        staticDemo();
    }
}
