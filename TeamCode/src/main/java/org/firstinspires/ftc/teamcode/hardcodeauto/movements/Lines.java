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
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(turning), 1);
        robot.drive.setFrontLeftSpeed(((y - x - turning) / denominator ) / power);
        robot.drive.setRearRightSpeed(((y + x - turning) / denominator) / power);
        robot.drive.setFrontRightSpeed(((y + x + turning) / denominator) / power);
        robot.drive.setRearLeftSpeed(((y + x - turning) / denominator) / power);

    }
}
