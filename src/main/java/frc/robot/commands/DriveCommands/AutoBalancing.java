// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.DriveCommands;

import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import java.lang.Math;

/** An example command that uses an example subsystem. */
public class AutoBalancing extends CommandBase {


  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public AutoBalancing(ExampleSubsystem subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(DriveSubsystem.getGyroAxis() > Constants.AutoConstants.ANGLE_THRESHOLD || DriveSubsystem.getGyroAxis() < -Constants.AutoConstants.ANGLE_THRESHOLD){
        DriveSubsystem.drive(DriveSubsystem.getGyroAxis()*-1*Math.abs(DriveSubsystem.getGyroAxis()), DriveSubsystem.getGyroAxis()*-1*Math.abs(DriveSubsystem.getGyroAxis()));
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