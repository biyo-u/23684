package org.firstinspires.ftc.teamcode.Subsystems;

import com.acmerobotics.roadrunner.ftc.GoBildaPinpointDriverRR;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.IMU;

import java.util.Locale;

public class Compass {
    private final IMU imu;
    private final GoBildaPinpointDriverRR odocomp;

    private String model;

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
            model = "Pinpoint IMU";
            return odocomp.getHeading();
        } else {
            model = "REV Hub IMU";
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

    public String getTelemetry() {
        return String.format(Locale.getDefault(), """
                Robot Yaw: %f
                Robot Pitch: %f
                Robot Roll: %f
                Model Used: %s""", imu.getRobotYawPitchRollAngles().getYaw(), imu.getRobotYawPitchRollAngles().getPitch(), imu.getRobotYawPitchRollAngles().getRoll(), model);
    }
}
