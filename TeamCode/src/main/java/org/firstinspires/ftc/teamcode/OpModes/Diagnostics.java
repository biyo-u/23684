package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.CRServo;


import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "Zeta Prime Diagnostics", group = "1.TeleOp")
public class Diagnostics extends OpMode {

    private Robot robot;
    private final CRServo intakeServo;
    private final Servo clawServo;
    private final DcMotor elbowMotor;
    private final Servo wristServo;
    private DcMotor liftMotorLeft;
    private DcMotor liftMotorRight;
    private DcMotor liftMotorTilt;
    private DcMotor shoulderMotor;
    private final Servo first_hang_right;
    private final Servo first_hang_left;
    public DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor rearLeft;
    private DcMotor rearRight;

    @Override
    public void init() {

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
        telemetry.addData("Status", "Initialized");
    }

    @Override
    public void loop() {

    }
}
