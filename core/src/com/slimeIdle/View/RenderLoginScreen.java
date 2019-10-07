package com.slimeIdle.View;

import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Static;

public class RenderLoginScreen {

    Account acc;
    Render render;
    RenderMenssages renderMenssages;
    Buttons btns;

    public RenderLoginScreen(Account acc, Render render, RenderMenssages renderMenssages, Buttons btns){
        this.acc = acc;
        this.render = render;
        this.renderMenssages = renderMenssages;
        this.btns = btns;
    }

    public void render(){
        //vd.batch.draw(vd.background_menu, 1, 1);
        if(!acc.isLoginSuccess() && !acc.isLoginError() && !acc.isCreateAccountSuccess() && !acc.isCreateAccountError()
                && !acc.isCreateAccountErrorPass()) {
            btns.closeWindowBtn.draw(Static.batch);
        }

        if(acc.isCreateAccount()){
            if(!acc.isCreateAccountSuccess() && !acc.isCreateAccountError() && !acc.isCreateAccountErrorPass()) {

                btns.backBtn.draw(Static.batch);
                render.titleScreen("Create Account");

                btns.itemMenuBtns.get(0).draw(Static.batch);
                render.itemMenuBtnsSimpleText0(acc.createAccountStrings.get(0));

                btns.itemMenuBtns.get(1).draw(Static.batch);
                render.itemMenuBtnsSimpleText1(acc.createAccountStrings.get(1));

                btns.itemMenuBtns.get(2).draw(Static.batch);
                render.itemMenuBtnsSimpleText2(acc.passwordsHidden.get(1));

                btns.itemMenuBtns.get(3).draw(Static.batch);
                render.itemMenuBtnsSimpleText3(acc.passwordsHidden.get(2));

                btns.itemMenuBtns.get(4).draw(Static.batch);
                render.itemMenuBtnsSimpleText4("Create Account");

            }

            if(acc.isCreateAccountErrorPass()){
                renderMenssages.messageError("Password","doesn't match");
            }
            if(acc.isCreateAccountError()){
                renderMenssages.messageError("Error check", "input fields");
            }
            if(acc.isCreateAccountSuccess()){
                renderMenssages.messageSuccess("Successfully", "created");
            }


        } else {

            if(!acc.isLoginSuccess() && !acc.isLoginError()) {

                render.titleScreen("Login");

                btns.itemMenuBtns.get(1).draw(Static.batch);
                render.itemMenuBtnsSimpleText1(acc.getNickname());

                btns.itemMenuBtns.get(2).draw(Static.batch);
                render.itemMenuBtnsSimpleText2(acc.passwordsHidden.get(0));

                btns.itemMenuBtns.get(3).draw(Static.batch);
                render.itemMenuBtnsSimpleText3("Login");

                btns.itemMenuBtns.get(4).draw(Static.batch);
                render.itemMenuBtnsSimpleText4("Create Account");

            }

            if(acc.isLoginError()){
                renderMenssages.messageError("Error at", "login");
            }

            if(acc.isLoginSuccess()){
                renderMenssages.messageSuccess("Successfully", "login");
            }

        }
    }

}
