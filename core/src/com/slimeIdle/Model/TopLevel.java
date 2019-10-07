package com.slimeIdle.Model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import java.util.ArrayList;

public class TopLevel {

    // Textures
    public Texture topLevel;

    // Sprites


    private int playerTopSelecionado = 0;

    public int getPlayerTopSelecionado() {
        return playerTopSelecionado;
    }
    public void setPlayerTopSelecionado(int playerTopSelecionado) {
        this.playerTopSelecionado = playerTopSelecionado;
    }

    public ArrayList<String> topPlayers = new ArrayList<String>();
    public ArrayList<String> topPlayersLevel = new ArrayList<String>();
    public ArrayList<Integer> topPlayersItemEquippedId = new ArrayList<Integer>();

    public void dispose () {
        topLevel.dispose();
    }
}
