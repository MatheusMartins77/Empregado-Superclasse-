import java.sql.SQLOutput;
import static java.lang.Long.parseLong;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

import static javax.swing.JOptionPane.*;

public class util {

    private Controle controle = new Controle();

    public void menu() {

        inserir();
        pesquisar();
        pesquisar();
        listar();

    }

    private void inserir() {

        long matricula;
        String nome;
        double totalVendas, comissao, valorDaHora;
        int totalDeHoras;
        int opcao;
        String menu = "1. Empregado Comissionado\n2. Empregado Horista\n3. Sair";

        while (opcao = parseInt(showInputDialog(menu));
        if (opcao == 3){
            return;
        }
        if (opcao == 1 || opcao == 2){
            matricula = parseLong(showInputDialog("Matricula do empregado"));
            nome = showInputDialog("Nome do empregado");
            if (opcao == 1) {
                totalVendas = parseDouble(showInputDialog("Valor total de Vendas"));
                comissao = parseDouble(showInputDialog("Comissão (porcentagem)"));
                controle.inserir(new EmpregadoComissionado(matricula, nome, totalVendas, comissao));
            }
             else {
                 totalDeHoras = parseInt(showInputDialog("Total de horas trabalhadas"));
                 valorDaHora = parseDouble(showInputDialog("Valor da hora trabalhada"));
                 controle.inserir(new EmpregadoHorista(matricula,nome, totalDeHoras, valorDaHora));
          }
        }
      }

    private void pesquisar() {

        long matricula = parseLong(showInputDialog("Matricula para pesquisa:"));
        Empregado empregado = controle.pesquisar(matricula);
        if (empregado == null){

            showMessageDialog(null, "Empregado com a matricula" + matricula + "não encontrado");
        }
        else{
            showMessageDialog(null, empregado.getDados());
        }

    }
    private void listar() {

        showMessageDialog(null, controle.listar());
    }
}
