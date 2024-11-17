package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.ftc.GoBildaPinpointDriverRR;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Subsystems.Compass;
import org.firstinspires.ftc.teamcode.Subsystems.Drive;
import org.firstinspires.ftc.teamcode.Subsystems.Intake;
import org.firstinspires.ftc.teamcode.Subsystems.Lift;
import org.firstinspires.ftc.teamcode.Subsystems.Odometry;

public class Robot {
    // Public Subsystems
    public Intake intake;
    public Lift lift;
    public Drive drive;
    public Compass compass;
    public Odometry odometry;

    public Robot(HardwareMap hardwareMap) {
        // Private Devices
        CRServo intakeServo = hardwareMap.get(CRServo.class, "intakeServo");
        Servo clawServo = hardwareMap.get(Servo.class, "clawServo");
        Servo wristServo = hardwareMap.get(Servo.class, "wristServo");
        // TODO: Test if this works or if it can be a DcMotor
        DcMotor elbowMotor = hardwareMap.get(DcMotor.class, "elbowMotor");
        DcMotor liftMotorLeft = hardwareMap.get(DcMotor.class, "liftMotorLeft");
        DcMotor liftMotorRight = hardwareMap.get(DcMotor.class, "liftMotorRight");
        DcMotor liftMotorTilt = hardwareMap.get(DcMotor.class, "liftMotorTilt");
        DcMotor shoulderMotor = hardwareMap.get(DcMotor.class, "shoulderMotor");
        DcMotor frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        DcMotor frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        DcMotor rearLeft = hardwareMap.get(DcMotor.class, "rearLeft");
        DcMotor rearRight = hardwareMap.get(DcMotor.class, "rearRight");
        IMU imu = hardwareMap.get(IMU.class, "imu");
        GoBildaPinpointDriverRR odometryComputer = hardwareMap.get(GoBildaPinpointDriverRR.class, "odometry");

        // Initialize Public Subsystems
        compass = new Compass(imu);
        intake = new Intake(intakeServo, clawServo, elbowMotor, wristServo);
        lift = new Lift(liftMotorLeft, liftMotorRight, liftMotorTilt, shoulderMotor);
        drive = new Drive(frontLeft, frontRight, rearLeft, rearRight, this);
        odometry = new Odometry(odometryComputer, compass);
    }
}
