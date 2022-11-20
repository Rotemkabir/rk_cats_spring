package com.jb.cats.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PrintUtils {

    @Value("${string.len}")
    private int SIZE;

    public void print(String content) {
        int len = content.length();

        int side = (SIZE - len) / 2;
        // TODO: 08/11/2022 fixed with odd number
        System.out.print("@".repeat(side));
        System.out.print(content);
        System.out.println("@".repeat(side));

    }
}