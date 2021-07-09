/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package empmgmt.dao;

import empmgmt.dbutil.DBConnection;
import empmgmt.pojo.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author abc
 */
public class EmpDAO {
    
  public static boolean addEmployee(Employee e) throws SQLException
  {
  Connection conn=DBConnection.getConnection();
  PreparedStatement ps=conn.prepareStatement("insert into empdata values(?,?,?)");
  ps.setInt(1,e.getEmpNo());
  ps.setString(2, e.getEmpName());
  ps.setDouble(3, e.getSal());
  int result=ps.executeUpdate();
  if(result==1){
  return true;
  }
  
  return false;
  }
  public static boolean updateEmployee(Employee e) throws SQLException 
  {
  Connection conn=DBConnection.getConnection();
  PreparedStatement ps=conn.prepareStatement("update empdata set empname=?,empsal=? where empno=?");
    ps.setInt(3,e.getEmpNo());
    ps.setString(1, e.getEmpName());
    ps.setDouble(2, e.getSal());
  int result=ps.executeUpdate();
  return result==1;
  }
  public static boolean deleteEmployee(Employee e) throws SQLException
  {
  Connection conn=DBConnection.getConnection();
  PreparedStatement ps=conn.prepareStatement("delete from empdata where empno=?");
  ps.setInt(1, e.getEmpNo());
  int result=ps.executeUpdate();
  return result==1;
  }
  
  public static Employee findEmployeeById(int empNo)throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("Select * from empdata where empno=?");
        ps.setInt(1, empNo);
        ResultSet rs=ps.executeQuery();
        Employee e=null;
        if(rs.next())
        {
            e=new Employee();
            e.setEmpNo(rs.getInt(1));
            e.setEmpName(rs.getString(2));
            e.setSal(rs.getDouble(3));
        }
        return e;
    }
  
  public static ArrayList<Employee> getAllEmployees() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ArrayList<Employee> empList=new ArrayList<>();
        ResultSet rs=st.executeQuery("Select * from empdata order by empno");
        while(rs.next())
        {
            Employee e=new Employee();
            e.setEmpNo(rs.getInt(1));
            e.setEmpName(rs.getString(2));
            e.setSal(rs.getDouble(3));
            empList.add(e);
        }
        return empList;
    }
 
}
