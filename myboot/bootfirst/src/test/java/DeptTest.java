import com.learn.Application;
import com.learn.Service.IDeptService;
import com.learn.model.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * Unit test for simple Application.
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringRunner.class)
public class DeptTest {

    @Autowired
    private IDeptService deptService;
    @Test
    public void testDataSource() throws SQLException {
        List<Dept> list = this.deptService.list();
        System.err.println(list);
    }

}
