package enigma_project.PinBoard;

/**
 * Connection class
 * @author flippi321
 * @version 1.0
 */
public class Connection {
    char a;
    char b;

    public Connection(char a, char b) throws IllegalArgumentException {
        if(a==b){
            throw new IllegalArgumentException("The characters on the switchboard must be different");
        }
        this.a = a;
        this.b = b;
    }

    public boolean has(char c1, char c2){
        return a==c1 | a==c2 | b==c1 | b==c2;
    }

    public char swap(char c){
        if (c==a) { return b; }
        if (c==b) { return a; }
        return c;
    }

    public char getA() {
        return a;
    }

    public char getB() {
        return b;
    }
}
