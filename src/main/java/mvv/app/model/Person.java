package mvv.app.model;

import mvv.app.base.AbsMongoModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by manh.vu on 6/5/2015.
 */
public class Person extends AbsMongoModel {
    public String name;
    public Integer age;
    public List<String> groups;

    public Person() {
        super();

        groups = new ArrayList<String>(5);
    }
}
