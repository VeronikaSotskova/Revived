package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.Revived;

/**
 * Created by Admin on 08.01.2018.
 */

public class MainMenuScreen implements Screen {

    final Revived Game;
    OrthographicCamera camera;
    public static Texture bgTexture1;
    private Stage stage;
    private Skin skin;
    private TextureAtlas atlas;
    private BitmapFont font;
    private TextButton.TextButtonStyle textButtonStyle;
    private TextButton startGame;
    private TextButton settings;
    private TextButton exit;
    final String font_chars = "абвгдежзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";

    public MainMenuScreen(final Revived gam) {
        Game = gam;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1080, 720);

        bgTexture1 = new Texture("D:/Revived/android/assets/img/WABENE.jpg");
        stage = new Stage(new FillViewport(1080,720));
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("fonts/Old English Text MT.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = font_chars;
        parameter.size = 50;
        parameter.color = Color.BLACK;
        font = generator.generateFont(parameter);
        generator.dispose();

        skin = new Skin();
        atlas = new TextureAtlas(Gdx.files.internal("img/atlas.atlas"));
        skin.addRegions(atlas);
        textButtonStyle = new TextButton.TextButtonStyle();

        textButtonStyle.font = font;
        textButtonStyle.up = skin.getDrawable("button");
        textButtonStyle.over = skin.getDrawable("button");
        textButtonStyle.down= skin.getDrawable("button2");

        startGame = new TextButton("New Game", textButtonStyle);
        settings = new TextButton("Settings",textButtonStyle);
        exit = new TextButton("Exit",textButtonStyle);

        startGame.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Game.setScreen(new GameScreen(Game));
            }
        });

        settings.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Game.setScreen(new SettingsScreen(Game));
            }
        });
        exit.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
        startGame.setSize(310,90);
        settings.setSize(310,90);
        exit.setSize(310,90);
        startGame.setPosition(360,300);
        settings.setPosition(360, 200);
        exit.setPosition(360, 80);
        stage.addActor(startGame);
        stage.addActor(settings);
        stage.addActor(exit);

    }


    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void hide() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        Game.batch.setProjectionMatrix(camera.combined);
        Game.batch.begin();
        Game.batch.draw(bgTexture1,0,0,1080,720);
        Game.myfont.draw(Game.batch,"Revived",240,450);
        stage.act();
        stage.draw();
        Game.batch.end();
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
    public void dispose() {
        stage.dispose();
        Game.dispose();
    }
}
