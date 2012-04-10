package umejug;

import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class SuperRobot extends Robot {
	
	private boolean hideState = true;
	private boolean turnState = false;
	private double bearing;
	private double fireStart = 2;
	private int direction = 1;
	@Override
	public void run() {
		super.run();
		turnRight(getHeading() % 90); //event.getBearingDegrees());
		while (true) {
			if (hideState) {
				ahead(1000);
			} else if (turnState) {
				back(10);
				turnRight(bearing+90);
				turnGunRight(90);
				turnState = false;
			} else {
				ahead(1000*direction);

			}
		}
	}
	
	@Override
	public void onHitWall(HitWallEvent event) {
		if (hideState) {
			hideState = false;
			turnState = true;
			bearing = event.getBearingDegrees();
		} else {
			//back(10);
			turnRight(event.getBearingDegrees() + 90); //event.getBearingDegrees());
			//direction = direction * -1;
		}
	}

	@Override
	public void onHitRobot(HitRobotEvent event) {
		direction = direction * -1;
	}
	
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		if (event.getDistance() < 10) {
			fire(3);
		} else {
			fire(3 - (3 * (event.getDistance() * event.getDistance()) / (super.getBattleFieldHeight() * super.getBattleFieldWidth())));
		}
	}
	
}
