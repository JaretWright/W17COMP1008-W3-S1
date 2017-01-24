
package w17jan24;

import java.time.LocalDate;

/**
 *
 * @author jwright
 */
public class PayCheque {
    private double amount;
    private LocalDate dateIssued;
    private int chequeNum;
    private static int nextChequeNum = 10000;
    private String employeeName, notes;
    
    public PayCheque(String employee, double amount)
    {
        employeeName = employee;
        chequeNum = nextChequeNum;
        nextChequeNum++;
        dateIssued = LocalDate.now();
        notes = "";
        setChequeAmount(amount);
    }
    
    /**
     * This will validate that the cheque amount is valid
     */
    private void setChequeAmount(double amount)
    {
        if (amount > 0)
            this.amount = amount;
        else
            throw new IllegalArgumentException("Cheque value must be greater than 0");
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public int getChequeNum() {
        return chequeNum;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getNotes() {
        return notes;
    }
    
    @Override
    public String toString()
    {
        return String.format("Cheque # %d, made out to %s for the amount of $%.2f",
                getChequeNum(), getEmployeeName(), getAmount());
    }
    
}
