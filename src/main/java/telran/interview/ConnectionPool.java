package telran.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ConnectionPool {
    Map<String, Connection> connections;
    int limit;

    // TODO wort out data
    // Connections pool comprises of some number of connections
    // It cannot contains nore than the predefined number of connections
    // You should define some connection Pool policy so that if number of
    // connections
    // is going to exceed the limit a connectiopn should be removed
    // Policy should take in consideration the order of adding connections in pool
    // and using connections
    public ConnectionPool(int limit) {
        connections = new LinkedHashMap<>(5, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Connection> eldest) {
                return size() > limit;
            }
        };
    }

    public void addConnection(Connection connection) {
        if (connections.containsKey(connection.connectionID())) {
            throw new IllegalStateException("The connection is already in pool");
        }
        connections.put(connection.connectionID(), connection);

    }

    public Connection getConnection(String connectionID) {
        if (!connections.containsKey(connectionID)) {
            throw new NoSuchElementException();
        }
        return connections.get(connectionID);
    }
}
