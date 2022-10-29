package org.example;

import org.example.service.serviceimpl.CourseServiceImpl;
import org.example.service.serviceimpl.InstructorServiceImpl;
import org.example.service.serviceimpl.LessonServiceImpl;
import org.example.service.serviceimpl.TaskServiceImpl;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.entity.Lesson;
import org.example.entity.Task;
import org.example.util.Util;

import java.time.LocalDate;

public class App {
    public static void main( String[] args ) {
        CourseServiceImpl courseService = new CourseServiceImpl();
        InstructorServiceImpl instructorService = new InstructorServiceImpl();
        LessonServiceImpl lessonService = new LessonServiceImpl();
        TaskServiceImpl taskService = new TaskServiceImpl();
        Util.getConnection();

        Course course = new Course("Peaksoft School", 9, LocalDate.of(2022, 10, 29),
        "https://scontent.ffru1-3.fna.fbcdn.net/v/t39.30808-6/299575249_439555651530238_4141044783500990735_n.png?_nc_cat=104&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=7XkTs6fmCHcAX-xOsKv&_nc_ht=scontent.ffru1-3.fna&oh=00_AfClmqrxqMKxP6lzjKGPXZaab2I6upJSB-eK-mmctyGXiQ&oe=6362862D",
        "КУРСЫ ПРОГРАММИРОВАНИЯ |БИШКЕК IT ни үйрөнүп, жашооңду өзгөрт Программалоону кыргызча үйрөтөбүз 0 дон баштап 1-жумуш күнүнө чейин колдоо");

        Instructor instructor = new Instructor("Muhammed",
                "Allanov", "allanov32@gmail.com", 0500344433);

        Lesson lesson = new Lesson("Java-7",
                "https://www.youtube.com/watch?v=BRZAvpbydE8");

        Task task = new Task("Hibernate", "three day", "project relation ship");



//        courseService.saveCourse(course);

//        instructorService.saveInstructor(instructor);

//        instructorService.assignInstructorToCourse(1L, 1L);


//        lessonService.saveLesson(lesson, 1L);
//        taskService.saveTask(task);


    }
}
