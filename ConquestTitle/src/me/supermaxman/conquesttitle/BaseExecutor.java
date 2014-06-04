package me.supermaxman.conquesttitle;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

abstract class BaseExecutor implements CommandExecutor {
	protected static ConquestTitle pl;
    BaseExecutor(ConquestTitle pl) {
        BaseExecutor.pl = pl;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	
        this.run(sender, args);

        return true;
    }

    protected abstract void run(CommandSender player, String[] args);

}