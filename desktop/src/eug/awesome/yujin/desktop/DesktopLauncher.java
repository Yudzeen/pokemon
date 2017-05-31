package eug.awesome.yujin.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import eug.awesome.yujin.YujinGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 850;
		config.height = 480;
		new LwjglApplication(new YujinGame(), config);
	}
}
