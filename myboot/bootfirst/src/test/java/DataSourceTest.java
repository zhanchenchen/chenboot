import com.learn.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Unit test for simple Application.
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class DataSourceTest {

    @Autowired
    private DataSource dataSource;
    @Test
    public void testDataSource() throws SQLException {
        Connection connection = this.dataSource.getConnection();
        System.err.println(connection);
    }

}
