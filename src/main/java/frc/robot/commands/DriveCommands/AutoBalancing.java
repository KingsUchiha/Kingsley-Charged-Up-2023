// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriveCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;

/** An example command that uses an example subsystem. */
public class AutoBalancing extends CommandBase {

private DriveSubsystem drivebase;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AutoBalancing(DriveSubsystem passedDrivebase) {
    drivebase=passedDrivebase;
    addRequirements(drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(drivebase.getGyroRoll() > Constants.AutoConstants.ANGLE_THRESHOLD || drivebase.getGyroRoll() < -Constants.AutoConstants.ANGLE_THRESHOLD){
        drivebase.drive(-1*drivebase.getGyroRoll()/Math.abs(drivebase.getGyroRoll()), -1*drivebase.getGyroRoll()/Math.abs(drivebase.getGyroRoll()));
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
  @Override
   public boolean runsWhenDisabled() {
     return false;
 }
}
