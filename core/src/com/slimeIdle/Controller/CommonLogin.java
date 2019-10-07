package com.slimeIdle.Controller;

import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Encryption;
import com.slimeIdle.Model.SocketSlime;

public class CommonLogin {

    Account acc;
    SocketSlime socketSlime;
    Encryption encr;

    public CommonLogin(Account acc, SocketSlime socketSlime, Encryption encryption){
        this.acc = acc;
        this.socketSlime = socketSlime;
        this.encr = encryption;
    }

    public void getAutoLogin(){
        if(!acc.isAutoLoginFinished() && !acc.getPrefs().getString("fbId").isEmpty()){
            acc.setAutoLoginFinished(true);
            acc.setNome(acc.getPrefs().getString("name"));
            acc.setFbId(acc.getPrefs().getString("fbId"));
            acc.id = encr.encryptIn2(encr.decrypt(acc.getFbId()));
            acc.setNickname(acc.getPrefs().getString("nickname"));
            acc.setPassword(acc.getPrefs().getString("password"));
            acc.pass = encr.encryptIn2(encr.decrypt(acc.getPassword()));
            acc.getPrefs().flush();
            acc.setLogin(true);
            socketSlime.connectSocket();
            socketSlime.configSocketEvents();
        }
    }
}
