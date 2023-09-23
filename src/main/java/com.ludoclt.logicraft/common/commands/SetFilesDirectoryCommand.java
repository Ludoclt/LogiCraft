package com.ludoclt.logicraft.common.commands;

import java.util.ArrayList;
import java.util.List;

import com.ludoclt.logicraft.utils.Preferences;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.WrongUsageException;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.server.permission.PermissionAPI;

public class SetFilesDirectoryCommand extends CommandBase
{
    @Override
    public String getName()
    {
        return "setfilesdirectory";
    }

    @Override
    public String getUsage(ICommandSender sender)
    {
        return "test";
    }

    @Override
    public List<String> getAliases()
    {
        return new ArrayList<String>() {{ add("sfd"); }};
    }

    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        // if (sender instanceof EntityPlayer)
        // {
        //     return PermissionAPI.hasPermission((EntityPlayer)sender, "logicraft.command.setfileslocation");
        // }
        return true;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if (args.length < 1)
        {
            throw new WrongUsageException(getUsage(sender));
        }
        
        Preferences.FilesDirectoryPath = args[0];
        sender.sendMessage(new TextComponentString(("The files directory path has been set to " + args[0])));
    }
}
