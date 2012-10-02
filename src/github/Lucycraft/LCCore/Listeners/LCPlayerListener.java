package github.Lucycraft.LCCore.Listeners;

import github.Lucycraft.LCCore.LCCore;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Handle events for all Player related events
 * @authors Thisisboris and cskiwi
 * 
 * 
 */

public class LCPlayerListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		// int index = LCCore.Onlineplayerlist.size();
				
		if (LCCore.Onlineplayerlist.size() > 0){
			String players = "";
			for (int i = 0; i < LCCore.Onlineplayerlist.size(); i ++){
				players += LCCore.Onlineplayerlist.get(i).getDisplayName();
				if (i + 1 != LCCore.Onlineplayerlist.size())
					players += ", ";
			}
			
			LCCore.GetcommandManager().sendMessageToPlayer("The following people are online: " + players, event.getPlayer());
		} else {
			LCCore.GetcommandManager().sendMessageToPlayer("You're feeling lonely", event.getPlayer());
		}
			
		LCCore.Onlineplayerlist.add(event.getPlayer());	
			
	}
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		int lengthList = LCCore.Onlineplayerlist.size();
		Player QuitingPlayer = event.getPlayer();
		for (int i = 0; i < lengthList; i++){
			Player TempPlayer = LCCore.Onlineplayerlist.get(i);
			if (TempPlayer.getDisplayName() == QuitingPlayer.getDisplayName()){
				LCCore.Onlineplayerlist.remove(i);
				break;
			}
		}
	
	}
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		 
	 }
	@EventHandler
    public void onPlayerKick(PlayerKickEvent event) {
    	
    }
}
