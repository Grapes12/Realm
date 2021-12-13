package com.realm;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import java.util.ArrayList;

public class mapManager {
    private ArrayList<Map> maps = new ArrayList<>();
    private int currentMap;
    private OrthogonalTiledMapRenderer renderer;

    public mapManager() {
        maps.add(new Map(new TmxMapLoader().load("Maptest.tmx")));
        currentMap = 0;
        renderer = new OrthogonalTiledMapRenderer(maps.get(currentMap).getTiledMap());
    }
    public void setCurrentMap(int currentMap){
        this.currentMap = currentMap;
        renderer.setMap(maps.get(currentMap).getTiledMap());
    }
    public Map getCurrentMap(){
        return maps.get(currentMap);
    }
    public OrthogonalTiledMapRenderer getRenderer(){
        return renderer;
    }
    public void addSprite(Sprite sprite){

    }
}
