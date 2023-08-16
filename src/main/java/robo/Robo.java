package robo;

public class Robo {
    
    public static long contar(int x, int y) {
        if (x == 0 || y == 0) {
            return 1;
        }
        return (contar(x - 1, y) + contar(x, y - 1));
    }
    
    
    public static void main(String[] args) {
        long quantidade = Robo.contar(2, 2);
        System.out.println(quantidade);
    }
    
}
