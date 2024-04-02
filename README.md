# Easily import levels from No Idea Editor into your project

## Usage
```
ProjectImporter importer = new ProjectImporter();
importer.load(new File("C:\\Users\\Budget Breaker\\Documents\\house.nep"));

Room room = importer.getProject().getRoom("upstairs_hallway_1");

System.out.println("Room bg color: " + room.getBgColorR() + "," + room.getBgColorG() + "," + room.getBgColorB());

room.getTileLayers().forEach(tl -> {
    System.out.println("Tileset resource key: " + tl.getTileset().getEngineResourceKey());
    System.out.println("Tileset settings: " + tl.getTileset().getTileWidth() + "," + tl.getTileset().getTileHeight());
    System.out.println("Tileset depth: " + tl.getDepth());
    for(Tile tile : tl.getTiles()) {
        System.out.println("Tile position (in tile space): " + tile.getRoomX() + "," + tile.getRoomY());
        System.out.println("Position in tilemap (in tile space): " + tile.getTileX() + "," + tile.getTileY());
    }
});

room.getInstances().forEach(i -> {
    System.out.println("Instance class path: " + i.getClassPath());
    System.out.println("Instance depth: " + i.getDepth());
    System.out.println("Instance position: " + i.getX() + "," + i.getY());
    if(i.getCustomProperties() != null) {
        System.out.println("Custom properties size: " + i.getCustomProperties().size());
    }
});
```
