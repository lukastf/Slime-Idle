package com.slimeIdle.View;

import com.slimeIdle.Model.Account;
import com.slimeIdle.Model.Buttons;
import com.slimeIdle.Model.Static;

public class RenderLoginScreen {

    Account acc;
    Render render;
    RenderMessages renderMessages;
    Buttons btns;

    public RenderLoginScreen(Account acc, Render render, RenderMessages renderMessages, Buttons btns){
        this.acc = acc;
        this.render = render;
        this.renderMessages = renderMessages;
        this.btns = btns;
    }

    public void render(){
        //vd.batch.draw(vd.background_menu, 1, 1);
        if(!acc.isLoginSuccess() && !acc.isLoginError() && !acc.isCreateAccountSuccess() && !acc.isCreateAccountError()
                && !acc.isCreateAccountErrorPass()) {
            //btns.closeWindowBtn.draw(Static.batch);
            btns.drawCloseWindowBtn();
        }

        if(acc.isCreateAccount()){
            if(!acc.isCreateAccountSuccess() && !acc.isCreateAccountError() && !acc.isCreateAccountErrorPass()) {

                btns.drawButtonPrevBtn();
                render.titleScreen(AllTextStringsLanguages.createAccount);

                //Static.batch.draw(btns.btnMenu, btns.buttonMenuProps.get(0).get("x"), btns.buttonMenuProps.get(0).get("y"));
                //btns.drawMenuBtn(0);
                //render.itemMenuBtnsSimpleText(acc.createAccountStrings.get(0),0);

                //Static.batch.draw(btns.btnMenu, btns.buttonMenuProps.get(1).get("x"), btns.buttonMenuProps.get(1).get("y"));
                btns.drawMenuBtn(1);
                render.itemMenuBtnsSimpleText(acc.createAccountStrings.get(0),false,1);

                //Static.batch.draw(btns.btnMenu, btns.buttonMenuProps.get(2).get("x"), btns.buttonMenuProps.get(2).get("y"));
                btns.drawMenuBtn(2);
                render.itemMenuBtnsSimpleText(acc.createAccountStrings.get(1), false,2);

                //Static.batch.draw(btns.btnMenu, btns.buttonMenuProps.get(3).get("x"), btns.buttonMenuProps.get(3).get("y"));
                btns.drawMenuBtn(3);
                render.itemMenuBtnsSimpleText(acc.createAccountStrings.get(2), false,3);

                //Static.batch.draw(btns.btnMenu, btns.buttonMenuProps.get(4).get("x"), btns.buttonMenuProps.get(4).get("y"));
                btns.drawMenuBtn(4);
                render.itemMenuBtnsSimpleText(AllTextStringsLanguages.createAccount, false,4);

            }

            if(acc.isCreateAccountErrorPass()){
                renderMessages.messageError(AllTextStringsLanguages.errorPassword.get(0), AllTextStringsLanguages.errorPassword.get(1));
            }
            if(acc.isCreateAccountError()){
                renderMessages.messageError(AllTextStringsLanguages.errorInput.get(0), AllTextStringsLanguages.errorInput.get(1));
            }
            if(acc.isCreateAccountSuccess()){
                renderMessages.messageSuccess(AllTextStringsLanguages.successCreated.get(0), AllTextStringsLanguages.successCreated.get(1));
            }


        } else {

            if(!acc.isLoginSuccess() && !acc.isLoginError()) {

                render.titleScreen(AllTextStringsLanguages.login);

                for (int i = 1; i < 5; i++) {

                    btns.drawMenuBtn(i);
                    //Static.batch.draw(btns.btnMenu, btns.buttonMenuProps.get(i).get("x"), btns.buttonMenuProps.get(i).get("y"));
                    //render.itemMenuBtnsSimpleText(acc.loginStrings.get(0),1);
                }

                //btns.itemMenuBtns.get(1).draw(Static.batch);
                render.itemMenuBtnsSimpleText(acc.loginStrings.get(0),false,1);

                //btns.itemMenuBtns.get(2).draw(Static.batch);
                render.itemMenuBtnsSimpleText(acc.loginStrings.get(1), false,2);

                //btns.itemMenuBtns.get(3).draw(Static.batch);
                render.itemMenuBtnsSimpleText(AllTextStringsLanguages.login, false,3);

                //btns.itemMenuBtns.get(4).draw(Static.batch);
                render.itemMenuBtnsSimpleText(AllTextStringsLanguages.createAccount, false,4);

            }

            if(acc.isLoginError()){
                renderMessages.messageError(AllTextStringsLanguages.errorLogin.get(0), AllTextStringsLanguages.errorLogin.get(1));
            }

            if(acc.isLoginSuccess()){
                renderMessages.messageSuccess(AllTextStringsLanguages.successLogin.get(0), AllTextStringsLanguages.successLogin.get(1));
            }

        }
    }

}
