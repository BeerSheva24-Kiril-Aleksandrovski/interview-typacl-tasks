package telran.interview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class ConnectionPoolTest {
    @Test
    void addConnectionTest() {
        Connection[] connections = {
            new Connection("Dima"),
            new Connection("Kosta"),
        };
        ConnectionPool connectionPool = new ConnectionPool(2);
        for (Connection connection : connections) {
            connectionPool.addConnection(connection);
        }
        assertTrue(connectionPool.connections.containsKey("Dima"));
        assertThrowsExactly(IllegalStateException.class, () -> connectionPool.addConnection(new Connection("Dima")));
        connectionPool.addConnection(new Connection("Katya"));        
    }
    @Test
    void getConnectionTest() {
        ConnectionPool connectionPool = new ConnectionPool(2);
        Connection connection1 = new Connection("Dima");
        connectionPool.addConnection(connection1);
        Connection connection2 = new Connection("Kosta");
        connectionPool.addConnection(connection2);
        assertEquals(connection1, connectionPool.getConnection("Dima"));
        assertEquals(connection2, connectionPool.getConnection("Kosta"));
        assertThrows(NoSuchElementException.class, () -> connectionPool.getConnection("Vika"));
    }
    @Test
    void test() {
        ConnectionPool connectionPool = new ConnectionPool(2);
        Connection connection1 = new Connection("Dima");
        connectionPool.addConnection(connection1);
        Connection connection2 = new Connection("Kosta");
        connectionPool.addConnection(connection2);
        Connection connection3 = new Connection("Katya");
        connectionPool.addConnection(connection3);
        assertThrows(NoSuchElementException.class, () -> connectionPool.getConnection("Dima"));

        assertEquals(connection3, connectionPool.getConnection("Katya"));  
        assertEquals(connection2, connectionPool.getConnection("Kosta"));
        Connection connection4 = new Connection("Vika");
        connectionPool.addConnection(connection4);
        assertEquals(connection2, connectionPool.getConnection("Kosta"));
        assertEquals(connection4, connectionPool.getConnection("Vika"));          
    }
}
