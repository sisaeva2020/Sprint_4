package ru.yandex.praktikum;


public class Account {
    public final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if(name.matches("^[А-Яа-яё]{1,9} [А-Яа-яё]{1,9}$")) {
            return true;
        }
        return false;
    }
}
