package team.yogurt.Commands.SubCommands;

import org.bukkit.command.CommandSender;
import team.yogurt.Managers.CommandManager;

public class Instagram extends CommandManager {
    @Override
    public String getName() {
        return "Instagram";
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

    }
}
