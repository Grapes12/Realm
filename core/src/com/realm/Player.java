package com.realm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {
    private Sprite sprite;
    private int posX, posY;

    public Player(){
        posX = Gdx.graphics.getWidth()/2;
        posY = Gdx.graphics.getHeight()/2;
        sprite = new Sprite(new Texture("vishnu.jpg"));
        sprite.setSize(64, 64);
        updateSprite();


    }
    public void move(int x, int y){
        posX += x;
        posY += y;
        updateSprite();
    }
    private void updateSprite(){
        sprite.setCenter(posX, posY);
    }
    public Sprite getSprite(){
        return sprite;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }

}
