package io.univ.rouen.smartclass.weightpoc.entities;

import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "time_slot")
@Document(collection = "time_slot")
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private ZonedDateTime in;

    private ZonedDateTime out;

    public ZonedDateTime getIn() {
        return in;
    }

    public void setIn(ZonedDateTime in) {
        this.in = in;
    }

    public ZonedDateTime getOut() {
        return out;
    }

    public void setOut(ZonedDateTime out) {
        this.out = out;
    }
}
