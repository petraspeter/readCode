package neuronky;

import java.util.Stack;

/**
 *
 * @author student
 */
public class Read {
    
    private int intervalOd;
    
    private int intervalDo;
    
    private int dlzkaKodu;
    
    private int vygenerujUzolKodu;
    
    private int[] kod;
    
    private int posun = 0;
    
    private Uzol otec = new Uzol(0);
    
    public Read(int intervalOd, int intervalDo) {
        this.intervalOd = intervalOd;
        this.intervalDo = intervalDo;
        this.dlzkaKodu = (int) ((Math.random()*(intervalDo - intervalOd)) + intervalOd);
        this.vygenerujUzolKodu = this.dlzkaKodu;
        kod = new int[dlzkaKodu];
        // System.out.println("Dlzka kodu je: " + dlzkaKodu + "\nDalsie cislo ktore mozeme vygenerovat je v rozsahu od 0 do " + (vygenerujUzolKodu - 1));
    }
    
    public void generujKod(int prePoziciu) {
        if(prePoziciu < kod.length) {
            if(vygenerujUzolKodu > 1) {
                if(prePoziciu == 0) {
                    kod[prePoziciu] = (int) (Math.random() * vygenerujUzolKodu) + 1;
                } else {
                    if(vygenerujUzolKodu == 1) {
                        kod[prePoziciu] = (int) (Math.random() * vygenerujUzolKodu) + 1;
                    } else {
                        kod[prePoziciu] = (int) (Math.random() * vygenerujUzolKodu);
                    }
                }
                vygenerujUzolKodu = vygenerujUzolKodu - kod[prePoziciu];
            }
            generujKod(prePoziciu+1);
        }
    }
    
    public String vypisKod() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < kod.length; i++) {
            sb.append(kod[i]).append('.');
        }naplnZasobnik();
        return sb.toString();
    }
    
    
    private  Stack<Integer> zasobnik = new Stack<Integer>();
    
    public  void naplnZasobnik() {
        for (int i = kod.length-1; i > 0; i--) {
            zasobnik.push(kod[i]);
        }
        otec.setHodnota(kod[0]);
    }
    
    public void naplnStrom(Uzol uzol) {
        if(uzol.getHodnota() > 0) {
            for (int i = 0; i < uzol.getHodnota(); i++) {
                if(!zasobnik.isEmpty()) {
                    Uzol novyUzol = new Uzol(zasobnik.pop());
                    uzol.pridajPotomka(novyUzol);
                    naplnStrom(novyUzol);
                }
            }
        }
    }
    
    public void vypisStrom() {
        if(otec.getHodnota() == 1) {
            System.out.println("Som prarodic kodu a aj ked mam len 1 dieta, tak mam az " +
                    (dlzkaKodu - 1) + " potomkov, pricom dlzka kodu je: "+ dlzkaKodu +
                    "\nMoj kod vyzera takto: " + vypisKod() + "\n");
        } else {
            System.out.println("Som prarodic kodu a mam " + otec.getHodnota() + " deti a celkovo " +
                    (dlzkaKodu - 1) + " potomkov, pricom dlzka kodu je: "+ dlzkaKodu +
                    "\nMoj kod vyzera takto: " + vypisKod() + "\n");
        }
        otec.vypisSa();
    }
    
    public Uzol getOtec() {
        return otec;
    }
    
    public void setOtec(Uzol otec) {
        this.otec = otec;
    }
    
    
    
}

