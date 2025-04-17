import br.com.alura.models.Converter;
import br.com.alura.models.ConverterResponse;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Converter converter = new Converter();
        ConverterResponse convertedValue = null;
        int option = -1;
        double value = 0;
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
                        System.out.println("Digite o valor que deseja converter");
                        value = scanner.nextDouble();
                        convertedValue = converter.convertValue("USD", "ARS", value);
                        System.out.printf("Valor %.2f [USD] corresponde ao valor final de =>>> %s [ARS]%n", value, convertedValue.conversion_result());
                        break;
                    case 2:
                        System.out.println("Digite o valor que deseja converter");
                        value = scanner.nextDouble();
                        convertedValue = converter.convertValue("ARS", "USD", value);
                        System.out.printf("Valor %.2f [ARS] corresponde ao valor final de =>>> %s [USD]%n", value, convertedValue.conversion_result());
                        break;
                    case 3:
                        System.out.println("Digite o valor que deseja converter");
                        value = scanner.nextDouble();
                        convertedValue = converter.convertValue("USD", "BRL", value);
                        System.out.printf("Valor %.2f [USD] corresponde ao valor final de =>>> %s [BRL]%n", value, convertedValue.conversion_result());
                        break;
                    case 4:
                        System.out.println("Digite o valor que deseja converter");
                        value = scanner.nextDouble();
                        convertedValue = converter.convertValue("BRL", "USD", value);
                        System.out.printf("Valor %.2f [BRL] corresponde ao valor final de =>>> %s [USD]%n", value, convertedValue.conversion_result());
                        break;
                    case 5:
                        System.out.println("Digite o valor que deseja converter");
                        value = scanner.nextDouble();
                        convertedValue = converter.convertValue("USD", "COP", value);
                        System.out.printf("Valor %.2f [USD] corresponde ao valor final de =>>> %s [COP]%n", value, convertedValue.conversion_result());
                        break;
                    case 6:
                        System.out.println("Digite o valor que deseja converter");
                        value = scanner.nextDouble();
                        convertedValue = converter.convertValue("COP", "USD", value);
                        System.out.printf("Valor %.2f [COP] corresponde ao valor final de =>>> %s [USD]", value, convertedValue.conversion_result());
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