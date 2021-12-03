package team.yogurt.Commands.SubCommands.Admin.subcommands;

import org.bukkit.command.CommandSender;
import team.yogurt.Commands.ProfileCommand;
import team.yogurt.Managers.CommandManager;
import team.yogurt.PandoraProfiles;

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
            if(PandoraProfiles.getSQL().playerExist(player)){
                String media = args[3];
                for(CommandManager cmd : ProfileCommand.getCommands()){
                    sender.sendMessage(cmd.getName());
                    if(cmd.getName().equalsIgnoreCase(media)){
                        PandoraProfiles.getSQL().setLabel(media, null, player);
                        //Reset
                        sender.sendMessage(color(getConf().getString("profiles.reset-media")
                                .replace("%media%", media)
                                .replace("%player%", player)));
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
