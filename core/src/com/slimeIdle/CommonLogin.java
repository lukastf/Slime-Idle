package com.slimeIdle;

public class CommonLogin {

    VariablesDeclaration vd;
    SocketSlime socketSlime;

    public CommonLogin(VariablesDeclaration vdRecebido, SocketSlime socketSlimeRecebido){
        vd = vdRecebido;
        socketSlime = socketSlimeRecebido;
    }

    public void getAutoLogin(){
        if(!vd.isAutoLoginFinished() && !vd.getPrefs().getString("fbId").isEmpty()){
            vd.setAutoLoginFinished(true);
            vd.setNome(vd.getPrefs().getString("name"));
            vd.setFbId(vd.getPrefs().getString("fbId"));
            vd.id = vd.encryptIn2(vd.decrypt(vd.getFbId()));
            vd.setNickname(vd.getPrefs().getString("nickname"));
            vd.setPassword(vd.getPrefs().getString("password"));
            vd.pass = vd.encryptIn2(vd.decrypt(vd.getPassword()));
            vd.getPrefs().flush();
            vd.setLogin(true);
            socketSlime.connectSocket();
            socketSlime.configSocketEvents();
        }
    }
}
