package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Servo;

public class LiftServo {
    Servo lift_servo;

    public LiftServo(Servo lift_servo){
        this.lift_servo = lift_servo;
    }

    public void Move(double position) {
        lift_servo.setPosition(position);
    }

    public double getPosition(){
        return lift_servo.getPosition();
    }
}
