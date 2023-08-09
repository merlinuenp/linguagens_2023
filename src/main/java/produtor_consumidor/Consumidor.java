package produtor_consumidor;


public class Consumidor extends Thread {
    Buffer buffer;
    
    public Consumidor(Buffer fila){
        buffer = fila; 
    }
    
    public void run(){
        int item;
        while (true){
            try {
                item = buffer.retirar();
                System.out.println("Item retirado: "+item);
                
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}           
        }
        
    }
}