package com.library.client;

import java.util.ArrayList;
import java.util.Scanner;

import com.library.bean.Reader;
import com.library.exceptions.ReaderIdNotFoundException;
import com.library.services.ReaderServices;
import com.library.services.impl.ReaderImplementation;

//import com.hotel.bean.Item;
//import com.hotel.exceptions.CategoryNotFoundException;
//import com.hotel.exceptions.ItemIdNotFoundException;
//import com.hotel.service.ItemServices;
//import com.hotel.service.impl.ItemImplementation;

public class Admin {

	public static void main(String[] args) throws ReaderIdNotFoundException {
    
    
		System.out.println("welcome admin");
		Scanner scanner= new Scanner(System.in);
		int choiceForExit=0;
		ArrayList<Reader> readerList=null;
		
	/*	ItemServices itemImpl=new ItemImplementation();
		while(choiceForExit!=6){
			System.out.println("enter the choice number");
			System.out.println("1. get the list of all items");
			System.out.println("2. get the list of items by category");
			System.out.println("3. update an item information");
			System.out.println("4. set an item as unavailable.");
			System.out.println("5. add a new item");
			System.out.println("6. exit ");
			*/
		
			ReaderServices readerImpl=(ReaderServices) new ReaderImplementation();
			while(choiceForExit!=5){
				System.out.println("enter the choice number");
				System.out.println("1. show all Reader");
				System.out.println("2. add new Reader");
				System.out.println("3. update Reader");
				System.out.println("4. delete Reader");
				System.out.println("5. exit ");
			
			int choice= scanner.nextInt();
			
			switch(choice){
			case 1:
				readerList=readerImpl.GetReaderList();
			     for(Reader reader1:readerList){
			    	 System.out.println(reader1);
			     }
				break;
			/*case 2:
				System.out.println("Add new Reader");
				String category=scanner.next();
				try{
				 itemList=itemImpl.AddReader(category);
				 for(Item item1:itemList){
			    	 System.out.println(item1);
			     }
				}catch(CategoryNotFoundException e){
					System.out.println("Category Not Found");
				}
			     
				break;*/
				
			case 2:
				Reader newreader= new Reader();
				System.out.println("enter the Readerid");
				int readerId1=scanner.nextInt();
				newreader.setReaderId(readerId1);
				scanner.nextLine();
				System.out.println("enter the password");
				String readerPass1=scanner.nextLine();
				newreader.setReaderPass(readerPass1);
				System.out.println("enter the name");
				String readerName1=scanner.nextLine();
				newreader.setReaderName(readerName1);
				System.out.println("enter the designation");
				String readerDesg1=scanner.nextLine();
				newreader.setReaderDesg(readerDesg1);
				scanner.nextLine();
				readerImpl.AddReader(newreader);
				break;
				
			case 3:
				readerList=readerImpl.GetReaderList();
				for(Reader reader1:readerList){
			    	 System.out.println(reader1);
			     }
				Reader reader= new Reader();
				System.out.println("enter the id");
				int readerId=scanner.nextInt();
				boolean flag=false;
				for(Reader reader1:readerList){
					if(reader1.getReaderId()==readerId)
						flag=true;
				}
				try{
				if(!flag){
					throw new ReaderIdNotFoundException("ReaderIdNotFound");
				}
			    reader.setReaderId(readerId);
				scanner.nextLine();
				System.out.println("enter the Reader name");
				String readerName=scanner.nextLine();
				reader.setReaderName(readerName);
				System.out.println("enter the password");
				String readerPass=scanner.nextLine();
				reader.setReaderPass(readerPass);
				System.out.println("enter the designation");
				String readerdesg=scanner.nextLine();
				reader.setReaderDesg(readerdesg);
			
			     readerImpl.UpdateReader(reader);
				}catch(ReaderIdNotFoundException e){
					System.out.println("ReaderIdNotFound");
				}
				break;
			case 4:
				readerList=readerImpl.GetReaderList();
				for(Reader reader1:readerList){
			    	 System.out.println(reader1);
			     }
				System.out.println("enter the reader id");
				int id= scanner.nextInt();
				flag=false;
				for(Reader reader1:readerList){
					if(reader1.getReaderId()==id)
						flag=true;
				}
				try{
				if(!flag){
					throw new ReaderIdNotFoundException("ReaderIdNotFound");
				}
				
				readerImpl.DeleteReader(id);
				}catch(ReaderIdNotFoundException e){
				System.out.println("ReaderId not found");	
				}
				break;
		/*	case 5:
				Item newitem= new Item();
				System.out.println("enter the itemid");
				int itemId1=scanner.nextInt();
				newitem.setItemId(itemId1);
				scanner.nextLine();
				System.out.println("enter the item name");
				String itemName1=scanner.nextLine();
				newitem.setName(itemName1);
				System.out.println("enter the item price");
				int itemPrice1=scanner.nextInt();
				newitem.setPrice(itemPrice1);
				System.out.println("enter the item cooking time");
				int itemCookingTime1=scanner.nextInt();
				newitem.setCookingTime(itemCookingTime1);
				scanner.nextLine();
				System.out.println("enter the item category");
				String itemCategory1=scanner.nextLine();
				newitem.setCategory(itemCategory1);
				System.out.println("enter the item availability");
				String itemAvailability1=scanner.next();
				newitem.setAvailability(itemAvailability1);
				itemImpl.addItem(newitem);
				break; */
			case 5:
				System.out.println("thankyou for stopping by");
				choiceForExit=5;
				break;
			default:
					System.out.println("wrong choice");
					break;
			}
		}
		scanner.close();
	}
}
