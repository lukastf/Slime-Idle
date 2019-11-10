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
            btns.closeWindowBtn.draw(Static.batch);
        }

        if(acc.isCreateAccount()){
            if(!acc.isCreateAccountSuccess() && !acc.isCreateAccountError() && !acc.isCreateAccountErrorPass()) {

                btns.backBtn.draw(Static.batch);
                render.titleScreen(AllTextStrings.createAccount);

                /*for (int i = 0; i < 5; i++) {
                    btns.itemMenuBtns.get(i).draw(Static.batch);
                    render.itemMenuBtnsSimpleText0(acc.createAccountStrings.get(0));
                }*/

                btns.itemMenuBtns.get(0).draw(Static.batch);
                render.itemMenuBtnsSimpleText(acc.createAccountStrings.get(0),0);

                btns.itemMenuBtns.get(1).draw(Static.batch);
                render.itemMenuBtnsSimpleText(acc.createAccountStrings.get(1),1);

                btns.itemMenuBtns.get(2).draw(Static.batch);
                render.itemMenuBtnsSimpleText(acc.passwordsHidden.get(1), 2);

                btns.itemMenuBtns.get(3).draw(Static.batch);
                render.itemMenuBtnsSimpleText(acc.passwordsHidden.get(2), 3);

                btns.itemMenuBtns.get(4).draw(Static.batch);
                render.itemMenuBtnsSimpleText(AllTextStrings.createAccount, 4);

            }

            if(acc.isCreateAccountErrorPass()){
                renderMessages.messageError(AllTextStrings.errorPassword[0], AllTextStrings.errorPassword[1]);
            }
            if(acc.isCreateAccountError()){
                renderMessages.messageError(AllTextStrings.errorInput[0], AllTextStrings.errorInput[1]);
            }
            if(acc.isCreateAccountSuccess()){
                renderMessages.messageSuccess(AllTextStrings.successCreated[0], AllTextStrings.successCreated[1]);
            }


        } else {

            if(!acc.isLoginSuccess() && !acc.isLoginError()) {

                render.titleScreen(AllTextStrings.login);

                btns.itemMenuBtns.get(1).draw(Static.batch);
                render.itemMenuBtnsSimpleText(acc.getNickname(),1);

                btns.itemMenuBtns.get(2).draw(Static.batch);
                render.itemMenuBtnsSimpleText(acc.passwordsHidden.get(0), 2);

                btns.itemMenuBtns.get(3).draw(Static.batch);
                render.itemMenuBtnsSimpleText(AllTextStrings.login, 3);

                btns.itemMenuBtns.get(4).draw(Static.batch);
                render.itemMenuBtnsSimpleText(AllTextStrings.createAccount, 4);

            }

            if(acc.isLoginError()){
                renderMessages.messageError(AllTextStrings.errorLogin[0], AllTextStrings.errorLogin[1]);
            }

            if(acc.isLoginSuccess()){
                renderMessages.messageSuccess(AllTextStrings.successLogin[0], AllTextStrings.successLogin[1]);
            }

        }
    }

}
