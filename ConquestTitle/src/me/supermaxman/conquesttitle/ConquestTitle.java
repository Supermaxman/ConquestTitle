package me.supermaxman.conquesttitle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;



public class ConquestTitle extends JavaPlugin {
    public static FileConfiguration conf;
	public static ConquestTitle plugin;
	public static final Logger log = Logger.getLogger("Minecraft");
	public static Permission permission = null;
	
	static HashMap<String, String> prefixes = new HashMap<String, String>();
	static HashMap<String, String> suffixes = new HashMap<String, String>();
	static HashMap<String, String> colors = new HashMap<String, String>();
	
	static HashMap<String, String> prefixList = new HashMap<String, String>();
	static HashMap<String, String> suffixList = new HashMap<String, String>();
	static HashMap<String, String> colorList = new HashMap<String, String>();

	
	public void onEnable() {
		plugin = this;
		
		saveDefaultConfig();
        getCommand("title").setExecutor(new TitleExecutor(this));    
        if (!setupPermissions()) {
        	log.severe("Vault fail!");
            this.setEnabled(false);
            return;
        }
		loadSavedTitles();
		loadTitles();
        
		getServer().getPluginManager().registerEvents(new ConquestTitleListener(), plugin);
		
		log.info(getName() + " has been enabled.");
		
	}
	
	@SuppressWarnings("unchecked")
	void loadSavedTitles() {
		try {
			prefixes = (HashMap<String, String>) new ObjectInputStream(new FileInputStream(getDataFolder() + File.separator + "prefixes.ser")).readObject();
			suffixes = (HashMap<String, String>) new ObjectInputStream(new FileInputStream(getDataFolder() + File.separator + "suffixes.ser")).readObject();
			colors = (HashMap<String, String>) new ObjectInputStream(new FileInputStream(getDataFolder() + File.separator + "colors.ser")).readObject();
			
			new ObjectInputStream(new FileInputStream(getDataFolder() + File.separator + "prefixes.ser")).close();
			new ObjectInputStream(new FileInputStream(getDataFolder() + File.separator + "suffixes.ser")).close();
			new ObjectInputStream(new FileInputStream(getDataFolder() + File.separator + "colors.ser")).close();
			
		} catch (Exception e) {
			log.warning("[" + getName() + "] files could not be read! All files are now ignored.");
		}
		
	}
	
	

	static void loadTitles() {
		
		try {
			conf = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder() + File.separator + "config.yml"));
			if (conf.isConfigurationSection("prefixes")) {
		           for (Map.Entry<String, Object> entry : conf.getConfigurationSection("prefixes").getValues(false).entrySet()) {
		               prefixList.put(entry.getKey(), (String) entry.getValue());
		               
		           }
			}
			if (conf.isConfigurationSection("suffixes")) {
		           for (Map.Entry<String, Object> entry : conf.getConfigurationSection("suffixes").getValues(false).entrySet()) {
		               suffixList.put(entry.getKey(), (String) entry.getValue());
		               
		           }
			}
			if (conf.isConfigurationSection("colors")) {
		           for (Map.Entry<String, Object> entry : conf.getConfigurationSection("colors").getValues(false).entrySet()) {
		               colorList.put(entry.getKey(), (String) entry.getValue());
		               
		           }
			}
		} catch (Exception e) {
			log.warning("[" + plugin.getName() + "] Titles are invalid in config.yml! Could not load the values.");
		}
	}
	
	public void onDisable() {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(getDataFolder() + File.separator + "prefixes.ser"));
			oos.writeObject(prefixes);
			oos.close();
			ObjectOutputStream oos2 = new ObjectOutputStream(new FileOutputStream(getDataFolder() + File.separator + "suffixes.ser"));
			oos2.writeObject(suffixes);
			oos2.close();
			ObjectOutputStream oos3 = new ObjectOutputStream(new FileOutputStream(getDataFolder() + File.separator + "colors.ser"));
			oos3.writeObject(colors);
			oos3.close();
			
		} catch (Exception e) {
			log.warning("[" + getName() + "] files could not be saved!");
			e.printStackTrace();
		}
		
		log.info(getName() + " has been disabled.");
	}
	
	private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
            return true;
        }
        return false;
    }
}