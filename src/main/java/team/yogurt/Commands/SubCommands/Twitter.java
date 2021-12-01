package team.yogurt.Commands.SubCommands;

import org.bukkit.command.CommandSender;
import team.yogurt.Managers.CommandManager;

public class Twitter extends CommandManager {
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
        return "/profiles twitter <twitter>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {

    }
}
