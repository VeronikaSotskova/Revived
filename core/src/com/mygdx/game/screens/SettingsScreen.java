package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.Revived;

/**
 * Created by Admin on 08.01.2018.
 */

public class SettingsScreen implements Screen {
    final Revived Game;
    OrthographicCamera camera;
    public static Texture bgTexture;
    private Stage stage;
    private Skin skin;
    private TextureAtlas atlas;
    private TextButton.TextButtonStyle textButtonStyle;
    private TextButton back;

    public SettingsScreen(final Revived gam) {
        Game = gam;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1080, 720);

        bgTexture = new Texture("D:/Revived/android/assets/img/Bg.png");
        stage = new Stage(new FillViewport(1080,720));

        skin = new Skin();
        atlas = new TextureAtlas(Gdx.files.internal("img/atlas.atlas"));
        skin.addRegions(atlas);
        textButtonStyle = new TextButton.TextButtonStyle();

        textButtonStyle.font = Revived.myfont;
        textButtonStyle.up = skin.getDrawable("back");
        textButtonStyle.over = skin.getDrawable("back");
        textButtonStyle.down= skin.getDrawable("back");

        back = new TextButton("", textButtonStyle);

        back.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Game.setScreen(Revived.screen);
            }
        });
        back.setSize(310,90);
        back.setPosition(300,300);
        stage.addActor(back);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        Game.batch.setProjectionMatrix(camera.combined);
        Game.batch.begin();
        Game.batch.draw(bgTexture,0,0,1080,720);
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
    public void hide() {

    }

    @Override
    public void dispose() {
        bgTexture.dispose();
        Game.dispose();

    }
}
