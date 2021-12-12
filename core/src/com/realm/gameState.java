package com.realm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.utils.IntSet;

public class gameState {
    private Player player;
    private IntSet downKeys;
    private com.realm.mapManager mapManager;

    public gameState(){
        player = new Player();
        mapManager = new mapManager();
    }
    public void updateGame(float dt, IntSet downKeys){
        this.downKeys = downKeys;
        movement();
    }
    public void movement(){

        if (downKeys.contains(Input.Keys.A)) {
            player.move(-500f * Gdx.graphics.getDeltaTime(), 0);
        }
        if(downKeys.contains(Input.Keys.D)) {
            player.move(500f * Gdx.graphics.getDeltaTime(), 0);
        }
        if(downKeys.contains(Input.Keys.W)) {
            player.move(0, 500f * Gdx.graphics.getDeltaTime());
        }
        if(downKeys.contains(Input.Keys.S)) {
            player.move(0, -500f * Gdx.graphics.getDeltaTime());
        }
        if(downKeys.contains(Input.Keys.NUM_0)){
            mapManager.setCurrentMap(0);
        }
        if(downKeys.contains(Input.Keys.NUM_1)){
            mapManager.setCurrentMap(1);
        }
    }
    public Player getPlayer() {
        return player;
    }

    public com.realm.mapManager getMapManager() {
        return mapManager;
    }
}
