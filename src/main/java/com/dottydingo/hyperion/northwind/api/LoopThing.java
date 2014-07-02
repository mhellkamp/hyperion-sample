package com.dottydingo.hyperion.northwind.api;

/**
 */
public class LoopThing
{
    private String label;
    private LoopThing anotherLoop;

    public String getLabel()
    {
        return label;
    }

    public void setLabel(String label)
    {
        this.label = label;
    }

    public LoopThing getAnotherLoop()
    {
        return anotherLoop;
    }

    public void setAnotherLoop(LoopThing anotherLoop)
    {
        this.anotherLoop = anotherLoop;
    }
}
