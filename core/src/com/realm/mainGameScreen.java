package com.realm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapProperties;

public class mainGameScreen implements Screen {
    private Realm realm;

    private TextureRegion[] animationFrames;
    private Animation animation;
    private float elapsedTime;


    public mainGameScreen(Realm realm){
        this.realm = realm;

        loadAnimations();
    }
    public void loadAnimations(){
        TextureRegion[][] tmpFrames = TextureRegion.split(new Texture("FireAnimation.png"),64, 64);

        animationFrames = new TextureRegion[5];
        int index = 0;
        for (int i = 0; i < 5; i++) {
            animationFrames[index++] = tmpFrames[0][i];

        }
        animation = new Animation<TextureRegion>(1/15f,animationFrames);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        /*   INDEP CAM CONTROL
		if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
				camera.translate(-16, 0);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
				camera.translate(16, 0);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
				camera.translate(0, 16);
		}
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
				camera.translate(0, -16);
		}
		*/
        elapsedTime += Gdx.graphics.getDeltaTime();
        realm.game.updateGame(Gdx.graphics.getDeltaTime(), realm.Control.downKeys);
        updateCamera();
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        realm.camera.position.set(realm.game.getPlayer().getPosX(), realm.game.getPlayer().getPosY(), 0);
        realm.camera.update();

        realm.game.getMapManager().getRenderer().setView(realm.camera);
        realm.game.getMapManager().getRenderer().render();

        TextureRegion cFrame = (TextureRegion) animation.getKeyFrame(elapsedTime,true);

        //draw with game camera
        realm.sb.setProjectionMatrix(realm.camera.combined);
        realm.sb.begin();

        realm.game.getPlayer().getSprite().draw(realm.sb);
        realm.sb.draw(cFrame, realm.game.getPlayer().getPosX() - 32, realm.game.getPlayer().getPosY() - 48);

        realm.sb.end();

        //draw with hud camera
        realm.sb.setProjectionMatrix(realm.hudCamera.combined);
        realm.sb.begin();

        realm.font.draw(realm.sb, "FPS=" + Gdx.graphics.getFramesPerSecond(), 0, realm.hudCamera.viewportHeight - 5);

        realm.sb.end();

        realm.hudCamera.update();

    }
    public void updateCamera(){
        MapProperties p = realm.game.getMapManager().getCurrentMap().getTiledMap().getProperties();
        realm.camera = new OrthographicCamera(p.get("tilewidth", Integer.class) * 20 * realm.aspectRatio, p.get("tileheight", Integer.class) * 20 );
        realm.camera.update();
        realm.hudCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        realm.hudCamera.position.set(realm.hudCamera.viewportWidth / 2.0f, realm.hudCamera.viewportHeight / 2.0f, 1.0f);
        realm.hudCamera.update();
    }
    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
