package net.loganford.nieEditorImporter;

import lombok.Getter;

public class Tile {
    @Getter private int roomX;
    @Getter private int roomY;
    @Getter private int tileX;
    @Getter private int tileY;

    public Tile(int x, int y, int tileX, int tileY) {
        this.roomX = x;
        this.roomY = y;
        this.tileX = tileX;
        this.tileY = tileY;
    }
}
