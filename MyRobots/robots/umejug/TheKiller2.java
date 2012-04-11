package umejug;

import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class TheKiller2 extends Robot {
	
	boolean foundTarget = false;
	int bulletsShot = 0;
	@Override
	public void run() {
		while(true) {
			if(!foundTarget) {
				ahead(100);
				turnRight(120);
			} else {
				bulletsShot++;
			}
		}
	}
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		while(bulletsShot<5) {
			foundTarget=true;
			fire(1);
			turnGunLeft(4);
			ahead(1);
			bulletsShot++;
		}
		foundTarget=false;
		bulletsShot=0;
	}
	@Override
	public void onHitByBullet(HitByBulletEvent event) {
		turnRight(50);
		ahead(50);
	}
}