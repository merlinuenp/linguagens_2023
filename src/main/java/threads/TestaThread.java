package threads;

public class TestaThread {  

    public static void main(String[] args) throws InterruptedException {
//        Tarefa t1 = new Tarefa(" 1"); 
//        Tarefa t2 = new Tarefa(" 2");
//        t1.run();
//        t2.run();
//        
//        System.out.println("main terminou ");
//        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        TarefaParalela tarefa1 = new TarefaParalela(" 1");
        TarefaParalela tarefa2 = new TarefaParalela(" 2");
        tarefa1.start();
        tarefa2.start();
        
        tarefa1.join();
        tarefa2.join();
        System.out.println("Main terminou");
       


    }
}
