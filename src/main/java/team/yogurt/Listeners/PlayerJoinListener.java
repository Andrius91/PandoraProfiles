package team.yogurt.Listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import team.yogurt.PandoraProfiles;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        String username = e.getPlayer().getName();
        String UUID = e.getPlayer().getUniqueId().toString();
        PandoraProfiles.getSQL().createNewUser(username, UUID);
    }

}
