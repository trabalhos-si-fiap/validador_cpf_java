import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu cpf");
        String cpf = scanner.nextLine().replaceAll("\\D", "");
        System.out.println("CPF informado: " + cpf);

        if (cpf.length() != 11) {
            System.out.println("CPF inválido: O cpf deve conter 11 caracteres numéricos.");
            return;
        }

        int[] numeros = new int[11];

        for (int i = 0; i < 11; i++) {
            numeros[i] = Integer.parseInt(cpf.substring(i, i+1));
        }

        int soma = 0;
        int multiplica = 10;
        int digito1;
        int digito2;

        for (int i = 0; i < 9; i++) {
            soma += numeros[i] * multiplica;
            multiplica--;
        }

        if (soma % 11 < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - (soma % 11);
        }

        if (digito1 != numeros[9]) {
            System.out.println("CPF inválido.");
            return;
        }

        soma = 0;
        multiplica = 11;

        for (int i = 0; i < 10; i++) {
            soma += numeros[i] * multiplica;
            multiplica--;
        }

        if (soma % 11 < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - (soma % 11);
        }

        if (digito2 != numeros[10] || cpf.equals(Integer.toString(numeros[0]).repeat(11))) {
            System.out.println("CPF inválido.");
        } else {
            System.out.print("O CPF é válido");
            switch (numeros[8]){
                case 0:
                    System.out.println(" e foi emitido no Rio Grande do Sul");
                    break;
                case 1:
                    System.out.println(" e foi emitido no Distrito Federal, Goiás, Mato Grosso do Sul ou Tocantins");
                    break;
                case 2:
                    System.out.println(" e foi emitido no Pará, Amazonas, Acre, Amapá, Rondônia ou Roraima");
                    break;
                case 3:
                    System.out.println(" e foi emitido no Ceará, Maranhão ou Piauí");
                    break;
                case 4:
                    System.out.println(" e foi emitido em Pernambuco, Rio Grande do Norte, Paraíba ou Alagoas");
                    break;
                case 5:
                    System.out.println(" e foi emitido na Bahia ou Sergipe");
                    break;
                case 6:
                    System.out.println(" e foi emitido em Minas Gerais");
                    break;
                case 7:
                    System.out.println(" e foi emitido no Rio de Janeiro ou Espírito Santo");
                    break;
                case 8:
                    System.out.println(" e foi emitido em São Paulo");
                    break;
                case 9:
                    System.out.println(" e foi emitido no Paraná ou Santa Catarina");
                    break;
                default:
            }
        }
    }
}