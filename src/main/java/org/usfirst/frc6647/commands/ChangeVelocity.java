/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.commands;

import org.usfirst.frc6647.subsystems.Chassis;
import org.usfirst.frc6647.subsystems.NavX;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command to change Chassis velocity and acceleration.
 */
public class ChangeVelocity extends Command {

	double driveLimiter, padLimiter;
	boolean acceleration;

	/**
	 * Constructor for the command.
	 * 
	 * @param driveLimiter
	 * @param padLimiter
	 * @param acceleration
	 */
	public ChangeVelocity(double driveLimiter, double padLimiter, boolean acceleration) {
		this.driveLimiter = driveLimiter;
		this.padLimiter = padLimiter;
		this.acceleration = acceleration;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Chassis.getInstance().setDriveLimiter(driveLimiter);
		NavX.getInstance().setPadLimiter(padLimiter, acceleration);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}