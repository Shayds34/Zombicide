package com.example.zombicide.models;

public class Zombicide
{
    private String Game;

    private Data[] data;

    private String title;

    private String version;

    public String getGame ()
    {
        return Game;
    }

    public void setGame (String Game)
    {
        this.Game = Game;
    }

    public Data[] getData ()
    {
        return data;
    }

    public void setData (Data[] data)
    {
        this.data = data;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [Game = "+Game+", data = "+data+", title = "+title+", version = "+version+"]";
    }
}