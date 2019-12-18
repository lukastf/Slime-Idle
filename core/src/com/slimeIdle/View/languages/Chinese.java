package com.slimeIdle.View.languages;

import com.slimeIdle.View.AllTextStringsLanguages;

public class Chinese {

    public static void coinMessages() {

        AllTextStringsLanguages.errorBuy.add(0,"你没有硬币");
        AllTextStringsLanguages.errorBuy.add(1, "");
        AllTextStringsLanguages.oneCoin = "+1 硬币!";
        AllTextStringsLanguages.price = "价钱 ";

    }

    public static void coins() {

        AllTextStringsLanguages.buyCoins = "买硬币";
        AllTextStringsLanguages.coins.add(0, "硬币 ");
        AllTextStringsLanguages.coins.add(1, " 硬币");

    }

    public static void shopMessages() {

        AllTextStringsLanguages.successBuy.add(0,"成功购买");
        AllTextStringsLanguages.successBuy.add(1, "");

        AllTextStringsLanguages.errorSlimeReady.add(0,"史莱姆已经读了!");
        AllTextStringsLanguages.errorSlimeReady.add(1, "");

    }

    public static void shop() {

        AllTextStringsLanguages.shop = "店";

        int i = 0;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "时间重置");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "改变尼克");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "触控电源");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "维京头盔");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "派对帽");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "巫师帽");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "动漫帽");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "猫耳朵");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "翼盔");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "黑猫耳朵");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "牛仔帽 1");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "牛仔帽 2");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "头发 1");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "头发 2");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "头发 3");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "头发 4");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "头发 5");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "螺旋桨帽");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "罗宾·哈特");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "王冠");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "蛋糕帽");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "独角兽帽");

        ++i;
        AllTextStringsLanguages.itemsShop.get(i).put("name", "圣诞老人帽子");

    }

    public static void accountMessages() {

        AllTextStringsLanguages.errorPassword.add(0,"密码");
        AllTextStringsLanguages.errorPassword.add(1,"不匹配");

        AllTextStringsLanguages.errorInput.add(0,"错误检查");
        AllTextStringsLanguages.errorInput.add(1,"输入字段");

        AllTextStringsLanguages.successCreated.add(0,"成功创建");
        AllTextStringsLanguages.successCreated.add(0,"");

        AllTextStringsLanguages.errorNickname.add(0,"选择昵");
        AllTextStringsLanguages.errorNickname.add(1,"称时出错");

        AllTextStringsLanguages.successNickname.add(0,"成功选");
        AllTextStringsLanguages.successNickname.add(1,"择昵称");

        AllTextStringsLanguages.errorLogin.add(0,"登录时出错");
        AllTextStringsLanguages.errorLogin.add(1,"");

        AllTextStringsLanguages.successLogin.add(0,"登录成功");
        AllTextStringsLanguages.successLogin.add(1,"");

        AllTextStringsLanguages.logoutStrings.add(0,"您确定要退 ");
        AllTextStringsLanguages.logoutStrings.add(1, "出游戏吗？");

    }

    public static void accountInputs() {

        AllTextStringsLanguages.loginStrings.add(0,"> 插入昵称 <");
        AllTextStringsLanguages.loginStrings.add(1, "> 插入密码 <");

        //createAccountStrings.add(0, "> 名称 <");
        AllTextStringsLanguages.createAccountStrings.add(0, "> 昵称 <");
        AllTextStringsLanguages.createAccountStrings.add(1, "> 密码 <");
        AllTextStringsLanguages.createAccountStrings.add(2, "> 再次输入密码 <");
        AllTextStringsLanguages.createAccountStrings.add(3, "> 密码 <");
        AllTextStringsLanguages.createAccountStrings.add(4, "> 再次输入密码 <");

    }

    public static void accountTitles() {

        AllTextStringsLanguages.lv = "水平 ";
        AllTextStringsLanguages.createAccount = "登入";
        AllTextStringsLanguages.yourNickname = "您的昵称";
        AllTextStringsLanguages.login = "登录";
        AllTextStringsLanguages.name = "名称";
        AllTextStringsLanguages.nickname = "昵称";
        AllTextStringsLanguages.password = "密码";
        AllTextStringsLanguages.passwordAgain = "再次输入密码";
        AllTextStringsLanguages.logout = "登出";

    }

    public static void accountPlaceholders() {

        AllTextStringsLanguages.insertYourName = "输入你的名字";
        AllTextStringsLanguages.insertYourNickname = "输入您的昵称";
        AllTextStringsLanguages.insertYourPassword = "输入密码";
        AllTextStringsLanguages.insertYourPasswordAgain = "再次输入密码";

    }

    public static void backgrounds() {

        AllTextStringsLanguages.backgrounds = "背景";

        int i = 0;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","领域");

        ++i;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","木");

        ++i;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","市");

        ++i;
        AllTextStringsLanguages.backgroundsShop.get(i).put("name","火神");

    }

    public static void slimeColors() {

        AllTextStringsLanguages.slimeColors = "煤泥颜色";

        int i = 0;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","绿色");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","蓝色");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","黄色");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","红色");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","粉");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","紫色");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","浅蓝");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","橙子");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","黑色");

        ++i;
        AllTextStringsLanguages.slimeColorsShop.get(i).put("name","白色");

    }

    public static void otherTexts() {

        AllTextStringsLanguages.titleGame = "史莱姆空闲";
        AllTextStringsLanguages.ok = "好";
        AllTextStringsLanguages.topLevel = "顶层";
        AllTextStringsLanguages.yes = "是";
        AllTextStringsLanguages.no = "没有";

    }
}
