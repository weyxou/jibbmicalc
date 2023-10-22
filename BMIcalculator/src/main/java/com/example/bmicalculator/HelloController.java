package com.example.bmicalculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class HelloController {
    @FXML
    private TextField weightField;

    @FXML
    private TextField heightField;

    @FXML
    private Label bmiLabel;

    public void calculateBMI(ActionEvent event) {
        try {
            double weight = Double.parseDouble(weightField.getText());
            double height = Double.parseDouble(heightField.getText());

            double bmi = calculateBMIValue(weight, height);
            String bmiCategory = determineBMICategory(bmi);

            bmiLabel.setText("BMI: " + String.format("%.2f", bmi) + " (" + bmiCategory + ")");
        } catch (NumberFormatException e) {
            bmiLabel.setText("Invalid input. Please enter valid weight and height.");
        }
    }

    public void clearFields(ActionEvent event) {
        weightField.clear();
        heightField.clear();
        bmiLabel.setText("");
    }

    private double calculateBMIValue(double weight, double height) {
        return weight / (height * height);
    }

    private String determineBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 24.9) {
            return "Normal Weight";
        } else if (bmi < 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}
