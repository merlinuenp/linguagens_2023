package threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TarefaParalela extends Thread {
    
    public TarefaParalela(String nome) {
        super(nome);
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 4; i++) {
            System.out.println("Sou a tarefa " + this.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TarefaParalela.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
