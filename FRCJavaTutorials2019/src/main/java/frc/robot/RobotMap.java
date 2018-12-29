/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

public class RobotMap {

    // Intake Speed Values
    public static final double intakeLow = 0.3;
    public static final double intakeMed = 0.7;
    public static final double intakeHigh = 1;

    // Drivetrain speed controllers
	
	public static final int frontRight = 0;
	public static final int frontLeft = 1;
	public static final int backRight = 2;
    public static final int backLeft = 3;

    // Intake speed controllers

    public static final int intake1 = 4;
    public static final int intake2 = 5;

    // PCM Channels

    public static final int singleSolenoid = 0;
    public static final int doubleSolenoid1 = 1;
    public static final int doubleSolenoid2 = 2;

    // Digital Input Ports

     // Drivetrain Encoder Ports

    public static final int leftEnc1 = 0;
    public static final int leftEnc2 = 1;
    public static final int rightEnc1 = 2;
    public static final int rightEnc2 = 3;
 
    // Intake Ultrasonic Ports

    public static final int ping = 4;
    public static final int echo = 5;
}
