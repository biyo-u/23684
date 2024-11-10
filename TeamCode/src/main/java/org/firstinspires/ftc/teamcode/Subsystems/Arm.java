package org.firstinspires.ftc.teamcode.Subsystems;

// entire arm assembly subsystem includes: intakeMotor, clawServo, and armMotor

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Arm {
    private DcMotor intake;
    private DcMotor armMain;
    Servo claw;

    public Arm(DcMotor intake, DcMotor armMain, Servo claw) {
        this.intake = intake;
        this.armMain = armMain;
        this.claw = claw;
        armMain.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    // CLAW
    public void clawMove(double position) {
        claw.setPosition(position);
    }
    public double getPosition(){
        return claw.getPosition();
    }

    // INTAKE
    public void intakeMove(double speed){
        intake.setPower(speed);
    }

    // ARMMAIN
    public void armMainMove(double speed){
        armMain.setPower(speed);
    }
}
