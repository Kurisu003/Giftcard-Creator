package com.company;

import net.glxn.qrgen.image.ImageType;

import java.io.*;
import java.nio.file.Paths;

public class QRCode {

    public static void generate (String input) throws IOException {

        String cwd = Paths.get("").toAbsolutePath().toString();

        ByteArrayOutputStream out = net.glxn.qrgen.QRCode.from(input).to(ImageType.PNG).withSize(1800,1800).stream();

        File f = new File(cwd + "\\src\\com\\company\\QR.png");
        FileOutputStream fos = new FileOutputStream(f);

        fos.write(out.toByteArray());
        fos.flush();
    }


}
