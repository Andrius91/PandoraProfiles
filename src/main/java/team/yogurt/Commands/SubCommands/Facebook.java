package team.yogurt.Commands.SubCommands;

import org.bukkit.command.CommandSender;
import team.yogurt.Managers.CommandManager;

public class Facebook extends CommandManager {
    @Override
    public String getName() {
        return "facebook";
    }

    @Override
    public String getDescription() {
        return "Set your facebook";
    }

    @Override
    public String getSyntax() {
        return "/profiles facebook <facebook>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {

    }
}
