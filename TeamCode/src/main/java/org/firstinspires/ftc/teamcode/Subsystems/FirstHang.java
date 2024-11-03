package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Servo;

public class FirstHang {
    Servo hang_left;
    Servo hang_right;

    public FirstHang(Servo hang_left, Servo hang_right){
        this.hang_left = hang_left;
        this.hang_right = hang_right;

        this.hang_right.setDirection(Servo.Direction.REVERSE);
    }

    private void HangMove(double position) {
        hang_left.setPosition(position);
        hang_right.setPosition(position);
    }

    public void HangDown() {
        HangMove(0);
    }

    public void HangUp() {
        HangMove(1);
    }
}
