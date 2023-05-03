// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class AutoDrive extends CommandBase {

    private DriveSubsystem drivebase;
	private double angle, distance_needed, auto_drivespeed, distance_traveled;
	private boolean done_traveling;

  public AutoDrive(double distance_input, double speed_input, DriveSubsystem passed_drivebase) {
    drivebase=passed_drivebase;
    auto_drivespeed=speed_input;
    distance_input=distance_needed;
    distance_traveled=0;
    addRequirements(drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    distance_traveled=0;
    drivebase.resetEncoders();
    drivebase.resetGyroAngle();
    drivebase.DPPShifter("high");
    drivebase.DPPShifter("low");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    angle=drivebase.getGyroYaw();
    distance_traveled=drivebase.getPosition();
    if(distance_traveled<=distance_needed && distance_needed>0){
        drivebase.autoDrive(auto_drivespeed, auto_drivespeed, angle);
        done_traveling=false;
    }
    else if(distance_traveled>distance_needed+20 && distance_needed>0){
    drivebase.autoDrive(-auto_drivespeed, -auto_drivespeed, angle);
    }
    else if(distance_traveled>distance_needed && distance_needed<0){
        drivebase.autoDrive(auto_drivespeed, auto_drivespeed, angle);
    }
    else if(distance_traveled<distance_needed-20 && distance_needed<0){
        drivebase.autoDrive(-auto_drivespeed, -auto_drivespeed, angle);
    }
    else{
        drivebase.drive(0, 0);
        done_traveling=true;

        
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivebase.drive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return done_traveling;
  }
  @Override
  public boolean runsWhenDisabled() {
    return false;
}
}
