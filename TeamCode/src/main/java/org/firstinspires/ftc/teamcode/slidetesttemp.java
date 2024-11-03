package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

// THIS PROGRAM WAS CREATED TO TEST RUN THE VIPER SLIDES ON BENJAMIN. DO NOT DELETE!!!!
@TeleOp
public class slidetesttemp extends OpMode {

    private DcMotor slide_left;
    private DcMotor slide_right;

    double reduction = 1;

    @Override
    public void init() {
        slide_left = hardwareMap.get(DcMotor.class, "slide_left");
        slide_right = hardwareMap.get(DcMotor.class, "slide_right");
        slide_right.setDirection(DcMotor.Direction.REVERSE);
    }

    @Override
    public void loop() {
        if (gamepad1.dpad_up) {
            slide_left.setPower(1);
        } else if (gamepad1.dpad_down) {
            slide_left.setPower(-1);
        } else {
            slide_left.setPower(0);
        }

        if (gamepad1.dpad_left) {
            slide_right.setPower(1/reduction);
        } else if (gamepad1.dpad_right) {
            slide_right.setPower(-1/reduction);
        } else {
            slide_right.setPower(0);
        }

        telemetry.addData("SLIDE LEFT MOVEMENT (TICKS)", slide_left.getCurrentPosition());
        telemetry.addData("SLIDE RIGHT MOVEMENT (TICKS)", slide_right.getCurrentPosition());

    }
}
