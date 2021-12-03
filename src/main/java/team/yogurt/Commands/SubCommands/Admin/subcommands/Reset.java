package team.yogurt.Commands.SubCommands.Admin.subcommands;

import org.bukkit.command.CommandSender;
import team.yogurt.Commands.ProfileCommand;
import team.yogurt.Managers.CommandManager;
import team.yogurt.PandoraProfiles;

import java.util.Locale;

import static team.yogurt.PandoraProfiles.getConf;
import static team.yogurt.Utilities.color;

public class Reset extends CommandManager {
    @Override
    public String getName() {
        return "reset";
    }

    @Override
    public String getDescription() {
        return "reset a player";
    }

    @Override
    public String getSyntax() {
        return "/profiles admin reset <player> <media>";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if(args.length != 4){
            sender.sendMessage(color(getConf().getString("profiles.invalid")
                    .replace("%syntax%", getSyntax())));
        }else{
            String player = args[2];
            String media = args[3].toLowerCase(Locale.ROOT);
            if(PandoraProfiles.getSQL().playerExist(player)){
                for(CommandManager cmds : ProfileCommand.getCommands()){
                    if(cmds.getName().equals(media.replace("admin", ""))){
                        PandoraProfiles.getSQL().setLabel(media, null, player);
                        //Reset
                        sender.sendMessage(color(getConf().getString("profiles.reset-media")
                                .replace("%media%", media)
                                .replace("%player%", player)));
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
