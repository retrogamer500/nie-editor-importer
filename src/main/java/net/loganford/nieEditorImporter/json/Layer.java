package net.loganford.nieEditorImporter.json;

import lombok.Getter;
import lombok.Setter;
import net.loganford.nieEditorImporter.Tile;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    protected String name;
    protected List<Entity> entities = new ArrayList<>();
    protected TileMap tileMap = new TileMap();

    private transient List<Tile> tileList = null;

    @Getter protected int depth;
    @Getter @Setter protected Tileset Tileset;

    public List<Tile> getTiles() {
        if(tileList != null) {
            return tileList;
        }

        tileList = new ArrayList<>();

        for(int i = 0; i < tileMap.width; i++) {
            for(int j = 0; j < tileMap.height; j++) {
                int pos = (i + j * tileMap.width) * 2;

                int tileX = tileMap.tileData[pos] - 1;
                int tileY = tileMap.tileData[pos + 1] - 1;

                if(tileX >= 0 && tileY >= 0) {
                    tileList.add(new Tile(i, j, tileX, tileY));
                }
            }
        }

        return tileList;
    }
}
