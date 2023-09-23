package com.ludoclt.logicraft.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.vecmath.Vector2d;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ludoclt.logicraft.cores.logic.Circuit;
import com.ludoclt.logicraft.cores.logic.components.Wire;

public class CircDeserializer 
{
    public static Circuit parseCircuit(String filePath)
    {
        Circuit parsedCircuit = new Circuit();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            DocumentBuilder builder = factory.newDocumentBuilder();

            Document document = builder.parse(new File(filePath));

            document.getDocumentElement().normalize();
            Element circuit = (Element)document.getElementsByTagName("circuit").item(0);
            NodeList wires = circuit.getElementsByTagName("wires");
            System.out.println(((Element)wires.item(1)).getAttribute("from"));
            NodeList components = circuit.getElementsByTagName("comp");

            parsedCircuit = parseObjects(wires, components);
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace();
        }
        catch (SAXException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return parsedCircuit;
    }

    private static Circuit parseObjects(NodeList wires, NodeList components)
    {
        Circuit parsedCircuit = new Circuit();
        for (int i = 0; i < wires.getLength(); i++)
        {
            Vector2d start = new Vector2d();
            Vector2d end = new Vector2d();

            String from = ((Element)wires.item(i)).getAttribute("from");
            String to = ((Element)wires.item(i)).getAttribute("to");

            start.x = Double.parseDouble(from.substring(from.indexOf("(")+1, from.lastIndexOf(",")));
            start.y = Double.parseDouble(from.substring(from.indexOf(",")+1, from.lastIndexOf(")")));
            end.x = Double.parseDouble(to.substring(to.indexOf("(")+1, to.lastIndexOf(",")));
            end.y = Double.parseDouble(to.substring(to.indexOf(",")+1, to.lastIndexOf(")")));
            
            Wire wire = new Wire(start, end);
            wire.debug = "wire added";
            parsedCircuit.wires.add(wire);
            //parsedCircuit.wires.add((Element)wires.item(i));
        }
        for (int i = 0; i < components.getLength(); i++)
        {
            parsedCircuit.components.add((Element)components.item(i));
        }
        return parsedCircuit;
    }
}
