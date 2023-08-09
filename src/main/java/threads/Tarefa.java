package threads;

public class Tarefa {
    String nome;
    
    public Tarefa(String nome) {this.nome = nome; }
    
    public void run( ) throws InterruptedException {
        for (int i=0; i<4; i++){
            System.out.println("Sou a tarefa "+ this.nome);
            Thread.sleep(1000);
        }
    }

}
