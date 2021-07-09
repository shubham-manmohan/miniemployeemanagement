/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package empmgmt.pojo;

/**
 *
 * @author Shubham Manmohan
 */
public class Employee {
    private String empName;
    private double Sal;
    private int empNo;
    
    public Employee(){}

    public Employee(int empNo,String empName, double Sal) {
        this.empName = empName;
        this.Sal = Sal;
        this.empNo = empNo;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setSal(double Sal) {
        this.Sal = Sal;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    
    public String getEmpName() {
        return empName;
    }

    public double getSal() {
        return Sal;
    }

    public int getEmpNo() {
        return empNo;
    }
    
    
}
