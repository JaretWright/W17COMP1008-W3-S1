/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w17jan24;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

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
    
    /**
     * This will create a new HourlyEmployee when the button is pushed
     */
    public void createNewEmployeeButtonPushed()
    {
        HourlyEmployee newEmployee = new HourlyEmployee(firstNameTextField.getText(),
                                                        lastNameTextField.getText(),
                                                        socialInsuranceNumTextField.getText(),
                                                        dobPicker.getValue(),
                                         Double.parseDouble(hourlyRateTextField.getText()));
        
        System.out.printf("The new employee is %s%n", newEmployee);
    }
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
