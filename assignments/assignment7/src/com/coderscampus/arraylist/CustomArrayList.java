package com.coderscampus.arraylist;

public class CustomArrayList<T> implements CustomList<T> {
	Object[] items = new Object[10];
	int size = 0;

	@Override
	public boolean add(T item) {
		if (size == items.length){
			items = increaseSize();
		}
		items[size] = item;
		size++;
		return true;
	}

	@Override
	public boolean add(int index, T item) throws IndexOutOfBoundsException {
	    if (size == items.length){
	    	items = increaseSize();
		}
	    for (int i = size - 1; i > index; i--){
	    	items[i+1] = items[i];
		}
	    items[index] = item;
	    size++;
		return true;
	}

	private Object[] increaseSize() {
		Object[] newArray = new Object[size * 2];
		for (int i = 0; i < size; i++){
			newArray[i] = items[i];
		}
		return newArray;
	}

	@Override
	public int getSize() {
		return size;
	}

	@Override
	public T get(int index) {
		return (T) items[index];
	}

	@Override
	public T remove(int index) throws IndexOutOfBoundsException {
		for (int i = size - 1; i < index; i--){
			items[i+1] = items[i];
		}
		return (T) items[index];
	}

}
