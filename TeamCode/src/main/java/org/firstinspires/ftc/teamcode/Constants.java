package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;

public class Constants {
    public static final boolean developerMode = true;

    // TODO: Find these values
    public static final int liftLeftForwardLimit = 8333;
    public static final int liftRightForwardLimit = 8013;
    public static final int liftForwardLimit = 8013;
    public static final int liftBackwardLimit = -999999;
    // TODO: Test elbow with DcMotor to see if encoder works, otherwise remove these variables
    public static final int shoulderForwardLimit = -999999;
    public static final int shoulderBackwardLimit = 9999999;
    public static final double odometryWeight = 0.2;
    // TODO: Map values from threshold to 1/-1 for precise movement even with a dead zone
    public static final double liftThreshold = 0.2;
    public static final double shoulderThreshold = 0.2;
    public static final Pose2d RedObservationZone = new Pose2d(16, 60, Math.toRadians(90));

    public static class GroupNames {
        public static final String TeleOp = "1.TeleOp";
        public static final String Autonomous = "1.Auto";
        public static final String RoadrunnerTuning = "9.RoadrunnerTuning";
        public static final String Testing = "8.Testing";
    }
}
