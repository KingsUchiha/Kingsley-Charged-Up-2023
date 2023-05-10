// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;


public class Square extends CommandBase {
  private DriveSubsystem drivebase;

  double autoDriveSpeed, desiredDistance, distanceTraveled, angle; 
  boolean doneTraveling;
  int i;
  public Square(double distance, double speed, DriveSubsystem Drivebase) {
    autoDriveSpeed=speed;
    desiredDistance=distance;
    distanceTraveled=0;
    doneTraveling=false;
    addRequirements(drivebase);
  }

 
  @Override
  public void initialize() {
    drivebase.resetEncoders();
    drivebase.resetGyroAngle();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    angle=drivebase.getGyroAngle();
    distanceTraveled=Math.abs(drivebase.getPosition());

    if(distanceTraveled<desiredDistance){

        for(i=0;i<4;i++){
        drivebase.autoDrive(desiredDistance/4, autoDriveSpeed, angle);
        drivebase.autoTurn(autoDriveSpeed*0.8, 90);
        }

        doneTraveling=false;
    }
    else{
        doneTraveling=true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return doneTraveling;
  }
  @Override
  public boolean runsWhenDisabled() {
    return false;
}
}
