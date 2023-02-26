// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.subsystems.RomiDrivetrain;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class FowardWithPID extends CommandBase {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final RomiDrivetrain m_rdt;
  private double distance;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public FowardWithPID(RomiDrivetrain rdt, double inches) {
    m_rdt = rdt;
    distance = inches;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(rdt);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_rdt.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_rdt.straightLineWithPID(0.7);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_rdt.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (m_rdt.getAverageDistanceInch >= distance);
  }
}
