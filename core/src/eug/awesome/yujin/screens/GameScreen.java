package eug.awesome.yujin.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import eug.awesome.yujin.YujinGame;
import eug.awesome.yujin.utlis.GameConstants;

/**
 * Created by Yujin on 31/05/2017.
 */

public abstract class GameScreen implements Screen {

    protected YujinGame game;
    protected Stage stage;
    protected OrthographicCamera camera;

    public GameScreen(YujinGame game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.zoom = 0.5f;
        stage = new Stage(new StretchViewport(GameConstants.SCREEN_WIDTH, GameConstants.SCREEN_HEIGHT, camera));
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        stage.draw();
        stage.act(delta);
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
        stage.getViewport().setScreenSize(width, height);
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
        stage.dispose();
    }
}
