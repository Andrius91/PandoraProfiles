package team.yogurt.Commands.SubCommands.Admin.subcommands;

import org.bukkit.command.CommandSender;
import team.yogurt.Commands.ProfileCommand;
import team.yogurt.Managers.CommandManager;
import team.yogurt.PandoraProfiles;

import static team.yogurt.PandoraProfiles.getConf;
import static team.yogurt.Utilities.color;

public class Set extends CommandManager {
    @Override
    public String getName() {
        return "set";
    }

    @Override
    public String getDescription() {
        return "Set a variable in player";
    }

    @Override
    public String getSyntax() {
        return "/profiles admin set <player> <media> <value>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if(args.length != 5){
            sender.sendMessage(color(getConf().getString("profiles.invalid")
                    .replace("%syntax%", getSyntax())));
        }else{
            String player = args[2];
            String media = args[3];
            String value = args[4];
            if(PandoraProfiles.getSQL().playerExist(player)){
                for(CommandManager cmds : ProfileCommand.getCommands()){
                    if(cmds.getName().equals(media.replace("admin", ""))){
                        PandoraProfiles.getSQL().setLabel(media, value, player);
                        sender.sendMessage(color(getConf().getString("profiles.set-media")
                                .replace("%media%", media)
                                .replace("%player%", player)
                                .replace("%value%", value)));
                    }else{
                        //No media found
                        sender.sendMessage(color(getConf().getString("profiles.no-media-found")));
                        return;
                    }
                }
            }else{
                //No player found
                sender.sendMessage(color(getConf().getString("profiles.no-player-found")));
            }
        }
    }
}
