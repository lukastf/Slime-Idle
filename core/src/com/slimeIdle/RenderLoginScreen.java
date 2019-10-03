package com.slimeIdle;

public class RenderLoginScreen {

    VariablesDeclaration vd;
    Render render;
    RenderMenssages renderMenssages;

    public RenderLoginScreen(VariablesDeclaration vdRecebido, Render renderRecebido, RenderMenssages renderMenssagesRecebido){
        vd = vdRecebido;
        render = renderRecebido;
        renderMenssages = renderMenssagesRecebido;
    }

    public void render(){
        //vd.batch.draw(vd.background_menu, 1, 1);
        if(!vd.isLoginSuccess() && !vd.isLoginError() && !vd.isCreateAccountSuccess() && !vd.isCreateAccountError()
                && !vd.isCreateAccountErrorPass()) {
            vd.closeWindowBtn.draw(vd.batch);
        }

        if(vd.isCreateAccount()){
            if(!vd.isCreateAccountSuccess() && !vd.isCreateAccountError() && !vd.isCreateAccountErrorPass()) {

                vd.backBtn.draw(vd.batch);
                render.titleScreen("Create Account");

                vd.itemMenuBtns.get(0).draw(vd.batch);
                render.itemMenuBtnsSimpleText0(vd.createAccountStrings.get(0));

                vd.itemMenuBtns.get(1).draw(vd.batch);
                render.itemMenuBtnsSimpleText1(vd.createAccountStrings.get(1));

                vd.itemMenuBtns.get(2).draw(vd.batch);
                render.itemMenuBtnsSimpleText2(vd.passwordsHidden.get(1));

                vd.itemMenuBtns.get(3).draw(vd.batch);
                render.itemMenuBtnsSimpleText3(vd.passwordsHidden.get(2));

                vd.itemMenuBtns.get(4).draw(vd.batch);
                render.itemMenuBtnsSimpleText4("Create Account");

            }

            if(vd.isCreateAccountErrorPass()){
                renderMenssages.messageError("Password","doesn't match");
            }
            if(vd.isCreateAccountError()){
                renderMenssages.messageError("Error check", "input fields");
            }
            if(vd.isCreateAccountSuccess()){
                renderMenssages.messageSuccess("Successfully", "created");
            }


        } else {

            if(!vd.isLoginSuccess() && !vd.isLoginError()) {

                render.titleScreen("Login");

                vd.itemMenuBtns.get(1).draw(vd.batch);
                render.itemMenuBtnsSimpleText1(vd.getNickname());

                vd.itemMenuBtns.get(2).draw(vd.batch);
                render.itemMenuBtnsSimpleText2(vd.passwordsHidden.get(0));

                vd.itemMenuBtns.get(3).draw(vd.batch);
                render.itemMenuBtnsSimpleText3("Login");

                vd.itemMenuBtns.get(4).draw(vd.batch);
                render.itemMenuBtnsSimpleText4("Create Account");

            }

            if(vd.isLoginError()){
                renderMenssages.messageError("Error at", "login");
            }

            if(vd.isLoginSuccess()){
                renderMenssages.messageSuccess("Successfully", "login");
            }

        }
    }

}
