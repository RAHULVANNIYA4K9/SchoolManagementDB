package com.Driver;

import java.util.Scanner;

import com.service.SchoolService;

public class SchoolDriver {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Welcom to My School DB");
		System.out.println("Enter a Number 1 to save the data");
		System.out.println("Enter a Number 2 to Update the data");
		System.out.println("Enter a Number 3 to Delete the data");
		System.out.println("Enter a Number 4 to Fetch the data");
		System.out.println("Enter a Number 5 to Exit the Application");
		
		System.out.println("Enter your Choice");
		int choice =sc.nextInt();
		SchoolService s=new SchoolService();
		switch(choice) {
		case 1:
			int no=s.save();
			if(no!=0) {
				System.out.println("Data is saved");
			}
			break;
		case 2:
			int n2=s.Update();
			if(n2!=0) {
				System.out.println("Data is Updated");
			}
			break;
		case 3:
			int m=s.delete();
			if(m!=0) {
				System.out.println("Deleted");
			}
			break;
		case 4:
			boolean f=s.fetch();
			if(f==true) {
				System.out.println("Data is fetched");
			}
			break;
		default:
			System.out.println("Invalid Input");
			break;
		}
		
	}

}
