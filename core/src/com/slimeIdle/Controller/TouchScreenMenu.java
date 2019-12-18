package com.slimeIdle.Controller;

import com.badlogic.gdx.Gdx;
import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.SocketSlime;
import com.slimeIdle.View.AllTextStringsLanguages;

public class TouchScreenMenu {

    Account acc;
    Buttons btn;
    FacebookLogin fbLogin;
    Menu menu;
    Item item;
    //Slime slime;
    //Shop shop;
    SocketSlime socketSlime;
    InputListener listener;
    //PurchaseManager purchaseManager;
    //TopLevel topLevel;
    //Encryption encryption;

    public TouchScreenMenu(Account acc, Buttons btn, FacebookLogin fbLogin,
                           Menu menu, Item item, SocketSlime socketSlime, InputListener listener) {
        this.acc = acc;
        this.btn = btn;
        this.fbLogin = fbLogin;
        this.menu = menu;
        this.item = item;
        this.socketSlime = socketSlime;
        this.listener = listener;
    }

    public void keyBack () {
        menu.setMenu_item_BuySuccess(false);
        menu.setMenu_item_BuyError_ready(false);
        menu.setMenu_item_BuyError_money(false);
        menu.setMenuCurrentPage(1);
    }

    public boolean pages (int pageLimit) {
        if(btn.buttonPrevCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
            if(menu.getMenuCurrentPage() == 1) {
                return true;
            }
            menu.setMenuCurrentPage(menu.getMenuCurrentPage() - 1);
        }

        if(btn.buttonNextCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
            if(menu.getMenuCurrentPage() == pageLimit) {
                return true;
            }
            menu.setMenuCurrentPage(menu.getMenuCurrentPage() + 1);
        }

        return true;
    }

    public boolean closeButton () {
        if (!menu.isMenu_item_BuySuccess() && !menu.isMenu_item_BuyError_ready() && !menu.isMenu_item_BuyError_money()) {

            if (btn.buttonCloseCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {

                menu.setMenu(false);
                menu.setMenu_logout(false);
                menu.setMenu_language(false);
                menu.setMenu_background(false);
                menu.setMenu_slime_color(false);

                menu.setMenu_cart(false);
                menu.setMenu_coin(false);
                menu.setMenu_topLevel(false);
                menu.setMenu_topLevel_PlayerSelecionado(false);

                menu.setMenu_item_selecionado(false);
                menu.setMenu_item_BuySuccess(false);
                menu.setMenu_item_BuyError_ready(false);
                menu.setMenu_item_BuyError_money(false);

                menu.setMenuCurrentPage(1);
                item.setItemId(0);
                item.setCollection("");
                item.setItemMenuPosition(0);
                return true;
            }
        }

        return true;
    }

    public boolean checkNickname() {

        if(acc.getNickname().isEmpty() || acc.isSetNicknameSuccess() || acc.isSetNicknameError()) {

            if(!acc.isSetNicknameSuccess() && !acc.isSetNicknameError()) {

                if (btn.buttonCloseCollision.contains(btn.touchPoint.x, btn.touchPoint.y)) {
                    fbLogin.getlogout();
                    acc.logout();
                }

                if (btn.buttonMenuCollision.get(1).contains(btn.touchPoint.x, btn.touchPoint.y)) {
                    item.setItemId(1);
                    Gdx.input.getTextInput(listener, AllTextStringsLanguages.nickname, "", AllTextStringsLanguages.insertYourNickname);
                }

                if (btn.buttonMenuCollision.get(2).contains(btn.touchPoint.x, btn.touchPoint.y)){
                    socketSlime.setNickname();
                }
            }
            if(acc.isSetNicknameSuccess() || acc.isSetNicknameError()) {

                if (btn.buttonMenuCollision.get(4).contains(btn.touchPoint.x, btn.touchPoint.y)){
                    acc.setSetNicknameSuccess(false);
                    acc.setSetNicknameError(false);
                }
            }
            return true;
        }
        return false;
    }

    public boolean menu (
            TouchScreenBackgroundShop touchScreenBackgroundShop,
            TouchScreenSlimeColorShop touchScreenSlimeColorShop,
            TouchScreenCartShop touchScreenCartShop,
            TouchScreenCoinShop touchScreenCoinShop,
            TouchScreenTopLevel touchScreenTopLevel,
            TouchScreenLanguage touchScreenLanguage,
            TouchScreenLogoutScreen touchScreenLogoutScreen) {

        if (menu.isMenu()) {

            closeButton();

            if (menu.isMenu_logout()) {
                if (touchScreenLogoutScreen.touch()) return true;
            }

            if(menu.isMenu_language()) {
                if(touchScreenLanguage.touch()) return true;
                pages(2);
            }

            if (menu.isMenu_background()) {
                if(touchScreenBackgroundShop.touch()) return true;
                pages(1);
            }

            if (menu.isMenu_slime_color()) {
                if(touchScreenSlimeColorShop.touch()) return true;
                pages(2);
            }

            if (menu.isMenu_cart()) {
                if(touchScreenCartShop.touch()) return true;
                pages(5);
            }
            if (menu.isMenu_coin()) {
                if(touchScreenCoinShop.touch()) return true;
            }
            if (menu.isMenu_topLevel()) {
                if(touchScreenTopLevel.touch()) return true;
                pages(4);
            }

            return true;
        }

        return false;
    }
}
