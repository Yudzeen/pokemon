package eug.awesome.yujin;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

import eug.awesome.yujin.screens.MainScreen;

public class YujinGame extends Game {

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		setScreen(new MainScreen(this));
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0,0,0,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		super.render();
	}
}
