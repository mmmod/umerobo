package umejug;

import robocode.Robot;
import robocode.ScannedRobotEvent;

public class Wall_E extends Robot {

	@Override
	public void run() {
		while(true) {
			ahead(20);
			turnLeft(120);		
		}
	}
	
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		fire(2);
	}
}
