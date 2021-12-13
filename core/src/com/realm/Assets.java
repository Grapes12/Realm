package com.realm;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.SkinLoader;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class Assets {
    private  AssetManager manager;

    public Assets() {
        manager = new AssetManager();
    }

    public void loadFirstMapAssets(){
        manager.load("Maptest.tmx", TiledMap.class);

    }

}
