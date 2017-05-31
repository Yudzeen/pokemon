package eug.awesome.yujin.player;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * Created by Yujin on 31/05/2017.
 */

public class Player extends Actor {

    public static final String TAG = Player.class.getName();

    private TextureAtlas textureAtlas;
    private TextureRegion textureRegion;

    public Player() {
        init();
    }

    private void init() {
        textureAtlas = new TextureAtlas("images/yujin.atlas");
        textureRegion = new TextureRegion(textureAtlas.findRegion("yujin_south"));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        batch.draw(textureRegion, getX(), getY());
    }
}
