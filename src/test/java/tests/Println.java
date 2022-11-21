package tests;

import com.github.javafaker.Faker;

import java.util.Locale;

import static tests.RandomUtils.getRandomInt;
import static tests.RandomUtils.getRandomString;

public class Println {


    public static void main(String[] args) {
        Faker fakerRu = new Faker(new Locale("ru"));
        System.out.println(getRandomString(10));
        System.out.println(getRandomInt(1111, 9999));
        System.out.println(fakerRu.address().fullAddress());
    }
}
