package triangulopascaldiscretas.trianglepascalapp.model;

public class Variaciones {
    public static long calcularVariacionesSinRepeticion(int n, int k) {
        return factorial(n) / factorial(n - k);
    }

    public static long calcularVariacionesConRepeticion(int n, int k) {
        return (long) Math.pow(n, k);
    }

    private static long factorial(int num) {
        long result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }
}
