package com.company;

import java.util.Scanner;

public class CardSelector {

    public static int inputPrompt(){
        System.out.println("1.) Tageskarte \n2.) Saisonskarte \n3.) Familienkarte");
        Scanner selection = new Scanner(System.in);
        int selected = selection.nextInt();

        if(selected == 1){
            System.out.println("1.) Bis 15 \n2.) Ab 16 \n3.) Ab 18");
            selected = selection.nextInt();
            return selected;
        }
        else if(selected == 2){
            System.out.println("1.) Erwachsene \n2.) Familie \n3.) Kinder");
            selected = selection.nextInt();
            return selected + 10;
        }
        else {
            //If Familienkarte is selected, 23 gets returned
            return 23;
        }
    }
}
