package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.teamcode.Constants;

public class Slide {
    private final DcMotor slide_left;
    private final DcMotor slide_right;
    private final double left_extra_speed;
    private final double right_extra_speed;

    public Slide(DcMotor slide_left, DcMotor slide_right){
        this.slide_left = slide_left;
        this.slide_right = slide_right;
        this.left_extra_speed = Constants.slideLeftExtra;
        this.right_extra_speed = Constants.slideRightExtra;
        this.slide_right.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    public void SlideMove(double speed, double left_extra_speed, double right_extra_speed){
        slide_left.setPower(speed + left_extra_speed);
        slide_right.setPower(speed + right_extra_speed);
    }

    public void SlideUp(double speed){
        SlideMove(speed, left_extra_speed, right_extra_speed);
    }

    public void SlideDown(double speed){
        SlideMove(-speed, left_extra_speed, right_extra_speed);
    }

    public void SlideStop(){
        slide_left.setPower(0);
        slide_right.setPower(0);
    }
}

