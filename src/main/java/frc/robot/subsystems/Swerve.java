package frc.robot.subsystems;




import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Constants.SubsystemConstants;

public class Swerve extends SubsystemBase {
   
    private CANSparkMax driveMotor;
    private CANSparkMax turnMotor;
    private RelativeEncoder driveEncoder;
    private RelativeEncoder turnEncoder;
    private PIDController turningPidControler;
    private AnalogInput superEncoder;
    private boolean superReverse;
    private double superEncoderOffsetRad;
    public Swerve(int driveMotorId, int turnMotorId, int superEncoderId, double superEncoderOffset, boolean driveMotorReversed, boolean turnMotorReversed, boolean superEncoderReversed) {
        this.superEncoderOffsetRad=superEncoderOffset;
        this.superReverse=superEncoderReversed;
        superEncoder=new AnalogInput(superEncoderId);

        driveMotor=new CANSparkMax(driveMotorId, MotorType.kBrushless);
        turnMotor=new CANSparkMax(turnMotorId, MotorType.kBrushless);

        driveMotor.setInverted(driveMotorReversed);
        turnMotor.setInverted(turnMotorReversed);
        driveEncoder=driveMotor.getEncoder();
        turnEncoder=turnMotor.getEncoder();

        driveEncoder.setPositionConversionFactor(SubsystemConstants.kDriveEncoderRot2Meter);
        driveEncoder.setVelocityConversionFactor(SubsystemConstants.kDriveEncoderRPM2MeterPerSec);
        turnEncoder.setPositionConversionFactor(SubsystemConstants.kTurningEncoderRot2Rad);
        turnEncoder.setVelocityConversionFactor(SubsystemConstants.kDriveEncoderRPM2RadPerSec);

        turningPidControler= new PIDController(SubsystemConstants.kPTurning, 0, 0);
        turningPidControler.enableContinuousInput(Math.PI, Math.PI);
        

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
  }
  