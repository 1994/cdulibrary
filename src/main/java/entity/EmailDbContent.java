package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reeco_000 on 2015/4/29.
 */
public class EmailDbContent {

    private String email;

    private List<String> threeDay = new ArrayList<String>();

    private List<String> zeroDay = new ArrayList<String>();

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getThreeDay() {
        return threeDay;
    }

    public void setThreeDay(List<String> threeDay) {
        this.threeDay = threeDay;
    }

    public List<String> getZeroDay() {
        return zeroDay;
    }

    public void setZeroDay(List<String> zeroDay) {
        this.zeroDay = zeroDay;
    }
}
