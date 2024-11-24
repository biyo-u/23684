package org.firstinspires.ftc.teamcode.Roadrunner.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.Robot;

public class IntakeActions {
    public static class IntakeIn implements Action {
        private final Robot robot;

        public IntakeIn(Robot robot){
            this.robot = robot;
        }

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            robot.intake.intakeIn();
            return false;
        }
    }

    public static class IntakeOut implements Action {
        private final Robot robot;

        public IntakeOut(Robot robot){
            this.robot = robot;
        }

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            robot.intake.intakeOut();
            return false;
        }
    }

    public static class IntakeStop implements Action {
        private final Robot robot;

        public IntakeStop(Robot robot){
            this.robot = robot;
        }

        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            robot.intake.intakeStop();
            return false;
        }
    }

}
