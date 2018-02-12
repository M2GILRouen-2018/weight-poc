package io.univ.rouen.smartclass.weightpoc.simulators;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class DataTest {

    private Gson gson;

    @Before
    public void setUp() {
        this.gson = new Gson();
    }

    @Test
    public void whenGeneratedSomeData_thenDataAreDifferents() {
        List<Data> dataList = new ArrayList<>();

        for (int i = 0; i < 10; ++i) {
            dataList.add(Data.randomizeData());
        }

        for (Data data : dataList) {
            System.out.println("-------------------------- DATA --------------------------");
            System.out.println(data.toString());
            System.out.println(gson.toJson(data));
            System.out.println();
        }
    }
}
