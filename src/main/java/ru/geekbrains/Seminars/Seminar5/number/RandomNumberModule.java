package ru.geekbrains.Seminars.Seminar5.number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomNumberModule {


    public List<Integer> getList(int count) {
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(random.nextInt(10));
        }
        return list;
    }
}
