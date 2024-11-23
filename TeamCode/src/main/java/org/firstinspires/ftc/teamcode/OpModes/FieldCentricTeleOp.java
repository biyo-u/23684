package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "FieldCentricTeleOp", group = Constants.GroupNames.TeleOp)
public class FieldCentricTeleOp extends OpMode {
    // TODO: IMPORTANT! Add the preselect auto when we get one

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
            robot.drive.setPower(0.6);
        }

        // Intake
        if (gamepad2.left_trigger > 0.2) {
            robot.intake.intakeIn();
        } else if (gamepad2.right_trigger > 0.2) {
            robot.intake.intakeOut();
        } else {
            robot.intake.intakeStop();
        }

        // Wrist TODO: Add x and y key in README.md
        if (gamepad2.y){
            robot.intake.wristUp();
        } else if (gamepad2.x) {
            robot.intake.wristDown();
        }

        // Lift
        robot.lift.liftMove(gamepad2.left_stick_y);

        // Lift Tilt
        if (gamepad2.left_stick_y == 1){
            robot.lift.liftLeft();
        } else if (gamepad2.left_stick_y == -1){
            robot.lift.liftRight();
        }

        // Shoulder
        robot.lift.shoulderMove(gamepad2.right_stick_x);

        // Elbow
        telemetry.addLine("Gamepad 2 Right Stick Y: " + gamepad2.right_stick_y);
        robot.intake.elbowMove(gamepad2.right_stick_y);
//        if (gamepad2.right_stick_y > Constants.elbowThreshold) {
//            robot.intake.elbowMove(gamepad2.right_stick_y);
//        } else if (gamepad2.right_stick_y < -Constants.elbowThreshold) {
//            robot.intake.elbowMove(gamepad2.right_stick_y);
//        } else {
//            robot.intake.elbowMove(0);
//        }

        // Hang Hooks
        if (gamepad2.dpad_up) {
            robot.lift.hang(1, 0);
        } else if (gamepad2.dpad_down) {
            robot.lift.hang(0.1, 0.7);
        }

        // Claw
        if (gamepad2.a) {
            robot.intake.clawOpen();
        } else if (gamepad2.b) {
            robot.intake.clawClose();
        }

        // Telemetry
        telemetry.addLine(robot.lift.getTelemetry());
        telemetry.addLine(robot.intake.getTelemetry());
        telemetry.addLine(robot.odometry.getTelemetry());
    }
}
