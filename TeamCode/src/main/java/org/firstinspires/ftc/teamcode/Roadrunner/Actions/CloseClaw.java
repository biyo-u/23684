package org.firstinspires.ftc.teamcode.Roadrunner.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.Robot;

public class CloseClaw implements Action {
    private final Robot robot;

    public CloseClaw(Robot robot){
        this.robot = robot;
    }

    @Override
    public boolean run(@NonNull TelemetryPacket packet) {
        robot.intake.clawClose();
        return false;
    }
}
