package org.example.dao.daoimpl;

import jakarta.persistence.EntityManager;
import org.example.dao.TaskDao;
import org.example.util.Util;
import org.example.entity.Lesson;
import org.example.entity.Task;

import java.util.List;

public class TaskDaoImpl implements TaskDao {

    @Override
    public void saveTask(Task task) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public void updateTask(Long id, Task task) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Task task1 = entityManager.find(Task.class, id);
        task1.setName(task.getName());
        task1.setDeadLina(task.getDeadLina());
        task1.setTask(task.getTask());
        entityManager.refresh(task1);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long lesson_id) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lesson_id);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Get all task successfully!");
        return lesson.getTasks();
    }

    @Override
    public void deleteTaskById(Long id) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, id);
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
