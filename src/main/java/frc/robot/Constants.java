// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;

  }
  
  public class DriveConstants {
    //True Constants
    public static final double TELEOP_SPEED_ADJUSTMENT_RIGHT = 0.99;
    public static final double TELEOP_SPEED_ADJUSTMENT_LEFT = 1;
    public static final double LOW_GEAR_LEFT_DPP = 1; // Low gear skews left
    public static final double LOW_GEAR_RIGHT_DPP  = 1;
    public static final double HIGH_GEAR_LEFT_DPP = 1; // High gear skews left
    public static final double HIGH_GEAR_RIGHT_DPP = 1;
    public static final int DRIVEBASE_THRESHOLD_FOR_PID = 0;

    ////DRIVE MOTORS////
   //Right Motors
    public static final int DRIVE_MOTOR_RIGHT_1 = 1;
    public static final int DRIVE_MOTOR_RIGHT_2 = 3;
    public static final int DRIVE_MOTOR_RIGHT_3 = 5;

    //Left Motors
    public static final int DRIVE_MOTOR_LEFT_1 = 2;
    public static final int DRIVE_MOTOR_LEFT_2 = 4;
    public static final int DRIVE_MOTOR_LEFT_3 = 6;

    public static final int GEAR_SHIFTER = 0;

    public static final double kP = 34.199;
    public static final double kI = 0;
    public static final double KD = 1.5784;
    
    public static final int ARM_MOTOR = 7;
  }

  public static class SubsystemConstants {

    


    //Claw Constants
    public static final int CLAW_SOLENOID_1 = 1;
    public static final int CLAW_SOLENOID_2 = 2;
    
  

    //Arm Constants
    public static final int ARM_MOTOR_1 = 1;
    public static final int ARM_MOTOR_2 = 2;
    public static final int ARM_SOLENOID_1 = 3;
    public static final int ARM_SOLENOID_2 = 4;
    public static final double ARM_MOTOR_SPEEDS = 1;


  }
  public class ControlConstants {
    //Operator Interfaces
    public static final double AXIS_THRESHOLD = 0.25;
    public static final int XBOX_CONTROLLER_DRIVER = 0;
    public static final int XBOX_CONTROLLER_OPERATOR = 1;

     // Buttons
    public static final int XBOX_BUTTON_A = 1;
    public static final int XBOX_BUTTON_B = 2;
    public static final int XBOX_BUTTON_X = 3;
    public static final int XBOX_BUTTON_Y = 4;
    public static final int XBOX_BUTTON_LEFT_BUMPER = 5;
    public static final int XBOX_BUTTON_RIGHT_BUMPER = 6;
    public static final int XBOX_BUTTON_BACK = 7;
    public static final int XBOX_BUTTON_START = 8;
    public static final int XBOX_BUTTON_L3 = 9;
    public static final int XBOX_BUTTON_R3 = 10;

    // Axes
    public static final int XBOX_AXIS_LEFT_X = 0;
    public static final int XBOX_AXIS_LEFT_Y = 1;
    public static final int XBOX_AXIS_LEFT_TRIGGER = 2;
    public static final int XBOX_AXIS_RIGHT_TRIGGER = 3;
    public static final int XBOX_AXIS_RIGHT_X = 4;
    public static final int XBOX_AXIS_RIGHT_Y = 5;

    //Drive Sensitivities
    public static final double DRIVE_SENSITIVITY_PRECISION = 0.5;
    public static final double DRIVE_SENSITIVITY_DEFAULT = 1;
    public static final double SPIN_SENSITIVITY = 0.8;

    //public static final int PCM_ID = 0;

    //Solenoids


    ////Sensors////
    //Encoders
    public static final int DRIVE_ENC_LEFT_A = 3;
    public static final int DRIVE_ENC_RIGHT_A = 1;
    public static final int DRIVE_ENC_LEFT_B = 4;
    public static final int DRIVE_ENC_RIGHT_B = 2;
  }

  public final class AutoConstants{
    public static final double ANGLE_THRESHOLD = 6;
  }
}
