package ru.yandex.praktikum;

public class Praktikum {
    private static String name;

    public static boolean main(String[] args) {
        Account account = new Account(name);
        return account.checkNameToEmboss();
    }

}
