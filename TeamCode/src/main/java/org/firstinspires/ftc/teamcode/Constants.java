package org.firstinspires.ftc.teamcode;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Vector2d;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;

import java.util.HashMap;
import java.util.Map;

@Config
public class Constants {
    // TODO: Disable developerMode for comps
    public static boolean developerMode = true;
    public static double aprilTagTrust = 0.25;
    public static double slideLeftExtra = 0;
    public static double slideRightExtra = 0;
    public static double slideBrakeSpeed = 0.1;
    public static boolean cameraStreaming = false;
    public static double drivetrainEncoderResolution = 332.8; //measured in ticks
    public static Map<Integer, Vector2d> aprilTagLocations = new HashMap<Integer, Vector2d>();

    public static void addAprilTags(){
        aprilTagLocations.put(11, new Vector2d(12, 12));
        aprilTagLocations.put(12, new Vector2d(12, 60));
        aprilTagLocations.put(13, new Vector2d(108, 12));
        aprilTagLocations.put(14, new Vector2d(108, 60));
        aprilTagLocations.put(15, new Vector2d(108, 108));
        aprilTagLocations.put(16, new Vector2d(12, 108));
    }

    // TODO: Measure camera position relative to center of robot
    // TODO: Add code to cover for rotations
    public static class Camera {
        public static int width = 1920;
        public static int height = 1200;
        public static double fx = 1317.999212;
        public static double fy = 1313.49178;
        public static double cx = 967.5128547;
        public static double cy = 664.7096383;

        public static Position cameraPosition = new Position(DistanceUnit.INCH,
                7.31250, 7.03125, 7.50000, 0);
        public static YawPitchRollAngles cameraOrientation = new YawPitchRollAngles(AngleUnit.DEGREES,
                0, -90, 0, 0);
    }

}