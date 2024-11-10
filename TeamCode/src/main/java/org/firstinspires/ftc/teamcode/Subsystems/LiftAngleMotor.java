package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;

// TODO: Fine-tune line 13 and line 14 values for forwardLocation and backwardLocation
public class LiftAngleMotor {
    public DcMotor liftanglemotor;
    public double location;
    public int targetLocation;
    public int forwardLocation = 900; // in ticks
    public  int backwardLocation = -500; // in ticks
    public LiftAngleMotor(DcMotor liftanglemotor) {
        this.liftanglemotor = liftanglemotor;
        this.location = liftanglemotor.getTargetPosition();
    }

    public void LiftAngleMove(double speed, int targetLocation) {
        liftanglemotor.setTargetPosition(targetLocation);
        liftanglemotor.setPower(speed);
        liftanglemotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    public void LiftAngleFoward(double speed) {
        targetLocation = forwardLocation;
        LiftAngleMove(speed, targetLocation);
    }

    public void LiftAngleBackward(double speed) {
        targetLocation = backwardLocation;
        LiftAngleMove(-speed, targetLocation);
    }

    public void LiftAngleStop() {
        liftanglemotor.setTargetPosition((int) location);
        liftanglemotor.setPower(0);
    }
}
