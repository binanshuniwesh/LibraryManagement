package com.library.services;

import java.util.ArrayList;

import com.library.bean.Reader;

//import com.hotel.bean.Item;
//import com.hotel.exceptions.CategoryNotFoundException;

public interface ReaderServices {
	public void AddReader(Reader reader);

	public void UpdateReader(Reader reader);

	public void DeleteReader(int readerId);

	public ArrayList<Reader> GetReaderList();

	//public ArrayList<Item> getItemsByCategory(String category) throws CategoryNotFoundException;
}
