package future;

import java.util.Arrays;
import java.util.concurrent.Callable;

public class Somador 
        implements Callable<Integer> {
    
    private Integer vetor[];
    
    public Somador(Integer v[]){
       vetor = v; 
    }
    
    @Override
    public Integer call(){
        return Arrays.stream(vetor).reduce(0, Integer::sum);
    }
    
}
