import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
/*         try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Vamos calcular seu IMC");
            System.out.print("Digite seu peso (kg): ");
            double peso = scanner.nextDouble();
            System.out.print("Digite sua altura (m): ");
            double altura = scanner.nextDouble();

            double imc = peso / (altura * altura);

            if (imc < 18.5) {
                System.out.println("Abaixo do peso");
            } else if (imc < 25) {
                System.out.println("Peso normal");
            } else if (imc < 30) {
                System.out.println("Sobrepeso");
            } else {
                System.out.println("Obeso");
            }
            System.out.println("Seu IMC: " + imc);
        }*/
      
      
      
        /*Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o numero que aparecera o mes");
        int mes = scanner.nextInt();

        switch (mes) {
            case 1:
                System.out.println("Janeiro");
                System.out.println("Verão");
                break;
            case 2:
                System.out.println("Fevereiro");
                System.out.println("Verão");
                break;
            case 3:
                System.out.println("Março");
                System.out.println("Outono");
                break;
            case 4:
                System.out.println("Abril");
                System.out.println("Outono");
                break;
            case 5:
                System.out.println("Maio");
                System.out.println("Outono");
                break;
            case 6:
                System.out.println("Junho");
                System.out.println("Inverno");
                break;
            case 7:
                System.out.println("Julho");
                System.out.println("Inverno");
                break;
            case 8:
                System.out.println("Agosto");
                System.out.println("Inverno");
                break;
            case 9:
                System.out.println("Setembro");
                System.out.println("Inverno");
                break;
            case 10:
                System.out.println("Outubro");
                System.out.println("Primavera");
                break;
            case 11:
                System.out.println("Novembro");
                System.out.println("Primavera");
                break;
            case 12:
                System.out.println("Dezembro");
                System.out.println("Verão");
                break;
        
            default:
                break;
        }*/

                //arrays

        int [] numeros = {1, 2, 3, 4, 5};
        int [] numeros2 = new int[5];
        numeros2[4] = 6;

        String [] nomes = {"Kombi", "Kers", "Pioneer"};
        String [] nomes2 = new String[3];
        nomes2[2] = "Pioneer";

        String descri = "Kombi: Carro clássico da Volkswagen, conhecido por seu design icônico e versatilidade. Kers: Sistema de recuperação de energia cinética utilizado em carros de Fórmula 1 para aumentar a potência. Pioneer: Marca renomada no setor de eletrônicos, especialmente conhecida por seus equipamentos de áudio e vídeo de alta qualidade.";
        if (descri.length() > 100) {
            System.out.println("A descrição é muito longa.");
        } else {
            System.out.println("A descrição é adequada.");
        }

        System.out.println(numeros[0]);
        System.out.println(nomes[1]);

        int [][] matriz = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(matriz[2][1]);

        ArrayList<String> listaNomes = new ArrayList<>();
        listaNomes.add("Kombi");
        listaNomes.add("Kers");
        listaNomes.add("Pioneer");
        listaNomes.add("Cofap");
        listaNomes.add("Bosch");
        listaNomes.remove("Bosch");
        System.out.println(listaNomes.get(0));
        System.out.println(listaNomes.get(1));
        System.out.println(listaNomes.get(2));
        System.out.println(listaNomes.get(3));
        System.out.println(listaNomes.get(2));

        System.out.println("Deseja remover qual?");
        Scanner scannerT = new Scanner(System.in);

        int qualRemover = scannerT.nextInt();

        switch (qualRemover) {
            case 1:
                listaNomes.remove(0);
                System.out.println("Removido");
                break;
            case 2:
                listaNomes.remove(1);
                break;
            case 3:
                listaNomes.remove(2);
                break;
            case 4:
                listaNomes.remove(3);
                break;
            default:
                System.out.println("Número inválido");
                break;
        }

        if (listaNomes.contains("Bosch")) {
            System.out.println("A lista contém Bosch");
        } else {
            System.out.println("A lista não contém Bosch");
            
        }


    }
}
