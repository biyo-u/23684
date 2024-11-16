package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;


import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Robot;

/*
THIS OPMODE IS FOR DIAGNOSTIC TESTING OF ALL HARDWARE INDEPENDENT OF SUBSYSTEMS. DO NOT DELETE THIS.
 */

@TeleOp(name = "Zeta Prime Diagnostics", group = "1.TeleOp")
public class Diagnostics extends OpMode {
    private CRServo intakeServo;
    private Servo clawServo;
    private DcMotor elbowMotor;
    private Servo wristServo;
    private DcMotor liftMotorLeft;
    private DcMotor liftMotorRight;
    private DcMotor liftMotorTilt;
    private DcMotor shoulderMotor;
    private Servo first_hang_right;
    private Servo first_hang_left;
    public DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor rearLeft;
    private DcMotor rearRight;

    @Override
    public void init() {
        // HANG
        this.first_hang_left = first_hang_left;
        this.first_hang_right = first_hang_right;
        // DRIVE
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.rearLeft = rearLeft;
        this.rearRight = rearRight;
        this.frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.rearLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.rearRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        // LIFT
        this.liftMotorLeft = liftMotorLeft;
        this.liftMotorRight = liftMotorRight;
        this.liftMotorTilt = liftMotorTilt;
        this.shoulderMotor = shoulderMotor;
        this.liftMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.liftMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.liftMotorTilt.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.shoulderMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.liftMotorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.liftMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.liftMotorTilt.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.shoulderMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        // INTAKE
        this.intakeServo = intakeServo;
        this.clawServo = clawServo;
        this.elbowMotor = elbowMotor;
        this.wristServo = wristServo;
        telemetry.addData("Hardware Status", "Initialized");
    }

    @Override
    public void loop() {
        telemetry.addData("Motor Speed Note", "All motors will move at 100% speed, which is not" +
                "the max. Motors can move more than 100%, but that" +
                "damages the motors.");
        telemetry.addData("GAMEPAD ONE", "CONTROLS");
        telemetry.addData("X Key", "Front Left Motor");
        telemetry.addData("Y Key", "Front Right Motor");
        telemetry.addData("A Key", "Rear Left Motor");
        telemetry.addData("B Key", "Rear Right Motor");
        telemetry.addData("D Pad Up", "Both Lift Motors Up");
        telemetry.addData("D Pad Down", "Both Lift Motors Down");
        telemetry.addData("D Pad Left", "Lift Tilt +1 power");
        telemetry.addData("D Pad Right", "Lift Tilt -1 power");
        telemetry.addData("Right Bumper", "Intake Forward");
        telemetry.addData("Left Bumper", "Intake Backward");

        telemetry.addData("GAMEPAD TWO", "CONTROLS");
        telemetry.addData("X Key", "Shoulder Up");
        telemetry.addData("Y Key", "Shoulder Down");
        telemetry.addData("A Key", "Claw Pos A");
        telemetry.addData("B Key", "Claw Pos B");
        telemetry.addData("D Pad Up", "Elbow +1 Power");
        telemetry.addData("D Pad Down", "Elbow -1 Power");
        telemetry.addData("D Pad Left", "Claw Pos A");
        telemetry.addData("D Pad Right", "Claw Pos B");
        telemetry.addData("Right Bumper", "Hangs Up");
        telemetry.addData("Left Bumper", "Hangs Down");

        // CONFIRM MOTOR DIRECTION
        if (gamepad1.x) {
            frontLeft.setPower(1);
        } else {
            frontLeft.setPower(0);
        }
        if (gamepad1.y) {
            frontRight.setPower(1);
        } else {
            frontRight.setPower(0);
        }
        if (gamepad1.a) {
            rearLeft.setPower(1);
        } else {
            rearLeft.setPower(0);
        }
        if (gamepad1.b) {
            rearRight.setPower(1);
        } else {
            rearRight.setPower(0);
        }

        // CONFIRM SLIDE DIRECTIONS
        if (gamepad1.dpad_up) {
            liftMotorLeft.setPower(1);
            liftMotorRight.setPower(1);
        } else if (gamepad1.dpad_down) {
            liftMotorLeft.setPower(-1);
            liftMotorRight.setPower(-1);
        } else {
            liftMotorLeft.setPower(0);
            liftMotorRight.setPower(0);
        }

        // MOTOR TILT TESTING
        if (gamepad1.dpad_left) {
            liftMotorTilt.setPower(1);
        } else if (gamepad1.dpad_right) {
            liftMotorTilt.setPower(-1);
        } else {
            liftMotorTilt.setPower(0);
        }

        // CONFIRM INTAKE FUNCTIONS
        if (gamepad1.left_bumper) {
            intakeServo.setPower(1);
        } else if (gamepad1.right_bumper) {
            intakeServo.setPower(-1);
        } else {
            intakeServo.setPower(0);
        }

        // SHOULDER DIRECTION TEST
        if (gamepad2.x) {
            shoulderMotor.setPower(1);
        } else if (gamepad2.y) {
            shoulderMotor.setPower(-1);
        } else {
            shoulderMotor.setPower(0);
        }

        // CLAW TESTING
        if (gamepad2.a) {
            clawServo.setPosition(1);
        } else if (gamepad2.b) {
            clawServo.setPosition(0);
        }

        // ELBOW WORKING
        if (gamepad2.dpad_up) {
            elbowMotor.setPower(1);
        } else if (gamepad2.dpad_down) {
            elbowMotor.setPower(-1);
        } else {
            elbowMotor.setPower(0);
        }

        // WRIST RUNNING
        if (gamepad2.dpad_left) {
            wristServo.setPosition(1);
        } else if (gamepad2.dpad_right) {
            wristServo.setPosition(0);
        }

        // HANG SERVO PREP
        if (gamepad2.right_bumper) {
            first_hang_left.setPosition(1);
            first_hang_right.setPosition(1);
        } else if (gamepad2.left_bumper) {
            first_hang_left.setPosition(0);
            first_hang_right.setPosition(0);
        }
    }
}
