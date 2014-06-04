package me.supermaxman.conquesttitle;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class AlertExecutor extends BaseExecutor {
    @Override
    protected void run(CommandSender sender, String[] args) {	
    	if(sender.isOp()) {
	    	if(args.length != 0){
	        	String m = "";
	        	for(String s : args) {
	        		m = m +" "+s;
	        	}
	        	sender.getServer().broadcastMessage(ChatColor.DARK_GRAY+"["+ChatColor.DARK_RED+"ALERT"+ChatColor.DARK_GRAY+"]: "+ChatColor.RED+m);
	        }else {
	        	sender.sendMessage(ChatColor.RED+"Command used incorrectly, please type /alert [text]");
	        }
    	}else {
    		sender.sendMessage(ChatColor.RED+"You are not op.");
    	}
    }

    public AlertExecutor(ConquestTitle pl) {
        super(pl);
    }
}
