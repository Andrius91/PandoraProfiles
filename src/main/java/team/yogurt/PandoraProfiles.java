package team.yogurt;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import team.yogurt.Commands.ProfileCommand;
import team.yogurt.Managers.ConfigManager;
import team.yogurt.MySQL.MySQL;

public final class PandoraProfiles extends JavaPlugin {
    private static PandoraProfiles instance;
    private MySQL sql;


    @Override
    public void onEnable() {
        instance = this;
        ConfigManager.createFolder();
        getConf();
        getMySql();
        sql = new MySQL();
        sql.createTables();
        registerCommands();
        // Plugin startup logic
    }

    public static PandoraProfiles getInstance() {
        return instance;
    }
    public static FileConfiguration getConf(){
        return ConfigManager.getFile("config.yml");
    }

    public static FileConfiguration getMySql(){
        return ConfigManager.getFile("mysql.yml");
    }
    private void registerCommands(){
        getCommand("profiles").setExecutor(new ProfileCommand(this));
    }
}
