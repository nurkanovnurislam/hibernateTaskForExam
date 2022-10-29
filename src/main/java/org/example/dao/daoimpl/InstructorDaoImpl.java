package org.example.dao.daoimpl;

import jakarta.persistence.EntityManager;

import org.example.dao.InstructorDao;
import org.example.entity.Course;
import org.example.entity.Instructor;
import org.example.util.Util;

import java.util.List;

public class InstructorDaoImpl implements InstructorDao {
    @Override
    public void saveInstructor(Instructor instructor) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateInstructor(Long id, Instructor instructor) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Instructor instructor1 = entityManager.find(Instructor.class, id);
        instructor1.setFirstname(instructor.getFirstname());
        instructor1.setLastname(instructor.getLastname());
        instructor1.setEmail(instructor.getEmail());
        instructor1.setPhoneNumber(instructor.getPhoneNumber());
        entityManager.refresh(instructor1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Get instructor successfully!");
        return instructor;
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long course_id) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, course_id);
        entityManager.getTransaction().commit();
        entityManager.close();
        if (course.getInstructors() == null) {
            System.out.println("arrayList is null!");
        }
        System.out.println("Get all instructor successfully!");
        return course.getInstructors();
    }

    @Override
    public void deleteInstructorById(Long id) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, id);
        entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void assignInstructorToCourse(Long instructor_id, Long course_id) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, instructor_id);
        Course course = entityManager.find(Course.class, course_id);
        instructor.getCourses().add(course);
        course.getInstructors().add(instructor);
        entityManager.persist(instructor);
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
