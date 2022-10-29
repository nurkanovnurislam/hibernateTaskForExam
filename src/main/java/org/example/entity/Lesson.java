package org.example.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.util.Util;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String videoLink;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(name = "lesson_id")
    private List<Task> tasks = new ArrayList<>();

    public Lesson(String name, String videoLink, Long course_id) {
        this.videoLink = videoLink;
        this.name = name;
        this.course = convert(course_id);
    }

    public Lesson(String name, String videoLink) {
        this.name = name;
        this.videoLink = videoLink;
    }

    private Course convert(Long id) {
        EntityManager entityManager = Util.getConnection();
        entityManager.getTransaction().begin();
        Course course1 = entityManager.find(Course.class, id);
        entityManager.getTransaction().begin();
        entityManager.close();
        return course1;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", videoLink='" + videoLink + '\'' +
                '}';
    }
}
