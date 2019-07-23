/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import model.PersonInfo;
import contract.PersonService;
import java.util.List;

/**
 *
 * @author rahul
 */
public class PersonServiceBaseDecorator implements PersonService{

    PersonService nextDecorator;

    public PersonService getNextDecorator() {
        return nextDecorator;
    }

    public void setNextDecorator(PersonService nextDecorator) {
        this.nextDecorator = nextDecorator;
    }
    
    @Override
    public void addPerson(PersonInfo person) throws Exception {
        getNextDecorator().addPerson(person);
    }

    @Override
    public PersonInfo getPerson(Long id) throws Exception {
        return getNextDecorator().getPerson(id);
    }

    @Override
    public List<PersonInfo> getPersons() throws Exception {
        return getNextDecorator().getPersons();
    }
    
}
