package com.varijon.tinies.NPCLoader;

import java.io.File;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pixelmonmod.pixelmon.entities.npcs.EntityNPC;
import com.pixelmonmod.pixelmon.entities.npcs.NPCChatting;
import com.pixelmonmod.pixelmon.entities.npcs.NPCNurseJoy;
import com.pixelmonmod.pixelmon.entities.npcs.NPCRelearner;
import com.pixelmonmod.pixelmon.entities.npcs.NPCShopkeeper;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrader;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTutor;
import com.pixelmonmod.pixelmon.entities.pixelmon.EntityPixelmon;
import com.pixelmonmod.pixelmon.enums.EnumNPCType;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.common.gameevent.TickEvent.WorldTickEvent;

public class NPCLoaderHandler 
{
	int count = 0;
	@SubscribeEvent
	public void onWorldTick (WorldTickEvent event)
	{
		if(count < 100)
		{
			count++;
			return;
		}
		count = 0;
		try
		{
			if(event.phase != Phase.END)
			{
				return;
			}
			if(!event.world.getWorldInfo().getWorldName().equals("world"))
			{
				return;
			}
			for(EntityNPC npc : NPCStoreManager.lstPixelmonNPC)
			{
				if(npc.getEntityWorld().isBlockLoaded(npc.getPosition()))
				{
					boolean exists = false;
					for(Entity entityWorld : event.world.loadedEntityList)
					{
						if(entityWorld instanceof EntityNPC)
						{
							if(entityWorld.getPositionVector().equals(npc.getPositionVector()))
							{
								exists = true;
								break;
							}							
						}
					}
					if(!exists)
					{
						if(npc instanceof NPCShopkeeper)
						{
							npc.getEntityWorld().spawnEntity((NPCShopkeeper)npc);
							NPCLoader.logger.info("Spawned a NPCShopkeeper at X:" + npc.getPosition().getX() + " Y:" + npc.getPosition().getY() + " Z:" + npc.getPosition().getZ() + " in " + npc.getEntityWorld().getWorldInfo().getWorldName());						
						}
						if(npc instanceof NPCChatting)
						{
							npc.getEntityWorld().spawnEntity((NPCChatting)npc);		
							NPCLoader.logger.info("Spawned a NPCChatting at X:" + npc.getPosition().getX() + " Y:" + npc.getPosition().getY() + " Z:" + npc.getPosition().getZ() + " in " + npc.getEntityWorld().getWorldInfo().getWorldName());						
						}
						if(npc instanceof NPCRelearner)
						{
							npc.getEntityWorld().spawnEntity((NPCRelearner)npc);	
							NPCLoader.logger.info("Spawned a NPCRelearner at X:" + npc.getPosition().getX() + " Y:" + npc.getPosition().getY() + " Z:" + npc.getPosition().getZ() + " in " + npc.getEntityWorld().getWorldInfo().getWorldName());						
						}
						if(npc instanceof NPCTutor)
						{
							npc.getEntityWorld().spawnEntity((NPCTutor)npc);	
							NPCLoader.logger.info("Spawned a NPCTutor at X:" + npc.getPosition().getX() + " Y:" + npc.getPosition().getY() + " Z:" + npc.getPosition().getZ() + " in " + npc.getEntityWorld().getWorldInfo().getWorldName());						
						}
						if(npc instanceof NPCTrainer)
						{
							npc.getEntityWorld().spawnEntity((NPCTrainer)npc);	
							NPCLoader.logger.info("Spawned a NPCTrainer at X:" + npc.getPosition().getX() + " Y:" + npc.getPosition().getY() + " Z:" + npc.getPosition().getZ() + " in " + npc.getEntityWorld().getWorldInfo().getWorldName());						
						}
						if(npc instanceof NPCTrader)
						{
							npc.getEntityWorld().spawnEntity((NPCTrader)npc);	
							NPCLoader.logger.info("Spawned a NPCTrader at X:" + npc.getPosition().getX() + " Y:" + npc.getPosition().getY() + " Z:" + npc.getPosition().getZ() + " in " + npc.getEntityWorld().getWorldInfo().getWorldName());						
						}
						if(npc instanceof NPCNurseJoy)
						{
							npc.getEntityWorld().spawnEntity((NPCNurseJoy)npc);	
							NPCLoader.logger.info("Spawned a NPCNurseJoy at X:" + npc.getPosition().getX() + " Y:" + npc.getPosition().getY() + " Z:" + npc.getPosition().getZ() + " in " + npc.getEntityWorld().getWorldInfo().getWorldName());						
						}
					}
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}
