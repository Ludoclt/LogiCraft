package com.ludoclt.logicraft.cores.logic;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;

import com.ludoclt.logicraft.cores.logic.components.Wire;

public class Circuit 
{
    public List<Wire> wires;
    public List<Element> components;

    public Circuit()
    {
        wires = new ArrayList<Wire>();
        components = new ArrayList<Element>();
    }
}
