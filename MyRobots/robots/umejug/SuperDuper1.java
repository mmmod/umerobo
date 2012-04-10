package umejug;

import java.awt.Color;

import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * SuperDuper1 - a robot by (your name here)
 */
public class SuperDuper1 extends Robot
{
	private double	_bearing		= 0;
	private boolean	_enemyDetected	= false;
	private int		_radarDirection	= 1;
	private double	_distance;
	private String	_trackedName;

	/**
	 * run: SuperDuper1's default behavior
	 */
	public void run()
	{
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		// setColors(Color.red,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		setColors(Color.CYAN, Color.pink, Color.black);
		while (true)
		{
			// Replace the next 4 lines with any behavior you would like

			radar();
			movement();
			gun();
			_enemyDetected = false;

		}
	}

	private void gun()
	{
		if (_enemyDetected)
		{
			if(_distance<300 && getGunHeat()==0)
			{
				double gunHeading=getGunHeading();
				turnGunRight(_bearing-gunHeading);
				fire(Math.min(300 / _distance, 3));
			}
		}
	}

	private void movement()
	{
		if (_enemyDetected)
		{
			if (_distance > 100)
			{
				turnRight(_bearing - getHeading());
				ahead(20);
			}
		}

	}

	private void radar()
	{
		if (_radarDirection > 0)
		{
			turnRadarLeft(45);
		}
		else
		{
			turnRadarRight(45);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e)
	{
		// Replace the next line with any behavior you would like

		if (e.getName().equals(_trackedName) || _trackedName == null || e.getDistance()<_distance)
		{
			_trackedName = e.getName();
			_distance = e.getDistance();
			_radarDirection *= -1;
			_bearing = getHeading() + e.getBearing();
			_enemyDetected = true;
		}
	}

	@Override
	public void onRobotDeath(RobotDeathEvent e)
	{
		if (e.getName().equals(_trackedName))
		{
			_trackedName = null;
		}
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e)
	{
		// Replace the next line with any behavior you would like
		//back(10);
	}

	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e)
	{
		// Replace the next line with any behavior you would like
		//back(20);
	}
}
