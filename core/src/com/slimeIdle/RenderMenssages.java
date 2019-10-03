package com.slimeIdle;

public class RenderMenssages {

    VariablesDeclaration vd;

    public RenderMenssages(VariablesDeclaration vdRecebido){
        vd = vdRecebido;
    }

    public void messageSuccess(String msg1, String msg2){
        vd.windowSpr.draw(vd.batch);
        vd.fontSuccess.draw(vd.batch, msg1,
                (float) (vd.camera.position.x/2),
                (float)(vd.camera.position.y + vd.camera.position.y/10));
        vd.fontSuccess.draw(vd.batch, msg2,
                (float) (vd.camera.position.x/2),
                (float)(vd.camera.position.y - vd.camera.position.y/45));
        vd.itemMenuBtns.get(4).draw(vd.batch);
        vd.fontTopLevel.draw(vd.batch, "Ok",
                (float)(vd.camera.position.x/1.1),
                (float)(vd.camera.position.y - vd.camera.position.y/2.10));
    }

    public void messageError(String msg1, String msg2){
        vd.windowSpr.draw(vd.batch);
        vd.fontError.draw(vd.batch, msg1,
                (float) (vd.camera.position.x/2),
                (float)(vd.camera.position.y + vd.camera.position.y/10));
        vd.fontError.draw(vd.batch, msg2,
                (float) (vd.camera.position.x/2),
                (float)(vd.camera.position.y - vd.camera.position.y/45));
        vd.itemMenuBtns.get(4).draw(vd.batch);
        vd.fontTopLevel.draw(vd.batch, "Ok",
                (float)(vd.camera.position.x/1.1),
                (float)(vd.camera.position.y - vd.camera.position.y/2.10));
    }
}
