package com.slimeIdle.Model;

import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.utils.Array;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class Account {

    public String[] id = {"",""};
    public String[] pass = {"",""};

    private String nome = "";
    private String fbId = "";
    private String nickname = ">Insert Nickname<";
    private String password = "";

    private boolean conectado = false;
    private boolean loginScreen = false;
    private boolean loginSuccess = false;
    private boolean loginError = false;
    private boolean createAccount = false;
    private boolean createAccountSuccess = false;
    private boolean createAccountError = false;
    private boolean createAccountErrorPass = false;

    private boolean setNicknameSuccess = false;
    private boolean setNicknameError = false;
    public boolean loginPause = false;

    // facebook
    private boolean login = false;
    private Preferences prefs;
    private Array<String> permissionsRead = new Array<String>();
    private boolean autoLoginFinished = false;

    public ArrayList<String> createAccountStrings = new ArrayList<String>();
    public ArrayList<String> passwordsHidden = new ArrayList<String>();
    public Array<String> getPermissionsRead() {
        return permissionsRead;
    }

    public Preferences getPrefs() {
        return prefs;
    }
    public void setPrefs(Preferences prefs) {
        this.prefs = prefs;
    }

    public boolean isConectado() {
        return conectado;
    }
    public void setConectado(boolean conectado) {
        this.conectado = conectado;
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

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
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

    public void addCreateAccountStrings (){
        createAccountStrings.add("> Name <");
        createAccountStrings.add("> Nickname <");
        createAccountStrings.add("> Password <");
        createAccountStrings.add("> Password Again <");

        passwordsHidden.add("> Insert Password <");
        passwordsHidden.add("> Password <");
        passwordsHidden.add("> Password Again <");
    }

    // socket io

    public void connect(Socket socket) {

        JSONObject enviar = new JSONObject();
        try {
            enviar.put("name", getNome());
            if(getFbId() != ""){
                enviar.put("fbId1", id[0]);
                enviar.put("fbId2", id[1]);
            }

            if(getPassword() != "" && getNickname() != "" && getNickname() != ">Insert Nickname<"){
                enviar.put("nickname", getNickname());
                enviar.put("password1", pass[0]);
                enviar.put("password2", pass[1]);
            }

            socket.emit("checkAccount", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        setConectado(true);
    }

    public void disconnect(Slime slime, Coin coin) {

        setFbId("");
        setLogin(false);
        setConectado(false);

        slime.setLevel(0);
        slime.setLastTimeTouch("time...");
        coin.setCoins(0);
    }

    public void pingado(Socket socket) {
        JSONObject enviar = new JSONObject();
        try {
            enviar.put("name", getNome());
            enviar.put("fbId1", id[0]);
            enviar.put("fbId2", id[1]);

            socket.emit("pingado", enviar);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createAccount(final Socket socket) {

        socket.connect();

        JSONObject enviar = new JSONObject();
        try {
            enviar.put("name", createAccountStrings.get(0));
            enviar.put("nickname", createAccountStrings.get(1));
            enviar.put("password1", pass[0]);
            enviar.put("password2", pass[1]);

            socket.emit("createAccount", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        socket.on("createAccountSuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                setCreateAccountSuccess(true);
                socket.disconnect();

                createAccountStrings.set(0, "> Name <");
                createAccountStrings.set(1, "> Nickname <");
                createAccountStrings.set(2, "> Password <");
                createAccountStrings.set(3, "> Password Again <");

                passwordsHidden.set(0, "> Insert Password <");
                passwordsHidden.set(1, "> Password <");
                passwordsHidden.set(2, "> Password Again <");

                setPassword("");
                pass = null;

            }
        });

        socket.on("createAccountError", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                setCreateAccountError(true);
                socket.disconnect();

                setNickname(">Insert Nickname<");
                passwordsHidden.set(0, "> Insert Password <");
                setPassword("");
                pass = null;
            }
        });
    }

    public void loginAccount (final Encryption encryption, final Socket socket) {

        socket.connect();

        JSONObject enviar = new JSONObject();
        try {
            enviar.put("nickname", this.getNickname());
            enviar.put("password1", this.pass[0]);
            enviar.put("password2", this.pass[1]);

            socket.emit("login", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        socket.on("loginSuccessful", new Emitter.Listener() {
            @Override
            public void call(Object... args) {

                setLoginSuccess(true);

                JSONObject data = (JSONObject) args[0];
                try {
                    setNome(data.getString("name"));
                    setFbId(data.getString("fbId"));
                    id = encryption.encryptIn2(encryption.decrypt(data.getString("fbId")));
                    setNickname(data.getString("nickname"));
                    setPassword(data.getString("password"));
                    pass = encryption.encryptIn2(encryption.decrypt(data.getString("password")));

                    getPrefs().putString("name", getNome());
                    getPrefs().putString("fbId", getFbId());
                    getPrefs().putString("nickname", getNickname());
                    getPrefs().putString("password", getPassword());
                    getPrefs().flush();

                } catch (JSONException e){
                    e.printStackTrace();
                }

                socket.disconnect();
            }
        });

        socket.on("loginError", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                setLoginError(true);
                socket.disconnect();
            }
        });
    }

    public void setNickname(Socket socket) {

        JSONObject enviar = new JSONObject();
        try {
            enviar.put("name", getNome());
            enviar.put("fbId1", id[0]);
            enviar.put("fbId2", id[1]);
            enviar.put("nickname", createAccountStrings.get(1));

            socket.emit("setNickname", enviar);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setNicknameSuccessful(Object... args) {
        JSONObject data = (JSONObject) args[0];
        try {
            setNickname(data.getString("nickname"));
        } catch (JSONException e){
            e.printStackTrace();
        }
        setSetNicknameSuccess(true);
        createAccountStrings.set(1,"> Nickname <");
    }

    public void setNicknameError(Object... args) {
        setSetNicknameError(true);
    }

}
