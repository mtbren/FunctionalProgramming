package com.custom;

import java.util.List;

class Course{
    private String name;

    private String category;
    private int reviewScore;
    private int noOfStudents;

    public Course(String name, String category, int reviewScore, int noOfStudents) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.noOfStudents = noOfStudents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", noOfStudents=" + noOfStudents +
                '}';
    }
}
public class FPCustom {
    public static void main(String[] args) {
        List<Course> courses = List.of(
                new Course("Spring","Framework",98,20000),
                new Course("Spring Boot","Framework",95,18000),
                new Course("API","Microservices",95,22000),
                new Course("Microservices","Microservices",96,25000),
                new Course("Fullstack","Fullstack",91,14000),
                new Course("AWS","Cloud",92,21000),
                new Course("Azure","Cloud",99,21000),
                new Course("Docker","DevOps",92,20000),
                new Course("Kubernetes","DevOps",91,20000)
        );

        // allMatch checks whether all the stream elements satisfy a condition
        System.out.println(courses.stream()
                .allMatch(course -> course.getReviewScore()>95)); // false
        System.out.println(courses.stream()
                .allMatch(course -> course.getNoOfStudents()>10000)); // true


        // noneMatch checks whether none of the stream elements satisfy a condition
        System.out.println(courses.stream()
                .noneMatch(course -> course.getReviewScore() > 99)); // true
        System.out.println(courses.stream()
                .noneMatch(course -> course.getNoOfStudents() < 20000)); // false

        // anyMatch checks whether any of the stream elements satisfy a condition
        System.out.println(courses.stream()
                .anyMatch(course -> course.getReviewScore() > 95)); // true
        System.out.println(courses.stream()
                .anyMatch(course -> course.getNoOfStudents() > 50000)); // false

    }
}
