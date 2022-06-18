package com.github.systemdesign;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Set<Integer> set = new EntryHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(2);
        set.add(3);
        set.add(5);

        System.out.println(set.contains(5));
        set.remove(5);
        System.out.println(set.contains(5));
    }
}
