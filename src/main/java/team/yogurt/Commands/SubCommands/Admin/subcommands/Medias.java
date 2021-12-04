package team.yogurt.Commands.SubCommands.Admin.subcommands;

import org.bukkit.command.CommandSender;
import team.yogurt.Commands.ProfileCommand;
import team.yogurt.Managers.CommandManager;

import static team.yogurt.Utilities.color;

public class Medias extends CommandManager {
    @Override
    public String getName() {
        return "medias";
    }

    @Override
    public String getDescription() {
        return "Show the media list";
    }

    @Override
    public String getSyntax() {
        return "/profiles admin medias";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if (args.length == 2){
            sender.sendMessage(color("&5Medias:"));
            sender.sendMessage(" ");
            for(CommandManager cmds : ProfileCommand.getCommands()){
                if(!cmds.getName().equalsIgnoreCase("admin")){
                    sender.sendMessage(color("&7- &d"+cmds.getName()));
                }
            }
        }
    }
}
