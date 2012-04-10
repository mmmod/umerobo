package umejug;

import java.awt.Color;
import java.util.Random;

import robocode.BulletHitEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Wall_E extends Robot {

	Random random = new Random(System.currentTimeMillis());
	
	@Override
	public void run() {
		setAllColors(Color.GREEN);
		while(true) {
			ahead(getDistance());
			turnLeft(getDegrees());		
		}
	}
	
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		fire(2);
		ahead(50);
	}
	
	@Override
	public void onHitWall(HitWallEvent event) {
		turnLeft(180);
		ahead(50);
	}
	
	@Override
	public void onHitByBullet(HitByBulletEvent event) {
		turnRight(event.getHeading()-90);
		ahead(200);
	}
	
	@Override
	public void onHitRobot(HitRobotEvent event) {
		turnRight(120);
		ahead(50);
		turnGunLeft(120);
		fire(3);
		turnGunRight(120);
	}
	
	private double getDistance() {
		return random.nextDouble()*200;
	}
	
	private double getDegrees() {
		return random.nextDouble()*360;
	}
}
