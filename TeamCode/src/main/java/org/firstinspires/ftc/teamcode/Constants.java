package org.firstinspires.ftc.teamcode;

public class Constants {
    // TODO: Find these values
    public static final int liftForwardLimit = 999999;
    public static final int liftBackwardLimit = -999999;
    // TODO: Test elbow with DcMotor to see if encoder works, otherwise remove these variables
    public static final int elbowForwardLimit = -999999;
    public static final int elbowBackwardLimit = 9999999;
    public static final int shoulderForwardLimit = -999999;
    public static final int shoulderBackwardLimit = 9999999;
    public static final double intakeSpeed = 1;
    public static final double elbowSpeedMultiplier = 0.3;
    public static final double odometryWeight = 0.2;
    // TODO: Map values from threshold to 1/-1 for precise movement even with a dead zone
    public static final double intakeThreshold = 0.2;
    public static final double liftThreshold = 0.2;
    public static final double shoulderThreshold = 0.2;
    public static final double elbowThreshold = 0.2;

    public static class GroupNames {
        public static final String TeleOp = "1.TeleOp";
        public static final String Autonomous = "1.Auto";
        public static final String RoadrunnerTuning = "9.RoadrunnerTuning";
        public static final String Testing = "8.Testing";
    }
}
