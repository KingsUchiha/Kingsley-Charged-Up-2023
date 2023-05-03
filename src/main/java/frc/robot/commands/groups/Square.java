package frc.robot.commands.groups;


import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.Autonomous.AutoDrive;
import frc.robot.commands.Autonomous.AutoTurn;

import frc.robot.subsystems.DriveSubsystem;


public class Square extends SequentialCommandGroup {
  
  private DriveSubsystem drivebase;
  

  /**
   * @param DistanceInput
   * @param SpeedInput
   * @param Drivebase
   * 
   * 
   * 
   */

  public Square(double DistanceInput, double SpeedInput, DriveSubsystem Drivebase){
   drivebase = Drivebase;

    addCommands(
    
    new AutoDrive(DistanceInput/4, SpeedInput, drivebase),
    new AutoTurn(90, SpeedInput, drivebase),
    new AutoDrive(DistanceInput/4, SpeedInput, drivebase),
    new AutoTurn(90, SpeedInput, drivebase),
    new AutoDrive(DistanceInput/4, SpeedInput, drivebase),
    new AutoTurn(90, SpeedInput, drivebase),
    new AutoDrive(DistanceInput/4, SpeedInput, drivebase),
    new AutoTurn(90, SpeedInput, drivebase)
    
    );
  }

}