package com.mxdl.datastruct;

/**
 * Description: <MyTask><br>
 * Author:      mxdl<br>
 * Date:        2019/7/19<br>
 * Version:     V1.0.0<br>
 * Update:     <br>
 */
public class MyTask implements Comparable<MyTask> {
    private String name;
    private int age;

    public MyTask(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(MyTask o) {
        return this.age > o.age ? 1 : -1;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
