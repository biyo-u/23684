package org.firstinspires.ftc.teamcode.OpModes.Disabled;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.IMU;

@Disabled
public class OdometryOpMode extends LinearOpMode {

    // Motors
    private DcMotorEx leftMotor;
    private DcMotorEx rightMotor;
    private DcMotorEx backMotor;

    // IMU
    private IMU imu;

    // Odometry position variables
    private double xPos = 0;
    private double yPos = 0;
    private double heading = 0;

    // Encoder ticks per inch (This will vary based on your configuration)
    private final double TICKS_PER_INCH = 1000; // Example value

    @Override
    public void runOpMode() {
        // Initialize hardware
        leftMotor = hardwareMap.get(DcMotorEx.class, "leftMotor");
        rightMotor = hardwareMap.get(DcMotorEx.class, "rightMotor");
        backMotor = hardwareMap.get(DcMotorEx.class, "backMotor");

        // Set motor directions if necessary
        leftMotor.setDirection(DcMotor.Direction.REVERSE);
        rightMotor.setDirection(DcMotor.Direction.FORWARD);
        backMotor.setDirection(DcMotor.Direction.FORWARD);

        // Initialize IMU
        imu = hardwareMap.get(IMU.class, "imu");
        // Wait for the start button to be pressed
        waitForStart();

        while (opModeIsActive()) {
            // Update the odometry calculations
            updateOdometry();

            // Telemetry for debugging
            telemetry.addData("X Position (in)", xPos);
            telemetry.addData("Y Position (in)", yPos);
            telemetry.addData("Heading (deg)", heading);
            telemetry.update();
        }
    }

    private void updateOdometry() {
        // Get encoder positions
        int leftPosition = leftMotor.getCurrentPosition();
        int rightPosition = rightMotor.getCurrentPosition();
        int backPosition = backMotor.getCurrentPosition();

        // Convert encoder positions to inches
        double leftInches = leftPosition / TICKS_PER_INCH;
        double rightInches = rightPosition / TICKS_PER_INCH;
        double backInches = backPosition / TICKS_PER_INCH;

        // Calculate the robot's heading using the IMU

        // Update the robot's position (X, Y)
        // (This is a simplified version; you may need more complex calculations for accuracy)
        double deltaX = (leftInches + rightInches) / 2.0;
        double deltaY = backInches;

        xPos += deltaX * Math.cos(Math.toRadians(heading)) - deltaY * Math.sin(Math.toRadians(heading));
        yPos += deltaX * Math.sin(Math.toRadians(heading)) + deltaY * Math.cos(Math.toRadians(heading));
    }
}