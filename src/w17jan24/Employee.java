
package w17jan24;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author jwright
 */
public abstract class Employee implements Payable{
    private String firstName, lastName, socialInsuranceNumber;
    private LocalDate dateOfBirth;
    private int employeeNum;
    private static int nextEmployeeNum = 10001;
    
    public Employee(String first, String last, String sin, LocalDate dob)
    {
        firstName = first;
        lastName = last;
        socialInsuranceNumber = sin;
        setBirthday(dob);
        employeeNum = nextEmployeeNum;
        
        nextEmployeeNum++;  //increment so the next employee has a different number
    }

    public int getEmployeeNum() {
        return employeeNum;
    }
    
    /**
     * This method will validate the new Employee is 15-90 years old
     */
    public void setBirthday(LocalDate dob)
    {
        LocalDate today = LocalDate.now();
        int age = Period.between(dob, today).getYears();
        
        if (age >= 15 && age <= 90)
            dateOfBirth = dob;
        else
            throw new IllegalArgumentException("Employees must be 15-90 years old");
    }
    
    /**
     * This method will return the employee's first and last name
     */
    @Override
    public String toString()
    {
        return firstName + " " + lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSocialInsuranceNumber() {
        return socialInsuranceNumber;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    
    public abstract PayCheque getPayCheque();
    
}
