package com.coderscampus.arraylist;

public class CustomListApplication {
    public static void main(String[] args){
        CustomList<Integer> customList = new CustomArrayList<>();
        int j = 1;
        for (int i = 0; i < 10; i++){
            customList.add(j);
            j++;
        }

        customList.add(3, 100);

        for (int i = 0; i < customList.getSize(); i++){
            System.out.println(customList.get(i));
        }
    }
}
