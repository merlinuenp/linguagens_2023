package future;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class TestaFuture {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int QUANTIDADE = 1_000_000;
        Integer v1[] = new Integer[QUANTIDADE];
        Random gerador = new Random();
        for (int i = 0; i < QUANTIDADE; i++) {
            v1[i] = gerador.nextInt();
        }

        Integer v2[] = new Integer[QUANTIDADE];
        for (int i = 0; i < QUANTIDADE; i++) {
            v2[i] = gerador.nextInt();
        }

        List<Integer> lista1 = Arrays.asList(v1);
        List<Integer> lista2 = Arrays.asList(v2);

        // somar convencional
        long inicio = System.currentTimeMillis();
        ordena(lista1);
        ordena(lista2);
        System.out.println("Tempo decorrido: "+ (System.currentTimeMillis() - inicio));

// maior convencional 
//          long inicio = System.currentTimeMillis(); 
//          int maior = lista1.stream().reduce(Integer::max).get();
//          int maior2 = lista2.stream().reduce(Integer::max).get();
//          System.out.println(maior);
//          System.out.println(maior2);

        inicio = System.currentTimeMillis();
        CompletableFuture<List<Integer>> future = CompletableFuture.supplyAsync(
                () -> ordena(lista1));

        CompletableFuture<List<Integer>> future2 = CompletableFuture.supplyAsync(
                () -> ordena(lista2));

        future.get();
        future2.get();
        System.out.println("Tempo decorrido: " + (System.currentTimeMillis() - inicio));
        System.out.println(Thread.currentThread().getName());
    }

//    public static Integer maior(List<Integer> lista) {
//        System.out.println(Thread.currentThread().getName());
//        System.out.println("procurando");
//        return lista.stream().reduce(Integer::max).get();
//    }
//
//    public static Integer somar(List<Integer> lista) {
//        System.out.println(Thread.currentThread().getName());
//        System.out.println("somando");
//        return lista.stream().reduce(Integer::sum).get();
//    }

    public static List<Integer> ordena(List<Integer> lista) {
        System.out.println(Thread.currentThread().getName());
        Collections.sort(lista);
        System.out.println("ordenou");
        return lista;
    }
}
