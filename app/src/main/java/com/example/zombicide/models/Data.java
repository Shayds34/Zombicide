package com.example.zombicide.models;

public class Data
{
    private Skill[] skills;

    private String story_fr;

    private String name;

    private String from;

    private String id;

    private String alt_armor_en;

    public Skill[] getSkills ()
    {
        return skills;
    }

    public void setSkills (Skill[] skills)
    {
        this.skills = skills;
    }

    public String getStory_fr ()
    {
        return story_fr;
    }

    public void setStory_fr (String story_fr)
    {
        this.story_fr = story_fr;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getFrom ()
    {
        return from;
    }

    public void setFrom (String from)
    {
        this.from = from;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getAlt_armor_en ()
    {
        return alt_armor_en;
    }

    public void setAlt_armor_en (String alt_armor_en)
    {
        this.alt_armor_en = alt_armor_en;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [skills = "+skills+", story_fr = "+story_fr+", name = "+name+", from = "+from+", id = "+id+", alt_armor_en = "+alt_armor_en+"]";
    }
}