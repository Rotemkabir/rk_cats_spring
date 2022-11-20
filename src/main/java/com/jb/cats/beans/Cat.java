package com.jb.cats.beans;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "cats")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 40, nullable = false)
    private String name;
    private double weight;
    @Enumerated(EnumType.STRING)
    @Column(updatable = false)
    private Color color;
    private Date birthday;
    @OneToMany(mappedBy = "cat", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @Singular
    private List<Toy> toys;
}
