package org.coalery.map;

import java.awt.image.BufferedImage;

public class MapCell {

    private String name;
    private BufferedImage cellImage;

    public MapCell(String name, BufferedImage cellImage) {
        this.name = name;
        this.cellImage = cellImage;
    }

}
