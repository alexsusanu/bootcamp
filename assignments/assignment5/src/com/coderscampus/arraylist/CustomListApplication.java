package com.coderscampus.arraylist;

public class CustomListApplication {
    public static void main(String[] args){
        CustomList<Character> customList = new CustomArrayList<>();
        char j = 'a';
        for (int i = 0; i < 26; i++){
            customList.add(j);
            j++;
        }

        for (int i = 0; i < 26; i++){
            System.out.println(customList.get(i));
        }
    }
}
