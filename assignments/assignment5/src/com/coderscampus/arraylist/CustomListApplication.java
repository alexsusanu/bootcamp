package com.coderscampus.arraylist;

public class CustomListApplication {
    public static void main(String[] args){
        CustomList<Integer> customList = new CustomArrayList<>();
        for (int i = 0; i < 101; i++){
            customList.add(i);
            System.out.println(customList.get(i));
        }
    }
}
