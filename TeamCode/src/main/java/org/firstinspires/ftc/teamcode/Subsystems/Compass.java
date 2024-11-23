package org.firstinspires.ftc.teamcode.Subsystems;

import com.acmerobotics.roadrunner.ftc.GoBildaPinpointDriverRR;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Compass {
    private final IMU imu;
    private final GoBildaPinpointDriverRR odocomp;

    public Compass(IMU imu) {
        this.imu = imu;
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP));
        imu.initialize(parameters);
        odocomp = null;
    }

    public double getHeading() {
        if (odocomp != null) {
            return odocomp.getHeading();
        } else {
            return imu.getRobotYawPitchRollAngles().getYaw();
        }
    }
    public void resetYaw() {

       if (imu != null) {
           imu.resetYaw();
       } else {
           odocomp.resetPosAndIMU();
       }
    }

    public Compass(GoBildaPinpointDriverRR goBildaPinpointDriverRR) {
        this.odocomp = goBildaPinpointDriverRR;
        imu = null;
    }
}
