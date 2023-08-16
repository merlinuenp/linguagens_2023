package ponte;


public class Ponte {
    
    public synchronized void atravessar(Veiculo v) throws InterruptedException{
        System.out.println(v.getName()+ " está passando");
        for (int i=1; i < 11; i++){
            System.out.print(i + " ");
            Thread.sleep(500);
        }
        System.out.println("");
    }
    
}
