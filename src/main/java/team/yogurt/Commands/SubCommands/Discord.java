package team.yogurt.Commands.SubCommands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import team.yogurt.Managers.CommandManager;
import team.yogurt.Utilities;

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
        return "/profiles discord";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if(args.length == 1) {
            sender.sendMessage(color("&aIngresa tu discord:"));
            syncPlayers.add(sender.getName());
            Utilities.sendTitle((Player) sender, color("&bDiscord"), color("&fEscríbelo en el chat"), 1, 20, 1);

        }



        }

}
