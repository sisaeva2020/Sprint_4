package ru.yandex.praktikum;


public class Account {
    public final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        if (name.isEmpty() && name == null) {
            return false;
        } else if (name.length() < 3)    {
            return false;
        } else if (name.length() > 19)    {
            return false;
        } else if (name.matches("^[а-яёА-ЯЁ]+\\s[а-яёА-ЯЁ-]+$")) {
            return true;
        }
        return false;
    }
}
///^[а-яёА-ЯЁ]+(?:\s[а-яёА-ЯЁ.-]+)*$/