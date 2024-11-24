package org.firstinspires.ftc.teamcode.Roadrunner.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.Robot;

public class WristActions {
    public static class LowerWrist implements Action {
        private final Robot robot;

        public LowerWrist(Robot robot){
            this.robot = robot;
        }

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            robot.intake.wristDown();
            return false;
        }
    }

    public static class RaiseWrist implements Action {
        private final Robot robot;

        public RaiseWrist(Robot robot){
            this.robot = robot;
        }

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            robot.intake.wristUp();
            return false;
        }
    }
}
