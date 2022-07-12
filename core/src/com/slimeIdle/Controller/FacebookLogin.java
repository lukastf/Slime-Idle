package com.slimeIdle.Controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonValue;
import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Encryption;
import com.slimeIdle.Model.FacebookConfig;
import com.slimeIdle.Model.SocketSlime;
import com.slimeIdle.Slime;

import de.tomgrill.gdxfacebook.core.GDXFacebookCallback;
import de.tomgrill.gdxfacebook.core.GDXFacebookError;
import de.tomgrill.gdxfacebook.core.GDXFacebookGraphRequest;
import de.tomgrill.gdxfacebook.core.JsonResult;
import de.tomgrill.gdxfacebook.core.SignInMode;
import de.tomgrill.gdxfacebook.core.SignInResult;

import de.tomgrill.gdxfacebook.core.*;

public class FacebookLogin {

    Account acc;
    SocketSlime socketSlime;
    Encryption encr;

    private static final String TAG = Slime.class.getSimpleName();
    private GDXFacebook gdxFacebook;

    public FacebookLogin(Account acc, SocketSlime socketSlime, Encryption encryption){
        this.acc = acc;
        this.socketSlime = socketSlime;
        this.encr = encryption;
    }

    public void configFacebook(){
        FacebookConfig config = new FacebookConfig();
        if (config.APP_ID == null || config.APP_ID.equals("REPLACE_WITH_YOUR_APP_ID")) {
            throw new RuntimeException("You need to set APP_ID in MyFacebookConfig class.");
        }

        gdxFacebook = GDXFacebookSystem.install(config);
    }

    private void loginWithReadPermissions() {
        gdxFacebook.signIn(SignInMode.READ, acc.getPermissionsRead(), new GDXFacebookCallback<SignInResult>() {

            @Override
            public void onSuccess(SignInResult result) {
                gainMoreUserInfo();
                acc.setLogin(true);
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onFail(Throwable t) {
                Gdx.app.error(TAG, "SIGN IN (read permissions): Technical error occured:");
                logout();
                t.printStackTrace();
            }

            @Override
            public void onError(GDXFacebookError error) {
                Gdx.app.error(TAG, "SIGN IN (read permissions): Error login: " + error.getErrorMessage());
                logout();

            }

        });

    }

    public void getlogin(){
        loginWithReadPermissions();
    }

    private void gainMoreUserInfo() {

        GDXFacebookGraphRequest request = new GDXFacebookGraphRequest().setNode("me").useCurrentAccessToken();

        gdxFacebook.graph(request, new GDXFacebookCallback<JsonResult>() {
            @Override
            public void onSuccess(JsonResult result) {
                JsonValue root = result.getJsonValue();

                String fbName = root.getString("name");
                String fbIdForThisApp = root.getString("id");
                //acc.setNome(fbName);
                acc.setFbId(encr.encrypt(fbIdForThisApp));
                acc.fbIdArray = encr.encryptIn2(encr.decrypt(acc.getFbId()));

                acc.getPrefs().putBoolean("firstLogin", true);
                acc.getPrefs().flush();

                socketSlime.connectSocket();
                socketSlime.configSocketEvents();
            }

            @Override
            public void onError(GDXFacebookError error) {
                logout();
            }

            @Override
            public void onFail(Throwable t) {
                Gdx.app.error(TAG, "Graph Reqest: Failed with exception.");
                logout();
                t.printStackTrace();
            }

            @Override
            public void onCancel() {
                logout();
            }
        });
    }

    private void autologin() {
        if (!acc.isAutoLoginFinished() && acc.getPrefs().getBoolean("autosignin", false) && gdxFacebook.isLoaded()) {
            if(acc.getPrefs().getBoolean("firstLogin")) {
                loginWithReadPermissions();
                acc.setAutoLoginFinished(true);
            }
        }
    }

    public void getAutoLogin(){
        autologin();
    }

    private void logout() {
        socketSlime.disconnectSocket();
        gdxFacebook.signOut(false);
    }

    public void getlogout(){
        logout();
    }
}
