package com.ludoclt.logicraft;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.*;
import net.minecraftforge.server.permission.DefaultPermissionLevel;
import net.minecraftforge.server.permission.PermissionAPI;

import org.apache.logging.log4j.Logger;

import com.ludoclt.logicraft.proxy.CommonProxy;
import com.ludoclt.logicraft.common.commands.ImportCircuitCommand;
import com.ludoclt.logicraft.common.commands.SetFilesDirectoryCommand;

@Mod(modid = LogiCraft.MODID, name = "LogiCraft", version = "0.1", acceptedMinecraftVersions = "[1.12.2]")
public class LogiCraft 
{
    public static final String MODID = "logicraft";

    @Instance(MODID)
    public static LogiCraft instance;

    @SidedProxy(clientSide = "com.ludoclt.logicraft.proxy.ClientProxy", serverSide = "com.ludoclt.logicraft.proxy.ServerProxy")
    public static CommonProxy proxy;

    public static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        proxy.preInit(event.getSuggestedConfigurationFile());
    }
    	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.Init();
        PermissionAPI.registerNode("logicraft.command.importdiagram", DefaultPermissionLevel.OP, "Allows players to use the importdiagram command");
    }
    	
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event)
    {
        event.registerServerCommand(new ImportCircuitCommand());
        event.registerServerCommand(new SetFilesDirectoryCommand());
    }
}