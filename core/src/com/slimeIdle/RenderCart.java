package com.slimeIdle;

public class RenderCart {

    VariablesDeclaration vd;
    Render render;
    RenderMenssages renderMenssages;

    public RenderCart(VariablesDeclaration vdRecebido, Render renderRecebido ,RenderMenssages renderMenssagesRecebido){
        vd = vdRecebido;
        render = renderRecebido;
        renderMenssages = renderMenssagesRecebido;
    }

    public void render(){
        if(vd.isMenu_item_selecionado()) {

            render.titleScreen(vd.itemsShopNames.get(vd.getItemSelecionado()));
            render.subTitleScreen(vd.itemsShopPrices.get(vd.getItemSelecionado()));

            vd.slimeSpr.draw(vd.batch);

            if(vd.getItemSelecionado() == 0 || vd.getItemSelecionado() == 1) {
                vd.batch.draw(vd.itemsShopSprites.get(vd.getItemSelecionado()),
                        (vd.camera.position.x - (vd.w/3)),
                        (vd.camera.position.y));
            } else {
                vd.tw = vd.slimeSpr.getWidth();
                vd.th = vd.slimeSpr.getHeight();
                vd.batch.draw(vd.itemsShopSprites.get(vd.getItemSelecionado()),
                        (vd.camera.position.x - (vd.tw/2)),
                        (vd.camera.position.y - (vd.th/2) + (vd.h/5)),
                        vd.tw, vd.th);
            }

            if(!vd.isMenu_item_BuySuccess() && !vd.isMenu_item_BuyError_ready() && !vd.isMenu_item_BuyError_money()) {

                vd.backBtn.draw(vd.batch);

                if (vd.getItemSelecionado() != 0 && vd.itemsShopBought.get(vd.getItemSelecionado())) {
                    if ((vd.getItemEquippedId() * -1) + 1 == vd.getItemSelecionado() ||
                            vd.getItemEquippedId() + 5 == vd.getItemSelecionado()) {
                        vd.unequipBtn.draw(vd.batch);
                    } else {
                        vd.equipBtn.draw(vd.batch);
                    }
                } else {
                    vd.buyBtn.draw(vd.batch);
                }
            }
            if(vd.isMenu_item_BuySuccess()){
                renderMenssages.messageSuccess("Successfully", "Bought");
            }
            if(vd.isMenu_item_BuyError_ready()){
                renderMenssages.messageError("Your slime is", "already Read!");
            }
            if(vd.isMenu_item_BuyError_money()) {
                renderMenssages.messageError("You don't", "have coins");
            }


        } else {

            render.titleScreen("Shop");
            render.subTitleScreen("Coins: " + vd.getCoins());

            vd.itemMenuBtns.get(0).draw(vd.batch);
            vd.itemMenuBtns.get(1).draw(vd.batch);
            vd.itemMenuBtns.get(2).draw(vd.batch);
            vd.itemMenuBtns.get(3).draw(vd.batch);
            vd.itemMenuBtns.get(4).draw(vd.batch);

            if (vd.getCurrentPage() == 1) {

                //time reset
                //vd.timeSpr.draw(vd.batch);
                vd.itemsShopSprites.get(0).draw(vd.batch);
                vd.itemsShopNames.set(0,"Time Reset");
                vd.itemsShopPrices.set(0,"price: 10 coins");
                render.itemMenuBtnsDoubleText0(vd.itemsShopNames.get(0), vd.itemsShopPrices.get(0),true);

                //change nickname
                //vd.pencilSpr.draw(vd.batch);
                vd.itemsShopSprites.get(1).draw(vd.batch);
                vd.itemsShopNames.set(1,"Change Nick");
                vd.itemsShopPrices.set(1,"price: 10 coins");
                render.itemMenuBtnsDoubleText1(vd.itemsShopNames.get(1), vd.itemsShopPrices.get(1),true);

                for(int i = 2; i < 5; i++){
                    vd.itemsShopSprites.get(i).draw(vd.batch);
                    //vd.itemsShopNames.set(i,"Item " + i);
                   // vd.itemsShopPrices.set(i,"price: 0 coins");
                    if(i == 2){
                        render.itemMenuBtnsDoubleText2(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 3){
                        render.itemMenuBtnsDoubleText3(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 4){
                        render.itemMenuBtnsDoubleText4(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                }
                /*
                vd.itemsShopSprites.get(2).draw(vd.batch);
                vd.itemsShopNames.add(2,"Santa Claus Hat");
                vd.itemsShopPrices.add(2,"price: 30 coins");
                render.itemMenuBtnsDoubleText2(vd.itemsShopNames.get(2), vd.itemsShopPrices.get(2), true);

                vd.itemsShopSprites.get(3).draw(vd.batch);
                vd.itemsShopNames.add(3,"Habbit Ears");
                vd.itemsShopPrices.add(3,"price: 30 coins");
                render.itemMenuBtnsDoubleText3(vd.itemsShopNames.get(3), vd.itemsShopPrices.get(3), true);

                vd.itemsShopSprites.get(4).draw(vd.batch);
                vd.itemsShopNames.add(4,"Witch Hat");
                vd.itemsShopPrices.add(4,"price: 30 coins");
                render.itemMenuBtnsDoubleText4(vd.itemsShopNames.get(4), vd.itemsShopPrices.get(4), true);*/
            }
            if (vd.getCurrentPage() == 2) {

                for(int i = 5; i < 10; i++){
                    vd.itemsShopSprites.get(i).draw(vd.batch);
                    //vd.itemsShopNames.set(i,"Item " + i);
                    //vd.itemsShopPrices.set(i,"price: 0 coins");
                    if(i == 5){
                        render.itemMenuBtnsDoubleText0(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 6){
                        render.itemMenuBtnsDoubleText1(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 7){
                        render.itemMenuBtnsDoubleText2(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 8){
                        render.itemMenuBtnsDoubleText3(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 9){
                        render.itemMenuBtnsDoubleText4(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                }
                /*
                // viking helmet
                vd.itemsShopSprites.get(5).draw(vd.batch);
                vd.itemsShopNames.add(5,"Black Habbit Ears");
                vd.itemsShopPrices.add(5,"price: 30 coins");
                render.itemMenuBtnsDoubleText0(vd.itemsShopNames.get(5), vd.itemsShopPrices.get(5), true);

                // party hat
                vd.itemsShopSprites.get(6).draw(vd.batch);
                vd.itemsShopNames.add(6,"Viking Helmet");
                vd.itemsShopPrices.add(6,"price: 20 coins");
                render.itemMenuBtnsDoubleText1(vd.itemsShopNames.get(6), vd.itemsShopPrices.get(6), true);

                // wizard hat
                vd.itemsShopSprites.get(7).draw(vd.batch);
                vd.itemsShopNames.add(7,"Party Hat");
                vd.itemsShopPrices.add(7,"price: 10 coins");
                render.itemMenuBtnsDoubleText2(vd.itemsShopNames.get(7), vd.itemsShopPrices.get(7), true);

                vd.itemsShopSprites.get(8).draw(vd.batch);
                vd.itemsShopNames.add(8,"Wizard Hat");
                vd.itemsShopPrices.add(8,"price: 20 coins");
                render.itemMenuBtnsDoubleText3(vd.itemsShopNames.get(8), vd.itemsShopPrices.get(8), true);

                vd.itemsShopSprites.get(9).draw(vd.batch);
                vd.itemsShopNames.add(9,"Anime Hat");
                vd.itemsShopPrices.add(9,"price: 30 coins");
                render.itemMenuBtnsDoubleText4(vd.itemsShopNames.get(9), vd.itemsShopPrices.get(9), true);
                */
            }
            if (vd.getCurrentPage() == 3) {
                for(int i = 10; i < 15; i++){
                    vd.itemsShopSprites.get(i).draw(vd.batch);
                    //vd.itemsShopNames.set(i,"Item " + i);
                    //vd.itemsShopPrices.set(i,"price: 0 coins");
                    if(i == 10){
                        render.itemMenuBtnsDoubleText0(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 11){
                        render.itemMenuBtnsDoubleText1(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 12){
                        render.itemMenuBtnsDoubleText2(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 13){
                        render.itemMenuBtnsDoubleText3(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 14){
                        render.itemMenuBtnsDoubleText4(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                }
                /*
                vd.itemsShopSprites.get(10).draw(vd.batch);
                vd.itemsShopNames.add(10,"Cat Ears");
                vd.itemsShopPrices.add(10,"price: 20 coins");
                render.itemMenuBtnsDoubleText0(vd.itemsShopNames.get(10), vd.itemsShopPrices.get(10), true);

                vd.itemsShopSprites.get(11).draw(vd.batch);
                vd.itemsShopNames.add(11,"Winged Helmet");
                vd.itemsShopPrices.add(11,"price: 50 coins");
                render.itemMenuBtnsDoubleText1(vd.itemsShopNames.get(11), vd.itemsShopPrices.get(11), true);

                vd.itemsShopSprites.get(12).draw(vd.batch);
                vd.itemsShopNames.add(12,"Black Cat Ears");
                vd.itemsShopPrices.add(12,"price: 20 coins");
                render.itemMenuBtnsDoubleText2(vd.itemsShopNames.get(12), vd.itemsShopPrices.get(12), true);

                vd.itemsShopSprites.get(13).draw(vd.batch);
                vd.itemsShopNames.add(13,"Cowboy Hat 1");
                vd.itemsShopPrices.add(13,"price: 30 coins");
                render.itemMenuBtnsDoubleText3(vd.itemsShopNames.get(13), vd.itemsShopPrices.get(13), true);

                vd.itemsShopSprites.get(14).draw(vd.batch);
                vd.itemsShopNames.add(14,"Cowboy Hat 2");
                vd.itemsShopPrices.add(14,"price: 30 coins");
                render.itemMenuBtnsDoubleText4(vd.itemsShopNames.get(14), vd.itemsShopPrices.get(14), true);
                */
            }
            if (vd.getCurrentPage() == 4) {
                for(int i = 15; i < 20; i++){
                    vd.itemsShopSprites.get(i).draw(vd.batch);
                    //vd.itemsShopNames.set(i,"Item " + i);
                    //vd.itemsShopPrices.set(i,"price: 0 coins");
                    if(i == 15){
                        render.itemMenuBtnsDoubleText0(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 16){
                        render.itemMenuBtnsDoubleText1(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 17){
                        render.itemMenuBtnsDoubleText2(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 18){
                        render.itemMenuBtnsDoubleText3(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 19){
                        render.itemMenuBtnsDoubleText4(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                }
                /*
                vd.itemsShopSprites.get(15).draw(vd.batch);
                vd.itemsShopNames.add(15,"Hair 1");
                vd.itemsShopPrices.add(15,"price: 20 coins");
                render.itemMenuBtnsDoubleText0(vd.itemsShopNames.get(15), vd.itemsShopPrices.get(15), true);

                vd.itemsShopSprites.get(16).draw(vd.batch);
                vd.itemsShopNames.add(16,"Hair 2");
                vd.itemsShopPrices.add(16,"price: 20 coins");
                render.itemMenuBtnsDoubleText1(vd.itemsShopNames.get(16), vd.itemsShopPrices.get(16), true);

                vd.itemsShopSprites.get(17).draw(vd.batch);
                vd.itemsShopNames.add(17,"Hair 3");
                vd.itemsShopPrices.add(17,"price: 20 coins");
                render.itemMenuBtnsDoubleText2(vd.itemsShopNames.get(17), vd.itemsShopPrices.get(17), true);

                vd.itemsShopSprites.get(18).draw(vd.batch);
                vd.itemsShopNames.add(18,"Hair 4");
                vd.itemsShopPrices.add(18,"price: 20 coins");
                render.itemMenuBtnsDoubleText3(vd.itemsShopNames.get(18), vd.itemsShopPrices.get(18), true);

                vd.itemsShopSprites.get(19).draw(vd.batch);
                vd.itemsShopNames.add(19,"Hair 5");
                vd.itemsShopPrices.add(19,"price: 20 coins");
                render.itemMenuBtnsDoubleText4(vd.itemsShopNames.get(19), vd.itemsShopPrices.get(19), true);
                */
            }

            if (vd.getCurrentPage() == 5) {

                for(int i = 20; i < 25; i++){
                    vd.itemsShopSprites.get(i).draw(vd.batch);
                    //vd.itemsShopNames.set(i,"Item " + i);
                    //vd.itemsShopPrices.set(i,"price: 0 coins");
                    if(i == 20){
                        render.itemMenuBtnsDoubleText0(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 21){
                        render.itemMenuBtnsDoubleText1(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 22){
                        render.itemMenuBtnsDoubleText2(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 23){
                        render.itemMenuBtnsDoubleText3(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                    if(i == 24){
                        render.itemMenuBtnsDoubleText4(vd.itemsShopNames.get(i), vd.itemsShopPrices.get(i), true);
                    }
                }
                /*
                vd.itemsShopSprites.get(20).draw(vd.batch);
                vd.itemsShopNames.add(20,"Propeller Hat");
                vd.itemsShopPrices.add(20,"price: 30 coins");
                render.itemMenuBtnsDoubleText0(vd.itemsShopNames.get(20), vd.itemsShopPrices.get(20), true);

                vd.itemsShopSprites.get(21).draw(vd.batch);
                vd.itemsShopNames.add(21,"Robin Hat");
                vd.itemsShopPrices.add(21,"price: 20 coins");
                render.itemMenuBtnsDoubleText1(vd.itemsShopNames.get(21), vd.itemsShopPrices.get(21), true);

                vd.itemsShopSprites.get(22).draw(vd.batch);
                vd.itemsShopNames.add(22,"Crown");
                vd.itemsShopPrices.add(22,"price: 50 coins");
                render.itemMenuBtnsDoubleText2(vd.itemsShopNames.get(22), vd.itemsShopPrices.get(22), true);

                vd.itemsShopSprites.get(23).draw(vd.batch);
                vd.itemsShopNames.add(23,"Cake Hat");
                vd.itemsShopPrices.add(23,"price: 20 coins");
                render.itemMenuBtnsDoubleText3(vd.itemsShopNames.get(23), vd.itemsShopPrices.get(23), true);

                vd.itemsShopSprites.get(24).draw(vd.batch);
                vd.itemsShopNames.add(24,"Unicorn Hat");
                vd.itemsShopPrices.add(24,"price: 30 coins");
                render.itemMenuBtnsDoubleText4(vd.itemsShopNames.get(24), vd.itemsShopPrices.get(24), true);
                */
            }

            vd.tw = vd.prevBtn.getWidth();
            vd.th = vd.prevBtn.getHeight();

            render.pages(vd.getCurrentPage() + "/5");
        }
    }
}
