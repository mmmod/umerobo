package umejug;

import java.awt.Color;

import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * SuperDuper1 - a robot by (your name here)
 */
public class SuperDuper1 extends AdvancedRobot
{
	private double	_bearing		= 0;
	private boolean	_enemyDetected	= false;
	private int		_radarDirection	= 1;
	private double	_distance;
	private String	_trackedName;
	private int	_direction=1;

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
		setAdjustGunForRobotTurn(true);
		setColors(Color.cyan, Color.pink, Color.black);
		while (true)
		{
			// Replace the next 4 lines with any behavior you would like

			radar();
			movement();
			gun();
			execute();

		}
	}

	private void gun()
	{
		if (_distance < 500  )
		{
			double gunHeading = getGunHeading();
			setTurnGunRight(  _bearing - gunHeading);
			double gunError=Math.abs(getGunHeading() - _bearing);
			if (gunError<3 && getGunHeat() == 0)
			{
				setFire(Math.min(500 / _distance, 3));
			}
		}
	}

	private void movement()
	{
		double angle = 90;
		if (_distance > 200)
		{
			angle = 90-45*_direction;
		}
		else if (_distance < 200)
		{
			angle = 90;
		}/*
		else if(_distance <50)
		{
			angle = 110*_direction;
		}*/
		String str="B:"+_bearing+" H:"+getHeading();
		System.out.println(str);
		
		setTurnRight(_bearing - getHeading()-angle);
		setAhead(20*_direction);
	}

	private void radar()
	{
		if (_radarDirection > 0)
		{
			setTurnRadarLeft(45);
		}
		else
		{
			setTurnRadarRight(45);
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e)
	{
		// Replace the next line with any behavior you would like

		if (e.getName().equals(_trackedName) || _trackedName == null || e.getDistance() < _distance)
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
		// back(10);
	}

	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e)
	{
		// Replace the next line with any behavior you would like
		// back(20);
		_direction*=-1;
	}
	@Override
	public void onHitRobot(HitRobotEvent event)
	{
		// TODO Auto-generated method stub
		_direction*=-1;
	}
}
