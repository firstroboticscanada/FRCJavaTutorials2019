/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.SinglePunchCommand;
import frc.robot.commands.DoublePunchCommand;
import frc.robot.commands.IntakeSonicCommand;
import frc.robot.Robot;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	// Instantiaion of joysticks
	
	Joystick driverStick = new Joystick(0);
	Joystick operatorStick = new Joystick(1);

	// Instantiation of buttons with names based on their 
	// associated commands

	JoystickButton intake = new JoystickButton(operatorStick, 1);	
	JoystickButton outtake = new JoystickButton(operatorStick, 2);
	JoystickButton singlePunch = new JoystickButton(operatorStick, 3);
	JoystickButton doublePunch = new JoystickButton(operatorStick, 4);
	JoystickButton doubleRetract = new JoystickButton(operatorStick, 5);
	JoystickButton intakeSonic = new JoystickButton(operatorStick, 6);


	// Joystick accessors

	public Joystick getDriverStick() {
		return driverStick;
	}

	public Joystick getOperatorStick() {
		return operatorStick;
	}
	
	public OI(){

		// Associating commands with buttons

		intake.whileHeld(new IntakeCommand(true, 1));
		outtake.whileHeld(new IntakeCommand(false, 1));
		singlePunch.whileHeld(new SinglePunchCommand());
		doublePunch.whenPressed(new DoublePunchCommand(true));
		doublePunch.whenPressed(new DoublePunchCommand(false));
		intakeSonic.whenPressed(new IntakeSonicCommand());
	}

}
