package net.loganford.nieEditorImporter.json;

import lombok.Getter;
import lombok.Setter;
import net.loganford.nieEditorImporter.Instance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Room {
    private HashMap<String, EntityDefinition> entityDefinitionCache = new HashMap<>();
    private HashMap<String, Tileset> tilesetCache = new HashMap<>();

    @Getter @Setter private transient Project project = null;

    @Getter @Setter private String name;
    @Getter @Setter private int width, height;
    private List<Layer> layerList = new ArrayList<>();

    @Getter @Setter private int bgColorR = 128;
    @Getter @Setter private int bgColorG = 128;
    @Getter @Setter private int bgColorB = 128;

    public List<Instance> getInstances() {
        ArrayList<Instance> instances = new ArrayList<>();
        int depth = 0;

        for(Layer layer : layerList) {
            for(Entity entity : layer.entities) {
                Instance i = new Instance();
                i.setX(entity.x);
                i.setY(entity.y);
                i.setDepth(depth);
                i.setCustomProperties(entity.properties);
                i.setClassPath(getEntityDefinition(entity.entityDefinitionUUID).classPath);
                instances.add(i);
            }

            depth += 100;
        }

        return instances;
    }

    public List<Layer> getTileLayers() {
        ArrayList<Layer> tileLayers = new ArrayList<>();
        int depth = 50;

        for(Layer layer : layerList) {
            if(layer.tileMap != null && layer.tileMap.tilesetUuid != null) {
                layer.depth = depth;
                layer.setTileset(getTileset(layer.tileMap.tilesetUuid));
                tileLayers.add(layer);
            }

            depth += 100;
        }

        return tileLayers;
    }

    private EntityDefinition getEntityDefinition(String uuid) {
        EntityDefinition ed = entityDefinitionCache.get(uuid);
        if(ed == null) {
            ed = project.entityDefinitions.stream().filter(fe -> uuid.equals(fe.uuid)).findFirst().orElse(null);
            entityDefinitionCache.put(uuid, ed);
        }
        return ed;
    }

    private Tileset getTileset(String uuid) {
        Tileset ts = tilesetCache.get(uuid);
        if(ts == null) {
            ts = project.tilesets.stream().filter(ft -> uuid.equals(ft.uuid)).findFirst().orElse(null);
            tilesetCache.put(uuid, ts);
        }
        return ts;
    }
}
