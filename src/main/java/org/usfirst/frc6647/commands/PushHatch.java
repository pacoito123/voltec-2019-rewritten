/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.commands;

import org.usfirst.frc6647.subsystems.Intake;
import org.usfirst.lib6647.subsystem.hypercomponents.HyperSolenoid;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for pushing the H solenoid.
 */
public class PushHatch extends Command {

	private HyperSolenoid pushHatch;

	/**
	 * Constructor for the command.
	 */
	public PushHatch() {
		pushHatch = Intake.getInstance().getSolenoid("pushHatch");
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		pushHatch.set(true);
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		pushHatch.set(false);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
