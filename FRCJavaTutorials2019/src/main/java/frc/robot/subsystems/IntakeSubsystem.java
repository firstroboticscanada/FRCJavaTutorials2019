/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;


/**
 * Add your docs here.
 */
public class IntakeSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  //Instantiation of an ultrasonic object
  //Digital input ports are in RobotMap

  Ultrasonic sonic = new Ultrasonic(RobotMap.ping, RobotMap.echo);

  // Instantiation of speed controllers
  //CANBus port numbers are in RobotMap

  Victor intakeRight = new Victor(RobotMap.intake1);
  Victor intakeLeft = new Victor(RobotMap.intake2);

  //Groups speed controllers together
  SpeedControllerGroup intake = new SpeedControllerGroup(intakeRight, intakeLeft);

  public IntakeSubsystem(){

    // Sets the ultrasonic to ping automatically
    // at regular quick intervals
    sonic.setAutomaticMode(true);
  }

  // Intakes or outtakes based on direction (true, false respectively)
  // and given speed
  public void intake(boolean direction, double speed){
    //true = forward, false = backwards (or vice versa depending on how the motors were connected)

    speed = Math.abs(speed);

    if(direction){
      intake.set(speed);
    }else{
      intake.set(-speed);
    }

  }

  // Controls only left intake motor based on given direction and
  // speed
  public void intakeLeft(boolean direction, double speed){
    if(direction){
      intakeLeft.set(speed);
    }else{
      intakeLeft.set(-speed);
    }
  }

  // Control speed control based on input on the Y access of a 
  // given joystick and dampens with input with a damper
  // value from 0 to 1
  public void joystickIntake(Joystick joystick, double damper){

    intake.set(joystick.getY()*damper);

  }

  // Stops intake motors
  public void stop(){
    intake.stopMotor();
  }
  
  // Manually set automatic mode for ultrasonic if needed
  public void automaticMode(boolean mode){
    sonic.setAutomaticMode(mode);
  }

  // Manually ping ultrasonic if automatic mode is set to false
  public void pingSonic(){
    sonic.ping();
  }

  // Gets the distance the ultrasonic reads in CM by reading
  // in MM and converting
  public double getDistanceCM(){
    return sonic.getRangeMM() / 10;
  }

  // Gets the distance the ultrasonic reads in inches
  public double getDistanceInches(){
    return sonic.getRangeInches();
  }

  // Returns whether or not the intake "has something"
  // based on a given distance
  public boolean hasSomething(double maxDistance){
    return getDistanceCM() < maxDistance;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
