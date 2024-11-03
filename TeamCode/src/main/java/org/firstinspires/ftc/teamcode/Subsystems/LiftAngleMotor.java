package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.teamcode.Constants;

// TODO: Troubleshoot LiftAngleMotor.java functioning, after uncommenting out (lines 65, 99 in Robot.java) and lines 45, 48, 51 in FieldCentricTeleOp.java)!!!
public class LiftAngleMotor {
    private DcMotor liftanglemotor;
    public double location = liftanglemotor.getTargetPosition();
    public int targetLocation;
    public int forwardLocation = 900;
    public  int backwardLocation = -500;
    public LiftAngleMotor(DcMotor liftanglemotor) {
        this.liftanglemotor = liftanglemotor;
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
