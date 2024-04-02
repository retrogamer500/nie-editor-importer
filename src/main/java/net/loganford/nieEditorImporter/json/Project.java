package net.loganford.nieEditorImporter.json;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class Project {


    @Getter @Setter private String projectName;
    protected List<Tileset> tilesets = new ArrayList<>();
    protected List<EntityDefinition> entityDefinitions = new ArrayList<>();
    @Getter @Setter private List<Room> rooms = new ArrayList<>();

    public Room getRoom(String roomName) {
        return rooms.stream().filter(r -> roomName.equals(r.getName())).findFirst().orElse(null);
    }
}
