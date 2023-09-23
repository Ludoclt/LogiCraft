package com.ludoclt.logicraft.cores.logic.components;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public abstract class LogisimElement 
{
    public BlockPos origin;

    public abstract void build(World world, String facing);
}
