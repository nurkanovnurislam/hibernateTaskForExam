package org.example.dao;

import org.example.entity.Task;

import java.util.List;

public interface TaskDao {
    void saveTask(Task task);
    void updateTask(Long id, Task task);
    List<Task> getAllTaskByLessonId(Long lesson_id);
    void deleteTaskById(Long id);
}
