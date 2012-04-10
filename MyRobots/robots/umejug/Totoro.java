package umejug;

import java.awt.Color;
import java.util.Random;

import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Totoro extends Robot {

	@Override
	public void run() {
		setColors(Color.DARK_GRAY, Color.GRAY, Color.WHITE);
		Random random = new Random();
		while (true) {
			ahead(random.nextDouble() * 50 + 20);
			turnLeft(random.nextDouble() * 50);
		}
	}

	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		double distance = event.getDistance();
		if (distance > 150) {
			fire(1);
		} else {
			fire(3);
		}
	}
}
