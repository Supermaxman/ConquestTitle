package me.supermaxman.conquesttitle;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

	
public class ConquestTitleListener implements Listener {
	
	
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String pref = "";
		String suff = "";
		String col = "";
		if(ConquestTitle.prefixes.containsKey(p.getName()))pref = "[" + ConquestTitle.prefixes.get(p.getName())+ "] ";
		if(ConquestTitle.suffixes.containsKey(p.getName()))suff = " " + ChatColor.WHITE + "[" + ConquestTitle.suffixes.get(p.getName())+ "]";
		if(ConquestTitle.colors.containsKey(p.getName()))col = ChatColor.valueOf(ConquestTitle.colors.get(p.getName()))+"";
		e.setFormat(pref + col + p.getName() + ChatColor.WHITE + suff + ": " + e.getMessage());
	}
	
}