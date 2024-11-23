package org.firstinspires.ftc.teamcode.hardcodeauto;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import org.firstinspires.ftc.teamcode.hardcodeauto.movements.Lines;

@Autonomous
public class BlueAuto {
    public Lines lines;

    public void init() {

    }

    public void loop() throws InterruptedException {
      Lines.Movement(1,0,0.0,1);
      sleep(400);
      Lines.Movement(0,1,0,1);
        sleep(20);
      Lines.Movement(-1,0,0,1);
        sleep(20);

    }

}
