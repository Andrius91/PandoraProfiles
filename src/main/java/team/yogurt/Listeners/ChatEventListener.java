package team.yogurt.Listeners;

import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import team.yogurt.Commands.SubCommands.*;
import team.yogurt.PandoraProfiles;

import static team.yogurt.Utilities.color;

public class ChatEventListener implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent e){
        String player = e.getPlayer().getName();
        if(Age.syncPlayers.contains(player)
                || Discord.syncPlayers.contains(player)
                || Facebook.syncPlayers.contains(player)
                || Instagram.syncPlayers.contains(player)
                || Twitch.syncPlayers.contains(player)
                || Twitter.syncPlayers.contains(player)
                || Youtube.syncPlayers.contains(player)){
            e.getPlayer().sendMessage(color("&cNo puedes ejecutar comandos mientras estás relleando una wea"));
            e.setCancelled(true);
        }

    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String player = e.getPlayer().getName();
        String message = e.getMessage();
        //Age
        if(Age.syncPlayers.contains(player)){
            try{
                int age = Integer.parseInt(message);
                if(age > 6 && age < 100){
                    p.sendMessage(String.valueOf(age));
                }else{
                    p.sendMessage(color("&cTu edad es inválida para esta época"));
                }
                PandoraProfiles.getSQL().setLabel("age", String.valueOf(age), player);
            }catch (NumberFormatException exception){
                p.sendMessage(color("&cSolo puedes escribir números"));
            }
            e.setCancelled(true);
            Age.syncPlayers.remove(e.getPlayer().getName());
        }
        //Discord
        else if(Discord.syncPlayers.contains(player)){
            if(message.length() < 1){
                p.sendMessage(color("&cTu tag es muy corto"));
                return;
            }
            if(!message.contains("#")){
                p.sendMessage(color("&cNecesitas usar el #"));
                return;
            }
            String[] tag = message.split("#");
            if(tag[0].length() > 16){
                p.sendMessage(color("&cTu tag supera el límite"));
                return;
            }
            if(StringUtils.isNumeric(tag[1])){
                if(tag[1].equalsIgnoreCase("0000") || tag[1].length() != 4){
                    p.sendMessage(color("&cIngresa bien tu tag: " + tag[1]));
                }else{
                    p.sendMessage(color("&Tu discord es: "+ message));
                    PandoraProfiles.getSQL().setLabel("discord", message, player);
                }
            }else{
                p.sendMessage(color("&cSolo puedes poner numeros po"));
            }
            e.setCancelled(true);
            Discord.syncPlayers.remove(player);
        }

        //Facebook
        else if(Facebook.syncPlayers.contains(player)){
            if (message.startsWith("https://www.facebook.com/")) {
                PandoraProfiles.getSQL().setLabel("facebook", message, player);
            } else {
                p.sendMessage(color("&cEl link tiene que contener: https://www.facebook.com/<TuPerfil>"));
            }
            e.setCancelled(true);
            Facebook.syncPlayers.remove(player);
        }

        //Instagram
        else if(Instagram.syncPlayers.contains(player)){
            if (message.startsWith("https://www.instagram.com/")) {
                PandoraProfiles.getSQL().setLabel("instagram", message, player);
            } else {
                p.sendMessage(color("&cEl link tiene que contener: https://www.instagram.com/<ig>"));
            }
            e.setCancelled(true);
            Instagram.syncPlayers.remove(player);

        }

        //Twitch
        else if(Twitch.syncPlayers.contains(player)){
            if (message.startsWith("https://www.twitch.tv/")) {
                PandoraProfiles.getSQL().setLabel("twitch", message, player);
            } else {
                p.sendMessage(color("&cEl link tiene que contener: https://www.twitch.tv/<twitch>"));
            }
            e.setCancelled(true);
            Twitch.syncPlayers.remove(player);
        }

        //Twitter
        else if(Twitter.syncPlayers.contains(player)){
            if (message.startsWith("https://twitter.com/")) {
                PandoraProfiles.getSQL().setLabel("twitter", message, player);
            } else {
                p.sendMessage(color("&cEl link tiene que contener: https://twitter.com/<twitter>"));
            }
            e.setCancelled(true);
            Twitter.syncPlayers.remove(player);
        }

        //Youtube
        else if(Youtube.syncPlayers.contains(player)){
            if (message.startsWith("https://www.youtube.com/channel/")) {
                PandoraProfiles.getSQL().setLabel("youtube", message, player);
            } else {
                p.sendMessage(color("&cEl link tiene que contener: https://www.youtube.com/channel/<channel>"));
            }
            e.setCancelled(true);
            Youtube.syncPlayers.remove(player);
        }

    }
}
