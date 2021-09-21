package com.varijon.tinies.NPCLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.config.ConfigManager;

public class NPCLoaderCommand extends CommandBase {

	private List aliases;
	
	public NPCLoaderCommand()
	{
	   this.aliases = new ArrayList();
	   this.aliases.add("npcloader");
	}
	
	@Override
	public int compareTo(ICommand arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "npcloader";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		// TODO Auto-generated method stub
		return "npcloader";
	}

	@Override
	public List<String> getAliases() {
		// TODO Auto-generated method stub
		return this.aliases;
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException 
	{
		if(args.length == 1)
		{
			if(args[0].equals("reload"))
			{
				if(sender.canUseCommand(4, "npcloader.reload"))
				{
					if(NPCStoreManager.loadStorage())
					{
						sender.sendMessage(new TextComponentString(TextFormatting.GREEN + "Files reloaded succesfully"));						
					}
					else
					{
						sender.sendMessage(new TextComponentString(TextFormatting.RED + "Failed to reload files"));
					}
					return;
				}
				else
				{
					sender.sendMessage(new TextComponentString(TextFormatting.RED + "You don't have permission to use this command"));
					return;
				}
			}
		}
//		if(args.length == 2)
//		{
//			if(args[0].equals(""))
//			{
//				
//			}
//		}
//		if(args.length == 4)
//		{
//			if(args[0].equals("addevent"))
//			{
//				ConfigManager.getEventConfigList().add(new EventConfig(args[1], args[2], args[3], new ArrayList<EventPokemon>()));
//				ConfigManager
//				ConfigManager.loadConfig();
//			}
//		}
		sender.sendMessage(new TextComponentString(TextFormatting.RED + "Usage: /tmbossloot reload"));
	    return;
	}
	
	@Override
	public boolean checkPermission(MinecraftServer server, ICommandSender sender) 
	{
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isUsernameIndex(String[] args, int index) {
		// TODO Auto-generated method stub
		return false;
	}
	


}
