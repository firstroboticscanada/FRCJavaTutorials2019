/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveForwardTimeoutCommand extends Command {

  public DriveForwardTimeoutCommand() {
    
  }

  // Ensuring motors aren't moving and setting a timeout to 3sec
  @Override
  protected void initialize() {
    Robot.driveSubsystem.stop();
    		setTimeout(3);
  }

  // Drives forward at 100% speed with no rotation speed
  @Override
  protected void execute() {
    Robot.driveSubsystem.drive(1, 0);
  }

  // Will go to end once the timer runs out 
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Stops the motors
  @Override
  protected void end() {
    Robot.driveSubsystem.stop();
  }

  // Ends the command if the command is interrupted
  @Override
  protected void interrupted() {
    end();
  }
}
