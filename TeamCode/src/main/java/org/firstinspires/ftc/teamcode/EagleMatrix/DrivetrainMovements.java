package org.firstinspires.ftc.teamcode.EagleMatrix;

import org.firstinspires.ftc.teamcode.Robot;

public class DrivetrainMovements {
    Robot robot;

    double modifier = 0.6;
    double forward = 1 * modifier;
    double backward = -1 * modifier;
    double rest = 0;

    public DrivetrainMovements(Robot robot){
        this.robot = robot;
    }

    // Drivetrain moves forward
    public void YForward(){
        robot.drive.getFrontLeft().setPower(forward);
        robot.drive.getFrontRight().setPower(forward);
        robot.drive.getRearLeft().setPower(forward);
        robot.drive.getRearRight().setPower(forward);
    }

    // Drivetrain moves backward
    public void YBackward(){
        robot.drive.getFrontLeft().setPower(backward);
        robot.drive.getFrontRight().setPower(backward);
        robot.drive.getRearLeft().setPower(backward);
        robot.drive.getRearRight().setPower(backward);
    }

    // Drivetrain moves right
    public void XRight(){
        robot.drive.getFrontLeft().setPower(forward);
        robot.drive.getFrontRight().setPower(backward);
        robot.drive.getRearLeft().setPower(backward);
        robot.drive.getRearRight().setPower(forward);
    }

    // Drivetrain moves left
    public void XLeft(){
        robot.drive.getFrontLeft().setPower(backward);
        robot.drive.getFrontRight().setPower(forward);
        robot.drive.getRearLeft().setPower(forward);
        robot.drive.getRearRight().setPower(backward);
    }

    // Drivetrain moves at a 45 degree angle forward and to the right
    public void XYForwardRight(){
        robot.drive.getFrontLeft().setPower(forward);
        robot.drive.getFrontRight().setPower(rest);
        robot.drive.getRearLeft().setPower(rest);
        robot.drive.getRearRight().setPower(forward);
    }

    // Drivetrain moves at a 45 degree angle forward and to the left
    public void XYForwardLeft(){
        robot.drive.getFrontLeft().setPower(rest);
        robot.drive.getFrontRight().setPower(forward);
        robot.drive.getRearLeft().setPower(forward);
        robot.drive.getRearRight().setPower(rest);
    }

    // Drivetrain moves at a 45 degree angle backward and to the right
    public void XYBackwardRight(){
        robot.drive.getFrontLeft().setPower(backward);
        robot.drive.getFrontRight().setPower(rest);
        robot.drive.getRearLeft().setPower(rest);
        robot.drive.getRearRight().setPower(backward);
    }

    // Drivetrain moves at a 45 degree angle backward and to the left
    public void XYBackwardLeft(){
        robot.drive.getFrontLeft().setPower(rest);
        robot.drive.getFrontRight().setPower(backward);
        robot.drive.getRearLeft().setPower(backward);
        robot.drive.getRearRight().setPower(rest);
    }

    // Drivetrain rotates to the right
    public void thetaRight() {
        robot.drive.getFrontLeft().setPower(forward);
        robot.drive.getFrontRight().setPower(backward);
        robot.drive.getRearLeft().setPower(forward);
        robot.drive.getRearRight().setPower(backward);
    }

    //Drivetrain rotates to the left
    public void thetaLeft(){
        robot.drive.getFrontLeft().setPower(backward);
        robot.drive.getFrontRight().setPower(forward);
        robot.drive.getRearLeft().setPower(backward);
        robot.drive.getRearRight().setPower(forward);
    }

    public void stop(){
        robot.drive.getFrontLeft().setPower(rest);
        robot.drive.getFrontRight().setPower(rest);
        robot.drive.getRearLeft().setPower(rest);
        robot.drive.getRearRight().setPower(rest);
    }
}
