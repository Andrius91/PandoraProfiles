package team.yogurt.Commands.SubCommands.Admin.subcommands;

import org.bukkit.command.CommandSender;
import team.yogurt.Commands.SubCommands.Admin.Admin;
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
        return "Set a media in player";
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
            if(PandoraProfiles.getSQL().playerExist(player)){
                String media = args[3];
                for(String mediaList : Admin.getMedias()){
                    if(mediaList.equalsIgnoreCase(media)){
                        String value = args[4];
                        PandoraProfiles.getSQL().setLabel(media, value, player);
                        sender.sendMessage(color(getConf().getString("profiles.set-media")
                                .replace("%media%", media)
                                .replace("%player%", player)
                                .replace("%value%", value)));
                        return;
                    }
                }
                sender.sendMessage(color(getConf().getString("profiles.no-media-found")));
            }else{
                //No player found
                sender.sendMessage(color(getConf().getString("profiles.no-player-found")));
            }
        }
    }
}
