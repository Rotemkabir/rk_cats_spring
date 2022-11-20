package com.jb.cats.beans.clr.on;

import com.jb.cats.beans.Cat;
import com.jb.cats.beans.Color;
import com.jb.cats.beans.Toy;
import com.jb.cats.service.CatService;
import com.jb.cats.utils.PrintUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
@Order(2)
public class ServiceTesting implements CommandLineRunner {

    @Autowired
    private CatService catService;

    @Autowired
    private PrintUtils printUtils;

    @Override
    public void run(String... args) throws Exception {
        printUtils.print("get single cat #1");
        System.out.println(catService.getSingletCat(1));
        printUtils.print("get all cats");
        catService.getAllCats().forEach(System.out::println);
        printUtils.print("Adding Some Cats");
        Toy t1 = new Toy("Squash");
        Toy t2 = new Toy("PC");
        Toy t3 = new Toy("Football");
        Toy t4 = new Toy("Basketball");
        Toy t5 = new Toy("Wii");
        Toy t6 = new Toy("Java");

        Cat c1 = Cat.builder()
                .name("Litzi")
                .weight(15.7)
                .birthday(Date.valueOf(LocalDate.now().minusYears(4)))
                .color(Color.ORANGE)
                .toys(List.of(t1, t2))
                .build();

        Cat c2 = Cat.builder()
                .name("Ditzi")
                .weight(12.7)
                .birthday(Date.valueOf(LocalDate.now().minusYears(5)))
                .color(Color.ORANGE)
                .toys(List.of(t3, t4))
                .build();

        Cat c3 = Cat.builder()
                .name("Kitzi")
                .weight(3.8)
                .birthday(Date.valueOf(LocalDate.now().minusYears(8)))
                .color(Color.WHITE)
                .toys(List.of(t5, t6))
                .build();

        catService.addCat(c1);
        catService.addCat(c2);
        catService.addCat(c3);
        printUtils.print("get all cats");
        catService.getAllCats().forEach(System.out::println);
        printUtils.print("Updating Cat #1");
        Cat toUpdate = catService.getSingletCat(1);
        toUpdate.setName("Mitziyahoo");
        catService.updateCat(1, toUpdate);
        catService.getAllCats().forEach(System.out::println);
        printUtils.print("Deleting Cat #2");
        catService.deleteCat(2);
        catService.getAllCats().forEach(System.out::println);
        printUtils.print("all cats weight over 9");
        catService.getAllCatsOverWeight(9).forEach(System.out::println);
        printUtils.print("all cats weight under 9");
        catService.getAllCatsUnderWeight(9).forEach(System.out::println);
        printUtils.print("all cats color=WHITE and weight over 1");
        catService.getAllCatsByColorAndOverWeight(Color.WHITE, 1).forEach(System.out::println);
        printUtils.print("count ORANGE cats");
        System.out.println(catService.countCatInColor(Color.ORANGE));
        printUtils.print("avg weight");
        System.out.println(catService.avgWeight());
        printUtils.print("all cats color=WHITE or weight over 15");
        catService.getAllCatsByColorOrOverWeight(Color.WHITE, 15).forEach(System.out::println);


    }
}