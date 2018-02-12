package io.univ.rouen.smartclass.weightpoc.simulators;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import ru.yandex.qatools.embed.postgresql.EmbeddedPostgres;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static ru.yandex.qatools.embed.postgresql.distribution.Version.Main.V9_6;

public class DataTest {

    private Gson gson;

    private Connection connection;

    @Before
    public void setUp() throws IOException, SQLException {
        this.gson = new Gson();
        // starting Postgres
        final EmbeddedPostgres postgres = new EmbeddedPostgres(V9_6);
        // predefined data directory
        // final EmbeddedPostgres postgres = new EmbeddedPostgres(V9_6, "/path/to/predefined/data/directory");
        final String url = postgres.start("localhost", 5432, "dbName", "userName", "password");

        // connecting to a running Postgres and feeding up the database
        connection = DriverManager.getConnection(url);
        connection.createStatement().execute("CREATE TABLE data ( " +
                "id integer NOT NULL" +
                "stringData " +
                "longData " +
                "doubleData " +
                "localDate " +
                "listIntData " +
                "PRIMARY KEY(id));");
        connection.createStatement().execute("INSERT INTO data VALUES ('movie');");
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
