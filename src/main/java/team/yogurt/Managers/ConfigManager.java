package team.yogurt.Managers;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import team.yogurt.PandoraProfiles;
import team.yogurt.Utilities;

import java.io.File;
import java.io.IOException;

public class ConfigManager {


    public static void createFolder(){
        if (!PandoraProfiles.getInstance().getDataFolder().exists()){
            PandoraProfiles.getInstance().getDataFolder().mkdir();
        }
    }
    public static FileConfiguration getFile(String filename){

        File file = new File(PandoraProfiles.getInstance().getDataFolder(), filename);
        FileConfiguration config = new YamlConfiguration();
        if (!file.exists()){
            file.getParentFile().mkdir();
            PandoraProfiles.getInstance().saveResource(filename, true);
            PandoraProfiles.getInstance().getLogger().info(Utilities.color(filename + " &aregistered!"));
        }
        try {
            config.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
        return config;
    }
}
