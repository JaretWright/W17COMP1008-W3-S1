/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w17jan24;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author jwright
 */
public class W17Jan24 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       HourlyEmployee tex = new HourlyEmployee("John","Rex","200023442",
                                                LocalDate.of(1999, Month.MARCH, 15),
                                                27.33);
       
       System.out.println("The Employee is: " + tex.toString());       
       System.out.printf("%s was born on a %s%n", tex.getFirstName(), 
                                                tex.getDateOfBirth().getDayOfWeek());       
       System.out.printf("%s has an employee number of %d%n", tex, tex.getEmployeeNum());
       
       tex.addHoursWorked(8);
       tex.addHoursWorked(14);
     
       System.out.printf("The first paycheque is: %s%n", tex.getPayCheque().toString());
       
       CommissionEmployee emp2 = new CommissionEmployee("Frank","Sinatra","2233",LocalDate.of(1947, 12, 12),
                                                        45);
       emp2.recordSales(23445);
       emp2.recordSales(2223);
       System.out.printf("The next paycheque is: %s%n", emp2.getPayCheque().toString());
       
       BasePlusCommissionEmployee emp3 = new BasePlusCommissionEmployee("Anita","Job","1232923",
                                                        LocalDate.of(1996, Month.MARCH, 15),
                                                        45, 2000);
       emp3.recordSales(23445);
       emp3.recordSales(2223);
       System.out.printf("The next paycheque is: %s%n", emp3.getPayCheque().toString());
       
    }
    
}
