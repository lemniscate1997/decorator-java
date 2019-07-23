/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl.person.jdbc;

import static constant.JdbcConstant.*;
import static constant.Person.*;
import model.PersonInfo;
import contract.PersonService;
import static impl.person.jdbc.PersonServiceUtil.loadRs2Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rahul
 */
public class PersonServiceJdbcImpul
        extends PersonServiceUtil
        implements PersonService {

    private Connection conn;

    public PersonServiceJdbcImpul() throws Exception {
        this.conn = DriverManager.getConnection(DB_URL,
                DB_ID, DB_PASSWORD);
    }

    @Override
    public void addPerson(PersonInfo person) throws Exception {
        System.out.println("PersonServiceJdbcImpulse");
        String SQL_INSERT = String.format("insert into %s (%s, %s) values (?, ?)",
                PERSON, NAME, AGE);
        PreparedStatement preparedStatement = conn.prepareStatement(SQL_INSERT);

        preparedStatement.setString(1, person.getName());
        preparedStatement.setInt(2, person.getAge());

        if (preparedStatement.executeUpdate() != -1) {
            System.out.println("Insert operation successful");
        } else {
            System.out.println("Insert operation failed");
        }
    }

    @Override
    public PersonInfo getPerson(Long id) throws Exception {
        String SQL_SELECT = String.format("select * from %s where %s = ?", PERSON, ID);
        PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
        preparedStatement.setLong(1, id);
        ResultSet rs = preparedStatement.executeQuery();

        PersonInfo person = new PersonInfo();
        if (rs.next()) {
            loadRs2Person(rs, person);
        }

        return person;
    }

    @Override
    public List<PersonInfo> getPersons() throws Exception {
        String SQL_SELECT = String.format("select * from %s", PERSON);
        PreparedStatement preparedStatement = conn.prepareStatement(SQL_SELECT);
        ResultSet rs = preparedStatement.executeQuery();

        List<PersonInfo> persons = new ArrayList<>();
        while (rs.next()) {
            PersonInfo person = new PersonInfo();
            loadRs2Person(rs, person);
            persons.add(person);
        }
        return persons;
    }

    @Override
    protected void finalize() throws Exception {
        this.conn.close();
    }

}
