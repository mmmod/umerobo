package umejug;

import robocode.AdvancedRobot;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class TheKiller extends AdvancedRobot {

	private double gunRotation = 180;
	private double targetBearing;

	@Override
	public void run() {
		setAdjustGunForRobotTurn(true);
		while (true) {
			gunRotation = 180;
			setTurnGunRight(gunRotation);
			navigateTowardsEnemy();
			ahead(200);
		}
	}

	private void navigateTowardsEnemy() {
		double rightTurn = targetBearing - getHeading();
		double leftTurn = getHeading() - targetBearing;
		out.println("Enemy bearing: " + targetBearing);
		out.println("My bearing   : " + getHeading());
		out.println("Right turn   : " + rightTurn);
		out.println("Left turn   : " + leftTurn);
		setTurnRight(rightTurn);
	}

	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		targetBearing = event.getBearing();
		out.println("Enemy seen at " + targetBearing);
		// gunRotation = -gunRotation / 2.5;
		// setTurnGunRight(gunRotation);
		turnGunLeft(10);
		fire(3);
	}
}
