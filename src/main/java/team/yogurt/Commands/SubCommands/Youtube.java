package team.yogurt.Commands.SubCommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.yogurt.Managers.CommandManager;
import team.yogurt.Utilities;

import java.util.ArrayList;

import static team.yogurt.Utilities.color;

public class Youtube extends CommandManager {
    public static ArrayList<String> syncPlayers = new ArrayList<>();
    @Override
    public String getName() {
        return "youtube";
    }

    @Override
    public String getDescription() {
        return "Set your youtube channel";
    }

    @Override
    public String getSyntax() {
        return "/profiles youtube";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if(args.length == 1) {
            sender.sendMessage(Utilities.color("&cIngresa el url de tu canal: "));
            syncPlayers.add(sender.getName());
            Utilities.sendTitle((Player) sender, color("&fYou&ctube"), color("&fEscríbelo en el chat"), 1, 20, 1);
        }
    }
}
