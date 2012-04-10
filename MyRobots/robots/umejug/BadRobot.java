package umejug;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class BadRobot extends Robot {
	@Override
	public void run() {
		while (true) {
			ahead(500);
			turnGunRight(360);
		}
	}
	
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		fire(2);
	}
	
	@Override
	public void onHitWall(HitWallEvent event) {
		turnRight(90);
	}
	
	@Override
	public void onHitByBullet(HitByBulletEvent event) {
		ahead(100);
	}
	
	@Override
	public void onHitRobot(HitRobotEvent event) {
		super.onHitRobot(event);
	}
}
