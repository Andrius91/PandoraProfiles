package team.yogurt.Commands.SubCommands;

import org.bukkit.command.CommandSender;
import team.yogurt.Managers.CommandManager;

import static team.yogurt.Utilities.color;

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
        if(args.length != 2) {
            sender.sendMessage(color("&cComando incorrecto: " + getSyntax()));
        } else {
            try{
                int age = Integer.parseInt(args[1]);
                if(age > 6 && age < 100){
                    sender.sendMessage(String.valueOf(age));
                }else{
                    sender.sendMessage(color("&cTu edad es inválida para esta época"));
                }
            }catch (NumberFormatException e){
                sender.sendMessage(color("&cSolo puedes escribir números"));
            }

        }
    }
}
