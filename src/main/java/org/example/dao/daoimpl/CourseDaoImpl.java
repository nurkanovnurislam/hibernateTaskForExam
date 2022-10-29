package org.example.dao.daoimpl;

import jakarta.persistence.EntityManager;
import org.hibernate.HibernateException;
import org.example.dao.CourseDao;
import org.example.entity.Course;
import org.example.util.Util;

import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public void saveCourse(Course course) {
        try {
            EntityManager entityManager = Util.getConnection();
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            entityManager.close();
        } catch (HibernateException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Course getCourseById(Long id) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Get course successfully!");
        return course;
    }

    @Override
    public List<Course> getAllCourse() {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        List<Course> courses = entityManager
                .createQuery("select c from Course c")
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Get all courses successfully!");
        return courses;
    }

    @Override
    public void updateCourse(Long id, Course course) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Course course1 = entityManager.find(Course.class, id);
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course.getDuration());
        course1.setCreateAt(course.getCreateAt());
        course1.setImageLink(course.getImageLink());
        course1.setDescription(course.getDescription());
        entityManager.merge(course1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void deleteCourseById(Long id) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Course getCourseByName(String name) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, name);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Get course by name successfully!");
        return course;
    }
}
