package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Roadrunner.PinpointDrive;
import org.firstinspires.ftc.teamcode.Utilities;

@Autonomous
public class Acme extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d beginPose = new Pose2d(0, 0, 0);

        PinpointDrive drive = new PinpointDrive(hardwareMap, beginPose);

        waitForStart();

        Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .splineTo(new Vector2d(24, 24), Utilities.degreesToRadians(0))
                        .splineTo(new Vector2d(-24, -24), Utilities.degreesToRadians(0))
                        .build());
    }
}
