package com.mocott.smp.util;

import java.math.BigDecimal;

public class TestDouble {

    public static void main(String[] args) {
//        double f = 3.00;
        double f = 3.1510;
        BigDecimal b = new BigDecimal(f);
        double f1 = b.setScale(3, BigDecimal.ROUND_UP).doubleValue();

        System.out.println(f1);


        BigDecimal bb = new BigDecimal(f);
        double f2 = b.setScale(3, BigDecimal.ROUND_DOWN).doubleValue();

        System.out.println(f2);
    }
}
