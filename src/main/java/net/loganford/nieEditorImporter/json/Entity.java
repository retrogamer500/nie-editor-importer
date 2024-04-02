package net.loganford.nieEditorImporter.json;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class Entity {
    protected int x;
    protected int y;
    protected String entityDefinitionUUID;
    protected HashMap<String, String> properties = new HashMap<>();
}
