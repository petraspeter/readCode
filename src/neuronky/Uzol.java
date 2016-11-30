package neuronky;

import java.util.*;

/**
 *
 * @author Raven
 */
public class Uzol {
    
    private int hodnota;
    private List<Uzol> uzly = new ArrayList<>();
    
    public Uzol(int hodnota) {
        this.hodnota = hodnota;
    }
    
    public void pridajPotomka(Uzol uzol) {
        uzly.add(uzol);
    }
    
    public int getHodnota() {
        return hodnota;
    }
    
    public void setHodnota(int hodnota) {
        this.hodnota = hodnota;
    }
    
    public List<Uzol> getUzly() {
        return uzly;
    }
    
    public void setUzly(List<Uzol> uzly) {
        this.uzly = uzly;
    }
    
    @Override
    public String toString() {
        return "Hodnota uzlu je ";
    }
    
    public void vypisSa() {
        for (int i = 0; i < uzly.size(); i++) {
            System.out.println("Som dieta uzlu: " + hodnota + " a moja hodnota je: " + uzly.get(i).hodnota);
            uzly.get(i).vypisSa();
        }
    }
    
    
}
