package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

import frc.robot.commands.DriveForwardTimeoutCommand;
import frc.robot.commands.DriveToDistanceCommand;

/**
 *
 */
public class AutoCommand extends CommandGroup {
    
    public  AutoCommand() {
        // Add Commands here:
    	
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());

        // Drives to distance of 20 units at 80% speed
        // Then intakes until intake has something at the same
        // time as the robot drives forward until the timer
        // runs out
        // Remember, values used in this project are simply examples
        // and very amongst robots

        addSequential(new DriveToDistanceCommand(20, .8));
        addParallel(new IntakeSonicCommand());
        addSequential(new DriveForwardTimeoutCommand());

    	
    	
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}