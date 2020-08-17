/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSubsystem extends SubsystemBase {
  private final DifferentialDrive mDrive;

  /**
   * Creates a new DriveSubsystem.
   */
  public DriveSubsystem() {
    SpeedController leftFront = new WPI_VictorSPX(Constants.CAN_LEFT_FRONT_DRIVE);
    SpeedController leftRear = new WPI_VictorSPX(Constants.CAN_LEFT_REAR_DRIVE);
    SpeedController rightFront = new WPI_VictorSPX(Constants.CAN_RIGHT_FRONT_DRIVE);
    SpeedController rightRear = new WPI_VictorSPX(Constants.CAN_RIGHT_REAR_DRIVE);

    SpeedControllerGroup left = new SpeedControllerGroup(leftFront, leftRear);
    SpeedControllerGroup right = new SpeedControllerGroup(rightFront, rightRear);
    mDrive = new DifferentialDrive(left, right);
  }

  public void arcadeDrive(double forwardSpeed, double clockwiseSpeed) {
    mDrive.arcadeDrive(forwardSpeed, clockwiseSpeed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
