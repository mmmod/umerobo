package umejug;

import java.awt.Color;

import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Totoro extends Robot {

	@Override
	public void run() {
		setColors(Color.DARK_GRAY, Color.GRAY, Color.WHITE);
		while (true){
			ahead(50);
			turnLeft(24);
		}
	}
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		fire(1);
	}
}
