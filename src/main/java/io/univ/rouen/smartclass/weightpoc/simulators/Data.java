package io.univ.rouen.smartclass.weightpoc.simulators;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Entity
//@Document(collection = "data")
public class Data {

    @Id
    private long id;

    final static int MAX_LIST_ELEMENT = 500;

    private String stringData;

    private long longData;

    private double doubleData;

    @Temporal(TemporalType.DATE)
    private LocalDate localDate;

    private List<Double> listIntData;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public static int getMaxListElement() {
        return MAX_LIST_ELEMENT;
    }

    public String getStringData() {
        return stringData;
    }

    public void setStringData(String stringData) {
        this.stringData = stringData;
    }

    public long getLongData() {
        return longData;
    }

    public void setLongData(long longData) {
        this.longData = longData;
    }

    public double getDoubleData() {
        return doubleData;
    }

    public void setDoubleData(double doubleData) {
        this.doubleData = doubleData;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public List<Double> getListIntData() {
        return listIntData;
    }

    public void setListIntData(List<Double> listIntData) {
        this.listIntData = listIntData;
    }

    public static Data randomizeData() {
        Data data = new Data();

        data.setStringData(UUID.randomUUID().toString());
        data.setDoubleData(Math.random() * MAX_LIST_ELEMENT);
        data.setLongData((long) (Math.random() * MAX_LIST_ELEMENT));

        List<Double> list = new ArrayList<>();
        for (double i = 0; i < Math.random() * MAX_LIST_ELEMENT; ++i) {
            list.add(Math.random() * MAX_LIST_ELEMENT);
        }
        data.setListIntData(list);
        data.setLocalDate(Data.dateGenerator());

        return data;
    }

    static LocalDate dateGenerator() {
        return LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70))));
    }

    @Override
    public String toString() {
        return "Data{" +
                "id='" + id + '\'' +
                "stringData='" + stringData + '\'' +
                ", longData=" + longData +
                ", doubleData=" + doubleData +
                ", localDate=" + localDate +
                ", listIntData=" + listIntData +
                '}';
    }
}
