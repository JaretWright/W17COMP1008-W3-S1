/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w17jan24;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author JWright
 */
public class CreateNewEmployeeViewController implements Initializable {
    @FXML private TextField firstNameTextField;
    @FXML private TextField lastNameTextField;
    @FXML private TextField socialInsuranceNumTextField;
    @FXML private TextField hourlyRateTextField;
    @FXML private DatePicker dobPicker;
    @FXML private Button createNewEmployeeButton;
    
    @FXML private RadioButton hourlyRadioButton;
    @FXML private RadioButton commissionedRadioButton;
    @FXML private Label errorMessageLabel;
    @FXML private Label payRateLabel;
    
    /**
     * This will create a new HourlyEmployee when the button is pushed
     */
    public void createNewEmployeeButtonPushed()
    {
        if (this.hourlyRadioButton.isSelected())
        {
            try
            {
                HourlyEmployee newEmployee = new HourlyEmployee(firstNameTextField.getText(),
                                                            lastNameTextField.getText(),
                                                            socialInsuranceNumTextField.getText(),
                                                            dobPicker.getValue(),
                                             Double.parseDouble(hourlyRateTextField.getText()));

                System.out.printf("The new hourly employee is %s%n", newEmployee);
            }
            catch (IllegalArgumentException e)
            {
                this.errorMessageLabel.setText(e.getMessage());
            }
        }
        else if (this.commissionedRadioButton.isSelected())
        {
            try
            {
                CommissionEmployee newEmployee = new CommissionEmployee(firstNameTextField.getText(),
                                                            lastNameTextField.getText(),
                                                            socialInsuranceNumTextField.getText(),
                                                            dobPicker.getValue(),
                                             Double.parseDouble(hourlyRateTextField.getText()));

                System.out.printf("The new commission employee is %s%n", newEmployee);
            }
            catch (IllegalArgumentException e)
            {
                this.errorMessageLabel.setText(e.getMessage());
            }
        }
    
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup employeeTypeGroup = new ToggleGroup();
        this.hourlyRadioButton.setToggleGroup(employeeTypeGroup);
        this.commissionedRadioButton.setToggleGroup(employeeTypeGroup);
        this.errorMessageLabel.setVisible(false);  //makes it invisible
        this.hourlyRadioButton.setSelected(true);
        
        employeeTypeGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            @Override
            public void changed(ObservableValue<? extends Toggle>  observable, 
                                Toggle oldValue, Toggle newValue)
            {
                if (employeeTypeGroup.getSelectedToggle() != null)
                {
                    //configure the view for an hourly employee
                    if (hourlyRadioButton.isSelected())
                    {
                        payRateLabel.setText("Hourly Rate");
                        hourlyRateTextField.setPromptText("Hourly Rate");
                    }
                    
                    else if (commissionedRadioButton.isSelected())
                    {
                        payRateLabel.setText("Commission Rate");
                        hourlyRateTextField.setPromptText("Commission Rate");
                    }
                }
            }
            
        });
    }    
}
