package org.firstinspires.ftc.teamcode.Roadrunner.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.Robot;

public class LiftActions {
    public static class LiftUp implements Action {

        private boolean initialised = false;
        private final Robot robot;
        private final double tillPos;

        public LiftUp(Robot robot, double tillPos){
            this.robot = robot;
            this.tillPos = tillPos;
        }

        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {

            if (!initialised) {
                robot.lift.liftMove(-1);
                initialised = true;
            }

            double pos = robot.lift.getLiftPosition();

            telemetryPacket.put("liftPos", pos);
            if (pos > -tillPos) {
                return true;
            } else {
                robot.lift.liftMove(0);
                return false;
            }
        }
    }

    public static class LiftDown implements Action {

        private boolean initialised = false;
        private final Robot robot;
        private final double tillPos;

        public LiftDown(Robot robot, double tillPos){
            this.robot = robot;
            this.tillPos = tillPos;
        }

        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {

            if (!initialised) {
                robot.lift.liftMove(-1);
                initialised = true;
            }

            double pos = robot.lift.getLiftPosition();

            telemetryPacket.put("liftPos", pos);
            if (pos > -tillPos) {
                return true;
            } else {
                robot.lift.liftMove(0);
                return false;
            }
        }
    }
}