package com.slimeIdle.Model;

import com.badlogic.gdx.pay.PurchaseManagerConfig;

public class PurchaseManager {
    public com.badlogic.gdx.pay.PurchaseManager purchaseManager;
    public PurchaseManagerConfig pmc;

    public void dispose() {
        purchaseManager.dispose();
    }
}
