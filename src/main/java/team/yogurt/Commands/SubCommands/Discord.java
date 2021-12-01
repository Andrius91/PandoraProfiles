package team.yogurt.Commands.SubCommands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandSender;
import team.yogurt.Managers.CommandManager;

import java.util.ArrayList;

import static team.yogurt.Utilities.color;

public class Discord extends CommandManager {
    public static ArrayList<String> syncPlayers = new ArrayList<>();
    @Override
    public String getName() {
        return "discord";
    }

    @Override
    public String getDescription() {
        return "Set your discord";
    }

    @Override
    public String getSyntax() {
        return "/profiles discord <Discord#9999>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if(args.length == 1) {
            sender.sendMessage(color("&aIngresa tu discord:"));
            syncPlayers.add(sender.getName());
        }



        }

}
