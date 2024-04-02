package net.loganford.nieEditorImporter;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

public class Instance {
    @Getter @Setter private int x;
    @Getter @Setter private int y;
    @Getter @Setter private int depth;

    @Getter @Setter private transient String classPath;
    @Getter @Setter private transient HashMap<String, String> customProperties;
}
