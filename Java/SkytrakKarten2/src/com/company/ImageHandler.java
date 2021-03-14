package com.company;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageHandler {
    public static BufferedImage readImage(String fileLocation) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File(fileLocation));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }

    public static BufferedImage overlayImages(BufferedImage bgImage, BufferedImage fgImage) {

        if (fgImage.getHeight() > bgImage.getHeight() || fgImage.getWidth() > fgImage.getWidth()) {
            JOptionPane.showMessageDialog(null,
                    "Foreground Image Is Bigger In One or Both Dimensions"
                            + "nCannot proceed with overlay."
                            + "nn Please use smaller Image for foreground");
            return null;
        }

        //Create a Graphics  from the background image
        Graphics2D g = bgImage.createGraphics();
        //Set Antialias Rendering
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        /*
         * Draw background image at location (0,0)
         * You can change the (x,y) value as required
         */
        g.drawImage(bgImage, 0, 0, null);

        /*
         * Draw foreground image at location (0,0)
         * Change (x,y) value as required.
         */
        g.drawImage(fgImage, 440, 3640, null);

        g.dispose();
        return bgImage;
    }

    public static void writeImage(BufferedImage img, String fileLocation, String extension) {
        try {
            BufferedImage bi = img;
            File outfile = new File(fileLocation);
            ImageIO.write(bi, extension, outfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
