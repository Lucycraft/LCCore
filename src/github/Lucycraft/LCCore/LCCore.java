<<<<<<< HEAD
=======
<<<<<<< HEAD
package github.Lucycraft.LCCore;

import github.Lucycraft.LCCore.Includes.LCLogger;
import github.Lucycraft.LCCore.Listeners.LCCommandListener;
import github.Lucycraft.LCCore.Listeners.LCPlayerListener;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Lucycraft - A world enhancing plugin for Bukkit.
 *
 * @authors Thisisboris and cskiwi
 */

public class LCCore extends JavaPlugin {
	private final LCPlayerListener playerListener = new LCPlayerListener();
    private final static LCCommandListener commandManager = new LCCommandListener();
	public static String name;
    public static String version;
    public static List<Player> Onlineplayerlist = new ArrayList<Player>();
    public static List<Plugin> pluginlist =  new ArrayList<Plugin>();
    
    public void onEnable() {	
    	name = this.getDescription().getName();
        version = this.getDescription().getVersion();
    	
        // Logger
    	LCLogger.initialize(Logger.getLogger("Minecraft"));  	
    	
    	/*
         * Events
         */ 	
        PluginManager pm = getServer().getPluginManager();        
        // Player Events
        pm.registerEvents(this.playerListener, this);

        // If all fine 
        LCLogger.info(name + " version " + version + " is enabled!");
    }

    /*
     * This method runs when the plugin is disabling.
     */
    @Override
    public void onDisable() {
        // Player Events
    	HandlerList.unregisterAll(playerListener);
    	
    	/* 
    	 * TODO: Save everything! 
    	 */
    	
    	LCLogger.info(name + " has succesfully been disabled!");
    	
    }
    // just sending the commmands to the command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	return commandManager.onCommand(sender, command, label, args);
    }
    
    /* Getters and setters */
    public static LCCommandListener GetcommandManager(){
    	return commandManager;
    }
    
    public void Activate(Plugin plugin){
    	pluginlist.add(plugin);
    }

	/**
	 * @return the pluginlist
	 */
	public static List<Plugin> getPluginlist() {
		return pluginlist;
	}

=======
>>>>>>> temp
package github.Lucycraft.LCCore;

import github.Lucycraft.LCCore.Includes.LCLogger;
import github.Lucycraft.LCCore.Listeners.LCCommandListener;
import github.Lucycraft.LCCore.Listeners.LCPlayerListener;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Lucycraft - A world enhancing plugin for Bukkit.
 * testing adding code
 *
 * @authors Thisisboris and cskiwi
 */

public class LCCore extends JavaPlugin {
	private final LCPlayerListener playerListener = new LCPlayerListener();
    private final static LCCommandListener commandManager = new LCCommandListener();
	public static String name;
    public static String version;
    public static List<Player> Onlineplayerlist = new ArrayList<Player>();
    public static List<Plugin> pluginlist =  new ArrayList<Plugin>();
    
    public void onEnable() {	
    	name = this.getDescription().getName();
        version = this.getDescription().getVersion();
    	
        // Logger
    	LCLogger.initialize(Logger.getLogger("Minecraft"));  	
    	
    	/*
         * Events
         */ 	
        PluginManager pm = getServer().getPluginManager();        
        // Player Events
        pm.registerEvents(this.playerListener, this);

        // If all fine 
        LCLogger.info(name + " version " + version + " is enabled!");
    }

    /*
     * This method runs when the plugin is disabling.
     */
    @Override
    public void onDisable() {
        // Player Events
    	HandlerList.unregisterAll(playerListener);
    	
    	/* 
    	 * TODO: Save everything! 
    	 */
    	
    	LCLogger.info(name + " has succesfully been disabled!");
    	
    }
    // just sending the commmands to the command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	return commandManager.onCommand(sender, command, label, args);
    }
    
    /* Getters and setters */
    public static LCCommandListener GetcommandManager(){
    	return commandManager;
    }
    
    public void Activate(Plugin plugin){
    	pluginlist.add(plugin);
    }

	/**
	 * @return the pluginlist
	 */
	public static List<Plugin> getPluginlist() {
		return pluginlist;
	}

<<<<<<< HEAD
=======
>>>>>>> applying changes
>>>>>>> temp
}