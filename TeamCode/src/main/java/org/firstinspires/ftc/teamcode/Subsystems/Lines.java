package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import org.firstinspires.ftc.teamcode.Robot;


public class Lines {

    public static Robot robot;



    public static void MoveX(double power){
        robot.drive.getFrontLeft().setPower(power);
        robot.drive.getRearRight().setPower(power);
        robot.drive.getFrontRight().setPower(power);
        robot.drive.getRearLeft().setPower(power);
    }

    public static void MoveY(double power){
        robot.drive.getFrontLeft().setPower(-power);
        robot.drive.getRearRight().setPower(-power);
        robot.drive.getFrontLeft().setPower(power);
        robot.drive.getRearLeft().setPower(power);
    }
    public static void heading(double power){
        robot.drive.getFrontLeft().setPower(-power);
        robot.drive.getRearRight().setPower(power);
        robot.drive.getFrontLeft().setPower(-power);
        robot.drive.getRearLeft().setPower(power);
    }

    public static void Movement(double x ,double y , double turning, double power){
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(turning), 1);
        robot.drive.getFrontLeft().setPower(((y - x - turning) / denominator ) / power);
        robot.drive.getRearRight().setPower(((y + x - turning) / denominator) / power);
        robot.drive.getFrontRight().setPower(((y + x + turning) / denominator) / power);
        robot.drive.getRearLeft().setPower(((y + x - turning) / denominator) / power);

    }
}
