/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveCommand extends Command {

  public DriveCommand() {
   
  }

  // Ensures motors aren't already moving 
  @Override
  protected void initialize() {
    Robot.driveSubsystem.stop();
  }

  // Uses the driver joystick to control the drive train with
  // no damper on the speed
  @Override
  protected void execute() {
    Robot.driveSubsystem.driveJoystick(Robot.m_oi.getDriverStick(), 1);
  }

  // Will only return true if the command is cancelled
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Stops the motors
  @Override
  protected void end() {
    Robot.driveSubsystem.stop();
  }

  // Ends when the command is interrupted
  @Override
  protected void interrupted() {
    end();
  }
}
