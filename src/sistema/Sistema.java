package sistema;

import java.util.Scanner;
import usuario.Usuario;
import java.util.HashMap;
import java.util.Map;
import usuario.Cliente;
import usuario.Empresa;

public class Sistema {
    int escolha;
    Scanner scanner = new Scanner(System.in);
   

    Map<String, Empresa> empresas = new HashMap<>();
    Map<String, Cliente> clientes = new HashMap<>();
   
    public void cadastrarEmpresa(String cnpj, double taxa) {
        empresas.put(cnpj, new Empresa(cnpj, taxa));
    }
    public void cadastrarCliente(String cpf) {
        clientes.put(cpf, new Cliente(cpf));
    }
    

    public void realizarTransacao(Usuario usuario, double valor) {
        if (usuario instanceof Empresa) {
            Empresa empresa = (Empresa) usuario;
            double taxa = empresa.calcularTaxa(valor);
            double valorFinal = valor - taxa;
            empresa.sacar(valorFinal);
            System.out.println("Callback enviado para a empresa: Transação de R$" + valor + " realizada.");
        } else if (usuario instanceof Cliente) {
            Cliente cliente = (Cliente) usuario;
            System.out.println("Notificação enviada para o cliente com CPF " + cliente.getCpf() + ": Transação de R$" + valor + " realizada.");
        }
    } 
    public static void main(String[] args) {
    	Sistema sistema = new Sistema();
        sistema.cadastrarEmpresa("123456789", 0.05); // Exemplo: taxa de 5%
        sistema.cadastrarCliente("987654321"); // Exemplo: CPF de cliente

        Empresa empresa = sistema.empresas.get("123456789");
        Cliente cliente = sistema.clientes.get("987654321");

        double valorTransacao = 100.0;

        // Realizar transação
        sistema.realizarTransacao(empresa, valorTransacao);
        sistema.realizarTransacao(cliente, valorTransacao);
      }
   
}

