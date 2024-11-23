package org.firstinspires.ftc.teamcode.Roadrunner.Actions;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

import org.firstinspires.ftc.teamcode.Robot;

public class LiftUp implements Action {

    private boolean initialised = false;
    private final Robot robot;

    public LiftUp(Robot robot){
        this.robot = robot;
    }

    @Override
    public boolean run(@NonNull TelemetryPacket telemetryPacket) {

        if (!initialised) {
            robot.lift.liftMove(-1);
            initialised = true;
        }

        double pos = robot.lift.getLiftPosition();

        telemetryPacket.put("liftPos", pos);
        if (pos > -4000) {
            return true;
        } else {
            robot.lift.liftMove(0);
            return false;
        }
    }
}
