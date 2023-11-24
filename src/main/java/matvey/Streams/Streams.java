package matvey.Streams;


import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    //Функция, принимающая список Student и возвращающая список уникальных курсов
    //на которые подписаны студенты

    //public void uniqCourse(List<Student> Students){
    //        List<String> allCourses = Students.stream()
    //              .flatMap(List::stream)
    //            .distinct()
    //          .toList();
    //allCourses.stream().distinct().forEach(System.out::println);
    //}

    //Функция принимающая список Student и возвращающая список самых любознательных
    //любознательность проверяется на количестве курсов

//    public void curiosStudents(List<Student> Students) {
//        Students.sort(
//                Comparator.comparing(Student::getCoursesLength, Comparator.reverseOrder())
//                        .thenComparing(student -> student.name)
//        );
//        Students.stream()
//                .map(it -> it.getName())
//                .limit(3)
//                .forEach(System.out::println);
//    }

    //Написать функцию принимающую на вход список Student и экземпляр Course,
    //возвращающую список студентов, которые посещают этот курс
    //public String coursePopularity(List<Student> Students,String courses) {
    //return Students.stream().filter(student -> student.getCourses().allMatch(Students::contains(courses)));
    //}
}
