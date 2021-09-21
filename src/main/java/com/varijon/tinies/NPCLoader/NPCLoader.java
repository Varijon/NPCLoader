package com.varijon.tinies.NPCLoader;


import org.apache.logging.log4j.Logger;

import com.pixelmonmod.pixelmon.Pixelmon;

import net.minecraft.nbt.NBTException;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartedEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(modid="npcloader", version="1.0.0", acceptableRemoteVersions="*")
public class NPCLoader
{
	public static String MODID = "modid";
	public static String VERSION = "version";
	public static Logger logger;
		
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		logger = e.getModLog();

	}
	
	@EventHandler
	public void init(FMLInitializationEvent e)
	{
		MinecraftForge.EVENT_BUS.register(new NPCLoaderHandler());
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent e)
	{
	}

	 @EventHandler
	 public void serverLoad(FMLServerStartingEvent event)
	 {
		 event.registerServerCommand(new NPCLoaderCommand());
		 NPCStoreManager.loadStorage();
	 }

	 @EventHandler
	 public void serverStarted(FMLServerStartedEvent event)
	 {
		 NPCStoreManager.loadStorage();		 
	 }
}