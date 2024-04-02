package net.loganford.nieEditorImporter.json;

import lombok.Getter;
import lombok.Setter;

public class TileMap {
    protected String tilesetUuid;

    protected int width = 1;
    protected int height = 1;

    protected short[] tileData = new short[2 * width * height];
}
