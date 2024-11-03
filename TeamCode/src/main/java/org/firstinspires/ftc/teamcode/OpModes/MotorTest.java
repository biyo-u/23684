package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "Motor Test", group = "Test")
public class MotorTest extends OpMode {

    Robot robot;

    @Override
    public void init() {
        // Initializes the motor with the hardwareMap (for all hardware devices) and telemetry (for CAI Telemetry)
        robot = new Robot(hardwareMap, telemetry, false);
    }

    public void loop(){

        // All keys move motors at normal max speed (100%)
        // Note that motors can go faster than normal max speed, but is bad for the motors
        // X Key moves Front Left motor
        // Y Key moves Front Right motor
        // A Key moves Rear Left motor
        // B Key moves Rear Right motor
        // D Pad Up moves Slide up
        // D Pad Down moves Slide up

        robot.telemetry.addData("Motor Speed Note", "All motors will move at 100% speed, which is not" +
                                                                "the max. Motors can move more than 100%, but that" +
                                                                "damages the motors.");
        robot.telemetry.addData("X Key", "Front Left Motor");
        robot.telemetry.addData("Y Key", "Front Right Motor");
        robot.telemetry.addData("A Key", "Rear Left Motor");
        robot.telemetry.addData("B Key", "Rear Right Motor");
        robot.telemetry.addData("D Pad Up", "Both Slide Motors Up");
        robot.telemetry.addData("D Pad Down", "Both Slide Motors Down");

        double frontLeftSpeed = gamepad1.x ? 1 : 0;
        double frontRightSpeed = gamepad1.y ? 1 : 0;
        double rearLeftSpeed = gamepad1.a ? 1 : 0;
        double rearRightSpeed = gamepad1.b ? 1 : 0;

        robot.drive.setFrontLeftSpeed(frontLeftSpeed);
        robot.drive.setFrontRightSpeed(frontRightSpeed);
        robot.drive.setRearLeftSpeed(rearLeftSpeed);
        robot.drive.setRearRightSpeed(rearRightSpeed);

        if(gamepad1.dpad_up){
            robot.slide.SlideUp(1);
        } else if(gamepad1.dpad_down){
            robot.slide.SlideDown(1);
        } else {
            robot.slide.SlideStop();
        }


    }
}