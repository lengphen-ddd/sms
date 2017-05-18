/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isoft.db;

import java.rmi.UnknownHostException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SOCHAN
 */
public class utils {

    
    public static final String Driver="com.mysql.jdbc.Driver";
     public static final String DriverURL="jdbc:mysql://localhost/SMS";
     public static final String DBUser="root";
     public static final String DBPassword="";
   
     public static Connection getConnection() throws SQLException{
        
        Connection conn = null;
           
        try {
            Class.forName(Driver);
           
            conn = (Connection) DriverManager.getConnection(DriverURL,DBUser,DBPassword);
            
             
        } catch (ClassNotFoundException ex) {    
           System.out.println("connection is error!" + ex.getClass().getName());
       }
        return conn;
   
    } 
    //Use for get data from database,store procedure,function return table,return sclare with paramenter
     public static ResultSet getDatatFromDB(String spname,Object... val)throws ClassNotFoundException, UnknownHostException, SQLException{
     String par1="";
        for(byte i=0;i<val.length;i++){
            if(i == val.length-1)
                par1 +="?";
            else
                par1+="?,";
        }
        spname="{call " + spname + "(" + par1 + ")}";   
        java.sql.CallableStatement cstmt = getConnection().prepareCall(spname);
        for(byte i=0;i<val.length;i++)
            if(val[i] instanceof Byte)
                cstmt.setByte((i+1), (byte)val[i]);
            else if(val[i] instanceof String)
                cstmt.setString((i+1), (String)val[i]);
            else if(val[i] instanceof java.sql.Date)
                cstmt.setDate((i+1), (java.sql.Date)val[i]);
        return cstmt.executeQuery();
    }
    //Use for get data from databse,store procedure,table,view,function table and scalar
     //can use for read data to combox return as resultset
     public static ResultSet getDataFromDB(String sql){
        ResultSet rs = null;
        try {
            Statement stmt = getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            rs = stmt.executeQuery(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(utils.class.getName()).log(Level.SEVERE, null, ex);
        }  
        return rs;
    }
    //Use for Insert delete update,store procedure(commet text)
     public static byte runSQL(String sql){
        try 
        {            
            Statement statment = getConnection().createStatement();            
           return  (byte)statment.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(utils.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    //Use for insert delete update with only store procedure
     public static byte runSQL(String spname,Object... value){
        try 
        {
            String par1="";
            for(byte i=0;i<value.length;i++)
            {
                if(i == value.length-1)
                    par1 +="?";
                else
                    par1+="?,";
            }
            CallableStatement statment =getConnection().prepareCall("{call "+ spname +"("+ par1 +")}");
            for (int i=0; i<=value.length-1;i++)
            {               
                statment.setByte(i+1,(byte)value[i]);
                statment.setObject(i+1, (Object)value[i]);
            }
            return (byte)statment.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(utils.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        
    }  
     //Use for insert data to database with only table
     public static void runSQLInsert(String tbName, Object... value){
        try {
            String s = "INSERT INTO "+tbName+" "
                    + "value(";
            for(int j=0;j<value.length;j++){
                if(j==0)
                    s+="?";
                else
                    s+=",?";
            }
            s+=")";
                PreparedStatement pre = getConnection().prepareStatement(s);
                for(int k=1; k<=value.length; k++){
                    pre.setObject(k, value[k-1]);
                }

                pre.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(utils.class.getName()).log(Level.SEVERE, null, ex);
        }
  
    }
    //Use for read data from database a value
     public static String getSclar(String sql){
        String str = "";
        try {
            str  = getDataFromDB(sql).getString(0);
        } catch (SQLException ex) {
            Logger.getLogger(utils.class.getName()).log(Level.SEVERE, null, ex);
        }
        return str;
    }
   
}
