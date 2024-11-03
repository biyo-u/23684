package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.robotcore.external.navigation.Pose2D;
import org.firstinspires.ftc.teamcode.Constants;
import org.firstinspires.ftc.teamcode.GoBildaPinpointDriver;

public class Odometry {
    boolean isInitialized = false;
    IMU imu;
    public GoBildaPinpointDriver odo;

    public Odometry(GoBildaPinpointDriver odo, IMU imu) {
        this.odo = odo;
        this.imu = imu;
        // Sets Odometry offsets
        // TODO: Tune odometry offsets with our final robot
        // TODO: Change odo.setOffsets to robot specification
        // TODO: Confirm setEncoderDirections by running EncoderDirectionTest
        this.odo.setOffsets(-84.0, -168.0); //measured in mm
        this.odo.setEncoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_SWINGARM_POD);
        this.odo.setEncoderDirections(GoBildaPinpointDriver.EncoderDirection.FORWARD, GoBildaPinpointDriver.EncoderDirection.FORWARD);
        this.odo.resetPosAndIMU();
    }

    public void updateOdometry(double x, double y){
        if (!isInitialized){
            // If there is no starting odometry position, set it using april tags and IMU
            odo.setPosition(new Pose2D(DistanceUnit.INCH, x, y, AngleUnit.DEGREES, imu.getRobotYawPitchRollAngles().getYaw()));
            // then set it to initialize so it is not overridden, but set using a weight instead
            isInitialized = true;
        } else {
            // TODO: Find out how accurate april tags are
            double odoX = odo.getPosX();
            double odoY = odo.getPosY();

            // Sets odometry position with a weight value (Constants.aprilTagTrust is between 0 and 1)
            odo.setPosition(new Pose2D(DistanceUnit.INCH, (odoX * (1 - Constants.aprilTagTrust)) + (x * Constants.aprilTagTrust), (odoY * (1 - Constants.aprilTagTrust)) + (y * Constants.aprilTagTrust), AngleUnit.DEGREES, imu.getRobotYawPitchRollAngles().getYaw()));
        }
    }

    public double getX(){
        return odo.getPosX();
    }

    public double getY(){
        return odo.getPosY();
    }
}
