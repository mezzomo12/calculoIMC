import java.util.Scanner;

public class IMC {

    static Scanner lerTeclado = new Scanner(System.in);

    public static void main(String[] args) {
        String nome   = lerNome();
        char   genero = lerGenero();
        double altura = lerAltura();
        double peso   = lerPeso();

        double imc           = calcularIMC(peso, altura);
        String classificacao = classificar(imc, genero);

        limparTela();
        exibirResultado(nome, genero, imc, classificacao);

        lerTeclado.close();
    }

    static String lerNome() {
        System.out.print("Nome: ");
        return lerTeclado.nextLine();
    }

    static char lerGenero() {
        System.out.print("Gênero (M: masculino, F: feminino, N: prefiro não informar): ");
        return lerTeclado.next().charAt(0);
    }

    static double lerAltura() {
        System.out.print("Altura (m, ex: 1,75): ");
        return lerTeclado.nextDouble();
    }

    static double lerPeso() {
        System.out.print("Peso (kg, ex: 70.5): ");
        return lerTeclado.nextDouble();
    }

    static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    static String classificar(double imc, char genero) {
        String classificacao;

        switch (genero) {
            case 'M':
            case 'm':
                if (imc >= 40)       classificacao = "Obesidade Mórbida";
                else if (imc >= 30)  classificacao = "Obesidade Moderada";
                else if (imc >= 25)  classificacao = "Obesidade Leve";
                else if (imc >= 20)  classificacao = "Normal";
                else                 classificacao = "Abaixo do Normal";
                break;

            case 'F':
            case 'f':
            case 'N':
            case 'n':
                if (imc >= 39)       classificacao = "Obesidade Mórbida";
                else if (imc >= 29)  classificacao = "Obesidade Moderada";
                else if (imc >= 24)  classificacao = "Obesidade Leve";
                else if (imc >= 19)  classificacao = "Normal";
                else                 classificacao = "Abaixo do Normal";
                break;

            default:
                classificacao = "Gênero inválido";
        }

        return classificacao;
    }

    static void limparTela() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void exibirResultado(String nome, char genero, double imc, String classificacao) {
        System.out.println("Nome: " + nome);
        System.out.println("Gênero: " + genero);
        System.out.printf("IMC: %.1f%n", imc);
        System.out.println("Classificação: " + classificacao);
    }
}
