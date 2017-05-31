package eug.awesome.yujin.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;

import eug.awesome.yujin.YujinGame;
import eug.awesome.yujin.player.Player;

/**
 * Created by Yujin on 31/05/2017.
 */

public class MainScreen extends GameScreen {

    public static final String TAG = MainScreen.class.getName();

    private Player player;

    private TiledMap map;
    private OrthogonalTiledMapRenderer tiledMapRenderer;

    public MainScreen(YujinGame game) {
        super(game);
        init();
    }

    private void init() {
        map = new TmxMapLoader().load("tilemaps/home.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(map);

        player = new Player();
        stage.addActor(player);
        stage.addListener(player.getPlayerController());
    }

    @Override
    public void render(float delta) {
        camera.position.set(player.getX(), player.getY(), 0);
        tiledMapRenderer.setView(camera);
        tiledMapRenderer.render();
        super.render(delta);
    }

    @Override
    public void dispose() {
        super.dispose();
        map.dispose();
        tiledMapRenderer.dispose();
    }
}
