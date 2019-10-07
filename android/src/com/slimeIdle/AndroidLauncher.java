package com.slimeIdle;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.pay.Offer;
import com.badlogic.gdx.pay.OfferType;
import com.badlogic.gdx.pay.PurchaseManagerConfig;
import com.badlogic.gdx.pay.android.googlebilling.PurchaseManagerGoogleBilling;
import com.slimeIdle.Model.PurchaseManager;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		Slime slime = new Slime();
		PurchaseManager purchaseManager = new PurchaseManager();
		slime.purchaseManager.purchaseManager = new PurchaseManagerGoogleBilling(this);
		slime.purchaseManager.pmc = new PurchaseManagerConfig();
		slime.purchaseManager.pmc.addOffer(new Offer().setType(OfferType.CONSUMABLE).setIdentifier("1"));
		slime.purchaseManager.pmc.addOffer(new Offer().setType(OfferType.CONSUMABLE).setIdentifier("2"));
		slime.purchaseManager.pmc.addOffer(new Offer().setType(OfferType.CONSUMABLE).setIdentifier("3"));
		slime.purchaseManager.pmc.addOffer(new Offer().setType(OfferType.CONSUMABLE).setIdentifier("4"));
		slime.purchaseManager.pmc.addOffer(new Offer().setType(OfferType.CONSUMABLE).setIdentifier("5"));
		initialize(slime, config);
	}
}
