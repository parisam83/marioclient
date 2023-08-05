package com.parim.view.loaders;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ImageLoader {
    private static ImageLoader instance;
    private HashMap<String, Image> imagesCollection = new HashMap<>();

    public Image loadImage(String directory, int width, int height) {
        String key = directory + String.valueOf(width) + "," + String.valueOf(height);
        if (imagesCollection.containsKey(key)) {
            return imagesCollection.get(key);
        }

        Image image;
        try {
            image = ImageIO.read(new File("src/main/resources/objects/" + directory + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        image = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        imagesCollection.put(directory, image);
        return image;
    }

    public static ImageLoader getInstance() {
        if (instance == null) instance = new ImageLoader();
        return instance;
    }
}
