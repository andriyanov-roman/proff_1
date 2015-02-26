import carrentals.connection.ConnectionManagerMySQL;
import carrentals.controller.PagePath;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by Tatty on 24.02.2015.
 */
public class BundleTest {

    @Test
    public void testBundle() throws Exception {
        Connection connection = ConnectionManagerMySQL.getInstance().getConnection();
        Assert.assertNotNull(connection);
    }
}
