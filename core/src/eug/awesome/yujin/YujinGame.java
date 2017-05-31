package eug.awesome.yujin;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import eug.awesome.yujin.screens.MainScreen;

public class YujinGame extends Game {

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		setScreen(new MainScreen(this));
	}


}
