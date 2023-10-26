import java.security.SecureRandom;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SecureRandom random = new SecureRandom();

        System.out.println("Elige el nivel de dificultad: ");
        System.out.println("1: Fácil (números de un dígito)");
        System.out.println("2: Medio (números de dos dígitos)");
        System.out.println("3: Difícil (números de tres dígitos)");
        int level = scanner.nextInt();

        System.out.println("Elige el tipo de problema: ");
        System.out.println("1: Suma");
        System.out.println("2: Resta");
        System.out.println("3: Multiplicación");
        System.out.println("4: División");
        System.out.println("5: Aleatorio");
        int problemType = scanner.nextInt();

        int num1 = generateNumber(level, random);
        int num2 = generateNumber(level, random);

        double correctAnswer = generateQuestion(num1, num2, problemType, random);

        double userAnswer = scanner.nextDouble();

        if (Math.abs(userAnswer - correctAnswer) < 0.001) {
            System.out.println("Correcto!");
        } else {
            System.out.println("Incorrecto. La respuesta correcta era: " + correctAnswer);
        }

    }

    public static int generateNumber(int level, SecureRandom random) {
        int number;
        switch (level) {
            case 1:
                number = 1 + random.nextInt(9);
                break;
            case 2:
                number = 10 + random.nextInt(90);
                break;
            case 3:
                number = 100 + random.nextInt(900);
                break;
            default:
                number = 1 + random.nextInt(9);
        }
        return number;
    }

    public static double generateQuestion(int num1, int num2, int problemType, SecureRandom random) {
        if (problemType == 5) {
            problemType = 1 + random.nextInt(4);
        }

        switch (problemType) {
            case 1:
                System.out.println("¿Cuánto es " + num1 + " más " + num2 + "?");
                return num1 + num2;
            case 2:
                System.out.println("¿Cuánto es " + num1 + " menos " + num2 + "?");
                return num1 - num2;
            case 3:
                System.out.println("¿Cuánto es " + num1 + " por " + num2 + "?");
                return num1 * num2;
            case 4:
                while (num2 == 0) { // Evita la división por cero
                    num2 = generateNumber(1, random);
                }
                System.out.println("¿Cuánto es " + num1 + " dividido por " + num2 + "?");
                return (double) num1 / num2;
            default:
                return 0;
        }
    }
}
