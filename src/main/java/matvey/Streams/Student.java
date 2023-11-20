package matvey.Streams;

import examples.streams_10.Demo6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Student{
    String name;
    List<String> course;
    public Student(String name, List<String> course){
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public String getCourses(){
        return course.toString();
    }
    public String getAllCourses() {
        return Arrays.toString(course.toArray());
    }

    public int getCoursesLength(){
        return course.size();
    }
}
