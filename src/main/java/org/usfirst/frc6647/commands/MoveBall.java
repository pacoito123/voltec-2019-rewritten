/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc6647.commands;

import org.usfirst.frc6647.subsystems.Intake;
import org.usfirst.lib6647.subsystem.hypercomponents.HyperTalon;
import org.usfirst.lib6647.util.MoveDirection;

import edu.wpi.first.wpilibj.command.Command;

/**
 * Command for grabbing/releasing Cargo balls.
 */
public class MoveBall extends Command {

	private double speed;
	private MoveDirection direction;
	private HyperTalon intakeLeft, intakeRight;

	/**
	 * Constructor for the command.
	 * 
	 * @param direction
	 * @param speed
	 */
	public MoveBall(MoveDirection direction, double speed, String leftName, String rightName) {
		requires(Intake.getInstance());

		intakeLeft = Intake.getInstance().getTalon(leftName);
		intakeRight = Intake.getInstance().getTalon(rightName);

		this.direction = direction;
		this.speed = speed;
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		switch (direction) {
		case IN:
			intakeLeft.setTalon(speed, false);
			intakeRight.setTalon(speed, false);
			break;
		case OUT:
			intakeLeft.setTalon(-speed, false);
			intakeRight.setTalon(-speed, false);
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
		Intake.getInstance().getTalon("intakeLeft").stopTalon();
		Intake.getInstance().getTalon("intakeRight").stopTalon();
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	@Override
	protected void interrupted() {
		end();
	}
}
