package org.firstinspires.ftc.teamcode.Subsystems;

// entire arm assembly subsystem includes: intakeMotor, clawServo, and armMotor

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {
    CRServo intake;
    private final DcMotor armMain;
    Servo claw;
    private DcMotor elbow;

    public Arm(CRServo intake, DcMotor armMain, Servo claw, DcMotor elbow) {
        this.intake = intake;
        this.armMain = armMain;
        this.claw = claw;
        this.elbow = elbow;
        armMain.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    // CLAW
    public void clawUse(double position) {
        claw.setPosition(position);
    }
    public double getPosition(){
        return claw.getPosition();
    }

    // INTAKE
    public void intakeMove(double speed){
        intake.setPower(speed);
    }
    public void intakeStop(){
        intake.setPower(0);
    }

    // ARMMAIN
    public void armMainMove(double speed){
        armMain.setPower(speed);
    }
    public void armMainStop(){
        armMain.setPower(0);
    }

    // ELBOW
    public void elbowMove(double speed){
        elbow.setPower(speed);
    }
    public void elbowStop(){
        elbow.setPower(0);
    }
}
