package ru.yandex.praktikum;


public class Account {
    public final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        if (name.isEmpty() && name == null) {
            return false;
        } else if (name.matches("^(?=[а-яА-Яё]+[\\s][а-яА-Яё-]+$)(.{3,19})")) {
            return true;
        }
        return false;
    }
}
