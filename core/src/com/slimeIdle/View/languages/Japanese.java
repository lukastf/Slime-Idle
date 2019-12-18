package com.slimeIdle.View.languages;

import com.slimeIdle.View.AllTextStringsLanguages;

public class Japanese {

    public static void coinMessages() {

        AllTextStringsLanguages.errorBuy.add(0,"コインを持");
        AllTextStringsLanguages.errorBuy.add(1,"っていない");
        AllTextStringsLanguages.oneCoin = "+1 コイン!";
        AllTextStringsLanguages.price = "価格 ";

    }

    public static void coins() {

        AllTextStringsLanguages.buyCoins = "コインを買う";
        AllTextStringsLanguages.coins.add(0, "硬貨 ");
        AllTextStringsLanguages.coins.add(1, " 硬貨");

    }

    public static void shopMessages() {

        AllTextStringsLanguages.successBuy.add(0,"正常に購入 ");
        AllTextStringsLanguages.successBuy.add(1,"しました");

        AllTextStringsLanguages.errorSlimeReady.add(0, "スライムはすでに ");
        AllTextStringsLanguages.errorSlimeReady.add(1, "読まれています!");

    }

    public static void shop() {

        AllTextStringsLanguages.shop = "ショップ";

        int i = 0;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "時間リセット");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "ニックを変更");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "タッチパワー");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "バイキングヘルメット");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "パーティーハット");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "ウィザードハット");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "アニメハット");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "猫の耳");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "翼のあるヘルメット");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "黒猫の耳");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "カウボーイハット 1");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "カウボーイハット 2");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "ヘア 1");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "ヘア 2");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "ヘア 3");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "ヘア 4");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "ヘア 5");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "プロペラハット");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "ロビン・ハット");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "クラウン");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "ケーキハット");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "ユニコーンハット");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "サンタクロースの帽子");
    }

    public static void accountMessages() {

        AllTextStringsLanguages.errorPassword.add(0,"パスワード");
        AllTextStringsLanguages.errorPassword.add(1,"が一致しません");

        AllTextStringsLanguages.errorInput.add(0,"エラーチェック");
        AllTextStringsLanguages.errorInput.add(1,"入力フィールド");

        AllTextStringsLanguages.successCreated.add(0,"作成されました");
        AllTextStringsLanguages.successCreated.add(1,"");

        AllTextStringsLanguages.errorNickname.add(0,"ニックネーム");
        AllTextStringsLanguages.errorNickname.add(1,"選択エラー");

        AllTextStringsLanguages.successNickname.add(0,"ニックネームが");
        AllTextStringsLanguages.successNickname.add(1,"選択されました");

        AllTextStringsLanguages.errorLogin.add(0,"ログイン時");
        AllTextStringsLanguages.errorLogin.add(1,"のエラー");

        AllTextStringsLanguages.successLogin.add(0,"正常にログイン");
        AllTextStringsLanguages.successLogin.add(1,"");

        AllTextStringsLanguages.logoutStrings.add(0,"ゲームを終了しても");
        AllTextStringsLanguages.logoutStrings.add(1, "よろしいですか？");

    }

    public static void accountInputs() {

        AllTextStringsLanguages.loginStrings.add(0,"> ニックネームを挿入 <");
        AllTextStringsLanguages.loginStrings.add(1,"> パスワードを挿入 <");

        //createAccountStrings.add(0, "> 名前 <");
        AllTextStringsLanguages.createAccountStrings.add(0, "> ニックネーム <");
        AllTextStringsLanguages.createAccountStrings.add(1,"> パスワード <");
        AllTextStringsLanguages.createAccountStrings.add(2, "> もう一度パスワード <");
        AllTextStringsLanguages.createAccountStrings.add(3, "> パスワード <");
        AllTextStringsLanguages.createAccountStrings.add(4, "> もう一度パスワード <");

    }

    public static void accountTitles() {

        AllTextStringsLanguages.lv = "レベル ";
        AllTextStringsLanguages.createAccount = "サインイン";
        AllTextStringsLanguages.yourNickname = "あなたのニックネーム";
        AllTextStringsLanguages.login = "ログインする";
        AllTextStringsLanguages.name = "名前";
        AllTextStringsLanguages.nickname = "ニックネーム";
        AllTextStringsLanguages.password = "パスワード";
        AllTextStringsLanguages.passwordAgain = "もう一度パスワード";
        AllTextStringsLanguages.logout = "ログアウト";

    }

    public static void accountPlaceholders() {

        AllTextStringsLanguages.insertYourName = "名前を入力してください";
        AllTextStringsLanguages.insertYourNickname = "ニックネームを挿入してください";
        AllTextStringsLanguages.insertYourPassword = "パスワードを挿入してください";
        AllTextStringsLanguages.insertYourPasswordAgain = "パスワードをもう一度挿入してください";

    }

    public static void backgrounds() {

        AllTextStringsLanguages.backgrounds = "背景";

        int i = 0;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","フィールド");

        ++i;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","木材");

        ++i;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","シティ");

        ++i;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","バルカン");

    }

    public static void slimeColors() {

        AllTextStringsLanguages.slimeColors = "スライム色";

        int i = 0;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","緑");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","青い");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","黄");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","赤");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","ピンク");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","紫の");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","ライトブルー");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","オレンジ");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","ブラック");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","ホワイト");


    }

    public static void otherTexts() {

        AllTextStringsLanguages.titleGame = "スライムアイドル";
        AllTextStringsLanguages.ok = "Ok";
        AllTextStringsLanguages.topLevel = "トップレベル";
        AllTextStringsLanguages.yes = "はい";
        AllTextStringsLanguages.no = "いや";

    }
}
