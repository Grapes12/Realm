package com.realm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.graphics.g2d.Animation;

public class Realm extends Game {
	float aspectRatio;
	OrthographicCamera camera;
	OrthographicCamera hudCamera;

	SpriteBatch sb;BitmapFont font;
	ShapeRenderer shapeRenderer;


	inputControl Control;
	gameState game;






	@Override
	public void create () {
		aspectRatio = (float)Gdx.graphics.getWidth() / (float)Gdx.graphics.getHeight();
		game = new gameState();
		Control = new inputControl();
		Gdx.input.setInputProcessor(Control);


		MapProperties p = game.getMapManager().getCurrentMap().getTiledMap().getProperties();
		camera = new OrthographicCamera(p.get("tilewidth", Integer.class) * 20 * aspectRatio, p.get("tileheight", Integer.class) * 20 );
		camera.update();

		hudCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		hudCamera.position.set(hudCamera.viewportWidth / 2.0f, hudCamera.viewportHeight / 2.0f, 1.0f);

		sb = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		font = new BitmapFont();

		setScreen(new mainGameScreen(this));
	}

	@Override
	public void dispose() { // SpriteBatches and Textures must always be disposed
		sb.dispose();
		shapeRenderer.dispose();
		font.dispose();
	}


}
