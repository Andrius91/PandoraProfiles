package team.yogurt.Commands.SubCommands;

import org.apache.commons.lang.StringUtils;
import org.bukkit.command.CommandSender;
import team.yogurt.Managers.CommandManager;

import static team.yogurt.Utilities.color;

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
        if(args.length != 2) {
            sender.sendMessage(color("&cComando incorrecto: " + getSyntax()));
        }else{
            String discord = args[1];
            if(discord.length() < 1){
                sender.sendMessage(color("&cTu tag es muy corto"));
                return;
            }
            if(!discord.contains("#")){
                sender.sendMessage(color("&cNecesitas usar el #"));
                return;
            }
            String[] tag = discord.split("#");
            if(tag[0].length() > 16){
                sender.sendMessage(color("&cTu tag supera el límite"));
                return;
            }
            if(StringUtils.isNumeric(tag[1])){
                if(tag[1].equalsIgnoreCase("0000") || tag[1].length() != 4){
                    sender.sendMessage(color("&cIngresa bien tu tag: " + tag[1]));
                }else{
                    sender.sendMessage(color("&a"+ discord));
                }
            }else{
                sender.sendMessage(color("&cSolo puedes poner numeros po"));
            }


        }
    }
}
