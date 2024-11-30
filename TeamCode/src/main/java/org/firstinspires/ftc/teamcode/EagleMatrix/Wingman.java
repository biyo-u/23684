package org.firstinspires.ftc.teamcode.EagleMatrix;

import org.firstinspires.ftc.teamcode.Robot;

import java.util.Timer;
import java.util.TimerTask;

public class Wingman {
    Robot robot;
    DrivetrainMovements drivetrainMovements;
    LiftMovements liftMovements;

    double forward = 1;
    double backward = -1;
    double rest = 0;

    public Wingman(Robot robot, DrivetrainMovements drivetrainMovements, LiftMovements liftmovements){
        this.robot = robot;
        this.drivetrainMovements = drivetrainMovements;
        this.liftMovements = liftmovements;
    }

    public void ActionA() {
        Timer timerone = new Timer("Timer");

        //create separate timertask for each command, build commands in reverse (first one is at the bottom, last one is at the top)
        TimerTask waitfive = new TimerTask() {
            @Override
            public void run() {
                liftMovements.ClawOpen();
            }
        };

        // Lift Lowers for 2 seconds
        TimerTask waitfour = new TimerTask() {
            @Override
            public void run() {
                liftMovements.LiftLower();
                timerone.schedule(waitfive, 2000);
            }
        };

        // Lift rests, wrist out for 2 seconds
        TimerTask waitthree = new TimerTask() {
            @Override
            public void run() {
                liftMovements.LiftRest();
                liftMovements.WristOut();
                timerone.schedule(waitfour, 2000);
            }
        };

        // Lift up for 4 seconds
        TimerTask waittwo = new TimerTask() {
            @Override
            public void run() {
                liftMovements.LiftRise();
                timerone.schedule(waitthree, 4000);
            }
        };

        // Stops
        TimerTask waitone = new TimerTask() {
            @Override
            public void run() {
                drivetrainMovements.stop();
                timerone.schedule(waittwo, 1000);
            }
        };

        // Moves forward for 1 second
        drivetrainMovements.YForward();
        timerone.schedule(waitone,1000);

        //end of ActionA
    }
}
