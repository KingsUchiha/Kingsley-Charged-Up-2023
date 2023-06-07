// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Autonomous;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

public class AutoTurn extends CommandBase {

    private DriveSubsystem drivebase;
	private double desiredAngle, autoDrivespeed;
	private boolean doneTraveling;
    public int count;

  public AutoTurn(double AngleInput, double speedInput, DriveSubsystem passedDrivebase) {
    drivebase=passedDrivebase;
    autoDrivespeed=speedInput;
    desiredAngle=AngleInput;
    doneTraveling=true;
    addRequirements(drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
    drivebase.resetEncoders();
    drivebase.resetGyroAngle();
    doneTraveling=false;
    count=0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   drivebase.autoTurn(autoDrivespeed*0.9, desiredAngle);
   if(drivebase.getGyroAngle()<desiredAngle+Constants.AutoConstants.ANGULAR_THRESHOLD&&drivebase.getGyroAngle()>desiredAngle-Constants.AutoConstants.ANGULAR_THRESHOLD){
    doneTraveling=true;
   }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

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
