package org.firstinspires.ftc.teamcode.hardcodeauto.movements;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.Robot;


public class Lines {

 public static Robot robot;


    public static void MoveX(double power){
        robot.drive.setFrontLeftSpeed(power);
        robot.drive.setFrontLeftSpeed(power);
        robot.drive.setFrontLeftSpeed(power);
        robot.drive.setFrontLeftSpeed(power);
    }
}
