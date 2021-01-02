package com.coderscampus.arraylist;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	int size = 0;

	@Override
	public boolean add(T item) {
		items[size] = item;
		size++;
		return true;
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public T get(int index) {
		return null;
	}
	
}
