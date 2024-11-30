package org.firstinspires.ftc.teamcode.EagleMatrix;

import org.firstinspires.ftc.teamcode.OpModes.Auto.Griffindrive;
import org.firstinspires.ftc.teamcode.Robot;

public class Wingman {
    Robot robot;
    DrivetrainMovements drivetrainMovements;

    double forward = 1;
    double backward = -1;
    double rest = 0;

    public Wingman(Robot robot, DrivetrainMovements drivetrainMovements){
        this.robot = robot;
        this.drivetrainMovements = drivetrainMovements;
    }

    public Wingman(Griffindrive griffindrive) {
    }

    public void Action() throws InterruptedException {
        drivetrainMovements.YForward();
        Thread.sleep(1000);
        drivetrainMovements.stop();
        Thread.sleep(1000);

    }
}
