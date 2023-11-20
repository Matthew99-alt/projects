package matvey.Streams;

import lombok.Getter;

import java.util.List;

public class Student {

    @Getter
    private final String name;

    private final List<Course> courses;

    public Student(String name, List<Course> courses) {
        this.name = name;
        this.courses = courses;
    }

    public List<Course> getAllCourses() {
        return courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courses=" + courses +
                '}';
    }
}
