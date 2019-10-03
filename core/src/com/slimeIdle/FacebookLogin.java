package com.slimeIdle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.JsonValue;

import de.tomgrill.gdxfacebook.core.GDXFacebookCallback;
import de.tomgrill.gdxfacebook.core.GDXFacebookError;
import de.tomgrill.gdxfacebook.core.GDXFacebookGraphRequest;
import de.tomgrill.gdxfacebook.core.JsonResult;
import de.tomgrill.gdxfacebook.core.SignInMode;
import de.tomgrill.gdxfacebook.core.SignInResult;

import de.tomgrill.gdxfacebook.core.*;

public class FacebookLogin {

    VariablesDeclaration vd;
    SocketSlime socketSlime;

    private static final String TAG = Slime.class.getSimpleName();
    private GDXFacebook gdxFacebook;

    public FacebookLogin(VariablesDeclaration vdRecebido, SocketSlime socketSlimeRecebido){
        vd = vdRecebido;
        socketSlime = socketSlimeRecebido;
    }

    public void configFacebook(){
        FacebookConfig config = new FacebookConfig();
        if (config.APP_ID == null || config.APP_ID.equals("REPLACE_WITH_YOUR_APP_ID")) {
            throw new RuntimeException("You need to set APP_ID in MyFacebookConfig class.");
        }

        gdxFacebook = GDXFacebookSystem.install(config);
    }

    private void loginWithReadPermissions() {
        gdxFacebook.signIn(SignInMode.READ, vd.getPermissionsRead(), new GDXFacebookCallback<SignInResult>() {

            @Override
            public void onSuccess(SignInResult result) {
                gainMoreUserInfo();
                vd.setLogin(true);
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
                vd.setNome(fbName);
                vd.setFbId(vd.encrypt(fbIdForThisApp));
                vd.id = vd.encryptIn2(vd.decrypt(vd.getFbId()));

                vd.getPrefs().putBoolean("firstLogin", true);
                vd.getPrefs().flush();

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
        if (!vd.isAutoLoginFinished() && vd.getPrefs().getBoolean("autosignin", false) && gdxFacebook.isLoaded()) {
            if(vd.getPrefs().getBoolean("firstLogin")) {
                loginWithReadPermissions();
                vd.setAutoLoginFinished(true);
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
