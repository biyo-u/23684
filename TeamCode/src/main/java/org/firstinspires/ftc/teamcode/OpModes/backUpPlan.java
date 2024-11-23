package org.firstinspires.ftc.teamcode.OpModes;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
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
import org.firstinspires.ftc.teamcode.Roadrunner.PinpointDrive;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.Utilities;

public class backUpPlan extends LinearOpMode {
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
        waitForStart();

        Pose2d initialPose = new Pose2d(0, 0, Math.toRadians(0));
        PinpointDrive drive = new PinpointDrive(hardwareMap, initialPose);

        this.robot = new Robot(hardwareMap);

        int visionOutputPosition = 1;

        TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
                        .splineTo(new Vector2d(48,0), 0);

        Actions.runBlocking(
                new SequentialAction(
                        tab1.build()
                )
        );
    }
}
