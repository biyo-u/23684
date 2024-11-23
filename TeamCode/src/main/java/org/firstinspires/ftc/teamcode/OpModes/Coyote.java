package org.firstinspires.ftc.teamcode.OpModes;


import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Roadrunner.Actions.CloseClaw;
import org.firstinspires.ftc.teamcode.Roadrunner.Actions.ElbowIn;
import org.firstinspires.ftc.teamcode.Roadrunner.Actions.ElbowOut;
import org.firstinspires.ftc.teamcode.Roadrunner.Actions.IntakeIn;
import org.firstinspires.ftc.teamcode.Roadrunner.Actions.IntakeOut;
import org.firstinspires.ftc.teamcode.Roadrunner.Actions.IntakeStop;
import org.firstinspires.ftc.teamcode.Roadrunner.Actions.LiftDown;
import org.firstinspires.ftc.teamcode.Roadrunner.Actions.LiftUp;
import org.firstinspires.ftc.teamcode.Roadrunner.Actions.LowerWrist;
import org.firstinspires.ftc.teamcode.Roadrunner.Actions.OpenClaw;
import org.firstinspires.ftc.teamcode.Roadrunner.Actions.RaiseWrist;
import org.firstinspires.ftc.teamcode.Roadrunner.Actions.ShoulderDown;
import org.firstinspires.ftc.teamcode.Roadrunner.Actions.ShoulderUp;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.Roadrunner.PinpointDrive;
import org.firstinspires.ftc.teamcode.Utilities;


@Autonomous //(name = "BlueAuto", group = Constants.GroupNames.Autonomous, preselectTeleOp = "FieldCentricTeleOp")
public class Coyote extends LinearOpMode {

    private Robot robot;

    public Action LiftUp() {
        return new LiftUp(robot);
    }
    public Action LiftDown() {
        return new LiftDown(robot);
    }
    public Action CloseClaw() {
        return new CloseClaw(robot);
    }
    public Action OpenClaw() {
        return new OpenClaw(robot);
    }
    public Action RaiseWrist() {
        return new RaiseWrist(robot);
    }
    public Action LowerWrist() {
        return new LowerWrist(robot);
    }
    public Action IntakeIn() {
        return new IntakeIn(robot);
    }
    public Action IntakeOut() {
        return new IntakeOut(robot);
    }
    public Action IntakeStop() {
        return new IntakeStop(robot);
    }
    public Action ShoulderUp() {
        return new ShoulderUp(robot);
    }
    public Action ShoulderDown() {
        return new ShoulderDown(robot);
    }
    public Action ElbowOut() {
        return new ElbowOut(robot);
    }
    public Action ElbowIn() {
        return new ElbowIn(robot);
    }

    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d initialPose = new Pose2d(0, 0, Math.toRadians(0));
        PinpointDrive drive = new PinpointDrive(hardwareMap, initialPose);

        int visionOutputPosition = 1;

        TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
                        .splineTo(new Vector2d(22, 0), Utilities.degreesToRadians(0));
        TrajectoryActionBuilder tab2 = drive.actionBuilder(initialPose)
                        .splineTo(new Vector2d(22, -10), Utilities.degreesToRadians(0))
                        .splineTo(new Vector2d(48, -30), Utilities.degreesToRadians(0));
        TrajectoryActionBuilder tab3 = drive.actionBuilder(initialPose)
                        .splineTo(new Vector2d(38, 30), 0);
        TrajectoryActionBuilder tab4 = drive.actionBuilder(initialPose)
                        .splineToLinearHeading(new Pose2d(54, 56, 45),0);
        TrajectoryActionBuilder tab5 = drive.actionBuilder(initialPose)
                        .splineToLinearHeading(new Pose2d(38, 30, 0),0);

        Actions.runBlocking(
                new SequentialAction(
                        LiftUp(),
                        tab1.build(),// move forward to chamber
                        LiftDown(), //pull specimen onto red high chamber
                        tab2.build(), //back away and move to first y sample
                        IntakeIn(), // use intake (need to add that) to collect yellow sample
                        ShoulderUp(),
                        ElbowOut(),
                        LiftUp(), // raise to high basket
                        IntakeOut(),// put in red high basket
                        LiftDown(),// lower lift
                        tab3.build(),// return to second y sample
                        ElbowOut(),// collect 2nd y sample
                        IntakeIn(),
                        tab4.build(),
                        LiftUp(),// raise to high basket
                        IntakeOut(),// put in red high basket
                       LiftDown(),// lower lift
                        // return to third yellow sample
                        // collect 3rd y sample
                        // raise to high basket
                        // score in red high basket
                        // lower lift
                        // move and park in observation zone
                )
        );
    }
}
