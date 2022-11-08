package enigma_project.PinBoard;

import java.lang.constant.Constable;

public class Connection {
    char a;
    char b;

    public Connection(char a, char b) {
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
