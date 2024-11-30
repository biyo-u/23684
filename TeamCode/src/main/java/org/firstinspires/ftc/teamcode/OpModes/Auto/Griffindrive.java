package org.firstinspires.ftc.teamcode.OpModes.Auto;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.EagleMatrix.DrivetrainMovements;
import org.firstinspires.ftc.teamcode.EagleMatrix.Wingman;
import org.firstinspires.ftc.teamcode.Robot;

public class Griffindrive extends OpMode {
    public Wingman wingman;

    @Override
    public void init() {
        wingman = new Wingman(new Robot(hardwareMap), new DrivetrainMovements(new Robot(hardwareMap)));
    }

    @Override
    public void loop() {
        try {
            wingman.Action();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
