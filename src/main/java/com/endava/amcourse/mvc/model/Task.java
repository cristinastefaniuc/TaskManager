package com.endava.amcourse.mvc.model;

import lombok.*;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

import static com.endava.amcourse.mvc.model.TaskStatus.TODO;
import static javax.persistence.GenerationType.SEQUENCE;


/**
 * Created by pcovaliov on 11/27/2018.
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Table(name = "task")
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "creation_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate = LocalDate.now();

    @Column(name = "due_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dueDate;

    @Column(name = "task_status")
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus = TODO;

    @Column(name = "comments")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
