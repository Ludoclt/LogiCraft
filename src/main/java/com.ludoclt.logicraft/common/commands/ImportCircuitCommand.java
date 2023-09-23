package com.ludoclt.logicraft.common.commands;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;

import com.ludoclt.logicraft.cores.builder.CircuitBuilder;
import com.ludoclt.logicraft.cores.logic.Circuit;
import com.ludoclt.logicraft.cores.logic.components.Wire;
import com.ludoclt.logicraft.utils.CircDeserializer;
import com.ludoclt.logicraft.utils.Preferences;

import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.server.permission.PermissionAPI;

public class ImportCircuitCommand extends CommandBase
{
    @Override
    public String getName()
    {
        return "importcircuit";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "test";
    }

    @Override
    public List<String> getAliases()
    {
        return new ArrayList<String>() {{ add("impc"); }};
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        // if (sender instanceof EntityPlayer)
        // {
        //     return PermissionAPI.hasPermission((EntityPlayer)sender, "logicraft.command.importcircuit");
        // }
        return true;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if (args.length < 5)
        {
            throw new WrongUsageException(getUsage(sender));
        }
        
        if (Preferences.FilesDirectoryPath == null)
        {
            sender.sendMessage(new TextComponentString("Please select the folder where the logisim files are stored using the /setfilesdirectory command"));
            return;
        }
        
        try
        {
            Circuit circuit = CircDeserializer.parseCircuit(Preferences.FilesDirectoryPath + "/" + args[0]);
            //CircuitBuilder.buildRedstoneCircuit(circuit);
            // for (int i = 0; i < circuit.wires.size(); i++)
            // {
            //     sender.sendMessage(new TextComponentString("Wire from " + circuit.wires.get(i).start.x + circuit.wires.get(i).start.y + " to " + circuit.wires.get(i).end.x + circuit.wires.get(i).end.y));
            // }
            System.out.println("2");
            sender.sendMessage(new TextComponentString("Wires lenght : " + Integer.toString(circuit.wires.size())));
            System.out.print("3");
            //sender.getEntityWorld().setBlockState(new BlockPos(Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3])), Blocks.WOOL.getDefaultState());
        }
        catch (Exception e)
        {
            throw new CommandException(e.getMessage());
        }
    }

    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos target)
    {
        if (sender instanceof EntityPlayer && target != null) 
        {
            switch (args.length) {
                case 2:
                    return new ArrayList<String>() {{ add(String.valueOf(target.getX())); }};
                case 3:
                    return new ArrayList<String>() {{ add(String.valueOf(target.getY())); }};
                case 4:
                    return new ArrayList<String>() {{ add(String.valueOf(target.getZ())); }};
            }
        }
        return new ArrayList<String>();
    }
}
