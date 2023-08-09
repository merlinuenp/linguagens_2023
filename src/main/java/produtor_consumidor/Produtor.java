package produtor_consumidor;

import java.util.Random;

public class Produtor extends Thread{
    Buffer buffer;

    public Produtor(Buffer fila){
        buffer = fila;
    }
    
    public void run(){
        int novoItem;
        Random random = new Random();
        while (true){
            novoItem = random.nextInt(100);
            buffer.depositar(novoItem);
            System.out.println("Item depositado: "+ novoItem);
        }
    }
}