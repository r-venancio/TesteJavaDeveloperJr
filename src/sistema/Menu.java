package sistema;

import usuario.Usuario;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar Empresa");
            System.out.println("3. Realizar Transação");
            System.out.println("4. Sair");

            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.println("Digite o CPF do cliente:");
                    String cpfCliente = scanner.next();
                    sistema.cadastrarCliente(cpfCliente);
                    break;
                case 2:
                    System.out.println("Digite o CNPJ da empresa:");
                    String cnpjEmpresa = scanner.next();
                    System.out.println("Digite a taxa da empresa:");
                    double taxaEmpresa = scanner.nextDouble();
                    sistema.cadastrarEmpresa(cnpjEmpresa, taxaEmpresa);
                    break;
                case 3:
                    System.out.println("Digite o CPF do cliente ou CNPJ da empresa:");
                    String idUsuario = scanner.next();
                    Usuario usuario;
                    if (idUsuario.length() == 11) {
                        usuario = sistema.clientes.get(idUsuario);
                    } else if (idUsuario.length() == 14) {
                        usuario = sistema.empresas.get(idUsuario);
                    } else {
                        System.out.println("ID inválido.");
                        continue;
                    }
                    if (usuario == null) {
                        System.out.println("Usuário não encontrado.");
                        continue;
                    }
                    System.out.println("Digite o valor da transação:");
                    double valorTransacao = scanner.nextDouble();
                    sistema.realizarTransacao(usuario, valorTransacao);
                    break;
                case 4:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        } while (escolha != 4);

        scanner.close();
    }
}