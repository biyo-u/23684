package org.firstinspires.ftc.teamcode.Roadrunner.messages;

import com.acmerobotics.roadrunner.ftc.GoBildaPinpointDriverRR;
import com.acmerobotics.roadrunner.ftc.PositionVelocityPair;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public final class MecanumLocalizerInputsMessage {
    public long timestamp;
    public PositionVelocityPair leftFront;
    public PositionVelocityPair leftBack;
    public PositionVelocityPair rightBack;
    public PositionVelocityPair rightFront;
    public double yaw;
    public double pitch;
    public double roll;

    public GoBildaPinpointDriverRR goBildaPinpointDriverRR;

    public MecanumLocalizerInputsMessage(PositionVelocityPair leftFront, PositionVelocityPair leftBack, PositionVelocityPair rightBack, PositionVelocityPair rightFront, GoBildaPinpointDriverRR goBildaPinpointDriverRR) {
        this.timestamp = System.nanoTime();
        this.leftFront = leftFront;
        this.leftBack = leftBack;
        this.rightBack = rightBack;
        this.rightFront = rightFront;
        this.goBildaPinpointDriverRR = goBildaPinpointDriverRR;
        {
            this.yaw = goBildaPinpointDriverRR.getHeading();
            this.pitch = 0;
            this.roll = 0;
        }
    }
}
