package com.custom;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

        /*courses.stream()
                .sorted((c1, c2) -> c1.getName().compareTo(c2.getName()))
                .forEach(System.out::println);*/

        Comparator<Course> reviewScoreComparator = Comparator.comparingInt(Course::getReviewScore);
        Comparator<Course> noOfStudentsComparatorIncreasing = new Comparator<Course>() {
            @Override
            public int compare(Course c1, Course c2) {
                return Integer.compare(c1.getNoOfStudents(), c2.getNoOfStudents());
            }
        };

        Comparator<Course> noOfStudentsComparatorDecreasing = Comparator.comparingInt(Course::getNoOfStudents).reversed();
        /*courses.stream()
                .sorted(noOfStudentsComparator)
                .forEach(System.out::println);*/

        /*courses.stream()
                .sorted(reviewScoreComparator)
                .forEach(System.out::println);*/

        System.out.println(
                courses.stream()
                        .sorted(noOfStudentsComparatorDecreasing)
                        .collect(Collectors.toList()));

        Comparator<Course> noOfStudentsReviewScoreComparator =
                Comparator.comparingInt(Course::getNoOfStudents).thenComparingInt(Course::getReviewScore).reversed();

        System.out.println(
                courses.stream()
                        .sorted(noOfStudentsReviewScoreComparator)
                        .collect(Collectors.toList()));


        // Take only 5
        System.out.println(
                courses.stream().limit(5).collect(Collectors.toList())
        );

        // Skip top 5
        System.out.println(
                courses.stream().skip(5).collect(Collectors.toList())
        );

        // Skip top 5 and get 2
        System.out.println(
                courses.stream()
                        .skip(5)
                        .limit(2)
                        .collect(Collectors.toList())
        );

        // Get all courses sorted by ReviewScore desc until you find a score < 95
        System.out.println(
                courses.stream()
                        .sorted(Comparator.comparing(Course::getReviewScore).reversed())
                        .takeWhile(course -> course.getReviewScore()>95)
                        .collect(Collectors.toList())
        );

        // Take a list of courses and display them only after you get the first element with noOfStudents = 21000
        System.out.println(
                courses.stream()
                        .dropWhile(course -> course.getNoOfStudents()!=21000)
                        .collect(Collectors.toList())
        );
    }
}
