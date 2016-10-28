package com.library.DAO.impl;


import java.util.ArrayList;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;

import com.library.DAO.ConnectionDAO;
import com.library.DAO.ReaderDAO;
import com.library.bean.Reader;
//import com.library.exceptions.ReaderIdNotFoundException;

import java.sql.*;
import java.sql.Connection;

import java.sql.SQLException;
public class ReaderDAOImplementation implements ReaderDAO {

	static Connection connection;
	//static Logger logger = Logger.getLogger(ItemDAO.class);


	@Override
	public void addReadertoDB(Reader reader) {
		connection = ConnectionDAO.openConnection();
		String insertQuery = "Insert into LOGIN values(?,?,?,?)";
		PreparedStatement statement = null;
	//	PropertyConfigurator.configure("log4j.properties");
		try {
			statement = connection.prepareStatement(insertQuery);
			statement.setInt(1, reader.getId());
			statement.setString(2, reader.getPass());
			statement.setString(3, reader.getName());
			statement.setString(4, reader.getDesignation());
		//	statement.setString(5, item.getCategory());
		//	statement.setString(6, item.getAvailability());
			statement.executeUpdate();
		//	logger.info("Inserted Sucessfully");
			System.out.println("Inserted");
		} catch (SQLException e) {
			//logger.error(e.getMessage());
			System.out.println(e);
		}finally {
			try {
				if (statement != null)
					statement.close();
				ConnectionDAO.closeConnection();
				//logger.info("database closed");
				System.out.println("database closed");
				
			} catch (SQLException e) {
				//logger.error(e.getMessage());
				System.out.println(e);
			}
		}

	}

	@Override
	public void updateReadertoDB(Reader reader) {
		connection = ConnectionDAO.openConnection();
		String updateQuery = "Update LOGIN set name=?,pass=?,desg=? where id=?";
		PreparedStatement statement = null;
				try {
			statement = connection.prepareStatement(updateQuery);
			//statement.setInt(1,reader.getId());
			
			statement.setString(1, reader.getName());
			statement.setString(2, reader.getPass());
		
			
			statement.setString(3, reader.getDesignation());
			statement.setInt(4,reader.getId());
		//	statement.setString(4, item.getCategory());
		//	statement.setString(5, item.getAvailability());
		//	statement.setInt(6,item.getItemId());
			statement.execute();
		  // logger.info("updated the changes sucessfully");	
			System.out.println("updated the changes sucessfully");
		} catch (SQLException e) {
			//logger.error(e.getMessage());
			System.out.println(e);
		}finally {
			try {
				if (statement != null)
					statement.close();
				ConnectionDAO.closeConnection();
			//	logger.info("database closed");
				System.out.println("database closed");
			} catch (SQLException e) {
				//logger.error(e.getMessage());
				System.out.println(e);
			}
		}


	}

	@Override
	public void deleteReadertoDB(int readerId) {
		connection = ConnectionDAO.openConnection();
		String deleteQuery = "delete from LOGIN where id=?";
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(deleteQuery);
            statement.setInt(1, readerId);
			statement.execute();
			System.out.println("deleted sucessfully");
		} catch (SQLException e) {
			//logger.error(e.getMessage());
			System.out.println(e);
		}finally {
			try {
				if (statement != null)
					statement.close();
				ConnectionDAO.closeConnection();
				//logger.info("database closed");
				System.out.println("database closed");
			} catch (SQLException e) {
				//logger.error(e.getMessage());
				System.out.println(e);
			}
		}


	}

	@Override
	public ArrayList<Reader> getAllReaderfromDB() {
       ArrayList<Reader> reader1=new ArrayList<Reader>();
       PreparedStatement statement=null;
		try{
			connection = ConnectionDAO.openConnection();
			String getQuery="Select * from LOGIN ";
			statement=connection.prepareStatement(getQuery);
			ResultSet rs=statement.executeQuery();
			//logger.info("showing all the items");
			System.out.println("Showing all readers");
			while(rs.next()){
				int readerId=rs.getInt(1);
				String readerPass=rs.getString(2);
				String readerName=rs.getString(3);
				String readerDesg=rs.getString(4);
				Reader reader2=new Reader();
			//	item.setAvailability(rs.getString(6));
			//	item.setCategory(rs.getString(5));
			//	item.setCookingTime(cookingTime);
			//	item.setPrice(price);
				 reader2.setReaderId(readerId);
				 reader2.setReaderPass(readerPass);
				 reader2.setReaderName(readerName);
		    
			     reader2.setReaderDesg(readerDesg);
				 reader1.add(reader2);
			}
		}catch(SQLException e){
			System.out.println(e);
		}finally {
			try {
				if (statement != null)
				   statement.close();
				ConnectionDAO.closeConnection();
		System.out.println("database closed");
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return reader1;
	}

	/*@Override
	public ArrayList<Item> getItemsByCategoryfromDB(String category)throws CategoryNotFoundException {
		ArrayList<Item> itemList=new ArrayList<Item>();
	       PreparedStatement statement=null;
			try{
				connection = ConnectionDAO.openConnection();
				statement=connection.prepareStatement("select * from Items where item_availability ='y' and item_category=?");
				statement.setString(1, category);
				ResultSet rs=statement.executeQuery();
				while(rs.next()){
					int itemId=rs.getInt(1);
					String itemName=rs.getString(2);
					int price=rs.getInt(3);
					int cookingTime=rs.getInt(4);
					Item item=new Item();
					item.setAvailability(rs.getString(6));
					item.setCategory(rs.getString(5));
					item.setCookingTime(cookingTime);
					item.setPrice(price);
					item.setItemId(itemId);
					item.setName(itemName);
					itemList.add(item);
				}
			}catch(Exception e){
				logger.error(e.getMessage());
			}finally {
				try {
					if (statement != null)
					   statement.close();
					ConnectionDAO.closeConnection();
					//logger.info("database closed");
				
				} catch (SQLException e) {
					logger.error(e.getMessage());
				}
			}
			if(itemList.size()==0)
			throw new CategoryNotFoundException("category not found");
			//logger.info("showing items by category");
			return itemList;
	}*/

}
