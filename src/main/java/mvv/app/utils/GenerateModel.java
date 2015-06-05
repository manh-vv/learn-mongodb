package mvv.app.utils;

import mvv.app.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by manh.vu on 6/5/2015.
 */
public class GenerateModel {

    private Random random = new Random();
    private String[] names = {"A", "B", "C", "D", "E", "F"};
    private String[] groups = {"Group_A", "Group_B", "Group_C", "Group_D", "Group_E", "Group_F"};

    public List<Person> listPerson() {
        int size = 100;
        List<Person> listPerson = new ArrayList<Person>(size);

        StringBuilder sb;

        for (int i = 0; i < size; i++) {
            Person p = new Person();
            listPerson.add(p);

            sb = new StringBuilder(10);
            sb.append("Name").append(names[random.nextInt(5)]).append('_').append(i);

            p._id = "id-" + i;
            p.name = sb.toString();
            p.age = 15 + random.nextInt(5);

            for (int j = 0; j < random.nextInt(5); j++) {
                p.groups.add(groups[random.nextInt(5)]);
            }
        }

        return listPerson;
    }
}
