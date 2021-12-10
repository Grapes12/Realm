package com.realm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.IntSet;

public class gameState {
    private Player player;
    private IntSet downKeys;
    private Map map;

    public gameState(){
        player = new Player();
        map = new Map(new TmxMapLoader().load("Maptest.tmx"));
    }
    public void updateGame(float dt, IntSet downKeys){
        this.downKeys = downKeys;
        movement();
    }
    public void movement(){
        if (downKeys.contains(Input.Keys.A)) {
            player.move(-16, 0);
        }
        if(downKeys.contains(Input.Keys.D)) {
            player.move(16, 0);
        }
        if(downKeys.contains(Input.Keys.W)) {
            player.move(0, 16);
        }
        if(downKeys.contains(Input.Keys.S)) {
            player.move(0, -16);
        }
    }
    public Player getPlayer() {
        return player;
    }

    public Map getMap() {
        return map;
    }
}
