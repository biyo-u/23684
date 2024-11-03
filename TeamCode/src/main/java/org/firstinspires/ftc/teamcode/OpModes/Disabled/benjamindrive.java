package org.firstinspires.ftc.teamcode.OpModes.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

// so benny here can actually move (competition robot drivetrain testing)
// based on DRIVER PRACTICE A

@TeleOp(name = "Benjamin Drivetrain V0.5.0", group = "TECH TITANS 2025")
@Disabled
public class benjamindrive extends OpMode {

    private DcMotor front_right;
    private DcMotor rear_right;
    private DcMotor front_left;
    private DcMotor rear_left;

    double ticks = (336.00) * 2;
    /* encoder resolution (ticks) = exact gearbox ratio (#:1) * bare motor ticks (ticks)
    ticks for our drivetrain is 336.00 (12:1 gearbox * 28 ticks for bare motor)
    ticks for our intake roller is 146.44 (5:1 gearbox * 28 ticks for bare motor)
    double the ticks to double the rotations, or double the rotations to do the same */
    double wheel_diameter = 3.7795; //in inches

    @Override
    public void init() {
        // initialise drivetrain motors
        front_right = hardwareMap.get(DcMotor.class, "front_right");
        rear_right = hardwareMap.get(DcMotor.class, "rear_right");
        front_left = hardwareMap.get(DcMotor.class, "front_left");
        rear_left = hardwareMap.get(DcMotor.class, "rear_left");
    }

    @Override
    public void loop() {
        // reverse motors + reset encoders
        rear_right.setDirection(DcMotor.Direction.REVERSE);

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
        double frontLeftPower = ((y - x - rx) / denominator) / power;
        double backLeftPower = ((y + x - rx) / denominator) / power;
        double frontRightPower = ((y + x + rx) / denominator) / power;
        double backRightPower = ((y - x + rx) / denominator) / power;

        // send power to the mecanum wheels using power values indicated
        front_left.setPower(frontLeftPower);
        rear_left.setPower(backLeftPower);
        front_right.setPower(frontRightPower);
        rear_right.setPower(backRightPower);

        // print out the current position of the encoders on driverhub (measured ticks)
        telemetry.addData("pod X ticks: ", front_right.getCurrentPosition());
        telemetry.addData("pod Y ticks: ", front_left.getCurrentPosition());

        // print out the normalised angle of the motors on driver hub (in degrees)
        telemetry.addData("Wheel Angle (Normalised) FL: ", (front_left.getCurrentPosition() + 360) % 360); //tells you the angle of the motor, but remains between 0 and 360.
        telemetry.addData("Wheel Angle (Normalised) FR: ", (front_right.getCurrentPosition() + 360) % 360); //tells you the angle of the motor, but remains between 0 and 360.

        // print out the revolution count of the encoders on the driver hub``````````````````````````````
        telemetry.addData("Encoder Y revolutions: ", front_left.getCurrentPosition() / ticks);
        telemetry.addData("Encoder X revolutions: ", front_right.getCurrentPosition() / ticks);

        // print out the ticks to inches count of the motor's movement amount
        telemetry.addData("Encoder Y ticks to inches: ", front_left.getCurrentPosition() * (Math.PI /(wheel_diameter /4)));
        telemetry.addData("Encoder X ticks to inches: ", front_right.getCurrentPosition() * (Math.PI /(wheel_diameter /4)));
    }
}

