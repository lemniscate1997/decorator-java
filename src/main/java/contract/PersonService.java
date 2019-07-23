/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contract;

import java.util.*;
import model.PersonInfo;

/**
 *
 * @author rahul
 */
public interface PersonService {
    public void addPerson(PersonInfo person) throws Exception;
    public PersonInfo getPerson(Long id) throws Exception;
    public List<PersonInfo> getPersons() throws Exception;
}
