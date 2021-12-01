package team.yogurt.Commands.SubCommands;

import org.bukkit.command.CommandSender;
import team.yogurt.Managers.CommandManager;

import java.util.ArrayList;

import static team.yogurt.Utilities.color;

public class Instagram extends CommandManager {
    public static ArrayList<String> syncPlayers = new ArrayList<>();
    @Override
    public String getName() {
        return "instagram";
    }

    @Override
    public String getDescription() {
        return "Set your instagram";
    }

    @Override
    public String getSyntax() {
        return "/profiles instagram <instagram>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if(args.length == 1) {
            sender.sendMessage(color("&aIngresa el url de tu instagram:"));
            syncPlayers.add(sender.getName());
        }
    }
}
