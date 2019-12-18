package com.slimeIdle.View;

import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.utils.ArrayMap;
import com.slimeIdle.Model.Font;
import com.slimeIdle.View.languages.Chinese;
import com.slimeIdle.View.languages.English;
import com.slimeIdle.View.languages.Japanese;
import com.slimeIdle.View.languages.Korean;
import com.slimeIdle.View.languages.Portuguese;
import com.slimeIdle.View.languages.Russian;
import com.slimeIdle.View.languages.Spanish;

import java.util.ArrayList;
import java.util.Map;

public class AllTextStringsLanguages {

    public static String language = "english";

    public static String english = "english";
    public static String spanish = "spanish";
    public static String portuguese = "portuguese";
    public static String russian = "russian";
    public static String japanese = "japanese";
    public static String korean = "korean";
    public static String chinese = "chinese";

    public static ArrayList<String> languagesStrings = new ArrayList<String>();

    public static String
            ok,lv,oneCoin,price,createAccount,login,shop,buyCoins,yourNickname,titleGame,topLevel,name,insertYourName,nickname,
            insertYourNickname,password,insertYourPassword,passwordAgain,insertYourPasswordAgain,backgrounds,slimeColors,languages,
            logout,yes,no;

    public static ArrayList<String>
            errorPassword = new ArrayList<String>(),
            errorInput = new ArrayList<String>(),
            successCreated = new ArrayList<String>(),
            errorLogin = new ArrayList<String>(),
            successLogin = new ArrayList<String>(),
            successBuy = new ArrayList<String>(),
            errorBuy = new ArrayList<String>(),
            errorSlimeReady = new ArrayList<String>(),
            coins = new ArrayList<String>(),
            coinPrices =  new ArrayList<String>(),
            errorNickname = new ArrayList<String>(),
            successNickname = new ArrayList<String>(),
            loginStrings = new ArrayList<String>(),
            createAccountStrings = new ArrayList<String>(),
            logoutStrings = new ArrayList<String>();

    public static ArrayList<ArrayMap<String,String>>
            itemsShop = new ArrayList<ArrayMap<String, String>>(),
            backgroundsShop = new ArrayList<ArrayMap<String, String>>(),
            slimeColorsShop = new ArrayList<ArrayMap<String, String>>();

    private static void coinPrices() {

        coinPrices.add(0, "50");
        coinPrices.add(1, "120");
        coinPrices.add(2, "700");
        coinPrices.add(3, "8000");
        coinPrices.add(4, "17000");
    }

    private static void coinMessages() {

        if (language == english) {

            English.coinMessages();
        }

        if (language == spanish) {

            Spanish.coinMessages();
        }

        if (language == portuguese) {

            Portuguese.coinMessages();
        }

        if (language == russian) {

            Russian.coinMessages();
        }

        if (language == japanese) {

            Japanese.coinMessages();
        }

        if (language == korean) {

            Korean.coinMessages();
        }

        if (language == chinese) {

            Chinese.coinMessages();
        }

    }

    private static void coins () {

        if (language == english) {

            English.coins();
        }

        if (language == spanish) {

            Spanish.coins();
        }

        if (language == portuguese) {

            Portuguese.coins();
        }

        if (language == russian) {

            Russian.coins();
        }

        if (language == japanese) {

            Japanese.coins();
        }

        if (language == korean) {

            Korean.coins();
        }

        if (language == chinese) {

            Chinese.coins();
        }

        coinMessages();
        coinPrices();
    }

    private static void shopMessages() {

        successBuy.clear();
        errorSlimeReady.clear();

        if (language == english) {

            English.shopMessages();
        }

        if (language == spanish) {

            Spanish.shopMessages();
        }

        if (language == portuguese) {

            Portuguese.shopMessages();
        }

        if (language == russian) {

            Russian.shopMessages();
        }

        if(language == japanese) {

            Japanese.shopMessages();
        }

        if (language == korean) {

            Korean.shopMessages();
        }

        if (language == chinese) {

            Chinese.shopMessages();
        }
    }

    private static void shop() {

        shopMessages();


        for (int i=0; i<23; i++) {
            //itemsShopPrices.add(i,"");
            itemsShop.add(i, new ArrayMap<String, String>());
            itemsShop.get(i).put("price", price + coins.get(1));
        }


        if (language == english) {

            English.shop();
        }

        if (language == spanish) {

            Spanish.shop();
        }

        if (language == portuguese) {

            Portuguese.shop();
        }

        if (language == russian) {

            Russian.shop();
        }

        if (language == japanese) {

            Japanese.shop();
        }

        if (language == korean) {

            Korean.shop();
        }

        if (language == chinese) {

            Chinese.shop();
        }
    }

    private static void accountMessages() {

        if(language == english) {

            English.accountMessages();
        }

        if(language == spanish) {

            Spanish.accountMessages();
        }

        if(language == portuguese) {

            Portuguese.accountMessages();
        }

        if(language == russian) {

            Russian.accountMessages();
        }

        if(language == japanese) {

            Japanese.accountMessages();
        }

        if(language == korean) {

            Korean.accountMessages();
        }

        if(language == chinese) {

            Chinese.accountMessages();
        }
    }

    private static void accountInputs() {

        if(language == english) {

            English.accountInputs();
        }

        if(language == spanish) {

            Spanish.accountInputs();
        }

        if(language == portuguese) {

            Portuguese.accountInputs();
        }

        if(language == russian) {

            Russian.accountInputs();
        }

        if(language == japanese) {

            Japanese.accountInputs();
        }

        if(language == korean) {

            Korean.accountInputs();
        }

        if(language == chinese) {

            Chinese.accountInputs();
        }

    }

    private static void accountTitles() {

        if(language == english) {

            English.accountTitles();
        }

        if(language == spanish) {

            Spanish.accountTitles();
        }

        if(language == portuguese) {

            Portuguese.accountTitles();
        }

        if(language == russian) {

            Russian.accountTitles();
        }

        if(language == japanese) {

            Japanese.accountTitles();
        }

        if(language == korean) {

            Korean.accountTitles();
        }

        if(language == chinese) {

            Chinese.accountTitles();
        }

    }

    private static void accountPlaceholders() {

        if(language == english) {

            English.accountPlaceholders();
        }

        if(language == spanish) {

            Spanish.accountPlaceholders();
        }

        if(language == portuguese) {

            Portuguese.accountPlaceholders();
        }

        if(language == russian) {

            Russian.accountPlaceholders();
        }

        if(language == japanese) {

            Japanese.accountPlaceholders();
        }
        if(language == korean) {

            Korean.accountPlaceholders();
        }
        if(language == chinese) {

            Chinese.accountPlaceholders();
        }
    }

    private static void account() {

        accountTitles();
        accountMessages();
        accountInputs();
        accountPlaceholders();
    }

    private static void backgrounds() {

        for (int i=0; i<5; i++) {

            backgroundsShop.add(i, new ArrayMap<String, String>());
            backgroundsShop.get(i).put("price", price + coins.get(1));
        }

        if (language == english) {

            English.backgrounds();
        }

        if (language == spanish) {

            Spanish.backgrounds();
        }

        if (language == portuguese) {

            Portuguese.backgrounds();
        }

        if (language == russian) {

            Russian.backgrounds();
        }

        if (language == japanese) {

            Japanese.backgrounds();
        }

        if (language == korean) {

            Korean.backgrounds();
        }

        if (language == chinese) {

            Chinese.backgrounds();
        }

    }

    private static void slimeColors() {

        for (int i=0; i<10; i++) {

            slimeColorsShop.add(i, new ArrayMap<String, String>());
            slimeColorsShop.get(i).put("price", price + coins.get(1));
        }

        if (language == english) {

            English.slimeColors();
        }

        if (language == spanish) {

            Spanish.slimeColors();
        }

        if (language == portuguese) {

            Portuguese.slimeColors();
        }

        if (language == russian) {

            Russian.slimeColors();
        }

        if (language == japanese) {

            Japanese.slimeColors();
        }

        if (language == korean) {

            Korean.slimeColors();
        }

        if (language == chinese) {

            Chinese.slimeColors();
        }

    }

    private static void otherTexts() {

        if (language == english) {

            English.otherTexts();
        }
        if (language == spanish){

            Spanish.otherTexts();
        }
        if (language == portuguese) {

            Portuguese.otherTexts();
        }
        if(language == russian) {

            Russian.otherTexts();
        }
        if (language == japanese) {

            Japanese.otherTexts();
        }
        if (language == korean) {

            Korean.otherTexts();
        }
        if (language == chinese) {

            Chinese.otherTexts();
        }
    }

    /*
    private static void langs() {

        if (language == english) {

            English.langs();
        }
        if (language == spanish){

            Spanish.langs();
        }
        if (language == portuguese) {

            Portuguese.langs();
        }
        if(language == russian) {

            Russian.langs();
        }
        if (language == japanese) {

            Japanese.langs();
        }
        if (language == korean) {

            Korean.langs();
        }
        if (language == chinese) {

            Chinese.langs();
        }

    }*/

    public static void getAllTexts() {

        languagesStrings.add(0, "English");
        languagesStrings.add(1, "Español");
        languagesStrings.add(2, "Português");
        languagesStrings.add(3, "русский");
        languagesStrings.add(4, "日本人");
        languagesStrings.add(5, "한국어");
        languagesStrings.add(6, "中文");

        languages = "languages";

        otherTexts();
        account();
        coins();
        shop();
        backgrounds();
        slimeColors();
        //langs();
    }
}
