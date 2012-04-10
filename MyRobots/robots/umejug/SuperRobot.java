package umejug;

import robocode.HitWallEvent;
import robocode.Robot;

public class SuperRobot extends Robot {
	
	private boolean hideState = true;
	private boolean turnState = false;
	private double bearing;
	private double fireStart = 2;
	@Override
	public void run() {
		super.run();
		while (true) {
			if (hideState) {
				ahead(50);
			} else if (turnState) {
				back(10);
				turnLeft(bearing);
				turnState = false;
			} else {
				fire(fireStart);
				fireStart = fireStart - 0.3;
			}
		}
	}
	
	@Override
	public void onHitWall(HitWallEvent event) {
		hideState = false;
		turnState = true;
		bearing = event.getBearingDegrees();		
	}

}
