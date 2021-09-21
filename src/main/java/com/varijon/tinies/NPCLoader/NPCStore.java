package com.varijon.tinies.NPCLoader;

public class NPCStore 
{
	String nbtTags;
	String type;
	String UUID;
	int worldID;
	
	public NPCStore(String nbtTags, String type, String uUID, int worldID) {
		super();
		this.nbtTags = nbtTags;
		this.type = type;
		UUID = uUID;
		this.worldID = worldID;
	}
	public String getNbtTags() {
		return nbtTags;
	}
	public void setNbtTags(String nbtTags) {
		this.nbtTags = nbtTags;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUUID() {
		return UUID;
	}
	public void setUUID(String uUID) {
		UUID = uUID;
	}
	public int getWorldID() {
		return worldID;
	}
	public void setWorldID(int worldID) {
		this.worldID = worldID;
	}
	
	
}
