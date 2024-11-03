package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.Subsystems.*;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagGameDatabase;
import org.firstinspires.ftc.vision.apriltag.AprilTagProcessor;

public class Robot {
    // Webcam for AprilTags
    public WebcamName webcam;
    // IMU is for direction, it is part of the control hub
    public IMU imu;
    // Power is for speed (percentage between 0 and 1)
    public double power;
    // Telemetry will be overridden with CAI's Telemetry, which sends telemetry to both the driver hub and FTC Dashboard
    public Telemetry telemetry;

    public Slide slide;

    public Drive drive;

    public VisionPortal.Builder builder;

    public AprilTagProcessor aprilTag;

    public Odometry odometry;

    public FirstHang firstHang;

    public LiftServo liftServo;

    public LiftAngleMotor liftAngleMotor;

    // TODO: Only initialize required hardware depending on use case (IN PROGRESS)
    // TODO: Configure lift angle motor onto Driver Hub config file, then uncomment the corresponding lines (line 65, 99)
    public Robot(HardwareMap hardwareMap, Telemetry ftcTelemetry, boolean setupAprilTags) {
        // Uses CAI Telemetry to integrate with FTC Dashboard
//        telemetry = new CAITelemetry(ftcTelemetry);
        // TODO: Fix CAI Telemetry
        telemetry = ftcTelemetry;
        // Gets the GoBuilda odometry computer
        GoBildaPinpointDriver odo = hardwareMap.get(GoBildaPinpointDriver.class,"odo");
        // All 4 motors
        DcMotor front_left = hardwareMap.get(DcMotor.class, "front_left");
        DcMotor rear_left = hardwareMap.get(DcMotor.class, "rear_left");
        DcMotor front_right = hardwareMap.get(DcMotor.class, "front_right");
        DcMotor rear_right = hardwareMap.get(DcMotor.class, "rear_right");
        // Both slide motors, to move the slide up and down
        DcMotor slide_left = hardwareMap.get(DcMotor.class, "slide_left");
        DcMotor slide_right = hardwareMap.get(DcMotor.class, "slide_right");

        Servo hang_left = hardwareMap.get(Servo.class, "first_hang_left");
        Servo hang_right = hardwareMap.get(Servo.class, "first_hang_right");

        Servo lift_servo = hardwareMap.get(Servo.class, "lift_servo");
//        DcMotor liftAngleMotor = hardwareMap.get(DcMotor.class, "lift_angle_motor");

        if (setupAprilTags){
            webcam = hardwareMap.get(WebcamName.class, "Webcam 1");
            aprilTag = new AprilTagProcessor.Builder()
                    .setDrawAxes(Constants.developerMode)
                    .setDrawCubeProjection(Constants.developerMode)
                    .setDrawTagOutline(Constants.developerMode)
                    .setTagFamily(AprilTagProcessor.TagFamily.TAG_36h11)
                    .setTagLibrary(AprilTagGameDatabase.getIntoTheDeepTagLibrary())
                    .setOutputUnits(DistanceUnit.INCH, AngleUnit.DEGREES)
                    .setLensIntrinsics(Constants.Camera.fx, Constants.Camera.fy, Constants.Camera.cx, Constants.Camera.cy)
                    .setCameraPose(Constants.Camera.cameraPosition, Constants.Camera.cameraOrientation)
                    .build();

            // TODO: Learn about April Tag decimation
            // Adjust Image Decimation to trade-off detection-range for detection-rate.
            // eg: Some typical detection data using a Logitech C920 WebCam
            // Decimation = 1 :  Detect 2" Tag from 10 feet away at 10 Frames per second
            // Decimation = 2 :  Detect 2" Tag from 6  feet away at 22 Frames per second
            // Decimation = 3 :  Detect 2" Tag from 4  feet away at 30 Frames Per Second (default)
            // Decimation = 3 :  Detect 5" Tag from 10 feet away at 30 Frames Per Second (default)
            // Note: Decimation can be changed on-the-fly to adapt during a match.
            aprilTag.setDecimation(3);
        }

        this.slide = new Slide(slide_left, slide_right);

        this.drive = new Drive(front_left, front_right, rear_left, rear_right);

        this.firstHang = new FirstHang(hang_left, hang_right);

        this.liftServo = new LiftServo(lift_servo);

//        this.liftAngleMotor = new LiftAngleMotor(liftAngleMotor);

        // Sets slide zero power mode to break so slide doesn't fall by itself
        slide_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        slide_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // Stops and resets the encoder for the lift angle slide
//        liftanglemotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        // Retrieve the IMU from the hardware map
        imu = hardwareMap.get(IMU.class, "imu");
        // Adjust the orientation parameters to match your robot
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.RIGHT,
                RevHubOrientationOnRobot.UsbFacingDirection.UP));
        // Without this, the REV Hub's orientation is assumed to be logo up / USB forward
        imu.initialize(parameters);

        odometry = new Odometry(odo, imu);

//        telemetry.clearAll();
    }

    // TODO: Call updateOdometry from AprilTag Code


    public void updateSpeed(double newPower) {
        power = newPower;
    }
}
