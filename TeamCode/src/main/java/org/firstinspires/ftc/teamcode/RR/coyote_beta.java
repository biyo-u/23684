package org.firstinspires.ftc.teamcode.RR;

// RR-specific imports
import androidx.annotation.NonNull;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;

// Non-RR imports
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import org.firstinspires.ftc.teamcode.Robot;

//TODO: Update code to use the newest version of the config!!

@Config
@Autonomous(name = "Coyote V0.0.1 ALPHA", group = "ROADRUNNER")
public class coyote_beta extends LinearOpMode {

    // gets Robot.java + bot hardware map
    Robot robot;

    public class MoveForward implements Action {

        // checks if the robot has been initalised
        private boolean initialized = false;

        // actions are formatted via telemetry packets
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            // powers on motor IF it is not on
            if (!initialized) {
                robot.drive.setMotorSpeeds(0.8, 0.8, 0.8, 0.8);
                initialized = true;
            }

            // check current positions, not useful on drive, will be useful on other motors
            double posfl = robot.drive.front_left.getCurrentPosition();
            double posfr = robot.drive.front_right.getCurrentPosition();
            double posrl = robot.drive.rear_left.getCurrentPosition();
            double posrr = robot.drive.rear_right.getCurrentPosition();
            packet.put("front_left", posfl);
            if (posfl < 3000.0) {
                // true causes the action to run
                return true;
            } else {
                // false stops action rerun
                robot.drive.setMotorSpeeds(0, 0, 0, 0);
                return false;
            }
            // overall, the action powers the drivetrain until it surpasses
            // 3000 encoder ticks, then powers it off
        }
    }

    public Action moveForward() {
        return new MoveForward();
    }

    @Override
    public void runOpMode() throws InterruptedException {
        Pose2d initalPose = new Pose2d(0, 0, Math.toRadians(0));
        robot = new Robot(hardwareMap, telemetry, false);
        Robot robot1 = this.robot;
        robot1 = new Robot(hardwareMap, telemetry, telemetry, false, initalPose); // TODO: Fix this.

        MoveForward moveForward = new MoveForward();
    }
    int visionOutPutPosition = 1;

    // TODO: Figure out why TrajectoryActionBuilder is not working
    // TODO: Fix robot class issues (its like wack-a-mole out here)
}
