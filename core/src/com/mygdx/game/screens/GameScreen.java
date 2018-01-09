package com.mygdx.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.Revived;


/**
 * Created by Admin on 08.01.2018.
 */

public class GameScreen implements Screen {
    final Revived Game;
    OrthographicCamera camera;
    Stage stage;
    Texture bgTexture;

    public GameScreen(final Revived gam) {
        this.Game = gam;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 1080, 720);
        stage = new Stage(new FillViewport(1080,720));

        bgTexture = new Texture("D:/Revived/android/assets/img/Bg.png");
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
