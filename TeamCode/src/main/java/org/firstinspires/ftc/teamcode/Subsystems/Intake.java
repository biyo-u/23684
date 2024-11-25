package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.Servo;

import java.util.Locale;

public class Intake {
    private final Servo clawServo;
    private final Servo wristServo;

    /**
     * Constructor for the Intake subsystem.
     *
     * @param clawServo   The Servo object representing the claw servo.
     * @param wristServo The servo object representing the claw lift.
     */
    public Intake(Servo clawServo, Servo wristServo) {
        this.clawServo = clawServo;
        this.wristServo = wristServo;
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

    /**
     * Moves the wrist servo to the "up" position.
     * <p>
     * This method sets the position of the wrist servo to 1.
     */
    public void wristUp() {
        wristServo.setPosition(1);
    }

    /**
     * Moves the wrist servo to the "down" position.
     * <p>
     * This method sets the position of the wrist servo to 0.
     */
    public void wristDown() {
        wristServo.setPosition(0);
    }


    public String getTelemetry() {
        return String.format(Locale.getDefault(), """
                Claw Servo: %f
                Wrist Servo: %f""", clawServo.getPosition(), wristServo.getPosition());
    }
}
