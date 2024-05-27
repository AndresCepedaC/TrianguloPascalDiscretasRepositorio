package triangulopascaldiscretas.trianglepascalapp.model;

public class Combinaciones {
    public static long calcularCombinaciones(int n, int k) {
        return factorial(n) / (factorial(k) * factorial(n - k));
    }

    private static long factorial(int num) {
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
