package com.slimeIdle.Controller.loader;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ArrayMap;
import com.slimeIdle.Model.Buttons;

public class ButtonsTextures {

    Loader loader;
    Buttons btn;

    public ButtonsTextures(Loader loader, Buttons btn) {

        this.loader = loader;
        this.btn = btn;
    }

    public void loadBtnsTextures () {

        btn.buttons = new Texture("textures/buttons.png");

        btn.buttonLoginFace = loader.posicaoTextureCustom(btn.buttons,0,3,5,1);

        btn.buttonCart = loader.posicaoTextureStandard(btn.buttons,0,0);
        btn.buttonCoin = loader.posicaoTextureStandard(btn.buttons,1,0);
        btn.buttonTopLevel = loader.posicaoTextureStandard(btn.buttons,2,0);


        //menu
        btn.buttonCloseWindow = loader.posicaoTextureStandard(btn.buttons,3,0);
        btn.buttonMenu = loader.posicaoTextureCustom(btn.buttons,0,1, 5,1);

        btn.buttonBattle = loader.posicaoTextureStandard(btn.buttons,4,0);
        btn.buttonPrev = loader.posicaoTextureStandard(btn.buttons,5,0);
        btn.buttonNext = loader.posicaoTextureStandard(btn.buttons,6,0);
        btn.buttonBuy = loader.posicaoTextureStandard(btn.buttons,7,0);
        btn.buttonEquip = loader.posicaoTextureStandard(btn.buttons,5,1);
        btn.buttonUnequip = loader.posicaoTextureStandard(btn.buttons,6,0);

        btn.buttonSlimeColor = loader.posicaoTextureStandard(btn.buttons,7,0);
        btn.buttonBackground = loader.posicaoTextureStandard(btn.buttons,5,2);
        btn.buttonLanguage = loader.posicaoTextureStandard(btn.buttons,6,2);
        btn.buttonSlimeItemsBought = loader.posicaoTextureStandard(btn.buttons,7,2);
    }

    public void loadBtnsCollision() {

        btn.buttonCloseCollision = loader.loadButton(btn.buttonCloseWindowProps,0.8f,0.9f,0.16f,0.08f);
        btn.buttonLanguageCollision = loader.loadButton(btn.buttonLanguageProps, 0.8f, 0.8f, 0.16f, 0.08f);
        btn.buttonBackgroundCollision = loader.loadButton(btn.buttonBackgroundProps, 0.8f, 0.7f, 0.16f, 0.08f);
        btn.buttonSlimeColorCollision = loader.loadButton(btn.buttonSlimeColorProps, 0.8f, 0.6f, 0.16f, 0.08f);

        btn.buttonCartCollision = loader.loadButton(btn.buttonCartProps,0.80f,0.2f,0.16f,0.08f);
        btn.buttonCoinCollision = loader.loadButton(btn.buttonCoinProps,0.42f,0.2f,0.16f,0.08f);
        btn.buttonTopLevelCollision = loader.loadButton(btn.buttonTopLevelProps,0.050f,0.2f,0.16f,0.08f);

        btn.buttonMenuProps.add(0, new ArrayMap<String, Float>());
        btn.buttonMenuProps.add(1, new ArrayMap<String, Float>());
        btn.buttonMenuProps.add(2, new ArrayMap<String, Float>());
        btn.buttonMenuProps.add(3, new ArrayMap<String, Float>());
        btn.buttonMenuProps.add(4, new ArrayMap<String, Float>());

        btn.buttonMenuCollision.add(0, loader.loadButton(btn.buttonMenuProps.get(0),0.2f,0.75f,0.6f,0.08f));
        btn.buttonMenuCollision.add(1, loader.loadButton(btn.buttonMenuProps.get(1),0.2f,0.6f,0.6f,0.08f));
        btn.buttonMenuCollision.add(2, loader.loadButton(btn.buttonMenuProps.get(2),0.2f,0.45f,0.6f,0.08f));
        btn.buttonMenuCollision.add(3, loader.loadButton(btn.buttonMenuProps.get(3),0.2f,0.3f,0.6f,0.08f));
        btn.buttonMenuCollision.add(4, loader.loadButton(btn.buttonMenuProps.get(4),0.2f,0.15f,0.6f,0.08f));

        btn.buttonLoginFaceCollision = loader.loadButton(btn.buttonLoginFaceProps,0.2f,0.3f,0.6f,0.08f);
        btn.buttonPrevCollision = loader.loadButton(btn.buttonPrevProps,0.050f,0.03f,0.16f,0.08f);
        btn.buttonNextCollision = loader.loadButton(btn.buttonNextProps,0.80f,0.03f,0.16f,0.08f);
        btn.buttonEquipCollision = loader.loadButton(btn.buttonEquipProps,0.80f,0.03f,0.16f,0.08f);
        btn.buttonUnequipCollision = loader.loadButton(btn.buttonUnequipProps,0.80f,0.03f,0.16f,0.08f);
        btn.buttonBuyCollision = loader.loadButton(btn.buttonBuyProps,0.80f,0.03f,0.16f,0.08f);

    }
}
