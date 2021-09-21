package com.varijon.tinies.NPCLoader;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.pixelmonmod.pixelmon.entities.npcs.EntityNPC;
import com.pixelmonmod.pixelmon.entities.npcs.NPCChatting;
import com.pixelmonmod.pixelmon.entities.npcs.NPCNurseJoy;
import com.pixelmonmod.pixelmon.entities.npcs.NPCRelearner;
import com.pixelmonmod.pixelmon.entities.npcs.NPCShopkeeper;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrader;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTrainer;
import com.pixelmonmod.pixelmon.entities.npcs.NPCTutor;
import com.pixelmonmod.pixelmon.entities.npcs.registry.NPCRegistryVillagers;

import net.minecraft.nbt.JsonToNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;

public class NPCStoreManager 
{
	static ArrayList<NPCStore> lstNPCStore = new ArrayList<NPCStore>();
	static ArrayList<EntityNPC> lstPixelmonNPC = new ArrayList<EntityNPC>();
	static MinecraftServer server;
	public static boolean loadStorage()
	{
		String basefolder = new File("").getAbsolutePath();
        String source = basefolder + "/config/NPCLoader";
		try
		{
			Gson gson = new Gson();
			
			File dir = new File(source);
			if(!dir.exists())
			{
				dir.mkdirs();
			}
			
			lstNPCStore.clear();
			
			for(File file : dir.listFiles())
			{
				FileReader reader = new FileReader(file);
				
				NPCStore poll = gson.fromJson(reader, NPCStore.class);
								
				lstNPCStore.add(poll);
				reader.close();
			}
			lstPixelmonNPC.clear();
			server = FMLCommonHandler.instance().getMinecraftServerInstance();	
			for(NPCStore npcStore : lstNPCStore)
			{
				if(npcStore.type.equals("ShopKeeper"))
				{
					NPCShopkeeper npc = new NPCShopkeeper(server.getWorld(npcStore.getWorldID()));
					npc.readFromNBT(JsonToNBT.getTagFromJson(npcStore.nbtTags));
					lstPixelmonNPC.add(npc);
				}
				if(npcStore.type.equals("Chatting"))
				{
					NPCChatting npc = new NPCChatting(server.getWorld(npcStore.getWorldID()));
					npc.readFromNBT(JsonToNBT.getTagFromJson(npcStore.nbtTags));
					lstPixelmonNPC.add(npc);
				}
				if(npcStore.type.equals("Relearner"))
				{
					NPCRelearner npc = new NPCRelearner(server.getWorld(npcStore.getWorldID()));
					npc.readFromNBT(JsonToNBT.getTagFromJson(npcStore.nbtTags));
					lstPixelmonNPC.add(npc);
				}
				if(npcStore.type.equals("Tutor"))
				{
					NPCTutor npc = new NPCTutor(server.getWorld(npcStore.getWorldID()));
					npc.readFromNBT(JsonToNBT.getTagFromJson(npcStore.nbtTags));
					lstPixelmonNPC.add(npc);
				}
				if(npcStore.type.equals("Trainer"))
				{
					NPCTrainer npc = new NPCTrainer(server.getWorld(npcStore.getWorldID()));
					npc.readFromNBT(JsonToNBT.getTagFromJson(npcStore.nbtTags));
					lstPixelmonNPC.add(npc);
				}
				if(npcStore.type.equals("Trader"))
				{
					NPCTrader npc = new NPCTrader(server.getWorld(npcStore.getWorldID()));
					npc.readFromNBT(JsonToNBT.getTagFromJson(npcStore.nbtTags));
					lstPixelmonNPC.add(npc);
				}
				if(npcStore.type.equals("Nurse"))
				{
					NPCNurseJoy npc = new NPCNurseJoy(server.getWorld(npcStore.getWorldID()));
					npc.readFromNBT(JsonToNBT.getTagFromJson(npcStore.nbtTags));
					lstPixelmonNPC.add(npc);
				}
			}
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}
}
