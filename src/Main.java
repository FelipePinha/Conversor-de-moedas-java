import br.com.alura.models.Converter;
import br.com.alura.models.ConverterResponse;

import java.util.Scanner;

public class Main {

    public static void calcConversion(String initialCurrency, String currencyToConvert) {
        Converter converter = new Converter();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o valor que deseja converter");
        double value = scanner.nextDouble();
        ConverterResponse convertedValue = converter.convertValue(initialCurrency, currencyToConvert, value);
        System.out.printf("Valor %.2f [%s] corresponde ao valor final de =>>> %s [%s]%n", value, initialCurrency, convertedValue.conversion_result(), currencyToConvert);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        String menu = """
        1) Dólar =>> Peso argentino
        2) Peso argentino =>> Dólar
        3) Dólar =>> Real brasileiro
        4) Real brasileiro =>> Dólar
        5) Dólar =>> Peso colombiano
        6) Peso colombiano =>> Dólar
        7) Sair
        """;

        while(option != 7) {
            System.out.println("*******************************");
            System.out.println(menu);
            System.out.print("Escolha uma opção válida: ");
            option = scanner.nextInt();

            if(option == 7) break;

            try {
                switch (option) {
                    case 1:
                        calcConversion("USD", "ARS");
                        break;
                    case 2:
                        calcConversion("ARS", "USD");
                        break;
                    case 3:
                        calcConversion("USD", "BRL");
                        break;
                    case 4:
                        calcConversion("BRL", "USD");
                        break;
                    case 5:
                        calcConversion("USD", "COP");
                        break;
                    case 6:
                        calcConversion("COP", "USD");
                        break;
                    default:
                        System.out.println("Opção inválida...");
                }
            } catch (RuntimeException e) {
                System.out.println("Não foi possível converter o valor...");
            }
        }

        System.out.println("Finalizando o programa...");
    }
}