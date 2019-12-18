package com.slimeIdle.View.languages;

import com.slimeIdle.View.AllTextStringsLanguages;

public class Korean {

    public static void coinMessages() {

        AllTextStringsLanguages.errorBuy.add(0,"당신은 동전이 ");
        AllTextStringsLanguages.errorBuy.add(1,"없습니다");
        AllTextStringsLanguages.oneCoin = "코인 +1";
        AllTextStringsLanguages.price = "가격 ";

    }

    public static void coins() {

        AllTextStringsLanguages.buyCoins = "코인 구매";
        AllTextStringsLanguages.coins.add(0,"동전 ");
        AllTextStringsLanguages.coins.add(1," 동전");

    }

    public static void shopMessages() {

        AllTextStringsLanguages.successBuy.add(0,"성공적으로 ");
        AllTextStringsLanguages.successBuy.add(1,"샀다");

        AllTextStringsLanguages.errorSlimeReady.add(0,"점액은 이미 ");
        AllTextStringsLanguages.errorSlimeReady.add(1,"읽었습니다!");

    }

    public static void shop() {

        AllTextStringsLanguages.shop = "가게";

        int i = 0;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "시간 리셋");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "닉 변경");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "터치 파워");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "바이킹 헬멧");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "파티 용 모자");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "마법사 모자");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "애니메이션 모자");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "고양이 귀");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "날개 달린 헬멧");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "검은 고양이 귀");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "카우보이 모자 1");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "카우보이 모자 2");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "머리 1");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "머리 2");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "머리 3");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "머리 4");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "머리 5");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "프로펠러 모자");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "로빈 모자");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "왕관");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "케이크 모자");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "유니콘 모자");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "산타 클로스 모자");

    }

    public static void accountMessages() {

        AllTextStringsLanguages.errorPassword.add(0,"비밀번호가 ");
        AllTextStringsLanguages.errorPassword.add(1,"일치하지 않습니다");

        AllTextStringsLanguages.errorInput.add(0,"오류 점검 ");
        AllTextStringsLanguages.errorInput.add(1,"입력 필드");

        AllTextStringsLanguages.successCreated.add(0,"성공적으로 ");
        AllTextStringsLanguages.successCreated.add(1,"생성");

        AllTextStringsLanguages.errorNickname.add(0,"닉네임 ");
        AllTextStringsLanguages.errorNickname.add(1,"선택시 오류");

        AllTextStringsLanguages.successNickname.add(0,"닉네임이 성공적으로 ");
        AllTextStringsLanguages.successNickname.add(1,"선택되었습니다");

        AllTextStringsLanguages.errorLogin.add(0,"로그인시 ");
        AllTextStringsLanguages.errorLogin.add(1,"오류");

        AllTextStringsLanguages.successLogin.add(0,"성공적으로 ");
        AllTextStringsLanguages.successLogin.add(1,"로그인");

        AllTextStringsLanguages.logoutStrings.add(0,"게임을 종료 ");
        AllTextStringsLanguages.logoutStrings.add(1, "하시겠습니까?");

    }

    public static void accountInputs() {

        AllTextStringsLanguages.loginStrings.add(0,"> 닉네임 삽입 <");
        AllTextStringsLanguages.loginStrings.add(1,"> 비밀번호 삽입 <");

        //createAccountStrings.add(0, "> 이름 <");
        AllTextStringsLanguages.createAccountStrings.add(0, "> 닉네임 <");
        AllTextStringsLanguages.createAccountStrings.add(1, "> 비밀번호 <");
        AllTextStringsLanguages.createAccountStrings.add(2, "> 비밀번호 다시 <");
        AllTextStringsLanguages.createAccountStrings.add(3, "> 비밀번호 <");
        AllTextStringsLanguages.createAccountStrings.add(4, "> 비밀번호 다시 <");

    }

    public static void accountTitles() {

        AllTextStringsLanguages.lv = "수평 ";
        AllTextStringsLanguages.createAccount = "등록 사무관";
        AllTextStringsLanguages.yourNickname = "닉네임";
        AllTextStringsLanguages.login = "로그인";
        AllTextStringsLanguages.name = "이름";
        AllTextStringsLanguages.nickname = "별명";
        AllTextStringsLanguages.password = "암호";
        AllTextStringsLanguages.passwordAgain = "다시 비밀번호";
        AllTextStringsLanguages.logout = "로그 아웃";

    }

    public static void accountPlaceholders() {

        AllTextStringsLanguages.insertYourName = "당신의 이름을 삽입";
        AllTextStringsLanguages.insertYourNickname = "당신의 별명을 삽입";
        AllTextStringsLanguages.insertYourPassword = "비밀번호를 입력하십시오";
        AllTextStringsLanguages.insertYourPasswordAgain = "비밀번호를 다시 입력하십시오";

    }

    public static void backgrounds() {

        AllTextStringsLanguages.backgrounds = "배경";

        int i = 0;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","들");

        ++i;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","나무");

        ++i;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","시티");

        ++i;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","불카누스");

    }

    public static void slimeColors() {

        AllTextStringsLanguages.slimeColors = "슬라임 색상";

        int i = 0;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","녹색");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","푸른");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","노랑");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","빨간");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","담홍색");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","자");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","하늘색");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","주황색");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","검은");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","화이트");

    }

    public static void otherTexts() {

        AllTextStringsLanguages.titleGame = "점액 유휴";
        AllTextStringsLanguages.ok = "승인";
        AllTextStringsLanguages.topLevel = "최상위";
        AllTextStringsLanguages.yes = "예";
        AllTextStringsLanguages.no = "아니";

    }
}
