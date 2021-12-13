package com.realm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
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



	SpriteBatch sb;
	BitmapFont font;
	ShapeRenderer shapeRenderer;

	AssetManager manager;

	gameState game;

	mainGameScreen mgs;



	@Override
	public void create () {
		aspectRatio = (float)Gdx.graphics.getWidth() / (float)Gdx.graphics.getHeight();
		aspectRatio = 1920f/1017f;




		game = new gameState();



		sb = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		font = new BitmapFont();

		manager = new AssetManager();

		mgs = new mainGameScreen(this);
		setScreen(mgs);

	}

	@Override
	public void dispose() {
		sb.dispose();
		shapeRenderer.dispose();
		font.dispose();
	}


}
