package team.yogurt.Commands.SubCommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.yogurt.Managers.CommandManager;
import team.yogurt.Utilities;

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
        return "/profiles age";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if(args.length == 1) {
            sender.sendMessage(color("&aIngresa tu edad:"));
            syncPlayers.add(sender.getName());
            Utilities.sendTitle((Player) sender, color("&5Edad"), color("&fEscríbelo en el chat"), 1, 20, 1);

        }
    }
}
