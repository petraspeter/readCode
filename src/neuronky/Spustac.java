package neuronky;

/**
 *
 * @author Raven
 */
public class Spustac {
    
    
    public static void main(String[] args) {
        Read read = new Read(10, 35);
        read.generujKod(0);
        read.vypisKod();
        Uzol otec = read.getOtec();
        read.naplnStrom(otec);
        read.vypisStrom();
    }
    
}
