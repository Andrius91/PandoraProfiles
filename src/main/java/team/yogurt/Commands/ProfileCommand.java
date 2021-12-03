package team.yogurt.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import team.yogurt.Commands.SubCommands.*;
import team.yogurt.Commands.SubCommands.Admin.Admin;
import team.yogurt.Managers.CommandManager;

import java.util.ArrayList;

import static team.yogurt.PandoraProfiles.getConf;
import static team.yogurt.Utilities.color;

public class ProfileCommand implements CommandExecutor {
    private static final ArrayList<CommandManager> commands = new ArrayList<>();
    private final String permission = getConf().getString("profiles.permission");

    public ProfileCommand() {
        commands.add(new Age());
        commands.add(new Discord());
        commands.add(new Facebook());
        commands.add(new Instagram());
        commands.add(new Twitter());
        commands.add(new Twitch());
        commands.add(new Youtube());
        commands.add(new Admin());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission(permission)) {
            if (args.length > 0) {
                for (CommandManager cmd : getCommands()) {
                    if (args[0].equalsIgnoreCase(cmd.getName())) {
                        cmd.perform(sender, args);
                        return true;
                    }
                }
            }
            sendHelpList(sender);
        }else{
            sender.sendMessage(color(getConf().getString("profiles.no-permissions")));
        }
        return true;
    }
    private void sendHelpList(CommandSender sender){
        sender.sendMessage(color("&5Commands:"));
        sender.sendMessage(" ");
        for(CommandManager cmd : getCommands()) {
            sender.sendMessage(color("&d" + cmd.getSyntax() + "&f - &7" + cmd.getDescription()));
        }
    }
    public static ArrayList<CommandManager> getCommands() {
        return commands;
    }
}
