package com.realm;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.IntSet;

public class mainGameScreenInputControl extends InputAdapter implements InputProcessor {

    public final IntSet downKeys = new IntSet(20);
    private mainGameScreen screen;
    private Realm realm;
    public mainGameScreenInputControl(Realm realm, mainGameScreen screen){
        this.screen = screen;
        this.realm = realm;
    }
    @Override
    public boolean keyDown(int keycode) {
        downKeys.add(keycode);
        return true;
    }
    @Override
    public boolean keyUp(int keycode) {
        downKeys.remove(keycode);
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        System.out.println("YEET");
        screen.camera.zoom += amountY * 0.1f;
        screen.camera.update();
        return true;
    }

}
