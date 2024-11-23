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

import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.Roadrunner.PinpointDrive;


@Autonomous //(name = "BlueAuto", group = Constants.GroupNames.Autonomous, preselectTeleOp = "FieldCentricTeleOp")
public class Coyote extends LinearOpMode {

    private Robot robot;

    public class LiftUp implements Action {

        private boolean initialised = false;

        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {

            if (!initialised) {
                robot.lift.liftMove(1);
                initialised = true;
            }

            double pos = robot.lift.getLiftPosition();

            telemetryPacket.put("liftPos", pos);
            if (pos < -2000) {
                return true;
            } else {
                robot.lift.liftMove(0);
                return false;
            }
        }
    }
    public Action LiftUp() {
        return new LiftUp();
    }

    public class LiftDown implements Action {

        private boolean initialised = false;

        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {

            if (!initialised) {
                robot.lift.liftMove(-1);
                initialised = true;
            }

            double pos = robot.lift.getLiftPosition();

            telemetryPacket.put("liftPos", pos);
            if (pos > 200) {
                return true;
            } else {
                robot.lift.liftMove(0);
                return false;
            }
        }
    }
    public Action LiftDown() {
        return new LiftDown();
    }

    public class CloseClaw implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            robot.intake.clawClose();
            return false;
        }
    }
    public Action closeClaw() {
        return new CloseClaw();
    }

    public class OpenClaw implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            robot.intake.clawOpen();
            return false;
        }
    }
    public Action openClaw() {
        return new OpenClaw();
    }

    public class raiseWrist implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            robot.intake.wristUp();
            return false;
        }
    }
    public Action raiseWrist() {
        return new raiseWrist();
    }

    public class lowerWrist implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            robot.intake.wristDown();
            return false;
        }
    }
    public Action lowerWrist() {
        return new lowerWrist();
    }

    public class intakeIn implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            robot.intake.intakeIn();
            return false;
        }
    }
    public Action intakeIn() {
        return new intakeIn();
    }

    public class intakeOut implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            robot.intake.intakeOut();
            return false;
        }
    }
    public Action intakeOut() {
        return new intakeOut();
    }

    public class intakeStop implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            robot.intake.intakeStop();
            return false;
        }
    }
    public Action intakeStop() {
        return new intakeStop();
    }

    public class shoulderUp implements Action {
        private boolean initialised = false;
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (!initialised) {
                robot.lift.shoulderMove(1);
                initialised = true;
            }

            double pos = robot.lift.getShoulderPosition();

            packet.put("shoulderPos", pos);
            if (pos > 200) {
                return true;
            } else {
                robot.lift.shoulderMove(0);
                return false;
            }
        }
    }
    public Action shoulderUp() {
        return new shoulderUp();
    }

    public class shoulderDown implements Action {
        private boolean initialised = false;
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (!initialised) {
                robot.lift.shoulderMove(-1);
                initialised = true;
            }

            double pos = robot.lift.getShoulderPosition();

            packet.put("shoulderPos", pos);
            if (pos < 200) {
                return true;
            } else {
                robot.lift.shoulderMove(0);
                return false;
            }
        }
    }
    public Action shoulderDown() {
        return new shoulderDown();
    }

    public class elbowOut implements Action {
        private boolean initialised = false;
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (!initialised) {
                robot.intake.elbowMove(1);
                initialised = true;
            }

            double pos = robot.intake.getElbowPosition();

            packet.put("shoulderPos", pos);
            if (pos > 200) {
                return true;
            } else {
                robot.lift.shoulderMove(0);
                return false;
            }
        }
    }
    public Action elbowOut() {
        return new elbowOut();
    }

    public class elbowIn implements Action {
        private boolean initialised = false;
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            if (!initialised) {
                robot.lift.shoulderMove(-1);
                initialised = true;
            }

            double pos = robot.intake.getElbowPosition();

            packet.put("shoulderPos", pos);
            if (pos < 200) {
                return true;
            } else {
                robot.lift.shoulderMove(0);
                return false;
            }
        }
    }
    public Action elbowIn() {
        return new elbowIn();
    }

    @Override
    public void runOpMode () throws InterruptedException {
        Pose2d initialPose = new Pose2d(0, 0, Math.toRadians(0));
        PinpointDrive drive = new PinpointDrive(hardwareMap, initialPose);

        int visionOutputPosition = 1;

        TrajectoryActionBuilder tab1 = drive.actionBuilder(initialPose)
                        .lineToX(24);
        TrajectoryActionBuilder tab2 = drive.actionBuilder(initialPose)
                        .lineToY(-10)
                        .splineTo(new Vector2d(0, -30), Math.PI/2)
                        .lineToY(31);
        TrajectoryActionBuilder tab3 = drive.actionBuilder(initialPose)
                        .splineToLinearHeading(new Pose2d(54, 56, 45), Math.PI / 2);

        Actions.runBlocking(
                new SequentialAction(
                        LiftUp(),
                        tab1.build(),// move forward to chamber
                        LiftDown(), //pull specimen onto red high chamber
                        tab2.build(), //back away and move to first y sample
                        intakeIn(), // use intake (need to add that) to collect yellow sample
                        shoulderUp(),
                        elbowOut(),
                        LiftUp(), // raise to high basket
                        intakeOut(),// put in red high basket
                        LiftDown(),// lower lift
                        tab3.build(),// return to second y sample
                        elbowOut(),// collect 2nd y sample
                        intakeIn()
                        // raise to high basket
                        // put in red high basket
                        // lower lift
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
