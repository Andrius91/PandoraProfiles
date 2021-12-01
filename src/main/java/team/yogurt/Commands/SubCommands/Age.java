package team.yogurt.Commands.SubCommands;

import org.bukkit.command.CommandSender;
import team.yogurt.Managers.CommandManager;

import java.util.ArrayList;

import static team.yogurt.Utilities.color;

public class Age extends CommandManager {
    public static ArrayList<String> syncPlayers = new ArrayList<>();
    @Override
    public String getName() {
        return "age";
    }

    @Override
    public String getDescription() {
        return "Set your age";
    }

    @Override
    public String getSyntax() {
        return "/profiles age <age>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if(args.length == 1) {
            syncPlayers.add(sender.getName());
            sender.sendMessage(color("&aIngresa tu edad:"));
        }
    }
}
