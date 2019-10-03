package com.slimeIdle;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.pay.Offer;
import com.badlogic.gdx.pay.OfferType;
import com.badlogic.gdx.pay.PurchaseManagerConfig;
import com.badlogic.gdx.pay.android.googlebilling.PurchaseManagerGoogleBilling;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		Slime slime = new Slime();
		slime.vd.purchaseManager = new PurchaseManagerGoogleBilling(this);
		slime.vd.pmc = new PurchaseManagerConfig();
		slime.vd.pmc.addOffer(new Offer().setType(OfferType.CONSUMABLE).setIdentifier("1"));
		slime.vd.pmc.addOffer(new Offer().setType(OfferType.CONSUMABLE).setIdentifier("2"));
		slime.vd.pmc.addOffer(new Offer().setType(OfferType.CONSUMABLE).setIdentifier("3"));
		slime.vd.pmc.addOffer(new Offer().setType(OfferType.CONSUMABLE).setIdentifier("4"));
		slime.vd.pmc.addOffer(new Offer().setType(OfferType.CONSUMABLE).setIdentifier("5"));
		initialize(slime, config);
	}
}
