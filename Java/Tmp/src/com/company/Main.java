package com.company;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        LocalDateTime time1 = LocalDateTime.of(2021, 12, 13, 15, 56);
        LocalDateTime time2 = LocalDateTime.of(2022, 3, 12, 14, 57);

        long diff = ChronoUnit.MONTHS.between(time1, time2);

        System.out.println(diff);
        System.out.println(time1.getMonthValue());
    }

}
