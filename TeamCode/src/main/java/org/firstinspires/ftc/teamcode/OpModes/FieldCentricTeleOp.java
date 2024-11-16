package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "FieldCentricTeleOp", group = "1.TeleOp")
public class FieldCentricTeleOp extends OpMode {
    private Robot robot;

    @Override
    public void init() {
        robot = new Robot(hardwareMap);
    }

    @Override
    public void loop() {
        // Drive the robot with the gamepad
        robot.drive.driveMecanumFieldCentric(gamepad1.left_stick_y, gamepad1.left_stick_x, gamepad1.right_stick_x, robot.compass);

        // Reset IMU for Field Centric
        if (gamepad1.left_bumper) {
            robot.compass.resetYaw();
        }

        // Set speed mode
        if (gamepad1.right_bumper) {
            robot.drive.setPower(1);
        } else {
            robot.drive.setPower(0.5);
        }

        // Intake
        if (gamepad2.left_trigger > Constants.intakeThreshold) {
            robot.intake.intakeIn();
        } else if (gamepad2.right_trigger > Constants.intakeThreshold) {
            robot.intake.intakeOut();
        } else {
            robot.intake.intakeStop();
        }

        // Lift
        if (gamepad2.left_stick_y > Constants.liftThreshold) {
            robot.lift.liftMove(gamepad2.left_stick_y);
        } else if (gamepad2.left_stick_y < -Constants.liftThreshold) {
            robot.lift.liftMove(gamepad2.left_stick_y);
        } else {
            robot.lift.liftMove(0);
        }
        if (gamepad2.left_stick_x > Constants.liftThreshold) {
            robot.lift.liftTilt(gamepad2.left_stick_x);
        } else if (gamepad2.left_stick_x < -Constants.liftThreshold) {
            robot.lift.liftTilt(gamepad2.left_stick_x);
        } else {
            robot.lift.liftTilt(0);
        }

        // Shoulder
        if (gamepad2.right_stick_x > Constants.shoulderThreshold) {
            robot.lift.shoulderMove(gamepad2.right_stick_x);
        } else if (gamepad2.right_stick_x < -Constants.shoulderThreshold) {
            robot.lift.shoulderMove(gamepad2.right_stick_x);
        } else {
            robot.lift.shoulderMove(0);
        }

        // Elbow
        if (gamepad2.right_stick_y > Constants.elbowThreshold) {
            robot.intake.elbowMove(gamepad2.right_stick_y);
        } else if (gamepad2.right_stick_y < -Constants.elbowThreshold) {
            robot.intake.elbowMove(gamepad2.right_stick_y);
        } else {
            robot.intake.elbowMove(0);
        }

        // Telemetry
        telemetry.addLine(robot.lift.getTelemetry());
        telemetry.addLine(robot.intake.getTelemetry());
        telemetry.addLine(robot.odometry.getTelemetry());
    }
}
