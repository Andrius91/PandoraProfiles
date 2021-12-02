package team.yogurt.Commands.SubCommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.yogurt.Managers.CommandManager;
import team.yogurt.Utilities;

import java.util.ArrayList;

import static team.yogurt.Utilities.color;

public class Twitch extends CommandManager {
    public static ArrayList<String> syncPlayers = new ArrayList<>();
    @Override
    public String getName() {
        return "twitch";
    }

    @Override
    public String getDescription() {
        return "Set your twitch channel";
    }

    @Override
    public String getSyntax() {
        return "/profiles twitch";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if(args.length == 1){
            sender.sendMessage(Utilities.color("&dIngresa el url de tu twitch:"));
            syncPlayers.add(sender.getName());
            Utilities.sendTitle((Player) sender, color("&5Twitch"), color("&fEscríbelo en el chat"), 1, 20, 1);

        }
    }
}
