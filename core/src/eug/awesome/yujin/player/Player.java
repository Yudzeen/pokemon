package eug.awesome.yujin.player;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;

import eug.awesome.yujin.utlis.GameConstants;

/**
 * Player actor
 */

public class Player extends Actor {

    private static final String TAG = Player.class.getName();

    private final float WALKING_SPEED = 0.3f;
    private final int WIDTH = 16;
    private final int HEIGHT = 16;

    private PlayerController playerController;
    private PlayerRenderer playerRenderer;

    private State state;
    private Direction facingDirection;

    private float srcX, srcY;
    private float destX, destY;
    private float walkTimer;

    public Player() {
        playerController = new PlayerController(this);
        playerRenderer = new PlayerRenderer(this);
        state = State.STANDING;
        facingDirection = Direction.SOUTH;
        setBounds(getX(), getY(), WIDTH, HEIGHT);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        playerController.update(delta);
        playerRenderer.update(delta);
        if(state == State.WALKING) {
            walkTimer += delta;
            setX(Interpolation.linear.apply(srcX, destX, walkTimer/WALKING_SPEED));
            setY(Interpolation.linear.apply(srcY, destY, walkTimer/WALKING_SPEED));
            if(walkTimer >= WALKING_SPEED) {
                setX(destX);
                setY(destY);
                walkTimer = 0;
                state = State.STANDING;
            }
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        playerRenderer.draw(batch, parentAlpha);
    }

    private void face(Direction direction) {
        facingDirection = direction;
        playerRenderer.updateDirection(direction);
    }

    private void walk(Direction direction) {
        state = State.WALKING;
        srcX = getX();
        srcY = getY();
        switch (direction) {
            case WEST:
                destX = getX() - GameConstants.TILE_SIZE;
                destY = getY();
                break;
            case EAST:
                destX = getX() + GameConstants.TILE_SIZE;
                destY = getY();
                break;
            case SOUTH:
                destX = getX();
                destY = getY() - GameConstants.TILE_SIZE;
                break;
            case NORTH:
                destX = getX();
                destY = getY() + GameConstants.TILE_SIZE;
                break;
        }
    }

    public void move(Direction direction) {
        if(state == State.STANDING) {
            if(facingDirection != direction) {
                face(direction);
            }
            else {
                walk(direction);
            }
        }
    }

    public PlayerController getPlayerController() {
        return playerController;
    }

    public Direction getFacingDirection() {
        return facingDirection;
    }

    public State getState() {
        return state;
    }
}
