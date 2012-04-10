package umejug;

import java.awt.Color;
import java.util.Random;

import robocode.AdvancedRobot;
import robocode.ScannedRobotEvent;

public class Totoro extends AdvancedRobot {

	@Override
	public void run() {
		setColors(Color.DARK_GRAY, Color.GRAY, Color.WHITE);
//		setTurnRadarLeft(Double.POSITIVE_INFINITY);
//		setAdjustGunForRobotTurn(true);
//		setAdjustRadarForGunTurn(true);
//		setAdjustRadarForRobotTurn(true);

		Random random = new Random();
		while (true) {
			setAhead(random.nextDouble() * 50 + 20);
			turnLeft((random.nextDouble()) * 50 + 25);
		}
	}

	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		// turnRadarRight(10);
		double distance = event.getDistance();
		// double targetHeading = event.getHeading() - 45;
		// double gunHeading = getGunHeading();
		// if (gunHeading < targetHeading) {
		// turnGunLeft(gunHeading - targetHeading);
		// } else {
		// turnGunRight(targetHeading - gunHeading);
		// }
		if (distance > 300) {
			fire(1);
		} else if (distance > 150) {
			fire(2);
		} else {
			fire(3);
		}
	}
}
