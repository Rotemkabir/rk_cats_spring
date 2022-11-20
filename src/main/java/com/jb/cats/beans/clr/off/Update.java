package com.jb.cats.beans.clr.off;

import com.jb.cats.beans.Cat;
import com.jb.cats.repos.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class Update implements CommandLineRunner {

    @Autowired
    private CatRepository catRepository;

    @Override
    public void run(String... args) throws Exception {
        Cat toUpdate = catRepository.findById(1).orElseThrow();
        toUpdate.getToys().get(0).setName("Chess");
        catRepository.saveAndFlush(toUpdate);
        catRepository.findAll().forEach(System.out::println);
    }
}
