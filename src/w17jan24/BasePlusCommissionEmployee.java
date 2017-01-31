
package w17jan24;

import java.time.LocalDate;

/**
 *
 * @author JWright
 */
public class BasePlusCommissionEmployee extends CommissionEmployee
{
    private double baseMonthlySalary;
    
    public BasePlusCommissionEmployee(String first, String last, String sin, LocalDate dob, double comRate, double base) {
        super(first, last, sin, dob, comRate);
        
        setBaseSalary(base);
    }
    
    /**
     * This method will validate that the base is greater than 0 and set the baseMonthlySalary
     */
    public void setBaseSalary(double base)
    {
        if (base > 0)
            baseMonthlySalary = base;
        else
            throw new IllegalArgumentException("Base monthly salary must be greater than 0");
    }
    
    /**
     * This method will calculate the monthly pay and return a new PayCheque object
     */
    public PayCheque getPayCheque()
    {
        double payAmount = super.getCommissionAmount() + baseMonthlySalary;
        
        PayCheque newPay = new PayCheque(super.toString(), payAmount);
        
        super.resetMonthlySales();
        
        return newPay;
    }
    
}
