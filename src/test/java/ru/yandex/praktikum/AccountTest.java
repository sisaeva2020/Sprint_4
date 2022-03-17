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
                {"Тимати Шаламе", true},                    //0.валидное имя
                {"Т Ш", true},                              //1.минимум разрешенных символов
                {"Тиматидкв Шаламенвй", true},              //2.максимум разрешенных символов
                {"Тимати Ша-Ламе", true},                   //3.двойная фамилия
                {"Ти Шаламе", true},                        //4.короткое имя
                {"Тимати Ша", true},                        //5.короткая фамилия
                {"Ти", false},                              //6.меньше минимума символов
                {" Тимати Шаламе", false},                  //7.пробел перед
                {"Тимати Шаламе ", false},                  //8.пробел после
                {"ТиматиШаламе", false},                    //9.без пробела
                {"Тимати  Шаламе", false},                  //10.два пробела между
                {"Тиматиев Шаламепнггл", false},            //11.больше на 1 разрешенных символов
                {"Тиматирамнана Шаламепнггненге", false},   //12.много больше символов, чем разрешено
                {"dsygfh jhvjf", false},                    //13.латиница
                {"", false},                                //14.пустая строка
                {null, false},                            //15.без данных
        };
    }

    @Test
    public void isClientNameValidForCardPrint() {
        Account account = new Account(name);
        try {
            actualResult = account.checkNameToEmboss();
        } catch (NullPointerException exception) {
            actualResult = false;
        }
        assertEquals(expectedResult, actualResult, "Введенное имя некорректно. Имя должно быть длиной от 3 до 19 символов и содержать один пробел между именем и фамилией");
    }
}