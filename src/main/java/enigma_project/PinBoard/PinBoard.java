package enigma_project.PinBoard;

import java.util.ArrayList;

public class PinBoard {
    ArrayList<Connection> connections = new ArrayList<>();

    public PinBoard() {
    }

    /**
     * Method to add a new connection between two letters on the PinBoard
     * @param a the first letter
     * @param b the second letter
     * @throws IllegalArgumentException if either letter is already used
     */
    public void addConnection(char a, char b) throws IllegalArgumentException {
        // If either letter is already used, we cannot connect them
        if (has(a, b)){
            throw new IllegalArgumentException("One or both characters is already connected on the PinBoard");
        }

        // If not, they will be connected
        Connection connection = new Connection(a, b);
        connections.add(connection);
    }

    public boolean has(char a, char b){
        for(Connection connection : connections){
            if(connection.has(a, b)){
                return true;
            }
        }
        return false;
    }

    /**
     * Method to try to swap the character with one on the PinBoard if there is a valid connection
     * @param a the original character
     * @return a new char if there is a connection, the original if not
     */
    public char swap(char a){
        for (Connection connection : connections){
            // Tries to switch the letter
            char c = connection.swap(a);
            // If successful, return the new letter
            if (c!=a){ return c; }
        }
        return a;
    }

    public ArrayList<Connection> getConnections() {
        return connections;
    }
}
