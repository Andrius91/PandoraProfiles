package team.yogurt.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.yogurt.Commands.SubCommands.*;
import team.yogurt.Managers.CommandManager;
import team.yogurt.PandoraProfiles;

import java.util.ArrayList;

import static team.yogurt.PandoraProfiles.getConf;
import static team.yogurt.Utilities.color;

public class ProfileCommand implements CommandExecutor {
    private final PandoraProfiles plugin;
    ArrayList<CommandManager> commands = new ArrayList<>();
    private final String permission = getConf().getString("profiles.permission");
    public ProfileCommand(PandoraProfiles plugin){
        this.plugin = plugin;
        commands.add(new Age());
        commands.add(new Discord());
        commands.add(new Facebook());
        commands.add(new Instagram());
        commands.add(new Twitter());
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)){
            sender.sendMessage(color("&cSolo jugadores pueden usar este comando"));
        }else{
            if(sender.hasPermission(permission)){
                if (args.length <=0) {
                    sender.sendMessage(color("&cUse incorrectly!"));
                }else {
                    for (CommandManager cmd : getCommands()) {
                        if (args[0].equals(cmd.getName())) {
                            cmd.perform(sender, args);
                            return true;
                        }
                    }
                }
            }else{
                System.out.println("Debug");
            }
        }
        return true;
    }

    private ArrayList<CommandManager> getCommands(){
        return commands;
    }
}
