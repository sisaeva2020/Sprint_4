package ru.yandex.praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.jupiter.api.Assertions.assertEquals;



@RunWith(Parameterized.class)
public class AccountTest {
    private String name;
    private boolean expectedResult;
    private boolean actualResult;

    public AccountTest(String name, boolean expectedResult) {
        this.name = name;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getNameData() {
        return new Object[][] {
                {"Тимати Шаламе", true}, //валидное имя
                {"Т Ш", true}, //минимум разрешенных символов
                {"Тиматидкв Шаламенвй", true}, //максимум разрешенных символов
                {" Тимати Шаламе", false}, //пробел перед
                {"Тимати Шаламе ", false}, //пробел после
                {"ТиматиШаламе", false}, //без пробела
                {"Тимати  Шаламе", false}, //два пробела между
                {"Тиматирамн Шаламепнгг", false}, //больше на 1 разрешенных символов
                {"Тиматирамнана Шаламепнггненгег", false}, //больше чем на 1 разрешенных символов
                {"dsygfh jhvjf", false}, //латиница
                {"", false}, //пустая строка
        };
    }

    @Test
    public void isClientNameValidForCardPrint() {
        Account account = new Account(name);
        actualResult = account.checkNameToEmboss();
        assertEquals(expectedResult, actualResult, "Введенное имя некорректно. Имя должно быть длиной от 3 до 19 символов и содержать один пробел между именем и фамилией");
    }
}