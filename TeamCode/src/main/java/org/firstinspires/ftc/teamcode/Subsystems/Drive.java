package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Robot;

public class Drive {
    private final DcMotor frontLeft;
    private final DcMotor frontRight;
    private final DcMotor rearLeft;
    private final DcMotor rearRight;
    private final Robot robot;
    private double power;

    // TODO: Document with Gemini Code Assist

    public Drive(DcMotor frontLeft, DcMotor frontRight, DcMotor rearLeft, DcMotor rearRight, Robot robot) {
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
        this.rearLeft = rearLeft;
        this.rearRight = rearRight;
        this.frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.rearLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.rearRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        this.frontLeft.setDirection(DcMotor.Direction.FORWARD);
        this.frontRight.setDirection(DcMotor.Direction.REVERSE);
        this.rearLeft.setDirection(DcMotor.Direction.FORWARD);
        this.rearRight.setDirection(DcMotor.Direction.REVERSE);
        this.frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.rearLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.rearRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        this.robot = robot;
        this.power = 0.5;
    }

    public void driveMecanumFieldCentric(double left_stick_y, double left_stick_x, double right_stick_x, Compass imu) {
        // TODO: Make sure this is needed and doesn't just cause problems
        double y = -left_stick_y; // Remember, Y stick value is reversed

        // Gets robot heading (direction it's pointing)
        double botHeading = imu.getHeading(AngleUnit.RADIANS);

        // Rotate the movement direction counter to the bot's rotation
        double rotX = left_stick_x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        double rotY = left_stick_x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

        // TODO: Make sure this is needed and doesn't just cause problems
        rotX = rotX * 1.1;  // Counteract imperfect strafing

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(right_stick_x), 1);
        double frontLeftPower = ((rotY + rotX + right_stick_x) / denominator) * power;
        double backLeftPower = ((rotY - rotX + right_stick_x) / denominator) * power;
        double frontRightPower = ((rotY - rotX - right_stick_x) / denominator) * power;
        double backRightPower = ((rotY + rotX - right_stick_x) / denominator) * power;

        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        rearLeft.setPower(backLeftPower);
        rearRight.setPower(backRightPower);
    }

    public void driveMecanumRobotCentric(double left_stick_y, double left_stick_x, double right_stick_x) {
        double y = -left_stick_y; // Remember, Y stick value is reversed
        double x = left_stick_x * 1.1; // Counteract imperfect strafing

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(right_stick_x), 1);
        double frontLeftPower = (y + x + right_stick_x) / denominator;
        double backLeftPower = (y - x + right_stick_x) / denominator;
        double frontRightPower = (y - x - right_stick_x) / denominator;
        double backRightPower = (y + x - right_stick_x) / denominator;

        frontLeft.setPower(frontLeftPower);
        frontRight.setPower(frontRightPower);
        rearLeft.setPower(backLeftPower);
        rearRight.setPower(backRightPower);
    }

    public void setPower(double power) {
        this.power = power;
    }

    public DcMotor getFrontLeft() {
        return frontLeft;
    }

    public DcMotor getFrontRight() {
        return frontRight;
    }

    public DcMotor getRearLeft() {
        return rearLeft;
    }

    public DcMotor getRearRight() {
        return rearRight;
    }
}
