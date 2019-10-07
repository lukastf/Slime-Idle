package com.slimeIdle.Controller;

import com.badlogic.gdx.pay.Transaction;
import com.slimeIdle.Model.SocketSlime;


public class PurchaseObserver implements com.badlogic.gdx.pay.PurchaseObserver {

    SocketSlime socketSlime;
    Transaction t = new Transaction();

    public PurchaseObserver(SocketSlime socketSlimeRecebido){
        socketSlime = socketSlimeRecebido;
    }

    @Override
    public void handleInstall() {
    }

    @Override
    public void handleInstallError(Throwable e) {
        // throw error
        //throw new GdxRuntimeException(e);
    }

    @Override
    public void handleRestore(Transaction[] transactions) {
    }

    @Override
    public void handleRestoreError(Throwable e) {
        // throw error
        //throw new GdxRuntimeException(e);
    }

    @Override
    public void handlePurchase(Transaction transaction) {
        String id = transaction.getIdentifier();
        socketSlime.buyCoins(id);
    }

    @Override
    public void handlePurchaseError(Throwable e) {
        // throw error
        //throw new GdxRuntimeException(e);
    }

    @Override
    public void handlePurchaseCanceled() {
    }
}
