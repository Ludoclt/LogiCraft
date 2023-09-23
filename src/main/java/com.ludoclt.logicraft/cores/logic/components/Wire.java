package com.ludoclt.logicraft.cores.logic.components;

import java.awt.Color;

import javax.vecmath.Vector2d;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Wire extends LogisimElement
{
    public Vector2d start;
    public Vector2d end;
    public String debug;

    public Wire(Vector2d wireStart, Vector2d wireEnd)
    {
        this.start = wireStart;
        this.end = wireEnd;
    }

    @Override
    public void build(World world, String facing)
    {
        switch (facing)
        {
            case "north":
                
            case "east":
                // for (int i = 0; i < end-start; i++)
                // {
                //     world.setBlockState(new BlockPos(origin.getX()+i, origin.getY(), origin.getZ()), Blocks.WOOL.getDefaultState());
                //     world.setBlockState(new BlockPos(origin.getX()+i, origin.getY()+1, origin.getZ()), Blocks.REDSTONE_WIRE.getDefaultState());
                // }
            case "west":
                // for (int i = 0; i < end-start; i++)
                // {
                //     world.setBlockState(new BlockPos(origin.getX()-i, origin.getY(), origin.getZ()), Blocks.WOOL.getDefaultState());
                //     world.setBlockState(new BlockPos(origin.getX()-i, origin.getY()+1, origin.getZ()), Blocks.REDSTONE_WIRE.getDefaultState());
                // }
            case "south":
                // for (int i = 0; i < end-start; i++)
                // {
                //     world.setBlockState(new BlockPos(origin.getX(), origin.getY(), origin.getZ()+i), Blocks.WOOL.getDefaultState());
                //     world.setBlockState(new BlockPos(origin.getX(), origin.getY()+1, origin.getZ()+i), Blocks.REDSTONE_WIRE.getDefaultState());
                // }
        }
    }
}
