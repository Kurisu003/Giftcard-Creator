package com.company;

import java.awt.image.BufferedImage;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    static String cwd = Paths.get("").toAbsolutePath().toString();


    public static void main(String[] args) throws IOException {

        //Adds direct path to cwd as cwd only returns directory of project
        cwd += "\\src\\com\\company";
        String vorlage = "";

        /* 1 Tageskarte bis 15
         * 2 Tageskarte ab 16
         * 3 Tageskarte ab 18
         *
         * 11 Saisonskarte Erwachsene
         * 12 Saisonskarte Familie
         * 13 Saisonskarte Kind
         *
         * 23 Familienkarte
         */

        int selectedCard = CardSelector.inputPrompt();
        String qrText = switch (selectedCard) {
            case (1) -> "Tageskarte bis 15 - ";
            case (2) -> "Tageskarte ab 16 - ";
            case (3) -> "Tageskarte ab 18 - ";

            case (11) -> "Saisonskarte Erwachsene - ";
            case (12) -> "Saisonskarte Familie - ";
            case (13) -> "Saisonskarte Kinder - ";

            case (23) -> "Familienkarte - ";

            default -> "";
        };

        switch (selectedCard){
            case (1) -> vorlage = "TagesKarteVorlage.png";
            case (2) -> vorlage = "TagesKarteVorlage.png";
            case (3) -> vorlage = "TagesKarteVorlage.png";

            case (11) -> vorlage = "SaisonsKarteVorlage.png";
            case (12) -> vorlage = "SaisonsKarteVorlage.png";
            case (13) -> vorlage = "SaisonsKarteVorlage.png";

            case (23) -> vorlage = "FamilieKarteVorlage.png";
        }

        Scanner selection = new Scanner(System.in);

        System.out.println("Wo starten?");
        int start = selection.nextInt();

        System.out.println("Wo enden?");
        int end = selection.nextInt();

        String temp = "";

        BufferedImage bgImage = ImageHandler.readImage(cwd + "\\Vorlagen\\" + vorlage);

        while(start <= end){

            temp = qrText + start;

            System.out.println(temp);

            //Create QR Code
            QRCode.generate(temp);

            //Load created QR Code
            BufferedImage qrCode = ImageHandler.readImage(cwd + "\\QR.png");

            //Create combined image
            //BufferedImage overlayedImage =
            ImageHandler.writeImage(ImageHandler.overlayImages(bgImage, qrCode), cwd + "\\" + temp + ".png", "PNG");

//            if (overlayedImage != null){
//                ImageHandler.writeImage(overlayedImage, cwd + "\\" + temp + ".png", "PNG");
//                System.out.println("Overlay Completed...");
//            }else
//                System.out.println("Problem With Overlay...");

            start++;
            temp = "";
        }
    }


}
