package org.firstinspires.ftc.teamcode.Subsystems;


import com.qualcomm.robotcore.hardware.DcMotor;

public class LiftAngleMotorV2 {
    public DcMotor liftAngleMotor;
    public double location;
    public int forwardLimit = 900;
    public int backwardLimit = -500;

    public LiftAngleMotorV2(DcMotor liftAngleMotor) {
        this.liftAngleMotor = liftAngleMotor;
        this.liftAngleMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        this.location = liftAngleMotor.getCurrentPosition();
    }

    public void loop() {
        this.location = liftAngleMotor.getCurrentPosition();
        if (!liftAngleMotor.isBusy()) {
            liftAngleMotor.setPower(0);
        }
    }

    public void Move(double speed) {
        if (!((location + speed) > forwardLimit) && !((location + speed) < backwardLimit)) {
            liftAngleMotor.setTargetPosition((int) (location + speed));
            liftAngleMotor.setPower(1);
        } else {
            liftAngleMotor.setPower(0);
        }
    }
}
