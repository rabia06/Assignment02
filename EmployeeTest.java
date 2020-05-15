/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import jxl.Sheet;
import jxl.Workbook;
import org.junit.Assert;
import jxl.read.biff.BiffException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author Minahil
 */
@RunWith(Parameterized.class)
public class EmployeeTest {
        String employee_name;
        double employee_id;
        double hours_worked;
        double pay_rate;
        double holidays;
        double w;
        double t;
        double in;
        
        Employee et;
        
    public EmployeeTest(String name,double id, double hours,double rate, double holi,double wages,double tax, double ins) {
        employee_name=name;
        employee_id= id;
        hours_worked=hours;
        pay_rate=rate;
        holidays=holi;
        w=wages;
        t=tax;
        in=ins;
    }
    
    @Before
    public void setUp() {
        et=new Employee();
    }
    
    @Parameterized.Parameters
	public static Collection<Object[]> Testdata() throws BiffException, IOException, IllegalArgumentException
	{
            FileInputStream f;
            f = new FileInputStream("implementation.xlsx");
            
            Workbook wo = Workbook.getWorkbook(f);
            Sheet s = wo.getSheet(0);
            
            Object data[][] = new Object[s.getRows()][s.getColumns()];
            
            for(int i=0;i<(s.getRows());i++){
                
                String t=s.getCell(0,i).getContents();
                
                int one=Integer.parseInt(s.getCell(1,i).getContents());
                int two=Integer.parseInt(s.getCell(2,i).getContents());
                int three=Integer.parseInt(s.getCell(3,i).getContents());
                
                data[i][0] = t;
                data[i][1] = one;
                data[i][2] = two;
                data[i][3] = three;
            }
            return Arrays.asList(data);
	}
    @Test
    public void test1(){
        double hours_worked=40;
        double pay_rate=60;
        double holidays=4;
        assertNotNull(hours_worked);
        assertNotNull(pay_rate);
        assertNotNull(holidays);
        
        double result=et.WeeklyWage(hours_worked,pay_rate,holidays);
        double execpted_result=2100;
        assertEquals(execpted_result,result);
    }
    
    @Test
    public void test2() {
        
        double hours_worked=50;
        double pay_rate=70;
        double holidays=7;
        
        assertNotNull(hours_worked);
        assertNotNull(pay_rate);
        assertNotNull(holidays);;
        
        double result=et.WeeklyWage(hours_worked,pay_rate,holidays);
        double execpted_result=1315;
        assertNotEquals(execpted_result,result);
    }
    
    @Test
    public void test3() {
        
        double hours_worked=60;
        double pay_rate=49;
        double holidays=2;
        
        assertNotNull(hours_worked);
        assertNotNull(pay_rate);
        assertNotNull(holidays);;
        
        double result=et.WeeklyWage(hours_worked,pay_rate,holidays);
        double execpted_result=4410;
        assertNotEquals(execpted_result,result);
    }
    
    @Test
    public void test4() {
        
        double hours_worked=60;
        double pay_rate=50;
        double holidays=4;
        
        assertNotNull(hours_worked);
        assertNotNull(pay_rate);
        assertNotNull(holidays);;
        
        double result=et.WeeklyWage(hours_worked,pay_rate,holidays);
        double execpted_result=4100;
        assertNotEquals(execpted_result,result);
    }
    
    @Test
    public void test5() {
        
        double hours_worked=70;
        double pay_rate=30;
        double holidays=3;
        
        assertNotNull(hours_worked);
        assertNotNull(pay_rate);
        assertNotNull(holidays);;
        
        double result=et.WeeklyWage(hours_worked,pay_rate,holidays);
        double execpted_result=3150;
        assertNotEquals(execpted_result,result);
    }
    
    @Test
    public void test6() {
        
        double hours_worked=20;
        double pay_rate=30;
        double holidays=3;
        
        assertNotNull(hours_worked);
        assertNotNull(pay_rate);
        assertNotNull(holidays);;
        
        
        double result=et.WeeklyWage(hours_worked,pay_rate,holidays);
        double execpted_result=300;
        assertEquals(execpted_result,result);
    }
    @Test
    public void test7() {
        
        double hours_worked=30;
        double pay_rate=40;
        double holidays=2;
        
        assertNotNull(hours_worked);
        assertNotNull(pay_rate);
        assertNotNull(holidays);;
        
        
        double result=et.WeeklyWage(hours_worked,pay_rate,holidays);
        double execpted_result=1200;
        assertEquals(execpted_result,result);
    }
}
