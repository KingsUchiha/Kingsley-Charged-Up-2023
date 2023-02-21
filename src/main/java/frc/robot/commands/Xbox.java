// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Utilities.Controls;

/** An example command that uses an example subsystem. */
public class Xbox extends CommandBase {
  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public static XboxController driver;
  public static XboxController operator;
  double turn;
  double throttle;
  double reverse;
  boolean brake;
  double rotate;
 
  boolean GearShiftLow;
  boolean GearShiftHigh;

  double left;
  double right;
  double sensitivity;
  DriveSubsystem Drivebase;

 


  public Xbox(DriveSubsystem m_drivebase){
    // Use addRequirements() here to declare subsystem dependencies.
    driver=new XboxController(Constants.ControlConstants.XBOX_CONTROLLER_DRIVER);
    operator=new XboxController(Constants.ControlConstants.XBOX_CONTROLLER_OPERATOR);
    Drivebase=m_drivebase;
    }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    throttle= Controls.Axis(Controls.driver, Constants.ControlConstants.XBOX_AXIS_RIGHT_TRIGGER);
    reverse= Controls.Axis(Controls.driver, Constants.ControlConstants.XBOX_AXIS_LEFT_TRIGGER);
    turn= Controls.Axis(Controls.driver, Constants.ControlConstants.XBOX_AXIS_LEFT_X);
    
    
    if(brake){
        left=0;
        right=0;
    }

    //*if(rotate){
        if(Math.abs(turn)> Constants.ControlConstants.AXIS_THRESHOLD){

            left=Constants.ControlConstants.SPIN_SENSITIVITY*turn;
            right=Constants.ControlConstants.SPIN_SENSITIVITY*(turn*-1);
        }
        else if(Math.abs(turn)< Constants.ControlConstants.AXIS_THRESHOLD){
            left=0;
            right=0;
        }
        else{
            if(turn>Constants.ControlConstants.AXIS_THRESHOLD){
                left=(throttle-reverse)*sensitivity;
                right=(throttle-reverse)*sensitivity*(1-turn);
            }
            else if(turn< -1*Constants.ControlConstants.AXIS_THRESHOLD){
                left=(throttle-reverse)*sensitivity*(1+turn);
                right=(throttle-reverse)*sensitivity;
    
            }
            else{
                left=(throttle-reverse)*sensitivity;
                right=(throttle-reverse)*sensitivity;
            }
        }
    
        DriveSubsystem.drive(left,right);
    }
    
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    DriveSubsystem.drive(0,0);
  }

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
