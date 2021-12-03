package team.yogurt.Commands.SubCommands.Admin;

import org.bukkit.command.CommandSender;
import team.yogurt.Commands.ProfileCommand;
import team.yogurt.Commands.SubCommands.Admin.subcommands.Medias;
import team.yogurt.Commands.SubCommands.Admin.subcommands.Reset;
import team.yogurt.Commands.SubCommands.Admin.subcommands.Set;
import team.yogurt.Managers.CommandManager;
import team.yogurt.PandoraProfiles;

import java.util.ArrayList;

import static team.yogurt.PandoraProfiles.getConf;
import static team.yogurt.Utilities.color;

public class Admin extends CommandManager {
    ArrayList<CommandManager> adminsub = new ArrayList<>();
    public Admin(){
        adminsub.add(new Set());
        adminsub.add(new Reset());
        adminsub.add(new Medias());
    }
    @Override
    public String getName() {
        return "admin";
    }

    @Override
    public String getDescription() {
        return "Show the admin commands";
    }

    @Override
    public String getSyntax() {
        return "/profiles admin";
    }

    @Override
    public void perform(CommandSender sender, String[] args) {
        if(sender.hasPermission(getConf().getString("profiles.admin-permission"))){
            if(args.length <= 1){
                sender.sendMessage(color("&5Admin commands:"));
                sender.sendMessage(" ");
                for(CommandManager admins: getAdminsubs()){
                    sender.sendMessage(color("&d"+ admins.getSyntax() + "&f - &7" + admins.getDescription()));
                }
            }else{
                for(CommandManager cmd : getAdminsubs()) {
                    if (args[1].equalsIgnoreCase(cmd.getName())) {
                        cmd.perform(sender, args);
                        return;
                    }
                }
            }
        }else{
            sender.sendMessage(color(getConf().getString("profiles.no-permissions")));
        }
    }
    public static ArrayList<String> getMedias(){
        ArrayList<String> medias = new ArrayList<>();
        for (CommandManager command : ProfileCommand.getCommands()) {
            medias.add(command.getName());
        }
        return medias;
    }
    private ArrayList<CommandManager> getAdminsubs(){
        return adminsub;
    }
}
