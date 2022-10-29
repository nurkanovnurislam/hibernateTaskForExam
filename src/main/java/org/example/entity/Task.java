package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.util.Util;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String deadLina;
    private String task;

    @ManyToOne(cascade = {DETACH, MERGE, REFRESH, PERSIST}, fetch = LAZY)
    private Lesson lesson;

    public Task(String name, String deadLina, String task) {
        this.id = id;
        this.name = name;
        this.deadLina = deadLina;
        this.task = task;
    }
    public Task(String name, String deadLina, String task, Long lesson_id) {
        this.id = id;
        this.name = name;
        this.deadLina = deadLina;
        this.task = task;
        this.lesson = convert(lesson_id);
    }

    private Lesson convert(Long id) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, id);
        entityManager.getTransaction().begin();
        entityManager.close();
        return lesson;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", deadLina='" + deadLina + '\'' +
                ", task='" + task + '\'' +
                '}';
    }
}
