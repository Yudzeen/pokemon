package eug.awesome.yujin.player;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Player renderer
 */

class PlayerRenderer {

    private static final String TAG = PlayerRenderer.class.getName();

    private Player player;

    private TextureAtlas atlas;

    private Animation<TextureAtlas.AtlasRegion> walkWestAnimation;
    private Animation<TextureAtlas.AtlasRegion> walkEastAnimation;
    private Animation<TextureAtlas.AtlasRegion> walkSouthAnimation;
    private Animation<TextureAtlas.AtlasRegion> walkNorthAnimation;
    private Animation<TextureAtlas.AtlasRegion> currentAnimation;

    private float walkingAnimationTime;

    PlayerRenderer(Player player) {
        this.player = player;
        init();
    }

    private void init() {
        atlas = new TextureAtlas("images/yujin.atlas");

        walkWestAnimation = new Animation<TextureAtlas.AtlasRegion>(0.15f, atlas.findRegions("yujin_west"), Animation.PlayMode.LOOP);
        walkEastAnimation = new Animation<TextureAtlas.AtlasRegion>(0.15f, atlas.findRegions("yujin_east"), Animation.PlayMode.LOOP);
        walkSouthAnimation = new Animation<TextureAtlas.AtlasRegion>(0.15f, atlas.findRegions("yujin_south"), Animation.PlayMode.LOOP);
        walkNorthAnimation = new Animation<TextureAtlas.AtlasRegion>(0.15f, atlas.findRegions("yujin_north"), Animation.PlayMode.LOOP);

        currentAnimation = walkSouthAnimation;
    }

    void update(float delta) {
        switch (player.getState()) {
            case WALKING:
                walkingAnimationTime += delta;
                break;
            case STANDING:
                break;
        }
    }

    void draw(Batch batch, float parentAlpha) {
        batch.draw(getCurrentFrame(), player.getX(), player.getY());
    }

    private TextureRegion getCurrentFrame() {
        //return (TextureRegion) currentAnimation.getKeyFrame(walkingAnimationTime);
        return currentAnimation.getKeyFrame(walkingAnimationTime);
    }

    void updateDirection(Direction direction) {
        walkingAnimationTime = 0;
        switch (direction) {
            case WEST:
                currentAnimation = walkWestAnimation;
                break;
            case EAST:
                currentAnimation = walkEastAnimation;
                break;
            case SOUTH:
                currentAnimation = walkSouthAnimation;
                break;
            case NORTH:
                currentAnimation = walkNorthAnimation;
                break;
        }
    }

    void resetAnimationTime() {
        walkingAnimationTime = 0;
    }
}
