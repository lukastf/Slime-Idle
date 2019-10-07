package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.Texture;

public class Menu {

    // Textures
    public Texture background_menu;
    public  Texture itemMenu;

    private boolean menu = false;
    private boolean menu_cart = false;
    private boolean menu_coin = false;
    private boolean menu_topLevel = false;
    private boolean menu_topLevel_PlayerSelecionado = false;
    private boolean menu_item_selecionado = false;
    private boolean menu_item_BuySuccess = false;
    private boolean menu_item_BuyError_money = false;
    private boolean menu_item_BuyError_ready = false;

    private int menu_currentPage = 1;

    public boolean isMenu() {
        return menu;
    }
    public void setMenu(boolean menu) {
        this.menu = menu;
    }

    public boolean isMenu_cart() {
        return menu_cart;
    }
    public void setMenu_cart(boolean menu_cart) {
        this.menu_cart = menu_cart;
    }

    public boolean isMenu_coin() {
        return menu_coin;
    }
    public void setMenu_coin(boolean menu_coin) {
        this.menu_coin = menu_coin;
    }

    public boolean isMenu_topLevel() {
        return menu_topLevel;
    }
    public void setMenu_topLevel(boolean menu_topLevel) {
        this.menu_topLevel = menu_topLevel;
    }

    public boolean isMenu_topLevel_PlayerSelecionado() {
        return menu_topLevel_PlayerSelecionado;
    }
    public void setMenu_topLevel_PlayerSelecionado(boolean menu_topLevel_PlayerSelecionado) {
        this.menu_topLevel_PlayerSelecionado = menu_topLevel_PlayerSelecionado;
    }

    public boolean isMenu_item_selecionado() {
        return menu_item_selecionado;
    }
    public void setMenu_item_selecionado(boolean menu_item_selecionado) {
        this.menu_item_selecionado = menu_item_selecionado;
    }

    public boolean isMenu_item_BuySuccess() {
        return menu_item_BuySuccess;
    }
    public void setMenu_item_BuySuccess(boolean menu_item_BuySuccess) {
        this.menu_item_BuySuccess = menu_item_BuySuccess;
    }

    public boolean isMenu_item_BuyError_money() {
        return menu_item_BuyError_money;
    }
    public void setMenu_item_BuyError_money(boolean menu_item_BuyError_money) {
        this.menu_item_BuyError_money = menu_item_BuyError_money;
    }

    public boolean isMenu_item_BuyError_ready() {
        return menu_item_BuyError_ready;
    }
    public void setMenu_item_BuyError_ready(boolean menu_item_BuyError_ready) {
        this.menu_item_BuyError_ready = menu_item_BuyError_ready;
    }

    public int getMenuCurrentPage() {
        return menu_currentPage;
    }
    public void setMenuCurrentPage(int menu_currentPage) {
        this.menu_currentPage = menu_currentPage;
    }

    public void dispose () {
        background_menu.dispose();
        itemMenu.dispose();
    }
}
