/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package impl.person.jdbc;

import static constant.Person.AGE;
import static constant.Person.ID;
import static constant.Person.NAME;
import model.PersonInfo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rahul
 */
public class PersonServiceUtil {
    public static void loadRs2Person(ResultSet rs, PersonInfo person) throws SQLException {
        person.setId(rs.getLong(ID));
        person.setName(rs.getString(NAME));
        person.setAge(rs.getInt(AGE));
    }
}
