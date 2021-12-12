package com.realm;

import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMap;

public class Map {
    private int width, height;
    private TiledMap TiledMap;

    public Map(TiledMap TiledMap){
        this.TiledMap = TiledMap;
        MapProperties p = TiledMap.getProperties();
        width = (p.get("width", Integer.class) * p.get("tilewidth", Integer.class));
        height = (p.get("height", Integer.class) * p.get("tileheight", Integer.class));
    }
    public TiledMap getTiledMap(){
        return TiledMap;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }
}
