package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "Field Centric Tele Op", group = "1.TeleOp")
public class FieldCentricTeleOp extends OpMode {
    Robot robot;

    @Override
    public void init() {
        robot = new Robot(hardwareMap, telemetry, false);
    }

    public void loop(){
        double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
        double x = gamepad1.left_stick_x;
        double rx = gamepad1.right_stick_x;

        // This button choice was made so that it is hard to hit on accident,
        if (gamepad1.left_bumper) {
            robot.imu.resetYaw();
        }

        // Activates super speed mode (speed is a percentage between 0 and 1)
        if (gamepad1.right_bumper) {
            robot.updateSpeed((double) 1/100);
        } else {
            robot.updateSpeed((double) 75/100);
        }

        // Slide
        if (gamepad2.left_stick_y > Constants.deadZone) {
            robot.slide.SlideDown(1);
        } else if (gamepad2.left_stick_y < -Constants.deadZone) {
            robot.slide.SlideUp(1);
        } else {
            robot.slide.SlideStop();
        }

        // LiftAngleMotorV2
        if (Math.abs(gamepad2.left_stick_x) > Constants.deadZone) {
            float input = gamepad2.left_stick_x;
            float mappedInput;

            if (input > 0) {
                // Map values from 0 to 1 to deadZone to 1
                mappedInput = (float) (Constants.deadZone + (input * (1 - Constants.deadZone)));
            } else {
                // Map values from 0 to -1 to -deadZone to -1
                mappedInput = (float) (-Constants.deadZone + (input * (1 - Constants.deadZone)));
            }

            robot.liftAngleMotorV2.Move(mappedInput);
        }

        // Intake
        if (Math.abs(gamepad2.right_stick_x) > Constants.deadZone) {
            float input = gamepad2.right_stick_x;
            float mappedInput;

            if (input > 0) {
                // Map values from 0 to 1 to deadZone to 1
                mappedInput = (float) (Constants.deadZone + (input * (1 - Constants.deadZone)));
            } else {
                // Map values from 0 to -1 to -deadZone to -1
                mappedInput = (float) (-Constants.deadZone + (input * (1 - Constants.deadZone)));
            }

            robot.arm.intakeMove(mappedInput);
        }

        // Arm Main
        if (Math.abs(gamepad2.right_stick_y) > Constants.deadZone) {
            float input = gamepad2.right_stick_y;
            float mappedInput;

            if (input > 0) {
                // Map values from 0 to 1 to deadZone to 1
                mappedInput = (float) (Constants.deadZone + (input * (1 - Constants.deadZone)));
            } else {
                // Map values from 0 to -1 to -deadZone to -1
                mappedInput = (float) (-Constants.deadZone + (input * (1 - Constants.deadZone)));
            }

            robot.arm.armMainMove(mappedInput);
        }

        if (gamepad2.x) {
            robot.arm.elbowMove(-1);
        } else if (gamepad2.b) {
            robot.arm.elbowMove(1);
        } else {
            robot.arm.elbowMove(-0);
        }


        if(gamepad2.dpad_left){
            robot.firstHang.HangUp();
        } else if(gamepad2.dpad_right){
            robot.firstHang.HangDown();
        }

        telemetry.addData("Slide Servo Position", robot.liftServo.getPosition());


        // Gets robot heading (direction it's pointing)
        double botHeading = robot.imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

        // Rotate the movement direction counter to the bot's rotation
        double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

        // TODO: Make sure this is needed and doesn't just cause problems
        rotX = rotX * 1.1;  // Counteract imperfect strafing

        // Denominator is the largest motor power (absolute value) or 1
        // This ensures all the powers maintain the same ratio,
        // but only if at least one is out of the range [-1, 1]
        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
        double frontLeftPower = ((rotY + rotX + rx) / denominator) * robot.power;
        double backLeftPower = ((rotY - rotX + rx) / denominator) * robot.power;
        double frontRightPower = ((rotY - rotX - rx) / denominator) * robot.power;
        double backRightPower = ((rotY + rotX - rx) / denominator) * robot.power;

        robot.drive.setFrontLeftSpeed(frontLeftPower);
        robot.drive.setRearLeftSpeed(backLeftPower);
        robot.drive.setFrontRightSpeed(frontRightPower);
        robot.drive.setRearRightSpeed(backRightPower);
    }
}