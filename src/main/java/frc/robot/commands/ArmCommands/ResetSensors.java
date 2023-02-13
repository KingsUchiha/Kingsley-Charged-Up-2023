// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.ArmCommands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;


/** An example command that uses an example subsystem. */
public class ResetSensors extends CommandBase {
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
    boolean end_command;
    private final DriveSubsystem drivebase;
  public ResetSensors(DriveSubsystem m_drivebase) {
    // Use addRequirements() here to declare subsystem dependencies.
    end_command=false;
    drivebase=m_drivebase;
    addRequirements(drivebase);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivebase.shift("low");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivebase.resetEncoders();
    drivebase.resetGyroAngle();
    System.out.println("reset sensors");
    end_command=true;



  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return end_command;
  }
  @Override
    public boolean runsWhenDisabled() {
      return false;
  }
}
