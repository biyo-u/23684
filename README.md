# 23684

*Variables (except enums), Robot config, and functions* are always *camelCase*
*Classes and enums* are always *PascalCase*
Drive motors will be names weather they front or rear + weather they are left or right (like
frontLeft, frontRight, rearLeft, rearRight)
In any order where 4 drive motors are needed, they must be in the order: frontLeft, frontRight,
rearLeft, rearRight
Whenever something is given a power, there should not be a stop() function. Instead, set the power
to 0 to stop it.
If there isn't a way to set power (like moveUp and moveDown) then there should be a stop() function.

TODO: Label controller

### Gamepad 1 (Drive):

- Left Bumper: Reset IMU
- Right Bumper: Speed Mode
- Left Trigger: Nothing
- Right Trigger: Nothing
- Left Joystick: Drive
- Right Joystick: Turn
- DPad: Nothing
- X: Nothing
- Y: Nothing
- A: Nothing
- B: Nothing

### Gamepad 2 (Actions):

- Left Bumper: Nothing
- Right Bumper: Nothing
- Left Trigger: Intake In
- Right Trigger: Intake Out
- Left Joystick: Lift (Up, Down, Tilt Left, and Tilt Right)
- Right Joystick: Shoulder (Left and Right) and Elbow (Up and Down)
- DPad: Nothing
- X: Nothing
- Y: Nothing
- A: Nothing
- B: Nothing`
