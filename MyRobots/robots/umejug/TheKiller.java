package umejug;

import robocode.AdvancedRobot;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class TheKiller extends AdvancedRobot {

	private double gunRotation = 360;
	private double targetBearing;

	@Override
	public void run() {
		setAdjustGunForRobotTurn(true);
		while (true) {
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
		setTurnRight(targetBearing);
	}

	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		targetBearing = event.getBearing();
		out.println("Enemy seen at " + targetBearing);
		gunRotation = -gunRotation / 2.5;
		// setTurnGunRight(gunRotation);
		if (gunRotation < 45) {
			if (getGunHeat() == 0) {
				if (event.getDistance() < 200) {
					fire(3);
				} else {
					fire(0.5);
				}
			}
			gunRotation = 360;
		}

	}
}
