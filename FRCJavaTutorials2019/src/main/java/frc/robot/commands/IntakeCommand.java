/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeCommand extends Command {

  Boolean direction = false;
  Double speed = 0.0;

  // Constructor for intake (true) or outake (false) and
  // a motor speed value (0 to 1)
  public IntakeCommand(boolean direction, double speed) {

    this.direction = direction;
    this.speed = speed;

  }

  // Ensures motors are stopped to avoid conflict
  @Override
  protected void initialize() {
    Robot.intakeSubsystem.stop();
  }

  // Intakes or outtakes in the direction and speed given
  @Override
  protected void execute() {
    Robot.intakeSubsystem.intake(direction, speed);
  }

  // Will only return true when  the command is cancelled
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  // Stops the motors before exiting the program
  @Override
  protected void end() {
    Robot.intakeSubsystem.stop();
  }

  // Only called when the command is interrupted
  @Override
  protected void interrupted() {
    end();
  }
}
