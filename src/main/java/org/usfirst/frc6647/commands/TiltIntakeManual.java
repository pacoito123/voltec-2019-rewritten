/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.commands;

import org.usfirst.frc6647.subsystems.TiltIntake;
import org.usfirst.lib6647.subsystem.hypercomponents.HyperVictor;
import org.usfirst.lib6647.util.MoveDirection;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for manually controlling Intake tilt.
 */
public class TiltIntakeManual extends Command {

	private MoveDirection direction;
	private HyperVictor tiltIntake;

	/**
	 * Constructor for the command.
	 * 
	 * @param direction
	 */
	public TiltIntakeManual(MoveDirection direction) {
		requires(TiltIntake.getInstance());

		this.direction = direction;

		tiltIntake = TiltIntake.getInstance().getVictor("tiltIntake");
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		switch (direction) {
		case UP:
			tiltIntake.set(0.6);
			break;
		case DOWN:
			tiltIntake.set(-0.4);
			break;
		default:
			end();
			break;
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		tiltIntake.stopMotor();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
