package com.slimeIdle.View.languages;

import com.slimeIdle.View.AllTextStringsLanguages;

public class Russian {

    public static void coinMessages() {

        AllTextStringsLanguages.errorBuy.add(0, "У вас нет ");
        AllTextStringsLanguages.errorBuy.add(1, "монет");
        AllTextStringsLanguages.oneCoin = "+1 Монета!";
        AllTextStringsLanguages.price = "цена: ";
    }

    public static void coins() {

        AllTextStringsLanguages.buyCoins = "Купите монеты";
        AllTextStringsLanguages.coins.add(0,"монеты: ");
        AllTextStringsLanguages.coins.add(1," монеты");

    }

    public static void shopMessages() {

        AllTextStringsLanguages.successBuy.add(0,"Успешно ");
        AllTextStringsLanguages.successBuy.add(1,"куплено");

        AllTextStringsLanguages.errorSlimeReady.add(0,"Слизь уже ");
        AllTextStringsLanguages.errorSlimeReady.add(1,"готова!");

    }

    public static void shop() {

        AllTextStringsLanguages.shop = "Магазин";

        int i = 0;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Сброс времени");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Изменить ник");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Сила касания");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Шлем викинга");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Вечеринка шапка");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Волшебная Шляпа");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Аниме шляпа");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Кошачьи уши");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Крылатый Шлем");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Уши черной кошки");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Ковбойская шляпа 1");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Ковбойская шляпа 2");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Волосы 1");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Волосы 2");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Волосы 3");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Волосы 4");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Волосы 5");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Пропеллер шляпа");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Робин Хэт");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "коронка");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Торт Шляпа");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Шляпа единорога");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "Шапка санта клауса");

    }

    public static void accountMessages() {

        AllTextStringsLanguages.errorPassword.add(0,"Пароль не ");
        AllTextStringsLanguages.errorPassword.add(1,"совпадает");

        AllTextStringsLanguages.errorInput.add(0,"Ошибка проверки ");
        AllTextStringsLanguages.errorInput.add(1,"полей ввода");

        AllTextStringsLanguages.successCreated.add(0,"Успешно ");
        AllTextStringsLanguages.successCreated.add(1,"создан");

        AllTextStringsLanguages.errorNickname.add(0,"Ошибка при ");
        AllTextStringsLanguages.errorNickname.add(1,"выборе никнейма");

        AllTextStringsLanguages.successNickname.add(0,"Успешно ");
        AllTextStringsLanguages.successNickname.add(1,"выбран ник");

        AllTextStringsLanguages.errorLogin.add(0,"Ошибка при ");
        AllTextStringsLanguages.errorLogin.add(1,"входе");

        AllTextStringsLanguages.successLogin.add(0,"Успешный ");
        AllTextStringsLanguages.successLogin.add(1,"вход");

        AllTextStringsLanguages.logoutStrings.add(0,"Вы уверены, что");
        AllTextStringsLanguages.logoutStrings.add(1, "хотите выйти из игры?");

    }

    public static void accountInputs() {

        AllTextStringsLanguages.loginStrings.add(0,"> Вставить никнейм <");
        AllTextStringsLanguages.loginStrings.add(1,"> Введите пароль <");

        //createAccountStrings.add(0,"> имя <");
        AllTextStringsLanguages.createAccountStrings.add(0, "> кличка <");
        AllTextStringsLanguages.createAccountStrings.add(1, "> пароль <");
        AllTextStringsLanguages.createAccountStrings.add(2, "> Пароль еще раз <");
        AllTextStringsLanguages.createAccountStrings.add(3, "> пароль <");
        AllTextStringsLanguages.createAccountStrings.add(4, "> Пароль еще раз <");

    }

    public static void accountTitles() {

        AllTextStringsLanguages.lv = "уровень: ";
        AllTextStringsLanguages.createAccount = "Войти в систему";
        AllTextStringsLanguages.yourNickname = "Твой псевдоним";
        AllTextStringsLanguages.login = "логин";
        AllTextStringsLanguages.name = "имя";
        AllTextStringsLanguages.nickname = "кличка";
        AllTextStringsLanguages.password = "пароль";
        AllTextStringsLanguages.passwordAgain = "Пароль еще раз";
        AllTextStringsLanguages.logout = "Выйти";

    }

    public static void accountPlaceholders() {

        AllTextStringsLanguages.insertYourName = "Введите свое имя";
        AllTextStringsLanguages.insertYourNickname = "Введите свой ник";
        AllTextStringsLanguages.insertYourPassword = "Введите свой пароль";
        AllTextStringsLanguages.insertYourPasswordAgain = "Введите ваш пароль еще раз";

    }

    public static void backgrounds() {

        AllTextStringsLanguages.backgrounds = "фоны";

        int i = 0;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","поле");

        ++i;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","дерево");

        ++i;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","город");

        ++i;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","Вулкан");

    }

    public static void slimeColors() {

        AllTextStringsLanguages.slimeColors = "цвета слизи";

        int i = 0;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","зеленый");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","синий");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","желтый");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","красный");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","розовый");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","Фиолетовый");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","Светло-синий");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","оранжевый");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","черный");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","белый");

    }

    public static void otherTexts() {

        AllTextStringsLanguages.titleGame = "слизь вхолостую";
        AllTextStringsLanguages.ok = "хорошо";
        AllTextStringsLanguages.topLevel = "верхний нивель";
        AllTextStringsLanguages.yes = "да";
        AllTextStringsLanguages.no = "нет";

    }
}
