package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Constants;

import java.util.Locale;

public class Intake {
    private final CRServo intakeServo;
    private final Servo clawServo;
    // TODO: Test if this works or if it can be a DcMotorSimple
    private final DcMotor elbowMotor;
    private final Servo wristServo;

    /**
     * Constructor for the Intake subsystem.
     *
     * @param intakeServo The CRServo object representing the intake roller motor.
     * @param clawServo   The Servo object representing the claw servo.
     * @param elbowMotor  The DcMotor object representing the elbow motor.
     * @param wristServo The servo object representing the claw lift.
     */
    public Intake(CRServo intakeServo, Servo clawServo, DcMotor elbowMotor, Servo wristServo) {
        this.intakeServo = intakeServo;
        this.clawServo = clawServo;
        this.elbowMotor = elbowMotor;
        this.wristServo = wristServo;
    }

    /**
     * Activates the intake to pull the sample in.
     * This method sets the power of the intake servo to a negative value defined
     * in `Constants.intakeSpeed`, causing it to rotate in the direction that pulls
     * the sample into the robot.
     */
    public void intakeIn() {
        intakeServo.setPower(-Constants.intakeSpeed);
    }

    /**
     * Activates the intake to push game elements in.
     * This method sets the power of the intake servo to a positive value defined
     * in `Constants.intakeSpeed`. causing it to rotate in the direction that pushes
     * the sample out of the robot.
     */
    public void intakeOut() {
        intakeServo.setPower(Constants.intakeSpeed);
    }

    /**
     * Stops the intake motor by setting its power to 0
     */
    public void intakeStop() {
        intakeServo.setPower(0);
    }

    /**
     * Opens the claw of the robot.
     * <p>
     * This method sets the position of the claw servo to 0, which corresponds to the open position.
     */
    public void clawOpen() {
        clawServo.setPosition(0);
    }

    /**
     * Closes the claw of the robot.
     * <p>
     * This method sets the position of the claw servo to 1, which corresponds to the closed position.
     */
    public void clawClose() {
        clawServo.setPosition(1);
    }

    // TODO: Document
    public void wristUp() {
        wristServo.setPosition(1);}

    // TODO: Document
    public void wristDown() {
        wristServo.setPosition(0);
    }

    // TODO: Document with Gemini Code Assist
    public void elbowMove(double speed) {
        elbowMotor.setPower(-speed * Constants.elbowSpeedMultiplier);
    }

    public String getTelemetry() {
        return String.format(Locale.getDefault(), """
                Elbow Motor: %d
                Claw Servo: %f
                Intake Servo: %f
                Wrist Servo: %f""", elbowMotor.getCurrentPosition(), clawServo.getPosition(), intakeServo.getPower(), wristServo.getPosition());
    }
}
