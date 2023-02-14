// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.SubsystemConstants;


public class ArmSubsystem extends SubsystemBase {

    private static final PneumaticsModuleType PneumaticsModuleType = null;
    private CANSparkMax left_motor;
    private CANSparkMax right_motor;
    private CANSparkMax transitional_motor;
    private Solenoid Arm_Solenoid;
    private Solenoid Arm_Solenoid_2;
    private boolean brake;

  /** Creates a new ExampleSubsystem. */
  public ArmSubsystem() {
    brake=false;
    left_motor=new CANSparkMax(SubsystemConstants.ARM_MOTOR_1, MotorType.kBrushless );
    right_motor=new CANSparkMax(SubsystemConstants.ARM_MOTOR_2, MotorType.kBrushless );
    transitional_motor=new CANSparkMax(SubsystemConstants.ARM_MOTOR_1, MotorType.kBrushless);
    Arm_Solenoid=new Solenoid(PneumaticsModuleType, Constants.SubsystemConstants.ARM_SOLENOID_1);
    Arm_Solenoid=new Solenoid(PneumaticsModuleType, Constants.SubsystemConstants.ARM_SOLENOID_2);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public CommandBase exampleMethodCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return runOnce(
        () -> {
          /* one-time action goes here */
        });
  }

  /**
   * An example method querying a boolean state of the subsystem (for example, a digital sensor).
   *
   * @return value of some boolean subsystem state, such as a digital sensor.
   */
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
  public void run(String mode){
    if(mode.equalsIgnoreCase("back")){
        left_motor.set(-SubsystemConstants.ARM_MOTOR_SPEEDS);
        right_motor.set(SubsystemConstants.ARM_MOTOR_SPEEDS);
    }
    else if(mode.equalsIgnoreCase("forward")){

        left_motor.set(SubsystemConstants.ARM_MOTOR_SPEEDS);
        right_motor.set(-SubsystemConstants.ARM_MOTOR_SPEEDS);
    }
    else if(mode.equalsIgnoreCase("brake")){
        armbrake();
        Arm_Solenoid.set(brake);
        Arm_Solenoid_2.set(brake);

    }
    
    


  }
  public void armbrake(){
    brake=!brake;
  }
  public void transitional(String mode){
    if(mode.equalsIgnoreCase("forward")){
    transitional_motor.set(SubsystemConstants.ARM_MOTOR_SPEEDS);
    }
    else if(mode.equalsIgnoreCase("back")){
      transitional_motor.set(-SubsystemConstants.ARM_MOTOR_SPEEDS);
  }
}
}