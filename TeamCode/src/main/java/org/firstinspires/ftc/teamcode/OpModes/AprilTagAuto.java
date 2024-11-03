package org.firstinspires.ftc.teamcode.OpModes;

import android.util.Size;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.*;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.Robot;
import org.firstinspires.ftc.vision.VisionPortal;
import org.firstinspires.ftc.vision.apriltag.AprilTagDetection;
import java.util.List;


@TeleOp(name = "AutoWithAprilTags", group = "Auto")
public class AprilTagAuto extends OpMode {

    AutoUtility autoUtility;

    @Override
    public void init() {
        autoUtility = new AutoUtility(hardwareMap, telemetry);
    }

    public void loop(){
        autoUtility.loop();
    }

}
