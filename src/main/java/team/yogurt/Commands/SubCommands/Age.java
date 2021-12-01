package team.yogurt.Commands.SubCommands;

import org.bukkit.command.CommandSender;
import team.yogurt.Managers.CommandManager;
import team.yogurt.Utilities;

public class Age extends CommandManager {
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
        return "/profiles age <age>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if (args.length <=1) {
            sender.sendMessage(Utilities.color("&cFaltan args: " + getSyntax()));
        }else{
            String age = args[1];
            sender.sendMessage(age);
        }
    }
}
