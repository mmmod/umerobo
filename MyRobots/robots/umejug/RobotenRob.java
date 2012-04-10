package umejug;

import robocode.Robot;
import robocode.ScannedRobotEvent;

public class RobotenRob extends Robot {
	@Override
	public void run() {
		while (true) {
			ahead(100);
			turnLeft(180);
		}
	}
	
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		fire(3);
	}

}
