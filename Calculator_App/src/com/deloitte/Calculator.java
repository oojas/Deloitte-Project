package com.deloitte;

import java.util.HashSet;
import java.util.Scanner;

public class Calculator {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
	   HashSet<String> h=new HashSet<String>();
	    h.add("+");
	    h.add("-");
	    h.add("*");
	    h.add("/");
	    h.add("|");
	    h.add("&");
	    h.add("=");
		System.out.println("Enter the first number");
		String a=sc.next();
		System.out.println("Enter the second number");
		String b=sc.next();
		System.out.println("Enter the operator");
		String s=sc.next();
		int fn=checkCorrectForNum(a,1);
		int sn=checkCorrectForNum(b,2);
		int op=0;
		if(h.contains(s)==false) {
			op=1;
		}
		checkForValue(fn,sn,op);
		int fNum=Integer.parseInt(a);
		int sNum=Integer.parseInt(b);
		performOperation(fNum,sNum,s);
		
		sc.close();
    
	}
	
	static void performOperation(int fNum,int sNum,String s)
	{
		switch(s)
		{
		case "+":System.out.println("Result a+b = "+(fNum+sNum));
		         break;
		case "-":System.out.println("Result a-b = "+ (fNum-sNum));
		         break;
		case "*": System.out.println("Result a*b = "+(fNum*sNum));
		           break;
		case "/": {
			if(sNum==0) throw new ArithmeticException("Cannot divide by zero");
			else System.out.println(fNum/sNum);
		}
		          break;
		case "|": System.out.println("Result a&b = "+((int)fNum|(int)sNum));
		case "&":System.out.println("Result a|b = "+((int)fNum&(int)sNum));
		
		default:System.out.println("Please enter correct operator");
			      
		}
	}
	static void checkForValue(int fn,int sn,int op) throws MyClass
	{
		if(fn==1 && sn==1 && op==1)
		{
			System.out.println("1st Number - Please enter only numeric value");
			System.out.println("2nd Number - Please enter only numeric value");
			System.out.println("Enter correct operator value");
			return;
		}
		if(fn==1)
			throw new MyClass("1st Number - Please enter only numeric value");
		if(sn==2)
			throw new MyClass("2nd Number - Please enter only numeric value");
		if(op==1)
		{
			System.out.println("Enter correct operator value");
		}
	}
static int checkCorrectForNum(String z,int val) throws NumberFormatException
{
	if(val==1)
	 if(z.matches(".*[a-z].*") || z.matches(".*[A-Z].*"))
		 return 1;
	 if(val==2)
		if(z.matches(".*[a-z].*") || z.matches(".*[A-Z].*"))
			return 1;
	 return 0;
}

}
class MyClass extends Exception{
	MyClass(String s)
	{
		super(s); // Calling the method from throwable.
	}
}
