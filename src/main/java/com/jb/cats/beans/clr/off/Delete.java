package com.jb.cats.beans.clr.off;

import com.jb.cats.repos.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class Delete implements CommandLineRunner {

    @Autowired
    private CatRepository catRepository;

    @Override
    public void run(String... args) throws Exception {
        catRepository.deleteById(1);
    }
}