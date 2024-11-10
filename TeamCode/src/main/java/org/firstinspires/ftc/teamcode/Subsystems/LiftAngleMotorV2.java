package org.firstinspires.ftc.teamcode.Subsystems;


import com.qualcomm.robotcore.hardware.DcMotor;

public class LiftAngleMotorV2 {
    public DcMotor liftAngleMotor;
    public double location;

    public LiftAngleMotorV2(DcMotor liftAngleMotor) {
        this.liftAngleMotor = liftAngleMotor;
        this.location = liftAngleMotor.getCurrentPosition();
    }

    public void loop() {
        this.location = liftAngleMotor.getCurrentPosition();
        if (!liftAngleMotor.isBusy()) {
            liftAngleMotor.setPower(0);
        }
    }

    public void Move(double speed) {
        liftAngleMotor.setPower(1);
        liftAngleMotor.setTargetPosition((int) (location + speed));
        liftAngleMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
}
