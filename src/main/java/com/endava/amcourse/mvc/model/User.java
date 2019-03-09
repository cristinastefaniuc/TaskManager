package com.endava.amcourse.mvc.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import static com.endava.amcourse.mvc.model.Status.ACTIVE;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.List;

import static javax.persistence.GenerationType.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString

@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "age")
    private LocalDate age;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status = ACTIVE;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL)
    private List<Task> taskList;

}
