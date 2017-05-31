package eug.awesome.yujin.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

import eug.awesome.yujin.utlis.Controls;

/**
 * Player Controller
 */

class PlayerController extends InputListener {

    private static final String TAG = PlayerController.class.getName();

    private Player player;
    private boolean[] keyHeld;
    private float[] keyHeldTimer;

    private float HELD_THRESHOLD = 0.11f;

    PlayerController(Player player) {
        this.player = player;
        init();
    }

    private void init() {
        keyHeld = new boolean[Controls.values().length];
        keyHeldTimer = new float[Controls.values().length];
    }

    @Override
    public boolean keyDown(InputEvent event, int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                Gdx.app.debug(TAG, "Left key pressed.");
                onKeyPressed(Controls.LEFT);
                break;
            case Input.Keys.RIGHT:
                Gdx.app.debug(TAG, "Right key pressed.");
                onKeyPressed(Controls.RIGHT);
                break;
            case Input.Keys.DOWN:
                Gdx.app.debug(TAG, "Down key pressed.");
                onKeyPressed(Controls.DOWN);
                break;
            case Input.Keys.UP:
                Gdx.app.debug(TAG, "Up key pressed.");
                onKeyPressed(Controls.UP);
                break;
        }

        return false;
    }

    @Override
    public boolean keyUp(InputEvent event, int keycode) {
        switch (keycode) {
            case Input.Keys.LEFT:
                Gdx.app.debug(TAG, "Left key released.");
                onKeyReleased(Controls.LEFT);
                break;
            case Input.Keys.RIGHT:
                Gdx.app.debug(TAG, "Right key released.");
                onKeyReleased(Controls.RIGHT);
                break;
            case Input.Keys.DOWN:
                Gdx.app.debug(TAG, "Down key released.");
                onKeyReleased(Controls.DOWN);
                break;
            case Input.Keys.UP:
                Gdx.app.debug(TAG, "Up key released.");
                onKeyReleased(Controls.UP);
                break;
        }
        return false;
    }

    void update(float delta) {
        for (int i = 0; i < keyHeld.length; i++) {
            if(keyHeld[i]) {
                keyHeldTimer[i] += delta;
                if(keyHeldTimer[i] > HELD_THRESHOLD) {
                    onKeyHold(Controls.values()[i]);
                }
            }
        }
    }

    private void onKeyPressed(Controls key) {
        keyHeld[key.ordinal()] = true;

        switch (key) {
            case LEFT:
                player.move(Direction.WEST);
                break;
            case RIGHT:
                player.move(Direction.EAST);
                break;
            case DOWN:
                player.move(Direction.SOUTH);
                break;
            case UP:
                player.move(Direction.NORTH);
                break;
        }

    }

    private void onKeyReleased(Controls key) {
        keyHeld[key.ordinal()] = false;
        keyHeldTimer[key.ordinal()] = 0;
    }

    private void onKeyHold(Controls key) {
        switch (key) {
            case LEFT:
                player.move(Direction.WEST);
                break;
            case RIGHT:
                player.move(Direction.EAST);
                break;
            case DOWN:
                player.move(Direction.SOUTH);
                break;
            case UP:
                player.move(Direction.NORTH);
                break;
        }
    }

}
