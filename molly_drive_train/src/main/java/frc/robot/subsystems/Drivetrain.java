// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drivetrain extends SubsystemBase {
  private DifferentialDrive differentialDrive; 
  /** Creates a new Drivetrain. */
  WPI_TalonFX frontLeftController;
  WPI_TalonFX frontRightController;
  WPI_TalonFX backLeftController;
  WPI_TalonFX backRightController;

  public Drivetrain() {
    // controllers
    frontLeftController = new WPI_TalonFX(Constants.RIGHT_FRONT_TALON);
    frontRightController = new WPI_TalonFX(Constants.LEFT_FRONT_TALON);
    backLeftController = new WPI_TalonFX(Constants.RIGHT_BACK_TALON);
    backRightController = new WPI_TalonFX(Constants.LEFT_BACK_TALON);

    // speed controllers
    SpeedControllerGroup LEFT_MOTORS = new SpeedControllerGroup(frontRightController, backRightController);
    SpeedControllerGroup RIGHT_MOTORS = new SpeedControllerGroup(frontLeftController, backLeftController);
    // inverting
    // DELETE??
    RIGHT_MOTORS.setInverted(true);
    // differential drive
    differentialDrive  = new DifferentialDrive(LEFT_MOTORS, RIGHT_MOTORS);
  }
  public void diffDrive(double X_AXIS, double Y_AXIS){
    differentialDrive.arcadeDrive(X_AXIS,Y_AXIS);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
