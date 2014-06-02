package me.supermaxman.conquesttitle;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TitleExecutor extends BaseExecutor {
    @Override
    protected void run(Player player, String[] args) {
        if(args.length != 0){
        	if(args[0].equalsIgnoreCase("prefix")&&args.length>=2) {
        		String prefix = args[1];
        		if(ConquestTitle.prefixList.containsKey(prefix)) {
        			if(ConquestTitle.permission.has(player, ConquestTitle.prefixList.get(prefix))) {
        				ConquestTitle.prefixes.put(player.getName(), prefix);
                    	player.sendMessage(ChatColor.AQUA+"Your prefix has been changed.");
        			}else {
                    	player.sendMessage(ChatColor.RED+"You do not have permission!");
        			}
        		}else {
                	player.sendMessage(ChatColor.RED+"Prefix does not exist!");
        		}
        	}else if(args[0].equalsIgnoreCase("prefix")) {
        		if(ConquestTitle.prefixes.containsKey(player.getName())) {
        				ConquestTitle.prefixes.remove(player.getName());
        		}
            	player.sendMessage(ChatColor.AQUA+"Prefix removed.");
        	}else if(args[0].equalsIgnoreCase("suffix")&&args.length>=2) {
        		String suffix = args[1];
        		if(ConquestTitle.suffixList.containsKey(suffix)) {
        			if(ConquestTitle.permission.has(player, ConquestTitle.suffixList.get(suffix))) {
        				ConquestTitle.suffixes.put(player.getName(), suffix);
                    	player.sendMessage(ChatColor.AQUA+"Your suffix has been changed.");
        			}else {
                    	player.sendMessage(ChatColor.RED+"You do not have permission!");
        			}
        		}else {
                	player.sendMessage(ChatColor.RED+"Suffix does not exist!");
        		}
        	}else if(args[0].equalsIgnoreCase("suffix")) {
        		if(ConquestTitle.suffixes.containsKey(player.getName())) {
    				ConquestTitle.suffixes.remove(player.getName());
	    		}
	        	player.sendMessage(ChatColor.AQUA+"Suffix removed.");
	    	}else if(args[0].equalsIgnoreCase("color")&&args.length>=2) {
        		String color = args[1].toUpperCase();
        		if(ConquestTitle.colorList.containsKey(color)) {
        			if(ConquestTitle.permission.has(player, ConquestTitle.colorList.get(color))) {
        				ConquestTitle.colors.put(player.getName(), color);
                    	player.sendMessage(ChatColor.AQUA+"Your color has been changed.");
        			}else {
                    	player.sendMessage(ChatColor.RED+"You do not have permission!");
        			}
        		}else {
                	player.sendMessage(ChatColor.RED+"Color does not exist!");
        		}
        	}else if(args[0].equalsIgnoreCase("color")) {
        		if(ConquestTitle.colors.containsKey(player.getName())) {
    				ConquestTitle.colors.remove(player.getName());
	    		}
	        	player.sendMessage(ChatColor.AQUA+"Color removed.");
	    	}else if(args[0].equalsIgnoreCase("list")) {
            	player.sendMessage(ChatColor.AQUA+"Prefixes:");
        		for(String s : ConquestTitle.prefixList.keySet()) {
        			if(ConquestTitle.permission.has(player, ConquestTitle.prefixList.get(s))) {
                    	player.sendMessage(" - " + ConquestTitle.prefixText.get(s));
        			}
        		}
            	player.sendMessage(ChatColor.AQUA+"Suffixes:");
        		for(String s : ConquestTitle.suffixList.keySet()) {
        			if(ConquestTitle.permission.has(player, ConquestTitle.suffixList.get(s))) {
                    	player.sendMessage(" - " + ConquestTitle.suffixText.get(s));
        			}
        		}
            	player.sendMessage(ChatColor.AQUA+"Colors:");
        		for(String s : ConquestTitle.colorList.keySet()) {
        			if(ConquestTitle.permission.has(player, ConquestTitle.colorList.get(s))) {
                    	player.sendMessage(" - " + ChatColor.valueOf(s)+s);
        			}
        		}
        	}else {
            	player.sendMessage(ChatColor.RED+"Command used incorrectly, please type /title [prefix,suffix,color,list] [value]");
        	}
        }else {
        	player.sendMessage(ChatColor.RED+"Command used incorrectly, please type /title [prefix,suffix,color,list] [value]");
        }
    }

    public TitleExecutor(ConquestTitle pl) {
        super(pl);
    }
}
