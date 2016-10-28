package com.library.services.impl;

/*public class ReaderImplementation {

}*/


import java.util.ArrayList;

import com.library.DAO.ReaderDAO;

import com.library.DAO.impl.ReaderDAOImplementation;
import com.library.bean.Reader;
import com.library.services.ReaderServices;

public class ReaderImplementation implements ReaderServices {
	
	
		ReaderDAO readerDAO= new ReaderDAOImplementation();
	@Override
	public void AddReader(Reader reader) {
		
		readerDAO.addReadertoDB(reader);

	}

	@Override
	public void UpdateReader(Reader reader) {
		readerDAO.updateReadertoDB(reader);

	}

	@Override
	public void DeleteReader(int readerId) {
		readerDAO.deleteReadertoDB(readerId);

	}

	@Override
	public ArrayList<Reader> GetReaderList() {
		return readerDAO.getAllReaderfromDB();
		
	}

	/*@Override
	public ArrayList<Item> getItemsByCategory(String category) throws CategoryNotFoundException {
		return itemDAO.getItemsByCategoryfromDB(category);
	
	}
*/
}
