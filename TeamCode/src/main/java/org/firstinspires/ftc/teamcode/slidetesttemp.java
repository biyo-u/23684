package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Subsystems.Arm;
import org.firstinspires.ftc.teamcode.Subsystems.LiftAngleMotor;

// THIS PROGRAM WAS CREATED TO TEST RUN THE VIPER SLIDES ON BENJAMIN. DO NOT DELETE!!!!
@TeleOp (name = "Slide + Arm Test")
public class slidetesttemp extends OpMode {

    private DcMotor slide_left;
    private DcMotor slide_right;

    double reduction = 1;

    public LiftAngleMotor liftAngleMotor;

    public Arm arm;
    private Robot robot;

    @Override
    public void init() {
        slide_left = hardwareMap.get(DcMotor.class, "slide_left");
        slide_right = hardwareMap.get(DcMotor.class, "slide_right");
        slide_right.setDirection(DcMotor.Direction.REVERSE);

        robot = new Robot(hardwareMap, telemetry, false);
    }

    @Override
    public void loop() {

        // SLIDE CONTROLS
        if (gamepad1.dpad_up) {
            slide_right.setPower(1/reduction);
        } else if (gamepad1.dpad_down) {
            slide_left.setPower(-1);
            slide_right.setPower(-1/reduction);
        } else {
            slide_left.setPower(0);
            slide_right.setPower(0);
        }

        // ARMMAIN CONTROLS
        if (gamepad1.dpad_left) {
           robot.arm.armMainMove(1);
        } else if (gamepad1.dpad_right) {
            robot.arm.armMainMove(-1);
        } else {
            robot.arm.armMainStop();
        }

        // INTAKE CONTROLS
        if (gamepad1.a) {
            robot.arm.intakeMove(1);
        } else if (gamepad1.b) {
            robot.arm.intakeMove(-1);
        } else {
            robot.arm.intakeStop();
        }

        // CLAW CONTROLS
        if (gamepad1.x) {
            robot.arm.clawUse(1);
        } else {
            robot.arm.clawUse(0);
        }

        // LIFT ANGLE CONTROLS
        if (gamepad1.left_bumper) {
            robot.liftAngleMotor.LiftAngleForward(1);
        } else if (gamepad1.right_bumper) {
            robot.liftAngleMotor.LiftAngleBackward(1);
        } else {
            robot.liftAngleMotor.LiftAngleStop();
        }

        // PRINT TELEMETRY FOR TROUBLESHOOTING
        telemetry.addData("SLIDE LEFT MOVEMENT (TICKS)", slide_left.getCurrentPosition());
        telemetry.addData("SLIDE RIGHT MOVEMENT (TICKS)", slide_right.getCurrentPosition());
        telemetry.addData("LIFT ANGLE MOTOR LOCATION", liftAngleMotor.location);
        telemetry.addData("LIFT ANGLE MOTOR TICKS", liftAngleMotor.liftanglemotor.getCurrentPosition());
    }
}
