package wachi.adoptiontest.pojo;

import java.util.List;

/**
 * Created by Usagi on 2017/12/1.
 */

public class CountryInfo {
    private String name;
    private List<String> divisions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDivisions() {
        return divisions;
    }

    public void setDivisions(List<String> divisions) {
        this.divisions = divisions;
    }
}
