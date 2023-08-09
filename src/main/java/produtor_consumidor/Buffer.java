package produtor_consumidor;

public class Buffer {
    private Integer fila[];
    int frente, rabo, tamanhoMax, tamanhoAtual; 
    
    public Buffer(int tamanhoMax){
        fila = new Integer[tamanhoMax];
        this.tamanhoMax = tamanhoMax;
        frente = -1;
        rabo = -1; 
        this.tamanhoAtual = 0; 
    }
    
    public synchronized void depositar(int item){
        try{
            while (tamanhoAtual == tamanhoMax ){
                wait();
                System.out.println("Produtor foi dormir ");
            }
            rabo = (rabo + 1) % tamanhoMax; 
            fila[rabo] = item;
            tamanhoAtual++; 
            if (frente == -1) {
                frente = rabo; 
            }
            //Thread.sleep(1000); // só para visualizar
            notifyAll();          
        }
        catch( InterruptedException e){}
    }
    
    
    public synchronized int retirar() throws InterruptedException{
        int item = 0;
        while (tamanhoAtual == 0){
            wait();
            System.out.println("Consumidor foi dormir");
        }
        item = fila[frente];
        fila[frente] = null;
        frente = (frente + 1) % tamanhoMax;
        tamanhoAtual--;         
        //Thread.sleep(1000); // só para visualizar
        notifyAll();
        return item; 
        
    }
    
}