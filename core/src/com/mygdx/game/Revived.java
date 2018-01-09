package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.mygdx.game.screens.MainMenuScreen;

public class Revived extends Game {

	public SpriteBatch batch;
	public BitmapFont font;
	public static BitmapFont myfont;
	public static Screen screen;
	Music music;

	@Override
	public void create() {
		batch = new SpriteBatch();
		font = new BitmapFont();
		myfont = new BitmapFont();
		music = Gdx.audio.newMusic(Gdx.files.internal("music.mp3"));
		final String FONT_CHARS = "абвгдежзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|/?-+=()*&.;:,{}";
		final String FONT_PATH = "D:/Revived/android/assets/fonts/Old English Text MT.ttf";
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.absolute(FONT_PATH));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.characters = FONT_CHARS;
		parameter.size = 17;
		parameter.color = Color.BROWN;
		music.setLooping(true);
		music.play();
		myfont = generator.generateFont(parameter);
		generator.dispose();
		screen = new MainMenuScreen(this);
		this.setScreen(screen);
		font.setColor(1f,0f,0f,1f);
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		font.dispose();
		myfont.dispose();
		music.dispose();
	}
}
