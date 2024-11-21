package org.firstinspires.ftc.teamcode.Roadrunner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.acmerobotics.roadrunner.Pose2d;

import com.acmerobotics.roadrunner.Time;
import com.acmerobotics.roadrunner.Twist2dDual;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.GeomUtil;

public class GoBildaLocalizer implements Localizer {
    private final PinpointDrive pinpointDrive;

    public GoBildaLocalizer(final HardwareMap hardwareMap, final Pose2d mountOffsets) {
        this.pinpointDrive = new PinpointDrive(hardwareMap, mountOffsets);
    }

    @NonNull
    public Pose2d getPoseEstimate() {
        pinpointDrive.updatePoseEstimate();
        return pinpointDrive.pinpoint.getPositionRR();
    }

    public double getHeading() {
        pinpointDrive.updatePoseEstimate();
        return pinpointDrive.pinpoint.getHeading();
    }

    public void setPoseEstimate(@NonNull Pose2d pose2d) {
        pinpointDrive.pinpoint.setPosition(pose2d);
    }

    @Nullable
    public Pose2d getPoseVelocity() {
        pinpointDrive.updatePoseEstimate();
        return GeomUtil.toPose2d(pinpointDrive.pinpoint.getVelocity());
    }

    public double getHeadingVelocity() {
        pinpointDrive.updatePoseEstimate();
        return pinpointDrive.pinpoint.getHeadingVelocity();
    }

    /**
     * IMPORTANT: Requires *stationary* robot.
     */
    public void recalibrateIMU(){
        pinpointDrive.pinpoint.recalibrateIMU();
    }

    @Override
    public Twist2dDual<Time> update() {
        return null;
    }

}
