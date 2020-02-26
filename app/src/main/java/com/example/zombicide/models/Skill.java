package com.example.zombicide.models;

import org.jetbrains.annotations.NotNull;

public class Skill
{
    private String skill_name_fr;

    private String description_fr;

    private String skill_name_en;

    private String skill_id;

    public String getSkill_name_fr ()
    {
        return skill_name_fr;
    }

    public void setSkill_name_fr (String skill_name_fr)
    {
        this.skill_name_fr = skill_name_fr;
    }

    public String getDescription_fr ()
    {
        return description_fr;
    }

    public void setDescription_fr (String description_fr)
    {
        this.description_fr = description_fr;
    }

    public String getSkill_name_en ()
    {
        return skill_name_en;
    }

    public void setSkill_name_en (String skill_name_en)
    {
        this.skill_name_en = skill_name_en;
    }

    public String getSkill_id ()
    {
        return skill_id;
    }

    public void setSkill_id (String skill_id)
    {
        this.skill_id = skill_id;
    }

    @NotNull
    @Override
    public String toString()
    {
        return "ClassPojo [skill_name_fr = "+skill_name_fr+", description_fr = "+description_fr+", skill_name_en = "+skill_name_en+", skill_id = "+skill_id+"]";
    }
}