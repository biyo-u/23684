package org.firstinspires.ftc.teamcode.Roadrunner.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.Robot;

public class ElbowActions {
    public static class ElbowIn implements Action {
        private boolean initialised = false;
        private final Robot robot;

        public ElbowIn(Robot robot){
            this.robot = robot;
        }

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

    public static class ElbowOut implements Action {
        private boolean initialised = false;
        private final Robot robot;

        public ElbowOut(Robot robot){
            this.robot = robot;
        }

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
}
