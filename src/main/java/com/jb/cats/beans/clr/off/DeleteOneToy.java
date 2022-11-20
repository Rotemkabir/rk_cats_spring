package com.jb.cats.beans.clr.off;

import com.jb.cats.repos.ToyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DeleteOneToy implements CommandLineRunner {

    @Autowired
    private ToyRepository toyRepository;
    @Override
    public void run(String... args) throws Exception {
        toyRepository.deleteById(1);
    }
}

