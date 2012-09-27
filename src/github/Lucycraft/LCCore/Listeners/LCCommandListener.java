package github.Lucycraft.LCCore.Listeners;

import github.Lucycraft.LCCore.LCCore;
import github.Lucycraft.LCCore.Includes.LCLogger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * @description Handles commands.
 * @authors Thisisboris and cskiwi
 */
public class LCCommandListener implements CommandExecutor {
	String prefix = colorizeText("[Lucycraft] ", ChatColor.GOLD);
	@Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        boolean handled = false;
        String message = "";
                
        if (is(label, "LucyCraft") || is(label, "LC")) {

        	if (args == null || args.length == 0){
	        	//------------------
				// Player
				//------------------
				if (isPlayer(sender)){
	    			
	    			message = prefix.concat("[HELP]");
	    			sendMessage(sender, message);
	    			
	    			sendMessage(sender, colorizeText("/LC or Lucycraft: ", ChatColor.DARK_AQUA) + "Shows this page.");
	    			
	    			handled = true;
	    			
	    		} else {
	    		//-------------------
				// Terminal
				//-------------------
	    			sendLog(sender, "Prepare for statistics dump!");
	    			sendLog(sender, "Dump!");
	    			sendLog(sender, "Dump!");
	    			sendLog(sender, "Dump!");
	    			sendLog(sender, "Dump!");
	    			sendLog(sender, "Dump!");
	    			sendLog(sender, "Holy shit that's a lot of dumps!");
	    			handled = true;
	    			
	    		}
        	} else {
        		if (isPlayer(sender)){
        			if (is(args[0], "Modules")) {
        				sendMessage(sender, prefix + colorizeText("Current active modules:", ChatColor.GREEN));
        				for (int i=0; i < LCCore.getPluginlist().size(); i++)
        					if (i != LCCore.getPluginlist().size()-1)
        						message += LCCore.getPluginlist().get(i) + ", ";
        					else
        						message += LCCore.getPluginlist().get(i);
        				
    						sendMessage(sender, prefix + message);
        				handled = true;
        			}        			
        		}
        	}
        }
        return handled;
    }

    // Simplifies and shortens the if statements for commands.
    private boolean is(String entered, String label) {
        return entered.equalsIgnoreCase(label);
    }

    // Checks if the current user is actually a player.
    private boolean isPlayer(CommandSender sender) {
        return sender != null && sender instanceof Player;
    }

    // Checks if the current user is actually a player and sends a message to that player.
    private boolean sendMessage(CommandSender sender, String message) {
        boolean sent = false;
        if (isPlayer(sender)) {
            Player player = (Player) sender;
            player.sendMessage(message);
            sent = true;
        }
        return sent;
    }
    
    public boolean sendMessageToPlayer(String message, Player player) {
    	boolean sent = false;
    	if (isPlayer(player)){
    		player.sendMessage(prefix + message);
    		sent = true;
    	}
    	return sent;
    }

    public boolean sendLog(CommandSender sender, String message) {
        boolean sent = false;
        if (!isPlayer(sender)) {
            LCLogger.info(message);
            sent = true;
        }
        return sent;
    }
    
    private String colorizeText(String text, ChatColor color) {
        return color + text + ChatColor.WHITE;
    }
}
