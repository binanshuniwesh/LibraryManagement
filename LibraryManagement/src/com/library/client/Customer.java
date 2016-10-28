package com.library.client;
import java.sql.*;


//import java.util.ArrayList;
import java.util.Scanner;

import com.library.DAO.ConnectionDAO;
//import com.library.exceptions.ReaderIdNotFoundException;
import com.library.services.CustomerServices;
import com.library.services.impl.CustomerImplementation;

//import com.hotel.bean.Item;
//import com.hotel.exceptions.CategoryNotFoundException;
//import com.hotel.exceptions.ItemIdNotFoundException;
//import com.hotel.service.ItemServices;
//import com.hotel.service.impl.ItemImplementation;

public class Customer {
	static Connection connection;
	
	public static void main(String[] args)  {
    
    
		System.out.println("welcome customer");
		Scanner sc= new Scanner(System.in);
		Scanner sc1=new Scanner(System.in);
		Scanner sc2=new Scanner(System.in);
		System.out.println("Enter the User ID");
		int userId=sc.nextInt();
		System.out.println("Enter the Password");
		String pass=sc1.nextLine();
		String name;
		
		 PreparedStatement statement=null;
			try{
				connection = ConnectionDAO.openConnection();
				String getQuery="Select id,pass,name from LOGIN where id="+userId+" and pass='"+pass+"'";
				System.out.println(getQuery);
				statement=connection.prepareStatement(getQuery);
				ResultSet rs1=statement.executeQuery();
				//logger.info("showing all the items");
				//System.out.println("Showing all readers");
				
			//	System.out.println("rs1 is      "+rs1.next());
			//	System.out.println("hggggggg     "+rs1.getString(1));
				if (rs1!=null) {
					while(rs1.next())
					{
					name = rs1.getString(3);
					System.out.println("Welcome "+name);
					}
					
				} 
				else 
				{

					System.out.println("Book Not found");
				}
					
				/*if(!rs.next())
				{
					System.out.println("user not found");
					System.exit(0);
				}*/
					
				int choiceForExit=0;
				CustomerServices customerImpl=(CustomerServices) new CustomerImplementation();
				while(choiceForExit!=5){
					System.out.println("enter the choice number");
					System.out.println("1. Issue Book");
			//		System.out.println("2. Submit Book");
				
					int choice= sc2.nextInt();
				   switch(choice)
				   {
				   case 1: 
					      System.out.println("Enter the book name");
					      String bookname=sc1.nextLine();
					     
					      customerImpl.IssueBook(bookname);
					     
					      break;
				   /*
				   case 2: 
					      System.out.println("Enter the book name");
				          String bookname1=sc.nextLine();
                          customerImpl.Submit(bookname1);				   
				          break;
				   */
				   }			
			
					
					
				}
			}catch(SQLException e){
				System.out.println(e);			
			
		}
		sc.close();
	}
}
