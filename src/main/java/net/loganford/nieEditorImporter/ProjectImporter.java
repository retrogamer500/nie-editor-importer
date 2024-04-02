package net.loganford.nieEditorImporter;

import com.google.gson.Gson;
import lombok.Getter;
import net.loganford.nieEditorImporter.json.EntityDefinition;
import net.loganford.nieEditorImporter.json.Project;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ProjectImporter {
    @Getter private Project project;

    public void load(File file) {
        String json = "";
        try {
            json = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
        }
        catch(IOException e) {
            throw new RuntimeException(e);
        }
        load(json);
    }

    public void load(String json) {
        Gson gson = new Gson();
        project = gson.fromJson(json, Project.class);

        project.getRooms().forEach(r -> {
            r.setProject(project);
        });
    }
}
