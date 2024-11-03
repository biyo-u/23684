package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class Drive {
    public DcMotor front_left;
    public DcMotor rear_left;
    public DcMotor front_right;
    public DcMotor rear_right;

    public Drive(DcMotor front_left, DcMotor front_right, DcMotor rear_left, DcMotor rear_right){
        this.front_left = front_left;
        this.front_right = front_right;
        this.rear_left = rear_left;
        this.rear_right = rear_right;

        this.front_left.setDirection(DcMotorSimple.Direction.REVERSE);
        this.front_right.setDirection(DcMotorSimple.Direction.REVERSE);
        this.rear_left.setDirection(DcMotorSimple.Direction.REVERSE);
        this.rear_right.setDirection(DcMotorSimple.Direction.FORWARD);
    }

    // TODO: Add other common functions

    public void setFrontLeftSpeed(double speed){
        front_left.setPower(speed);
    }
    public void setFrontRightSpeed(double speed){
        front_right.setPower(speed);
    }
    public void setRearLeftSpeed(double speed){
        rear_left.setPower(speed);
    }
    public void setRearRightSpeed(double speed){
        rear_right.setPower(speed);
    }

    public void setMotorSpeeds(double front_left_speed, double front_right_speed, double rear_left_speed, double rear_right_speed){
        setFrontLeftSpeed(front_left_speed);
        setFrontRightSpeed(front_right_speed);
        setRearLeftSpeed(rear_left_speed);
        setRearRightSpeed(rear_right_speed);
    }
}
