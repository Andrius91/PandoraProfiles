package team.yogurt.Commands.SubCommands;

import org.bukkit.command.CommandSender;
import team.yogurt.Managers.CommandManager;

public class Discord extends CommandManager {
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

    }
}
