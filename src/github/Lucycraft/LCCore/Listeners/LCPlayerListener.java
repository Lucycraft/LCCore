package github.Lucycraft.LCCore.Listeners;

import java.util.ArrayList;

import github.Lucycraft.LCCore.LCCore;
import github.Lucycraft.LCCore.Includes.LCDataHandeler;

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
		Player player = event.getPlayer();
		LCCommandListener command = LCCore.GetcommandManager();
				
		if (LCCore.Onlineplayerlist.size() > 0){
			String players = "";
			for (int i = 0; i < LCCore.Onlineplayerlist.size(); i ++){
				players += LCCore.Onlineplayerlist.get(i).getDisplayName();
				if (i + 1 != LCCore.Onlineplayerlist.size())
					players += ", ";
			}
			command.sendMessageToPlayer("The following people are online: " + players, player);
		} else {
			command.sendMessageToPlayer("You're feeling lonely", player);
		}			
		LCCore.Onlineplayerlist.add(player);	
		
		// checking if I have him in database
		ArrayList<ArrayList<Object>> resultset = LCDataHandeler.getData("SELECT * FROM users WHERE Name = '" + player.getName() + "';");
		if (resultset == null || resultset.size() == 0){
			LCDataHandeler.executeQuerry("INSERT INTO users (Name)VALUES('" + player.getName() + "');");
			command.sendMessageToPlayer("Welcome to the server", player);
		} else {
			command.sendMessageToPlayer("Welcome back " + player.getName(), player);
		}
			
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
