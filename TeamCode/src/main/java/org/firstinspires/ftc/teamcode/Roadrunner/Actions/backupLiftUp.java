package org.firstinspires.ftc.teamcode.Roadrunner.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Robot;

public class backupLiftUp implements Action {

    private boolean initialised = false;
    private final Robot robot;

    private DcMotor liftMotorLeft;
    private DcMotor liftMotorRight;

    public backupLiftUp(Robot robot){
        this.robot = robot;
    }

    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {

        if (!initialised) {
            this.liftMotorLeft = robot.lift.getLiftMotorLeft();
            this.liftMotorRight = robot.lift.getLiftMotorRight();
            this.liftMotorLeft.setDirection(DcMotor.Direction.REVERSE);
            this.liftMotorRight.setDirection(DcMotor.Direction.FORWARD);
            this.liftMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            this.liftMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            this.liftMotorLeft.setPower(-1);
            this.liftMotorRight.setPower(-1);

            initialised = true;
        }

        double pos = (double) (liftMotorLeft.getCurrentPosition() + liftMotorRight.getCurrentPosition()) / 2;

        telemetryPacket.put("liftPos", pos);
        if (pos > -4000) {
            return true;
        } else {
            this.liftMotorLeft.setPower(0);
            this.liftMotorRight.setPower(0);
            return false;
        }
    }
}
