package io.univ.rouen.smartclass.weightpoc.entities;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class TimeSlot {

    private Date in;

    private Date out;

    public Date getIn() {
        return in;
    }

    public void setIn(Date in) {
        this.in = in;
    }

    public Date getOut() {
        return out;
    }

    public void setOut(Date out) {
        this.out = out;
    }
}
