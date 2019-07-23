/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package univ;

import impl.person.PersonServiceCalculationDecorator;
import impl.person.PersonServiceValidationDecorator;
import impl.person.jdbc.PersonServiceJdbcImpul;

/**
 *
 * @author rahul
 */
public class MainClass {

    public static void main(String[] args) {
        try {
            PersonServiceJdbcImpul db = new PersonServiceJdbcImpul();
            
            PersonServiceCalculationDecorator calc = new PersonServiceCalculationDecorator();
            calc.setNextDecorator(db);
            
            PersonServiceValidationDecorator validator = new PersonServiceValidationDecorator();
            validator.setNextDecorator(calc);
            
//            PersonInfo person = new PersonInfo();
//            person.setName("Rahul");
//            person.setAge(22);
//            
//            validator.addPerson(person);

            System.out.println("" + validator.getPersons());
            System.out.println("" + validator.getPerson(1L));
        } catch (Exception e) {
            System.out.println(""+e.getMessage());
        }
    }
}
