package neuronky;

/**
 *
 * @author Raven
 */
public class Neuronky {
    
    
    public static void main(String[] args) {
        Read read = new Read(10, 100);
        read.generujKod(0);
        read.vypisKod();
        Uzol otec = read.getOtec();
        read.naplnStrom(otec);
        read.vypisStrom();
    }
    
}
