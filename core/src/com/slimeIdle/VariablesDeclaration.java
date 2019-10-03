package com.slimeIdle;

import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.pay.PurchaseManager;
import com.badlogic.gdx.pay.PurchaseManagerConfig;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;

public class VariablesDeclaration {

    //public
    public PurchaseManager purchaseManager;
    public PurchaseManagerConfig pmc;

    public float w,h,tw,th = 0;
    public OrthographicCamera camera;
    public SpriteBatch batch;

    // Textures
    Texture slime;
    Texture cart;
    Texture coin;
    Texture topLevel;
    Texture reconnectWindow;
    Texture window;
    Texture background_menu;
    Texture closeWindow;
    Texture itemMenu;
    Texture buttonPrev;
    Texture buttonNext;

    /*
    Texture time;
    Texture pencil;

    Texture stClausHat;
    Texture habbitEars;
    Texture witchHat;

    Texture vkHelmet;
    Texture partyHat;
    Texture wizardHat;
    Texture animeHat;
    Texture blkCatEars;
    */

    Texture buttonBuy;
    Texture buttonEquip;
    Texture buttonUnequip;
    Texture loginButton;

    // Sprites
    Sprite cartBtn;
    Sprite coinBtn;
    Sprite topLevelBtn;
    Sprite closeWindowBtn;
    Sprite prevBtn;
    Sprite nextBtn;
    Sprite backBtn;
    Sprite buyBtn;
    Sprite equipBtn;
    Sprite unequipBtn;
    Sprite loginButtonBtn;

    Sprite slimeSpr;
    Sprite reconnectWindowSpr;
    Sprite windowSpr;

    /*
    Sprite timeSpr;
    Sprite pencilSpr;

    Sprite stClausHatSpr;
    Sprite habbitEarsSpr;

    Sprite vkHelmetSpr;
    Sprite partyHatSpr;
    Sprite wizardHatSpr;

    Sprite coinSpr0;
    Sprite coinSpr1;
    Sprite coinSpr2;
    Sprite coinSpr3;
    Sprite coinSpr4;*/

    Sprite fontSpr;

    ArrayList<Sprite> itemMenuBtns = new ArrayList();
    ArrayList<String> topPlayers = new ArrayList<String>();
    ArrayList<String> topPlayersLevel = new ArrayList<String>();
    ArrayList<Integer> topPlayersItemEquippedId = new ArrayList<Integer>();
    ArrayList<Texture> itemsShopTextures = new ArrayList<Texture>();
    ArrayList<Sprite> itemsShopSprites = new ArrayList<Sprite>();
    ArrayList<String> itemsShopNames = new ArrayList<String>();
    ArrayList<String> itemsShopPrices = new ArrayList<String>();
    ArrayList<Boolean> itemsShopBought = new ArrayList<Boolean>();
    ArrayList<String> createAccountStrings = new ArrayList<String>();
    ArrayList<String> passwordsHidden = new ArrayList<String>();

    // Fonts
    BitmapFont font;
    BitmapFont fontTopLevel;
    BitmapFont fontTopLevelNumber;
    BitmapFont fontPlayerSelecionadoLevel;
    BitmapFont fontSuccess;
    BitmapFont fontError;
    BitmapFont fontTitle;
    FreeTypeFontGenerator generator;

    // Strings
    private String encryptionKeyBase64 = "DJIzFkO22qfVMgX2fIsxOXNwz23pDBZfFJBvf4RS3eZ=";
    private String ivBase64 = "AkkkMwikMkW4c7+mHtwtfw==";
    public AES AES = new AES();
    public String[] id = {"",""};
    public String[] pass = {"",""};

    private String nome = "";
    private String fbId = "";
    private String nickname = ">Insert Nickname<";
    private String password = "";
    private int level = 0;
    private String lastTimeTouch = "time...";
    private int coins = 0;
    private int itemEquippedId = 0;

    // Booleans
    private boolean conectado = false;
    private boolean loginScreen = false;
    private boolean loginSuccess = false;
    private boolean loginError = false;
    private boolean createAccount = false;
    private boolean createAccountSuccess = false;
    private boolean createAccountError = false;
    private boolean createAccountErrorPass = false;
    private boolean menu = false;
    private boolean menu_cart = false;
    private boolean menu_coin = false;
    private boolean menu_topLevel = false;
    private boolean menu_topLevel_PlayerSelecionado = false;
    private boolean menu_item_selecionado = false;
    private boolean menu_item_BuySuccess = false;
    private boolean menu_item_BuyError_money = false;
    private boolean menu_item_BuyError_ready = false;
    private boolean setNicknameSuccess = false;
    private boolean setNicknameError = false;

    public boolean freeCoin = false;
    public boolean loginPause = false;

    //ints
    private int currentPage = 1;
    private int playerTopSelecionado = 0;
    private int itemSelecionado = 0;

    public float freeCoinPosition = 5;

    // facebook
    private boolean login = false;
    private Preferences prefs;
    private Array<String> permissionsRead = new Array<String>();
    private boolean autoLoginFinished = false;

    public Array<String> getPermissionsRead() {
        return permissionsRead;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLastTimeTouch() {
        return lastTimeTouch;
    }

    public void setLastTimeTouch(String lastTimeTouch) {
        this.lastTimeTouch = lastTimeTouch;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }

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

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPlayerTopSelecionado() {
        return playerTopSelecionado;
    }

    public void setPlayerTopSelecionado(int playerTopSelecionado) {
        this.playerTopSelecionado = playerTopSelecionado;
    }

    public int getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(int itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public int getItemEquippedId() {
        return itemEquippedId;
    }

    public void setItemEquippedId(int itemEquippedId) {
        this.itemEquippedId = itemEquippedId;
    }

    public Preferences getPrefs() {
        return prefs;
    }

    public void setPrefs(Preferences prefs) {
        this.prefs = prefs;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    public boolean isAutoLoginFinished() {
        return autoLoginFinished;
    }

    public void setAutoLoginFinished(boolean autoLoginFinished) {
        this.autoLoginFinished = autoLoginFinished;
    }

    public String getFbId() {
        return fbId;
    }

    public void setFbId(String fbId) {
        this.fbId = fbId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String apelido) {
        this.nickname = apelido;
    }

    public void variablesDispose(){

        purchaseManager.dispose();

        // Textures
        slime.dispose();
        cart.dispose();
        coin.dispose();
        topLevel.dispose();
        reconnectWindow.dispose();
        window.dispose();
        background_menu.dispose();
        closeWindow.dispose();
        itemMenu.dispose();
        buttonPrev.dispose();
        buttonNext.dispose();

        /*
        time.dispose();
        pencil.dispose();

        stClausHat.dispose();
        habbitEars.dispose();

        vkHelmet.dispose();
        partyHat.dispose();
        wizardHat.dispose();
        */

        buttonBuy.dispose();
        buttonEquip.dispose();
        buttonUnequip.dispose();
        loginButton.dispose();

        batch.dispose();

        // Fonts
        generator.dispose();
        font.dispose();
        fontTopLevel.dispose();
        fontTopLevelNumber.dispose();
        fontTopLevelNumber.dispose();
        fontPlayerSelecionadoLevel.dispose();
        fontSuccess.dispose();
        fontError.dispose();
        fontTitle.dispose();
    }

    public void addCreateAccountStrings (){
        createAccountStrings.add("> Name <");
        createAccountStrings.add("> Nickname <");
        createAccountStrings.add("> Password <");
        createAccountStrings.add("> Password Again <");

        passwordsHidden.add("> Insert Password <");
        passwordsHidden.add("> Password <");
        passwordsHidden.add("> Password Again <");
    }

    public void renderItemsShopSprites(){

        for (int i=0; i<25; i++) {
            itemsShopSprites.add(i, new Sprite());
        }
        //for (int i = 0; i < 20; i++) {
        //    itemsShopSprites.add();
        //}

        //itemsShopSprites.add(timeSpr);
        //itemsShopSprites.add(pencilSpr);

        //itemsShopSprites.add(stClausHatSpr);
        //itemsShopSprites.add(habbitEarsSpr);
        //itemsShopSprites.add(vkHelmetSpr);
        //itemsShopSprites.add(partyHatSpr);
        //itemsShopSprites.add(wizardHatSpr);
    }

    public void renderItemsEquipped(boolean currentPlayer){
        tw = slimeSpr.getWidth();
        th = slimeSpr.getHeight();

        int X = 0;
        int Y = 0;

        if(currentPlayer) {

            Y = getItemEquippedId();

            switch (Y){
                case -1:
                    X = 2;
                    break;

                case -2:
                    X = 3;
                    break;
                case -3:
                    X = 4;
                    break;
                case -4:
                    X = 5;
                    break;
                case 1:
                    X = 6;
                    break;
                case 2:
                    X = 7;
                    break;
                case 3:
                    X = 8;
                    break;
                case 4:
                    X = 9;
                    break;
                case 5:
                    X = 10;
                    break;
                case 6:
                    X = 11;
                    break;
                case 7:
                    X = 12;
                    break;
                case 8:
                    X = 13;
                    break;
                case 9:
                    X = 14;
                    break;
                case 10:
                    X = 15;
                    break;
                case 11:
                    X = 16;
                    break;
                case 12:
                    X = 17;
                    break;
                case 13:
                    X = 18;
                    break;
                case 14:
                    X = 19;
                    break;
                case 15:
                    X = 20;
                    break;
                case 16:
                    X = 21;
                    break;
                case 17:
                    X = 22;
                    break;
                case 18:
                    X = 23;
                    break;
                case 19:
                    X = 24;
                    break;
                    default:
                        X = 0;
            }

        } else {

            Y = getPlayerTopSelecionado();

            switch (topPlayersItemEquippedId.get(Y)){
                case -1:
                    X = 2;
                    break;

                case -2:
                    X = 3;
                    break;
                case -3:
                    X = 4;
                    break;
                case -4:
                    X = 5;
                    break;
                case 1:
                    X = 6;
                    break;
                case 2:
                    X = 7;
                    break;
                case 3:
                    X = 8;
                    break;
                case 4:
                    X = 9;
                    break;
                case 5:
                    X = 10;
                    break;
                case 6:
                    X = 11;
                    break;
                case 7:
                    X = 12;
                    break;
                case 8:
                    X = 13;
                    break;
                case 9:
                    X = 14;
                    break;
                case 10:
                    X = 15;
                    break;
                case 11:
                    X = 16;
                    break;
                case 12:
                    X = 17;
                    break;
                case 13:
                    X = 18;
                    break;
                case 14:
                    X = 19;
                    break;
                case 15:
                    X = 20;
                    break;
                case 16:
                    X = 21;
                    break;
                case 17:
                    X = 22;
                    break;
                case 18:
                    X = 23;
                    break;
                case 19:
                    X = 24;
                    break;
                default:
                    X = 0;
            }

        }

        batch.draw(itemsShopSprites.get(X),
                (camera.position.x - (tw/2)),
                (camera.position.y - (th/2) + (h/5)),
                tw, th);
    }

    public void permissionsRead(){
        //permissionsRead.add("email");
        permissionsRead.add("public_profile");
        //permissionsRead.add("user_friends");
    }

    public void logout(){
        setNome("");
        setFbId("");
        setNickname(">Insert Nickname<");
        setPassword("");
        id[0] = "";
        id[1] = "";

        pass[0] = "";
        pass[1]= "";

        createAccountStrings.set(0, "> Name <");
        createAccountStrings.set(1, "> Nickname <");
        createAccountStrings.set(2, "> Password <");
        createAccountStrings.set(3, "> Password Again <");

        passwordsHidden.set(0, "> Insert Password <");
        passwordsHidden.set(1, "> Password <");
        passwordsHidden.set(2, "> Password Again <");

        setLoginSuccess(false);
        setLoginError(false);

        getPrefs().clear();
        getPrefs().flush();

        setLogin(false);
        setConectado(false);
        loginPause = false;
    }

    public boolean isLoginScreen() {
        return loginScreen;
    }

    public void setLoginScreen(boolean loginScreen) {
        this.loginScreen = loginScreen;
    }

    public boolean isCreateAccount() {
        return createAccount;
    }

    public void setCreateAccount(boolean createAccount) {
        this.createAccount = createAccount;
    }

    public boolean isCreateAccountSuccess() {
        return createAccountSuccess;
    }

    public void setCreateAccountSuccess(boolean createAccountSuccess) {
        this.createAccountSuccess = createAccountSuccess;
    }

    public boolean isCreateAccountError() {
        return createAccountError;
    }

    public void setCreateAccountError(boolean createAccountError) {
        this.createAccountError = createAccountError;
    }

    public boolean isLoginSuccess() {
        return loginSuccess;
    }

    public void setLoginSuccess(boolean loginSuccess) {
        this.loginSuccess = loginSuccess;
    }

    public boolean isLoginError() {
        return loginError;
    }

    public void setLoginError(boolean loginError) {
        this.loginError = loginError;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCreateAccountErrorPass() {
        return createAccountErrorPass;
    }

    public void setCreateAccountErrorPass(boolean createAccountErrorPass) {
        this.createAccountErrorPass = createAccountErrorPass;
    }

    public boolean isSetNicknameSuccess() {
        return setNicknameSuccess;
    }

    public void setSetNicknameSuccess(boolean setNicknameSuccess) {
        this.setNicknameSuccess = setNicknameSuccess;
    }

    public boolean isSetNicknameError() {
        return setNicknameError;
    }

    public void setSetNicknameError(boolean setNicknameError) {
        this.setNicknameError = setNicknameError;
    }

    public String getEncryptionKeyBase64() {
        return encryptionKeyBase64;
    }

    public void setEncryptionKeyBase64(String encryptionKeyBase64) {
        this.encryptionKeyBase64 = encryptionKeyBase64;
    }

    public String getIvBase64() {
        return ivBase64;
    }

    public void setIvBase64(String ivBase64) {
        this.ivBase64 = ivBase64;
    }

    public String encrypt(String encryptStr) {
        try {
            encryptStr = AES.encrypt(encryptStr, getEncryptionKeyBase64(), getIvBase64());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptStr;
    }

    public String decrypt(String decryptStr) {
        try {
            decryptStr = AES.decrypt(decryptStr, getEncryptionKeyBase64(), getIvBase64());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptStr;
    }

    public String[] encryptIn2(String plainString) {
        final int mid = plainString.length() / 2;
        String[] parts = {plainString.substring(0, mid),plainString.substring(mid)};
        try
        {
            parts[0] = AES.encrypt(parts[0], getEncryptionKeyBase64(), getIvBase64());
            parts[1] = AES.encrypt(parts[1], getEncryptionKeyBase64(), getIvBase64());

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

        return parts;
    }
}
