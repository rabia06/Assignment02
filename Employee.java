/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 *
 * @author rabia
 */
public class Employee
{

    Scanner input = new Scanner( System.in);
    String employee_name;
    double employee_id;
    double hours_worked;
    double pay_rate;
    double holidays;
    double w;
    double t;
    double in;
   
    Employee()
    {
          employee_name="Null";
          employee_id=0;
          hours_worked=0;
          pay_rate=0;
          holidays=0;
          w=0;
          t=0;
          in=0;
    }
    
    Employee(String name,double id, double hours,double rate, double holi,double wages,double tax, double ins)
    {
        employee_name=name;
        employee_id= id;
        hours_worked=hours;
        pay_rate=rate;
        holidays=holi;
        w=wages;
        t=tax;
        in=ins;
    }
    
    
    public void GetEmployeeData()
    {
        
             System.out.println("Name: ");
             employee_name = input.nextLine();
             
             System.out.println("Employee Id: ");
             employee_id=input.nextDouble();
              
             System.out.println("Hours worked: ");
             hours_worked=input.nextDouble();
               
             System.out.println("Pay Rate: ");
             pay_rate=input.nextDouble();
             
             System.out.println("Holidaye: ");
             holidays=input.nextDouble();
             w=WeeklyWage(hours_worked,pay_rate,holidays);
             t=TaxDeduction(w);
             in=InsuranceDeduction(t);
    
    }
    
    
   double WeeklyWage(double hours_worked, double pay_rate, double holidays)
{
    double wage;
	if (holidays <= 2)
	{
		if (hours_worked >= 40)
		{
                       if(pay_rate <=50 && pay_rate >=20)
                       {
			wage = pay_rate * hours_worked;
			wage = wage + (hours_worked - 40) * 1.5 * pay_rate;
			return wage;
                       }
                       else
                       {
                            System.out.println("Payrate exceeded");
                            System.exit(0);
                       }
		}
                else 
		{
                      if(pay_rate<=70 && pay_rate>=30)
                      {
			wage = pay_rate * hours_worked;
			return wage;
                      }
                       else
                       {
                            System.out.println("Payrate exceeded");
                            System.exit(0);
                       }

		}
	}

	else if (holidays >= 1 && holidays <= 7)
	{
		if (hours_worked > 40)
		{
			if(pay_rate <=50 && pay_rate <=20)
                        {
                        wage = pay_rate * hours_worked;
			wage = wage + (hours_worked - 40) * 1.5 * pay_rate;
			wage = wage - (holidays * 100);
			return wage;
                        }
                         else
                       {
                            System.out.println("Payrate exceeded");
                            System.exit(0);
                       }
		}
		else
		{
                    if(pay_rate <=70 && pay_rate>=30)
                      {
			wage = pay_rate * hours_worked;
			wage = wage - (holidays * 100);
			return wage;
                      }
                     else
                       {
                            System.out.println("Payrate exceeded");
                            System.exit(0);
                       }

		}
	}
        else
        {
             System.out.println("Holiday limi5 exceeded");
             System.exit(0);
        }
        return 0;
}
    public double TaxDeduction(double wages)
    {
      
        String c;
        double Tax=0;
        if (wages >=10000)
        {
        System.out.println("Enter your marital status");
        System.out.println("If married press m & s if single");
        c=input.nextLine();
        
        switch(c)
        {
            case "m": 
            {
                wages=wages-18;
                Tax=0.15*wages;
              
                break;
            }
            case "s":
            {
                wages=wages-10;
                Tax=0.20*wages;
                
                break;
            }
            default:
            {
                 System.out.println("Invalid option selected");
                 System.exit(0);
                 break;
                 
            }
        }
        return Tax;
        }
         else
        {
            Tax=0;
          return  Tax;     
        }  
    }
    
    public double InsuranceDeduction(double tax)
    {
 
        String ch;
        if(tax>=10000)
        {
        System.out.println("Do you want to apply for insurance? If yes press y else n ");
        ch=input.nextLine();
        
        switch(ch)
        {  
            case "y":
            {
                   if( tax >= 10000)
                   {
                       tax = tax-1000;

                   }
                   else
                   {
                        System.out.println("Pay is less then 10000");
                        System.exit(0);
                   }
                   break;
            }
            case "n":
            {
                 System.out.println("Insurance not applied");
                break;
            }
            default:
            {
                 System.out.println("Invalid option");
                 System.exit(0);
                 break;
            }
        }
         return tax; 
        }
        else
        {
            tax=0;
            return tax;
        }
    }
    
    public void display()
    {
         System.out.println("Employee id" + employee_id);
         System.out.println("Employee name"+employee_name);
         System.out.println("Weekly wage"+ w);
         System.out.println("Tax Deduction"+t);
         System.out.println("Insurance Deduction"+in);
         
    }
    
    
    public static void main(String args[]) throws IOException, NumberFormatException
    {

         
     Employee e = new Employee();
     
         e.GetEmployeeData();
         e.display();
                 
 
     
    }
    
}

    
    
  
