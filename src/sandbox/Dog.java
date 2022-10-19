package sandbox;

public class Dog {

	//public final double   pi = 34.141454545455;
	public int age;
	public String color;
	public	int distance;
	void forward(int steps)
	{
		distance=distance+steps;

	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sdfsdfsdsdfdsf
		
		/*
		String s1 = "123";
		String s2 = "123";
		String s3 = new String("123");
		String s5 = "123";
		String a ="1";
		String b ="23";
		String s6 = a+b; 
		String s4=s3;
		String s7;
		s7 = s4.repeat(4);
		
		System.out.println(s7);
		System.out.println(s7=="123123123123");
		System.out.println(s1==s2);
		System.out.println(s1==s3);
		System.out.println(s3==s4);
		System.out.println(s1==s5);
		System.out.println(s1==s6);
		*/
		
		String s1="\tAbc  ";
		String s2="\tAbc  ";
		
		System.out.println(s1);
		System.out.println(s1.toLowerCase());
		System.out.println(s1.toUpperCase());
		System.out.println(s1.trim());
		
		
		System.out.print("123n");
		System.out.print("123n");
		System.out.print("123n");
		System.out.print("123n");		
		
		int abc = 123;
		System.out.print("abc");
		System.out.print(abc);
		
		
		System.out.print("abc\t");
		System.out.print("abc\\");
		System.out.print("       ");
		System.out.print("abc\"");

		
		System.out.print("123\n");
		System.out.print("123\n");
		System.out.print("123\n");
		System.out.print("123\n");		

		System.out.print("123");
		System.out.print("123");
		System.out.print("123");
		System.out.print("123");		
		
		
		System.out.println("123");
		System.out.println("123");
		System.out.println("123");
		System.out.println("123");
		
		
		
		
		
		
		
		
		System.out.println(123*23);
		System.out.println(123L);
		System.out.println(123.3434);
		System.out.println("123");
		System.out.println("123.3434");
		System.out.println("alex");
		
		String s="abc"+"123";
		System.out.println(s);
		System.out.println("abc"+"123");
		
		System.out.println("abc"+123);
		System.out.println(123+"abc");
		System.out.println("abc"+3+4);
		System.out.println(3+4+"abc");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		Dog d1 = new Dog();
		//#Dog d1 = new Cat();
		Dog d2 = new Dog();
		Dog d3 = d1;
		d1.forward(100);
		d2.forward(50);
		d3.forward(150);
		
		
		int i1 = 23;
		//i1="123";
		System.out.println(23);
		
		
		int i2 = 23*12;
		System.out.println(23+12);
		System.out.println(23+12.34);
		System.out.println(23.23+12);
		System.out.println(23.2323+12.2323);
		
		
		int i3 = 23*i1;
		double d4=12.3;
		System.out.println(23+i3);
		System.out.println(23+d4);
		System.out.println(d4*d4);
		
		
		System.out.println();
		
		
		// operator - +,-,*,/ %
		// operand
		
		
		System.out.println();
	}

}
