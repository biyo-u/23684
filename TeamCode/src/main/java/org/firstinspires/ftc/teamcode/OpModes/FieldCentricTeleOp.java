package org.firstinspires.ftc.teamcode.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.Robot;

@TeleOp(name = "Field Centric Tele Op", group = "TeleOp")
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
        if (gamepad1.options) {
            robot.imu.resetYaw();
        }

        // Activates super speed mode (speed is a percentage between 0 and 1)
        if (gamepad1.right_bumper) {
            robot.updateSpeed((double) 1/100);
        } else {
            robot.updateSpeed((double) 75/100);
        }

        // Moves slide up when dpad up is pressed and down when dpad down is pressed
        if(gamepad2.left_stick_y > 0.1){
            robot.slide.SlideDown(1);
        } else if(gamepad2.left_stick_y < -0.1){
            robot.slide.SlideUp(1);
        } else {
            robot.slide.SlideStop();
        }
        // TODO: Configure lift angle motor onto Driver Hub config file, then uncomment the corresponding lines (line 45, 48, 51)
        if(gamepad2.x){
            robot.liftServo.Move(0);
//            robot.liftAngleMotor.LiftAngleFoward(1);
        } else if(gamepad2.y){
            robot.liftServo.Move(0.3);
//            robot.liftAngleMotor.LiftAngleBackward(1);
        } else if(gamepad2.b){
            robot.liftServo.Move(1);
//            robot.liftAngleMotor.LiftAngleStop();
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