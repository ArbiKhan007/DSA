package com.naukri.central_api.service;

import com.naukri.central_api.models.Skill;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {

    public List<Skill> getAllSkills(List<String> skillNames){
        List<Skill> skillObjs = new ArrayList<>();
        for(int i = 0; i < skillNames.size(); i++){
            String skillName = skillNames.get(i);
            // We need to get the skill object from database by skill name.
            Skill skill =  this.getSkillByName(skillName);
            skillObjs.add(skill);
        }
        return skillObjs;
    }


    public Skill getSkillByName(String skillName){
        // This function will make call to dbApi skill controller such that we will
        // be bringing skill object from the database.
    }


}
