package com.jb.cats.beans.clr.on;

import com.jb.cats.beans.Cat;
import com.jb.cats.beans.Color;
import com.jb.cats.beans.Toy;
import com.jb.cats.repos.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
@Order(1)
public class Init implements CommandLineRunner {
    @Autowired
    private CatRepository catRepository;

    @Override
    public void run(String... args) throws Exception {
        Toy t1 = new Toy("Tetris");
        Toy t2 = new Toy("Tennis");
        Toy t3 = new Toy("Nintendo");
        Toy t4 = new Toy("Playstation");


        Cat c1 = Cat.builder()
                .name("Mitzi")
                .weight(3.5)
                .birthday(Date.valueOf(LocalDate.now().minusYears(3)))
                .color(Color.ORANGE)
                .toys(List.of(t1,t2))
                .build();

        t1.setCat(c1);
        t2.setCat(c1);


        Cat c2 = Cat.builder()
                .name("Pitzi")
                .weight(30.5)
                .birthday(Date.valueOf(LocalDate.now().minusYears(6)))
                .color(Color.GRAY)
                .toys(List.of(t3,t4))
                .build();

        t3.setCat(c2);
        t4.setCat(c2);

        catRepository.saveAll(List.of(c1,c2));
        catRepository.findAll().forEach(System.out::println);
    }
}