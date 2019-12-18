package com.slimeIdle.View;

import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Coin;
import com.slimeIdle.Model.Flags;
import com.slimeIdle.Model.Item;
import com.slimeIdle.Model.Menu;
import com.slimeIdle.Model.Shop;
import com.slimeIdle.Model.Slime;
import com.slimeIdle.Model.Static;
import com.slimeIdle.Model.TopLevel;

public class RenderMenu {

    Account account;
    Buttons btns;
    Render render;
    RenderMessages renderMessages;
    Menu menu;
    Shop shop;
    RenderItems renderItems;
    Item item;
    Slime slime;
    Coin coin;
    TopLevel topLevel;
    Flags flags;

    RenderCartShop renderCartShop;
    RenderCoinShop renderCoinShop;
    RenderTopLevel renderTopLevel;
    RenderLoginScreen renderLoginScreen;

    RenderBackgroundShop renderBackgroundShop;
    RenderSlimeColorShop renderSlimeColorShop;
    RenderLanguageSelector renderLanguageSelector;
    RenderLogoutScreen renderLogoutScreen;

    public RenderMenu (
            Account account,
            Buttons buttons,
            Render render,
            RenderMessages renderMessages,
            Menu menu,
            Shop shop,
            RenderItems renderItems,
            Item item,
            Slime slime,
            Coin coin,
            TopLevel topLevel,
            Flags flags) {

        this.account = account;
        this.btns = buttons;
        this.render = render;
        this.renderMessages = renderMessages;
        this.menu = menu;
        this.shop = shop;
        this.renderItems = renderItems;
        this.item = item;
        this.slime = slime;
        this.coin = coin;
        this.topLevel = topLevel;
        this.flags = flags;

        renderCartShop = new RenderCartShop(this.menu, this.shop, this.render, this.renderMessages, this.renderItems, this.item, this.slime, this.btns, this.coin);
        renderCoinShop = new RenderCoinShop(this.btns, this.render, this.coin);
        renderTopLevel = new RenderTopLevel(this.menu, this.render, this.topLevel, this.btns, this.slime, this.shop, this.renderItems);
        renderLoginScreen = new RenderLoginScreen(this.account, this.render, this.renderMessages, this.btns);

        renderBackgroundShop = new RenderBackgroundShop(this.menu, this.shop, this.render, this.renderMessages, this.renderItems, this.item, this.slime, this.btns,coin);
        renderSlimeColorShop = new RenderSlimeColorShop(this.menu, this.shop, this.render, this.renderMessages, this.renderItems, this.item, this.slime, this.btns, this.coin);
        renderLanguageSelector = new RenderLanguageSelector(this.menu, this.render,this.renderMessages,this.renderItems,this.item,this.slime,this.btns,this.flags);
        renderLogoutScreen = new RenderLogoutScreen(btns,render);
    }

    public boolean checkNickname () {

        if(account.getNickname().isEmpty() || account.isSetNicknameSuccess() || account.isSetNicknameError()) {

            btns.drawCloseWindowBtn();

            if(!account.isSetNicknameSuccess() && !account.isSetNicknameError()) {

                render.titleScreen(AllTextStringsLanguages.yourNickname);
                btns.drawMenuBtn(1);
                render.itemMenuBtnsSimpleText(account.createAccountStrings.get(0), false,1);
                btns.drawMenuBtn(2);
                render.itemMenuBtnsSimpleText(AllTextStringsLanguages.ok, false,2);
            }

            if(account.isSetNicknameError()){
                renderMessages.messageError(AllTextStringsLanguages.errorNickname.get(0), AllTextStringsLanguages.errorNickname.get(1));
            }

            if(account.isSetNicknameSuccess()){
                renderMessages.messageSuccess(AllTextStringsLanguages.successNickname.get(0),
                        AllTextStringsLanguages.successNickname.get(1));
            }

            Static.batch.end();
            return true;

        }
        return false;
    }

    public boolean menu() {

        if (menu.isMenu()) {

            if (!menu.isMenu_item_BuySuccess()
                    && !menu.isMenu_item_BuyError_ready()
                    && !menu.isMenu_item_BuyError_money()) btns.drawCloseWindowBtn();
            if (menu.isMenu_background()) renderBackgroundShop.render();
            if (menu.isMenu_cart()) renderCartShop.render();
            if (menu.isMenu_coin()) renderCoinShop.render();
            if (menu.isMenu_topLevel()) renderTopLevel.render();
            if (menu.isMenu_slime_color()) renderSlimeColorShop.render();
            if (menu.isMenu_language()) renderLanguageSelector.render();
            if (menu.isMenu_logout()) renderLogoutScreen.render();

            Static.batch.end();
            return true;
        }

        return false;
    }

    public boolean loginScreen () {

        if (account.isLoginScreen()) {

            renderLoginScreen.render();

            Static.batch.end();
            return true;
        }

        return false;
    }
}
