package com.parim.view.loaders;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class FontLoader {
    private final static File fontFile = new File("src/main/resources/fonts/AGENCYB.TTF");
    public final static Font font;

    static {
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, fontFile);
        } catch (FontFormatException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    public final static Font titleFont = font.deriveFont(60f);
    public final static Font buttonFont = font.deriveFont(40f);
}
