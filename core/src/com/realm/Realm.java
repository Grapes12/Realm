package com.realm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.g2d.Animation;

public class Realm extends ApplicationAdapter {
	private OrthographicCamera camera;
	private SpriteBatch sb;


	private InputControl Control;
	private gameState game;

	TextureRegion[] animationFrames;
	Animation animation;
	float elapsedTime;

	@Override
	public void create () {
		game = new gameState();

		sb = new SpriteBatch();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();

		TextureRegion[][] tmpFrames = TextureRegion.split(new Texture("FireAnimation.png"),64, 64);

		animationFrames = new TextureRegion[5];
		int index = 0;
		for (int i = 0; i < 5; i++) {
			animationFrames[index++] = tmpFrames[0][i];

		}
		animation = new Animation<TextureRegion>(1/15f,animationFrames);

		Control = new InputControl(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), camera);
		Gdx.input.setInputProcessor(Control);
	}

	@Override
	public void render () {
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

		game.updateGame(Gdx.graphics.getDeltaTime(), Control.downKeys);

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		camera.position.set(game.getPlayer().getPosX(), game.getPlayer().getPosY(), 0);
		camera.update();

		game.getMap().setView(camera);
		game.getMap().render();

		TextureRegion cFrame = (TextureRegion) animation.getKeyFrame(elapsedTime,true);
		sb.setProjectionMatrix(camera.combined);

		sb.begin();

		game.getPlayer().getSprite().draw(sb);
		sb.draw(cFrame, 0, 0);

		sb.end();
	}
	@Override
	public void dispose() { // SpriteBatches and Textures must always be disposed
		sb.dispose();

	}


}
