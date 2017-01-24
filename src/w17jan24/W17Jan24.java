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
       Employee tex = new Employee("John","Rex","200023442",LocalDate.of(1999, Month.MARCH, 15));
       
       System.out.println("The Employee is: " + tex.toString());
       
       System.out.printf("%s was born on a %s%n", tex.getFirstName(), 
                                                tex.getDateOfBirth().getDayOfWeek());
       
       
    }
    
}