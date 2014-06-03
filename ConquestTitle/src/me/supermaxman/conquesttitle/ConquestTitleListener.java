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
		String sty = "";
		
		if(ConquestTitle.prefixes.containsKey(p.getName()))pref = ConquestTitle.prefixText.get(ConquestTitle.prefixes.get(p.getName()));
		if(ConquestTitle.suffixes.containsKey(p.getName()))suff = ConquestTitle.suffixText.get(ConquestTitle.suffixes.get(p.getName()));
		if(ConquestTitle.colors.containsKey(p.getName()))col = ChatColor.valueOf(ConquestTitle.colors.get(p.getName()))+"";
		if(ConquestTitle.styles.containsKey(p.getName()))sty = ChatColor.valueOf(ConquestTitle.styles.get(p.getName()))+"";
		
		p.setDisplayName((pref + ChatColor.WHITE + col + sty + p.getName() + ChatColor.RESET + ChatColor.WHITE + suff + ChatColor.WHITE));
	}
	
}
