package com.library.services.impl;

/*public class ReaderImplementation {

}*/




import com.library.DAO.CustomerDAO;

import com.library.DAO.impl.CustomerDAOImplementation;

import com.library.services.CustomerServices;


public class CustomerImplementation implements CustomerServices {
	
	
		CustomerDAO customerDAO= new CustomerDAOImplementation();
	@Override
	public void IssueBook(String bookname) {
		
		customerDAO.addCustomertoDB(bookname);

	}

	//@Override
	/*public void Submit(String bookname) {
		customerDAO.updateCustomertoDB(bookname);

	}*/

	
}
