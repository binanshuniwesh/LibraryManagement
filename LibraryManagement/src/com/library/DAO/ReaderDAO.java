package com.library.DAO;





import java.util.ArrayList;

import com.library.bean.Reader;

//import com.hotel.bean.Item;
//import com.hotel.exceptions.CategoryNotFoundException;

public interface ReaderDAO {
	public void addReadertoDB(Reader reader);

	public void updateReadertoDB(Reader reader);

	public void deleteReadertoDB(int readerId);

	public ArrayList<Reader> getAllReaderfromDB();

	//public ArrayList<Item> getItemsByCategoryfromDB(String category) throws CategoryNotFoundException;
 
}
