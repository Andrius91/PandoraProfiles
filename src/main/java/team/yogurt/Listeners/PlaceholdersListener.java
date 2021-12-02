package team.yogurt.Listeners;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import team.yogurt.PandoraProfiles;
import team.yogurt.Utilities;


public class PlaceholdersListener extends PlaceholderExpansion {

    public PlaceholdersListener(PandoraProfiles plugin){
        plugin.getLogger().info(Utilities.color("&cHooked with PlaceholderAPI"));
    }

    public boolean persist() {
        return true;
    }

    public boolean canRegister() {
        return true;
    }
    public @NotNull String getIdentifier() {
        return "profiles";
    }

    public @NotNull String getAuthor() {
        return "Andrius91";
    }

    public @NotNull String getVersion() {
        return "1.0";
    }

    public String onPlaceholderRequest(Player p, @NotNull String identifier) {
        String username = p.getName();
        return PandoraProfiles.getSQL().getLabel(identifier, username);
    }
}
