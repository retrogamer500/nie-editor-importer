package net.loganford.nieEditorImporter.json;

import lombok.Getter;
import lombok.Setter;

public class Tileset {
    @Getter protected String name;
    @Getter protected String engineResourceKey;
    protected String imagePath;
    @Getter protected int tileWidth;
    @Getter protected int tileHeight;

    protected String uuid;
}
