package org.firstinspires.ftc.teamcode.OpModes.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.EagleMatrix.DrivetrainMovements;
import org.firstinspires.ftc.teamcode.EagleMatrix.LiftMovements;
import org.firstinspires.ftc.teamcode.EagleMatrix.Wingman;
import org.firstinspires.ftc.teamcode.Robot;

@Autonomous(name = "Griffindrive", group = Constants.GroupNames.Autonomous, preselectTeleOp = "TeleOp")
public class Griffindrive extends OpMode {
    public Wingman wingman;
    private Robot robot;

    @Override
    public void init() {
        wingman = new Wingman(new Robot(hardwareMap), new DrivetrainMovements(new Robot(hardwareMap)), new LiftMovements(new Robot(hardwareMap)));
        robot.intake.clawClose();
        telemetry.addLine("Initialized");
    }

    @Override
    public void loop() {
        try {
            wingman.ActionA();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
