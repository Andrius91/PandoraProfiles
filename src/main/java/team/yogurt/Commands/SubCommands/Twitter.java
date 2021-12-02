package team.yogurt.Commands.SubCommands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.yogurt.Managers.CommandManager;
import team.yogurt.PandoraProfiles;
import team.yogurt.Utilities;

import java.util.ArrayList;

import static team.yogurt.Utilities.color;

public class Twitter extends CommandManager {
    public static ArrayList<String> syncPlayers = new ArrayList<>();
    @Override
    public String getName() {
        return "twitter";
    }

    @Override
    public String getDescription() {
        return "Set your twitter";
    }

    @Override
    public String getSyntax() {
        return "/profiles twitter";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if(args.length == 1) {
            sender.sendMessage(color("&aIngresa el url de tu twitter:"));
            syncPlayers.add(sender.getName());
            Utilities.sendTitle((Player) sender, color("&9Twitter"), color("&fEscríbelo en el chat"), 1, 20, 1);
        }
    }
}
