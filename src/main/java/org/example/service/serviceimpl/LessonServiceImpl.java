package org.example.service.serviceimpl;

import org.hibernate.HibernateException;
import org.example.dao.daoimpl.LessonDaoImpl;
import org.example.entity.Lesson;
import org.example.service.LessonService;

import java.util.List;

public class LessonServiceImpl implements LessonService {
    private LessonDaoImpl lessonDao = new LessonDaoImpl();
    @Override
    public void saveLesson(Lesson lesson, Long course_id) {
        try {
            lessonDao.saveLesson(lesson, course_id);
            System.out.println("Saved lesson successfully!");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateLesson(Long id, Lesson lesson) {
        try {
            lessonDao.updateLesson(id, lesson);
            System.out.println("Updated lesson successfully!");
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Lesson getLessonById(Long id) {
        try {
            return lessonDao.getLessonById(id);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Lesson> getLessonsByCourseId(Long course_id) {
        try {
            return lessonDao.getLessonsByCourseId(course_id);
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }
}
