package com.trud;

/*Можно добавить сереализацию и запись в файл*/

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Domain> list;
        Logger logger = new Logger(new DomainContainer());
        list = logger.parse();


        for (Domain d : list)
            System.out.println(d);
    }
}
