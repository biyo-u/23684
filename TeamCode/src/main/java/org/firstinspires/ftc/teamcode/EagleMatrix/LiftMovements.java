package org.firstinspires.ftc.teamcode.EagleMatrix;

import org.firstinspires.ftc.teamcode.Robot;

public class LiftMovements {

    Robot robot;

    double upward = 1;
    double downward = -1;
    double rest = 0;

    public LiftMovements(Robot robot){
        this.robot = robot;
    }


    // LIFT MOVEMENTS
    public void LiftRise() {
        robot.lift.liftMove(upward);
    }
    public void LiftLower() {
        robot.lift.liftMove(downward);
    }
    public void LiftRest() {
        robot.lift.liftMove(rest);
    }

    // CLAW MOVEMENTS
    public void ClawOpen() {
        robot.intake.clawOpen();
    }
    public void ClawClose() {
        robot.intake.clawClose();
    }

    // WRIST MOVEMENTS
    public void WristIn() {
        robot.intake.wristUp();
    }
    public void WristOut() {
        robot.intake.wristDown();
    }

    // SHOULDER MOVEMENTS
    public void ShoulderUp() {
        robot.lift.shoulderMove(upward);
    }
    public void ShoulderDown() {
        robot.lift.shoulderMove(downward);
    }
}