package team.yogurt;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import team.yogurt.Commands.ProfileCommand;
import team.yogurt.Listeners.PlayerJoinListener;
import team.yogurt.Managers.ConfigManager;
import team.yogurt.MySQL.MySQL;

public final class PandoraProfiles extends JavaPlugin {
    private static PandoraProfiles instance;
    private static MySQL sql;


    @Override
    public void onEnable() {
        instance = this;
        ConfigManager.createFolder();
        getConf();
        getMySql();
        sql = new MySQL();
        sql.createTables();
        registerCommands();
        registerListeners();
        // Plugin startup logic
    }
    @Override
    public void onDisable(){
        sql.disconnect();
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
    public static MySQL getSQL(){
        return sql;
    }
    private void registerCommands(){
        getCommand("profiles").setExecutor(new ProfileCommand(this));
    }
    private void registerListeners(){
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }
}
