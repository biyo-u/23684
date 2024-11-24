package com.iamcoder.meepmeep;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class BlueAutos {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(700);

        RoadRunnerBotEntity pathB = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(60, 60, Math.toRadians(180), Math.toRadians(180), 15)
                .build();

        pathB.runAction(pathB.getDrive().actionBuilder(new Pose2d(10, 64,67.55))
                .lineToY(38)
                .splineToConstantHeading(new Vector2d(5,38),Math.PI / 2)
                .lineToY(35)
                .waitSeconds(1)
                .lineToY(55)
                .setTangent(0)
                .splineTo(new Vector2d(36,26),Math.PI / 2)
                .waitSeconds(1)
                .setTangent(0)
                .splineTo(new Vector2d(56,50),Math.toRadians(45)) //score
                .waitSeconds(1)
                .setTangent(0)
                .splineTo(new Vector2d(46,26),Math.toRadians(-45))
                .waitSeconds(1)
                .setTangent(0)
                .splineTo(new Vector2d(56,50),Math.toRadians(45))
                .waitSeconds(1)
                .setTangent(0)
                .splineTo(new Vector2d(55,26),Math.toRadians(-45))
                .waitSeconds(1)
                .splineTo(new Vector2d(56,50),Math.toRadians(45))
                .lineToY(45)
                .waitSeconds(1)
                .splineTo(new Vector2d(-47,60),Math.toRadians(45))
                .build());

        meepMeep.setBackground(MeepMeep.Background.FIELD_INTO_THE_DEEP_JUICE_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(pathB)
                .start();
    }
}