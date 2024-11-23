package org.firstinspires.ftc.teamcode.OpModes;


import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.teamcode.Subsystems.Lift;


@Disabled //(name = "BlueAuto", group = Constants.GroupNames.Autonomous, preselectTeleOp = "FieldCentricTeleOp")
public class coyoteone extends LinearOpMode {

    private Robot robot;

    class LiftUp implements Action {

        private boolean initialised = false;

        @Override
        public boolean run(@NonNull TelemetryPacket telemetryPacket) {

            if (!initialised) {
                robot.lift.liftMove(1);
                initialised = true;
            }

            double pos = robot.lift.getLiftPosition();

            telemetryPacket.put("liftPos", pos);
            if (pos < 333){
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

    @Override
    public void runOpMode() throws InterruptedException {

    }
}
