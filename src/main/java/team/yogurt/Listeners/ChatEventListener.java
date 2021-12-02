package team.yogurt.Listeners;

import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import team.yogurt.Commands.SubCommands.*;
import team.yogurt.PandoraProfiles;

import static team.yogurt.PandoraProfiles.getConf;
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
                if(age > 5 && age < 100){
                    PandoraProfiles.getSQL().setLabel("age", String.valueOf(age), player);
                    p.sendMessage(color(getConf().getString("age.successfully-message")));
                }else{
                    p.sendMessage(color(getConf().getString("age.invalid-age")));
                }
            }catch (NumberFormatException exception){
                p.sendMessage(color(getConf().getString("age.only-numbers")));
            }
            e.setCancelled(true);
            Age.syncPlayers.remove(e.getPlayer().getName());
        }
        //Discord
        else if(Discord.syncPlayers.contains(player)){
            if(message.length() < 1){
                p.sendMessage(color(getConf().getString("discord.tag.short")));
                return;
            }
            if(!message.contains("#")){
                p.sendMessage(color(getConf().getString("discord.tag.char-not-found")));
                return;
            }
            String[] tag = message.split("#");
            if(tag[0].length() > getConf().getInt("discord.tag.limit")){
                p.sendMessage(color(getConf().getString("discord.tag.limit-message")));
                return;
            }
            if(StringUtils.isNumeric(tag[1])){
                if(tag[1].equalsIgnoreCase("0000") || tag[1].length() != 4){
                    p.sendMessage(color(getConf().getString("discord.tag.invalid")));
                }else{
                    PandoraProfiles.getSQL().setLabel("discord", message, player);
                    p.sendMessage(color(getConf().getString("discord.successfully-message")));
                }
            }else{
                p.sendMessage(color(getConf().getString("discord.tag.only-numbers")));
            }
            e.setCancelled(true);
            Discord.syncPlayers.remove(player);
        }

        //Facebook
        else if(Facebook.syncPlayers.contains(player)){
            if (message.startsWith(getConf().getString("facebook.startsWith"))) {
                PandoraProfiles.getSQL().setLabel("facebook", message, player);
                p.sendMessage(color(getConf().getString("facebook.successfully-message")));
            } else {
                p.sendMessage(color(getConf().getString("facebook.invalid-url")
                        .replace("%link%", getConf().getString("facebook.startsWith"))));
            }
            e.setCancelled(true);
            Facebook.syncPlayers.remove(player);
        }

        //Instagram
        else if(Instagram.syncPlayers.contains(player)){
            if (message.startsWith(getConf().getString("instagram.startsWith"))) {
                PandoraProfiles.getSQL().setLabel("instagram", message, player);
                p.sendMessage(color(getConf().getString("instagram.successfully-message")));
            } else {
                p.sendMessage(color(getConf().getString("instagram.invalid-url")
                        .replace("%link%", getConf().getString("instagram.startsWith"))));
            }
            e.setCancelled(true);
            Instagram.syncPlayers.remove(player);

        }

        //Twitch
        else if(Twitch.syncPlayers.contains(player)){
            if (message.startsWith(getConf().getString("twitch.startsWith"))) {
                PandoraProfiles.getSQL().setLabel("twitch", message, player);
                p.sendMessage(color(getConf().getString("twitch.successfully-message")));
            } else {
                p.sendMessage(color(getConf().getString("twitch.invalid-url")
                        .replace("%link%", getConf().getString("twitch.startsWith"))));
            }
            e.setCancelled(true);
            Twitch.syncPlayers.remove(player);
        }

        //Twitter
        else if(Twitter.syncPlayers.contains(player)){
            if (message.startsWith(getConf().getString("twitter.startsWith"))) {
                PandoraProfiles.getSQL().setLabel("twitter", message, player);
                p.sendMessage(color(getConf().getString("twitter.successfully-message")));
            } else {
                p.sendMessage(color(getConf().getString("twitter.invalid-url")
                        .replace("%link%", getConf().getString("twitter.startsWith"))));
            }
            e.setCancelled(true);
            Twitter.syncPlayers.remove(player);
        }

        //Youtube
        else if(Youtube.syncPlayers.contains(player)){
            if (message.startsWith(getConf().getString("youtube.startsWith"))) {
                PandoraProfiles.getSQL().setLabel("youtube", message, player);
                p.sendMessage(color(getConf().getString("youtube.successfully-message")));
            } else {
                p.sendMessage(color(getConf().getString("youtube.invalid-url")
                        .replace("%link%", getConf().getString("youtube.startsWith"))));
            }
            e.setCancelled(true);
            Youtube.syncPlayers.remove(player);
        }

    }
}
