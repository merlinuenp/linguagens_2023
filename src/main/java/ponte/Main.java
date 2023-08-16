package ponte;

public class Main {
    public static void main(String[] args) {
        Ponte p = new Ponte();
        Veiculo v1 = new Veiculo("Comum (v1)", p);
        Veiculo v2 = new Veiculo("Comum (v2)", p);
        Veiculo v4 = new Veiculo("Ambulância (v4)", p);
        v4.setPriority(10);
        Veiculo v3 = new Veiculo("Polícia", p);
        v3.setPriority(9);
        Veiculo v5 = new Veiculo("Ambulância (v5)", p);
        v5.setPriority(10);      
        v1.start();
        v2.start();
        v3.start();
        v4.start();
        v5.start();
    }
}
