package eug.awesome.yujin.screens;

import eug.awesome.yujin.YujinGame;
import eug.awesome.yujin.player.Player;

/**
 * Created by Yujin on 31/05/2017.
 */

public class MainScreen extends GameScreen {

    public static final String TAG = MainScreen.class.getName();

    private Player player;

    public MainScreen(YujinGame game) {
        super(game);
        player = new Player();
        player.setPosition(400, 200);
        stage.addActor(player);
    }

    @Override
    public void render(float delta) {
        camera.position.set(player.getX(), player.getY(), 0);
        super.render(delta);
    }
}
