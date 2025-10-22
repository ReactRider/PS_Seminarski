
package repository.db.impl;

import domain.*;
import java.sql.*;
import java.util.*;
import repository.db.*;

public class RepositoryGeneric implements DbRepository<OpstaDomenskaKlasa, Long> {

    @Override
    public List<OpstaDomenskaKlasa> getAll(OpstaDomenskaKlasa t) throws Exception {
        List<OpstaDomenskaKlasa> lista=new ArrayList<>();
        String query="";
        if(t instanceof Vozilo)
            query="SELECT * FROM "+t.getJoinCondition();
        else
            query="SELECT * FROM "+t.getTableName();
        
        System.out.println(query);
        Connection connection=DBConnectionFactory.getInstance().getConnection();
        Statement s=connection.createStatement();
        ResultSet rs=s.executeQuery(query);
        lista=t.getList(rs);
        s.close();
        rs.close();
        return lista;
    }

    @Override
    public long add(OpstaDomenskaKlasa t) throws Exception {
        long id=0l;
        String query="INSERT INTO "+t.getTableName()+" ("+t.getColumnsForInsert()+") VALUES ("+t.getValuesForInsert()+")";
        Connection connection=DBConnectionFactory.getInstance().getConnection();
        System.out.println(query);
        Statement s=connection.createStatement();
        s.execute(query, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs=s.getGeneratedKeys();
       
        while(rs.next())
           id=rs.getLong(1);

        return id;
    }

    @Override
    public boolean edit(OpstaDomenskaKlasa t) throws Exception {
        String query = "UPDATE " + t.getTableName() + " SET " + t.getValueForUpdate() + " WHERE " + t.getConditionForUpdate();
        System.out.println(query);
        Connection conn = DBConnectionFactory.getInstance().getConnection();
        Statement s = conn.createStatement();
        int b = s.executeUpdate(query);
        s.close();
        
        if(b != 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean delete(OpstaDomenskaKlasa t, OpstaDomenskaKlasa t2) throws Exception {
        String query="DELETE FROM "+t.getTableName()+" WHERE "+t.getConditionForDelete(t2);
        System.out.println(query);
        Connection conn=DBConnectionFactory.getInstance().getConnection();
        Statement s=conn.createStatement();
        int i=s.executeUpdate(query);
        s.close();
        return true;
    }

    @Override
    public List<OpstaDomenskaKlasa> getByClass(OpstaDomenskaKlasa t, OpstaDomenskaKlasa t2, String s) throws Exception {
        List<OpstaDomenskaKlasa> list = new ArrayList<>();
        String query = "";
        
        if(t2 instanceof Vlasnik)
            query = "SELECT * FROM " + t.getJoinCondition() + " WHERE " + t.getConditionForFind(s, t2);
        else if(t2 instanceof Raskrsnica)
            query = "SELECT * FROM " + t.getJoinCondition() + " WHERE " + t.getConditionForFind(s, t2);
        else if(t2 instanceof PolicijskaUprava)
            query = "SELECT * FROM " + t.getJoinCondition() + " WHERE " + t.getConditionForFind(s, t2);
        else if(t instanceof Vozilo) 
            query = "SELECT * FROM " + t.getJoinCondition() + " WHERE " + t.getConditionForFind(s, t2);
        else if(t instanceof EvidencijaKazni)
            query = "SELECT * FROM " + t.getJoinCondition() + " WHERE " + t.getConditionForFind(s, t2);
        else if(t instanceof StavkaEvidencije)
            query = "SELECT * FROM " + t.getJoinCondition() + " WHERE " + t.getConditionForFind(s, t2); 
        else
            query = "SELECT * FROM " + t.getTableName()+" WHERE " + t.getConditionForFind(s, t2);
        
        System.out.println(query);
        
        Connection conn=DBConnectionFactory.getInstance().getConnection();
        Statement statement=conn.createStatement();
        ResultSet rs=statement.executeQuery(query);
        list=t.getList(rs);
        statement.close();
        rs.close();
        return list;
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
            
            while(rs.next()) 
                odo = t.getObject(rs);
            
            st.close();
            rs.close();
            return (PolicijskaUprava)odo;
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
}
