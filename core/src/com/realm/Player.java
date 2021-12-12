package com.realm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player {
    private Sprite sprite;
    private int posX, posY;
    private Rectangle rect;

    public Player(){
        posX = Gdx.graphics.getWidth()/2;
        posY = Gdx.graphics.getHeight()/2;
        sprite = new Sprite(new Texture("vishnu.jpg"));
        sprite.setSize(32, 32);
        updateSprite();
    }
    public void move(float x, float y){
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
