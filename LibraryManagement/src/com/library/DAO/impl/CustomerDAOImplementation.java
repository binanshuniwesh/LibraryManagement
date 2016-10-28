package com.library.DAO.impl;



import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;





import com.library.DAO.ConnectionDAO;
import com.library.DAO.CustomerDAO;
//import com.library.bean.Customer;
//import com.library.exceptions.ReaderIdNotFoundException;

import java.sql.*;

public class CustomerDAOImplementation implements CustomerDAO {

	static Connection connection;
	 static Logger logger = Logger.getLogger(CustomerDAOImplementation.class);
	int bId1, price1;
	String bname1, aname1;

	@Override
	public void addCustomertoDB(String bookname) {
		logger.info("Entered into addCustomertoDB ");
        System.out.println("Book name is:"+bookname);
		connection = ConnectionDAO.openConnection();
		PreparedStatement statement = null;
		// PropertyConfigurator.configure("log4j.properties");
		try {

			String getQuery = "Select * from Book where bname='" + bookname +"' ";
            System.out.println(getQuery);
			statement = connection.prepareStatement(getQuery);
			ResultSet rs2 = statement.executeQuery();
		//	System.out.println("rs2 is      "+rs2.next());
			if (rs2.next()) {
				System.out.println("Book found");
				bId1 = rs2.getInt(1);
				bname1= rs2.getString(2);
				aname1 = rs2.getString(3);
				price1 = rs2.getInt(4);

				System.out.println("Book ID:" + bId1 + "Book name" + bname1 + "Author name" + aname1 + "Price" + price1);
			}
			else
			{
				System.out.println("book not found");
			}

		} catch (SQLException e) {
			 logger.error(e.getMessage());
			System.out.println(e);
		} 
		
		finally {
			try {
				if (statement != null)
					statement.close();
				ConnectionDAO.closeConnection();
				 logger.info("databasehhjk closed");
				System.out.println("database closed");

			} catch (SQLException e) {
				 logger.error(e.getMessage());
				System.out.println(e);
			}
		}

	}

}
