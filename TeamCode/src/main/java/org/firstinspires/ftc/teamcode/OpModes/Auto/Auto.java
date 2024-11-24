package org.firstinspires.ftc.teamcode.OpModes.Auto;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Roadrunner.Actions.LiftActions;
import org.firstinspires.ftc.teamcode.Roadrunner.PinpointDrive;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "Auto", group = Constants.GroupNames.Autonomous, preselectTeleOp = "TeleOp")
public class Auto extends LinearOpMode {
    @Override
    public void runOpMode() {
        // TODO: IMPORTANT Add April Tags
        // TODO: Clean up actions by grouping them in classes
        // TODO: Add robot location
        // Pose2d overridePose = new Pose2d(0, 0, 0);
        Pose2d overridePose = Constants.RedObservationZone;

        // Initialize April Tag Processor

        waitForStart();

        // Loop for 3 seconds, averaging April Tag values
        // Check where April Tag Location is closest to (check positive and negative x and y to figure out quadrant)

        // PinpointDrive drive = new PinpointDrive(hardwareMap, aprilTagPose);
        PinpointDrive drive = new PinpointDrive(hardwareMap, overridePose);

        Actions.runBlocking(
            drive.actionBuilder(overridePose)
                    .lineToX(44)
                    .build()
        );
    }
}
