package umejug;

import robocode.Robot;
import robocode.ScannedRobotEvent;

public class TheKiller extends Robot {

	@Override
	public void run() {
		while(true) {
			ahead(100);
			turnRight(180);
		}
	}
	
	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		fire(3);
	}
}
