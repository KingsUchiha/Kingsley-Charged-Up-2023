package frc.robot.Utilities;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants;


public class Controls {
  public static XboxController driver=new XboxController(Constants.ControlConstants.XBOX_CONTROLLER_DRIVER);
  public static CommandXboxController operater= new CommandXboxController(Constants.ControlConstants.XBOX_CONTROLLER_OPERATOR);


  public  Trigger A= operater.a();
  public  Trigger B= operater.b();
  public  Trigger X= operater.x();
  public  Trigger Y= operater.y();

 

  public static double Axis(XboxController controller, int axis){
    return controller.getRawAxis(axis);
  }

 
}
