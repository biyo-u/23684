package org.firstinspires.ftc.teamcode.OpModes.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/* A new drivebase code based on Game Manual 0's implementation of holonomic driving. this is to compare with DRIVER PRACTICE A to bugtest the code and fix strafing */

@TeleOp(name = "DRIVER PRACTICE A", group = "TECH TITANS 2025")
@Disabled
public class newdrivercode extends OpMode {

    private DcMotor right_front;
    private DcMotor right_back;
    private DcMotor left_front;
    private DcMotor left_back;
    private DcMotor intake_liftAsDcMotor;
    private DcMotor lift;
    private DcMotor intakeAsDcMotor;
    @Override
    public void init() {
        // initialise drivetrain motors
        right_front = hardwareMap.get(DcMotor.class, "right_front");
        right_back = hardwareMap.get(DcMotor.class, "right_back");
        left_front = hardwareMap.get(DcMotor.class, "left_front");
        left_back = hardwareMap.get(DcMotor.class, "left_back");

        //initalise intake + linear slide motors
        intakeAsDcMotor = hardwareMap.get(DcMotor.class, "intakeAsDcMotor");
        intake_liftAsDcMotor = hardwareMap.get(DcMotor.class, "intake_liftAsDcMotor");
        lift = hardwareMap.get(DcMotor.class, "lift");
    }

    @Override
    public void loop() {
        // reverse motors + reset encoders
        right_back.setDirection(DcMotor.Direction.REVERSE);
        intake_liftAsDcMotor.setDirection(DcMotor.Direction.REVERSE);
        intake_liftAsDcMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        intake_liftAsDcMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

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
        if (gamepad1.left_bumper || gamepad1.right_bumper) {
            power = 1;
        } else {
            power = 2.5;
        }

        // calculate the power value, dividing first by the denominator, then by speed
        double frontLeftPower = ((y - x + rx) / denominator) / power;
        double backLeftPower = ((y + x + rx) / denominator) / power;
        double frontRightPower = ((y - x - rx) / denominator) / power;
        double backRightPower = ((y + x - rx) / denominator) / power;

        // send power to the mecanum wheels using power values indicated
        left_front.setPower(frontLeftPower);
        left_back.setPower(backLeftPower);
        right_front.setPower(frontRightPower);
        right_back.setPower(backRightPower);

        // Intake Controls
        if (gamepad1.a) {
            intakeAsDcMotor.setPower(-0.3);
        } else if (gamepad1.b) {
            intakeAsDcMotor.setPower(0.3);
        } else {
            intakeAsDcMotor.setPower(0);
        }

        // Intake Lift Controls
        if (gamepad1.dpad_left) {
            intake_liftAsDcMotor.setPower(-0.7);
        } else if (gamepad1.dpad_right) {
            intake_liftAsDcMotor.setPower(0.7);
        } else {
            intake_liftAsDcMotor.setPower(0);
        }

        //Linear Slide Controls
        if (gamepad1.dpad_up) {
            lift.setPower(-1);
        } else if (gamepad1.dpad_down) {
            lift.setPower(1);
        } else {
            lift.setPower(0);
        }

    }
}
