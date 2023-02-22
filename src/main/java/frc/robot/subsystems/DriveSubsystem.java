// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package frc.robot.subsystems;




import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.I2C;
import com.revrobotics.RelativeEncoder;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
    private static AHRS Gyro;
    private CANSparkMax left_motor;
    private CANSparkMax left_motor_2;
    private CANSparkMax left_motor_3;
    private CANSparkMax right_motor;
    private CANSparkMax right_motor_2;
    private CANSparkMax right_motor_3;

    private MotorControllerGroup left_motors;
    private MotorControllerGroup right_motors;
    private static DifferentialDrive our_drive;

    private Solenoid gearShifter;

   private RelativeEncoder left_encoders[];
   private RelativeEncoder right_encoders[];

   


  /** Declaring the necessary objects */
  public DriveSubsystem() {
    Gyro= new AHRS(I2C.Port.kMXP);

    left_motor=new CANSparkMax(Constants.DriveConstants.DRIVE_MOTOR_LEFT_1, MotorType.kBrushless);
    left_motor_2=new CANSparkMax(Constants.DriveConstants.DRIVE_MOTOR_LEFT_2, MotorType.kBrushless);
    left_motor_3=new CANSparkMax(Constants.DriveConstants.DRIVE_MOTOR_LEFT_3, MotorType.kBrushless);

    right_motor=new CANSparkMax(Constants.DriveConstants.DRIVE_MOTOR_RIGHT_1, MotorType.kBrushless);
    right_motor_2=new CANSparkMax(Constants.DriveConstants.DRIVE_MOTOR_RIGHT_2, MotorType.kBrushless);
    right_motor_3=new CANSparkMax(Constants.DriveConstants.DRIVE_MOTOR_RIGHT_3, MotorType.kBrushless);
//*Innitializing the motors with the constants and brushless motor type */
    left_motors=new MotorControllerGroup(left_motor, left_motor_2, left_motor_3);
    right_motors=new MotorControllerGroup(right_motor, right_motor_2, right_motor_3);
//* Putting the motors in their respective motor control groups */
    our_drive=new DifferentialDrive(left_motors, right_motors);
//* Differentiating the control groups */
    gearShifter = new Solenoid(0, PneumaticsModuleType.CTREPCM, Constants.DriveConstants.GEAR_SHIFTER);
//*Innitializing the solenoid and setting it to a pneumatic module type and using the gear shift constants */
    left_encoders=new RelativeEncoder[2];
    right_encoders=new RelativeEncoder[2];
    /*Innitializing the encoders */
    left_encoders[0]=left_motor.getEncoder();
    left_encoders[1]=left_motor_2.getEncoder();
    left_encoders[2]=left_motor_3.getEncoder();
    right_encoders[0]=right_motor.getEncoder();
    right_encoders[1]=right_motor_2.getEncoder();
    right_encoders[2]=right_motor_3.getEncoder();
    /* Setting the encoder for each motor */
    left_encoders[0].setPositionConversionFactor(100/21);
    left_encoders[1].setPositionConversionFactor(100/21);
    left_encoders[2].setPositionConversionFactor(100/21);
    right_encoders[0].setPositionConversionFactor(100/21);
    right_encoders[1].setPositionConversionFactor(100/21);
    right_encoders[2].setPositionConversionFactor(100/21);
    /* Setting the position conversion factor of every encoder to 100/21 */
    right_motor.setInverted(true);
    right_motor_2.setInverted(true);
    right_motor_3.setInverted(true);
        /*Inverting the right motors */
    };

    
  public boolean exampleCondition() {
    // Query some boolean state, such as a digital sensor.
    return false;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public static void drive(double left, double right){
    our_drive.tankDrive(left, right);
    /*Allows the robot to drive */

  }

  public void resetEncoders(){
    for(int x=1; x<left_encoders.length;x++){
        left_encoders[x].setPosition(0);
        right_encoders[x].setPosition(0);
    };
    
    /*Loop that resets all the encoders */
  }
  public double getPosition(){ return left_encoders[0].getPosition(); }
  public void Getaxis(){
    System.out.println("X axis:" + Gyro.getRoll());
    System.out.println("Y axis:" + Gyro.getPitch());
    System.out.println("Z axis:" + Gyro.getYaw());
    /*This makes the gyro get the x,y, and z axis */
    }
    public double getGyroYaw(){ return Gyro.getYaw(); }

    public void shift(String gear) {
        if(gear.toUpperCase().equals("LOW")) 
          gearShifter.set(false);
        else if(gear.toUpperCase().equals("HIGH")) 
          gearShifter.set(true);
        DPPShifter(gear);  
        /*If statement that turns the gear shifter solenoid on and if the gear is high or low */
      }  

      public void DPPShifter(String gear) {
        if(gear.toUpperCase().equals("LOW")) {
          left_encoders[0].setPositionConversionFactor(Constants.DriveConstants.LOW_GEAR_LEFT_DPP);
          left_encoders[1].setPositionConversionFactor(Constants.DriveConstants.LOW_GEAR_LEFT_DPP);
          left_encoders[2].setPositionConversionFactor(Constants.DriveConstants.LOW_GEAR_LEFT_DPP);
          right_encoders[0].setPositionConversionFactor(Constants.DriveConstants.LOW_GEAR_RIGHT_DPP);
          right_encoders[1].setPositionConversionFactor(Constants.DriveConstants.LOW_GEAR_RIGHT_DPP);
          right_encoders[2].setPositionConversionFactor(Constants.DriveConstants.LOW_GEAR_RIGHT_DPP);
        } else if(gear.toUpperCase().equals("HIGH")) {
          left_encoders[0].setPositionConversionFactor(Constants.DriveConstants.HIGH_GEAR_LEFT_DPP);
          left_encoders[1].setPositionConversionFactor(Constants.DriveConstants.HIGH_GEAR_LEFT_DPP);
          left_encoders[2].setPositionConversionFactor(Constants.DriveConstants.HIGH_GEAR_LEFT_DPP);
          right_encoders[0].setPositionConversionFactor(Constants.DriveConstants.HIGH_GEAR_RIGHT_DPP);
          right_encoders[1].setPositionConversionFactor(Constants.DriveConstants.HIGH_GEAR_RIGHT_DPP);
          right_encoders[2].setPositionConversionFactor(Constants.DriveConstants.HIGH_GEAR_RIGHT_DPP);
        }
      } 

      public void resetGyroAngle() {
        Gyro.reset(); 
        /* resets the gyro */
     }

     public static double getGyroAxis(){
      return Gyro.getAngle();
     }
     public void autoDrive(double left, double right, double angle) {
     
      if (left > 0 && right > 0){ //driving forwards
        drive(
          angle > 0 ? left : left * Constants.AutoConstants.AUTO_SPEED_ADJUSTMENT * 1.08,
          angle < 0 ? right : right * Constants.AutoConstants.AUTO_SPEED_ADJUSTMENT * 1.08
        );
      }
      else if (left < 0 && right < 0){ //driving backwards
        drive(
          angle < 0 ? left : left * Constants.AutoConstants.AUTO_SPEED_ADJUSTMENT * 1.08,
          angle > 0 ? right : right * Constants.AutoConstants.AUTO_SPEED_ADJUSTMENT * 1.08
        );
      }
      else{ //When leftDrive1 and rightDrive1 are zero
        drive(0,0);      
      }
    }

}
