
package repository.db.impl;

import domain.*;
import java.sql.*;
import java.util.*;
import repository.db.*;

public class RepositoryGeneric implements DbRepository<OpstaDomenskaKlasa, Long> {

    @Override
    public List<OpstaDomenskaKlasa> getAll(OpstaDomenskaKlasa t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public long add(OpstaDomenskaKlasa t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean edit(OpstaDomenskaKlasa t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(OpstaDomenskaKlasa t, OpstaDomenskaKlasa t2) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<OpstaDomenskaKlasa> getByODK(OpstaDomenskaKlasa t, OpstaDomenskaKlasa t2, String s) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object login(OpstaDomenskaKlasa t) throws Exception {
        String query = "SELECT * FROM " + t.getTableName() + " WHERE " + t.getCondition();
        System.out.println(query);
        Connection conn = DBConnectionFactory.getInstance().getConnection();
        
        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            OpstaDomenskaKlasa odo = null;
            
            while(rs.next()) {
                odo = t.getObject(rs);
            }
            
            st.close();
            rs.close();
            return (PolicijskaUprava)odo;
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
