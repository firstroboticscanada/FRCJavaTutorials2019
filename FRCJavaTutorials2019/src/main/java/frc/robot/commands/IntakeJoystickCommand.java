/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class IntakeJoystickCommand extends Command {
  
  public IntakeJoystickCommand() {
    
  }

  // Ensures motors are stopped to avoid conflict
  @Override
  protected void initialize() {
    Robot.intakeSubsystem.stop();  
  }

  // Uses the operator stick to control the intake system
  protected void execute() {
    Robot.intakeSubsystem.joystickIntake(Robot.m_oi.getOperatorStick(), 1);
  }

  // Only returns true when the command is cancelled
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

  // Goes to end if the command is interrupted
  @Override
  protected void interrupted() {
    end();
  }
}
