package umejug;

import java.awt.Color;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class BadRobot extends Robot {
	@Override
	public void run() {
		setColors(Color.ORANGE, Color.ORANGE, Color.YELLOW);
		while (true) {
			ahead(250);
			turnRight(45);
			ahead(250);
			turnGunRight(360);
		}
	}
	
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		fire(3);
	}
	
	@Override
	public void onHitWall(HitWallEvent event) {
		turnRight(70);
	}
	
	@Override
	public void onHitByBullet(HitByBulletEvent event) {
//		turnRight(70);
//		ahead(100);
	}
	
	@Override
	public void onHitRobot(HitRobotEvent event) {
		back(100);
	}
}
