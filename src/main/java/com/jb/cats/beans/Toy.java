package com.jb.cats.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "toys")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Toy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 40, nullable = false)
    private String name;
    @ManyToOne
    @ToString.Exclude
    @JsonIgnore
    private Cat cat;

    public Toy(String name) {
        this.name = name;
    }

}
