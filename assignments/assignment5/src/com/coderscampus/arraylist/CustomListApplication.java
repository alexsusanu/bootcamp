package com.coderscampus.arraylist;

public class CustomListApplication {
    public static void main(String[] args){
        CustomList<Integer> customList = new CustomArrayList<>();
        for (int i = 1; i <= 11; i++){
            customList.add(i);
            System.out.println(i);
        }
    }
}
