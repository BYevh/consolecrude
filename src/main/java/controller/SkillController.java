package controller;

import model.Skill;
import repository.SkillRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class SkillController {
    private final String INPUT_ID = "Input new ID:";
    private final String INPUT_SKILL = "Input new SKILL:";

    private SkillRepository skillRepository = new SkillRepository();

    public TreeSet<Skill> menuOfSkills() throws IOException {
        TreeSet<Skill> setOfSkills = new TreeSet<Skill>();

        //пока без проверки на валидность
        int item;
        do {
            item = Integer.parseInt(inputData());
            switch (item) {
                case 1: {                       //1. Show all skills.
                    setOfSkills = skillRepository.getAllSkills();
                    break;
                }
                case 2: {                       //2. Add new skill.
                    System.out.println(INPUT_ID);
                    Long id = Long.parseLong(inputData());
                    System.out.println(INPUT_SKILL);
                    String skill = inputData();
                    setOfSkills = skillRepository.updateSkills(id, skill);
                    break;
                }
                case 3: {                       //2. Exit
                    break;
                }
            }
        } while (item != 3);

        return setOfSkills;
    }

    protected String inputData() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        try {
            s = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

}
