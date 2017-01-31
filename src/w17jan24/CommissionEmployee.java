package w17jan24;

import java.time.LocalDate;

/**
 *
 * @author jwright
 */
public class CommissionEmployee extends Employee {

    protected double commissionRate, monthlySales;
    
    public CommissionEmployee(String first, String last, String sin, LocalDate dob, double comRate)
    {
        super(first, last, sin, dob);
        
        monthlySales = 0;
        setCommissionRate(comRate);
    }
    
    /**
     *  This method will return the commission amount earned 
     */
    public double getCommissionAmount()
    {
        return commissionRate / 100 * monthlySales;
    }
    
    
    /**
     * This validates the commission rate is between 0-99 % 
     * @return 
     */
    public void setCommissionRate(double comRate)
    {
        if (comRate > 0 && comRate < 100)
            commissionRate = comRate;
        else
            throw new IllegalArgumentException("The commission must be 0-99");
    }

    public double getCommissionRate() {
        return commissionRate;
    }

    public double getMonthlySales() {
        return monthlySales;
    }
    
   public void recordSales(double salesAmount)
   {
       if (salesAmount > 0)
           this.monthlySales += salesAmount;
       else
           throw new IllegalArgumentException("Sales amount must be greater than 0");
   }
   
   protected void resetMonthlySales()
   {
       monthlySales = 0;
   }
   
    @Override
    public PayCheque getPayCheque() {
        double amount = getCommissionAmount();
        
        PayCheque newPayCheque = new PayCheque(super.toString(), amount);
        
        monthlySales = 0;
        return newPayCheque;
        
    }
    
}
