package app;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private int age;
    private double gpa;
    private List<Student> friends;

    public Student(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
        this.friends = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    public List<Student> getFriends() {
        return friends;
    }

    public void addFriend(Student friend) {
        this.friends.add(friend);
    }
}

