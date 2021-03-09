/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class driveSubsystem extends SubsystemBase {
  /**
   * Creates a new driveSubsystem.
   */
  //Instantiates left/right side NEO Motors
  public static final CANSparkMax neo1 = new CANSparkMax(Constants.DriveConstants.NEO_1, MotorType.kBrushless);
  public static final CANSparkMax neo2 = new CANSparkMax(Constants.DriveConstants.NEO_2, MotorType.kBrushless);
  public static SpeedController leftSide;
  public static SpeedController rightSide;
  public static DifferentialDrive drive;

  public driveSubsystem() {
    neo1.restoreFactoryDefaults();
    neo2.restoreFactoryDefaults();
    leftSide = new SpeedControllerGroup(neo1);
    rightSide = new SpeedControllerGroup(neo2);
    drive = new DifferentialDrive(leftSide, rightSide);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void arcadeDrive(double xSpeed, double zRotation) {
    drive.arcadeDrive(xSpeed, zRotation);
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    drive.tankDrive(leftSpeed, rightSpeed);
  }
}
