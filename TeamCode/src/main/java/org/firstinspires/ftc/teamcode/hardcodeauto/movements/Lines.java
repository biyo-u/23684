package org.firstinspires.ftc.teamcode.hardcodeauto.movements;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.Robot;


public class Lines {

 public static Robot robot;


    public static void MoveX(double power){
        robot.drive.setFrontLeftSpeed(power);
        robot.drive.setRearRightSpeed(power);
        robot.drive.setFrontRightSpeed(power);
        robot.drive.setRearLeftSpeed(power);
    }

    public static void MoveY(double power){
        robot.drive.setFrontLeftSpeed(-power);
        robot.drive.setRearRightSpeed(-power);
        robot.drive.setFrontRightSpeed(power);
        robot.drive.setRearLeftSpeed(power);
    }
    public static void heading(double power){
        robot.drive.setFrontLeftSpeed(-power);
        robot.drive.setRearRightSpeed(power);
        robot.drive.setFrontRightSpeed(-power);
        robot.drive.setRearLeftSpeed(power);
    }

    public static void Movement(double x ,double y , double turning, double power){
        robot.drive.setFrontLeftSpeed(((y - x - turning) / 1 ) / power);
        robot.drive.setRearRightSpeed();
        robot.drive.setFrontRightSpeed();
        robot.drive.setRearLeftSpeed(((y + x - turning) / 1) / power;);

    }
}
