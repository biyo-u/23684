package org.firstinspires.ftc.teamcode.OpModes.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.Subsystems.Odometry;

/*
THIS OPMODE IS FOR DIAGNOSTIC TESTING OF ALL HARDWARE INDEPENDENT OF SUBSYSTEMS. DO NOT DELETE THIS.
 */

@Disabled
@TeleOp(name = "Zeta Prime Diagnostics", group = Constants.GroupNames.Testing)
public class Diagnostics extends OpMode {
    private Servo clawServo;
    private Servo wristServo;
    private DcMotor liftMotorLeft;
    private DcMotor liftMotorRight;
    private Servo liftServoTiltRight;
    private Servo liftServoTiltLeft;
    private DcMotor shoulderMotor;
    private Servo first_hang_right;
    private Servo first_hang_left;
    public DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor rearLeft;
    private DcMotor rearRight;
    private Robot robot;

    @Override
    public void init() {
        if (Constants.developerMode) {
            requestOpModeStop();
        }

        robot = new Robot(hardwareMap);

        // Private Devices
        CRServo intakeServo = hardwareMap.get(CRServo.class, "intakeServo");
        Servo clawServo = hardwareMap.get(Servo.class, "clawServo");
        Servo wristServo = hardwareMap.get(Servo.class, "wristServo");
        Servo first_hang_right = hardwareMap.get(Servo.class, "rightHangServo");
        Servo first_hang_left = hardwareMap.get(Servo.class, "leftHangServo");
        DcMotor liftMotorLeft = hardwareMap.get(DcMotor.class, "liftMotorLeft");
        DcMotor liftMotorRight = hardwareMap.get(DcMotor.class, "liftMotorRight");
        Servo liftServoTiltRight = hardwareMap.get(Servo.class, "liftServoTiltRight");
        Servo liftServoTiltLeft = hardwareMap.get(Servo.class, "liftServoTiltLeft");
        DcMotor shoulderMotor = hardwareMap.get(DcMotor.class, "shoulderMotor");
        DcMotor frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        DcMotor frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        DcMotor rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
        DcMotor rearRight = hardwareMap.get(DcMotor.class, "rearRight");

        // HANG
        this.first_hang_left = first_hang_left;
        this.first_hang_right = first_hang_right;
        // DRIVE
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.rearLeft = rearLeft;
        this.rearRight = rearRight;
        this.frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        this.rearLeft.setDirection(DcMotorSimple.Direction.REVERSE);
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
        this.liftServoTiltLeft = liftServoTiltLeft;
        this.liftServoTiltRight = liftServoTiltRight;
        this.shoulderMotor = shoulderMotor;
        this.liftMotorRight.setDirection(DcMotorSimple.Direction.REVERSE);
        this.liftMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.liftMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.shoulderMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.liftMotorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.liftMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.shoulderMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        // INTAKE
        this.clawServo = clawServo;
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
        telemetry.addData("D Pad Left", "Both Lift Tilt +1 power");
        telemetry.addData("D Pad Right", "Both Lift Tilt -1 power");

        telemetry.addData("GAMEPAD TWO", "CONTROLS");
        telemetry.addData("X Key", "Shoulder Up"); //X sends down
        telemetry.addData("Y Key", "Shoulder Down"); // Y sends up
        telemetry.addData("A Key", "Claw Pos A"); // close
        telemetry.addData("B Key", "Claw Pos B"); // open
        telemetry.addData("D Pad Left", "Wrist Pos A");
        telemetry.addData("D Pad Right", "Wrist Pos B");
        telemetry.addData("Right Bumper", "Hangs Up");
        telemetry.addData("Left Bumper", "Hangs Down");

//        // CONFIRM MOTOR DIRECTION
//        if (gamepad1.x) {
//            frontLeft.setPower(0.3);
//        } else {
//            frontLeft.setPower(0);
//        }
//        if (gamepad1.y) {
//            frontRight.setPower(0.3);
//        } else {
//            frontRight.setPower(0);
//        }
//        if (gamepad1.a) {
//            rearLeft.setPower(0.3);
//        } else {
//            rearLeft.setPower(0);
//        }
//        if (gamepad1.b) {
//            rearRight.setPower(0.3);
//        } else {
//            rearRight.setPower(0);
//        }

        // convert joystick inputs into numbers indicating direction
        double y = gamepad1.right_stick_y; // Remember, Y stick value is reversed
        double x = gamepad1.right_stick_x * 1.1; // Counteract imperfect strafing
        double rx = gamepad1.left_stick_x;
        double power;

        // convert joystick direction numbers into power values
        /* Denominator is the largest motor power (absolute value) or 1
        This ensures all the powers maintain the same ratio,
        but only if at least one is out of the range [-1, 1] */
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);

        // Speed Controls
        if (gamepad1.options) {
            power = 1;
        } else {
            power = 2.5;
        }

        // calculate the power value, dividing first by the denominator, then by speed
        double frontLeftPower = ((y - x - rx) / denominator) / power;
        double backLeftPower = ((y + x - rx) / denominator) / power;
        double frontRightPower = ((y + x + rx) / denominator) / power;
        double backRightPower = ((y - x + rx) / denominator) / power;

        // send power to the mecanum wheels using power values indicated
        frontLeft.setPower(frontLeftPower);
        rearLeft.setPower(backLeftPower);
        frontRight.setPower(frontRightPower);
        rearRight.setPower(backRightPower);


        // CONFIRM SLIDE DIRECTIONS AGAIN!!!!
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
            liftServoTiltRight.setPosition(1);
            liftServoTiltLeft.setPosition(1);
        } else if (gamepad1.dpad_right) {
            liftServoTiltRight.setPosition(0);
            liftServoTiltLeft.setPosition(0);
        } else {
            liftServoTiltRight.setPosition(0);
            liftServoTiltLeft.setPosition(0);
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

        // WRIST RUNNING
        if (gamepad2.dpad_left) {
            wristServo.setPosition(1);
        } else if (gamepad2.dpad_right) {
            wristServo.setPosition(0);
        }

        // HANG SERVO PREP
        if (gamepad2.right_bumper) {
            first_hang_left.setPosition(1);
            first_hang_right.setPosition(0);
        } else if (gamepad2.left_bumper) {
            first_hang_left.setPosition(0.1);
            first_hang_right.setPosition(0.7);
        }

        telemetry.addLine(robot.odometry.getTelemetry());
        telemetry.addData("Heading", robot.compass.getHeading());
        telemetry.addData("X:", robot.odometry.rawXTelemetry());
        telemetry.addData("Y:", robot.odometry.rawYTelemetry());
        telemetry.addData("Heading:", robot.odometry.rawHeadingTelemetry());
    }
}