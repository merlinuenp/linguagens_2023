package ponte;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Veiculo extends Thread {
    Ponte ponte;
    
    public Veiculo(String nome, Ponte p){
        this.setName(nome);
        this.ponte = p;
    }
    
    @Override
    public void run(){
        try {
            ponte.atravessar(this);
        } catch (InterruptedException ex) {
            Logger.getLogger(Veiculo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    
}
