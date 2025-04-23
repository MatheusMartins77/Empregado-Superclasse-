import java.text.DecimalFormat;

public class EmpregadoComissionado extends Empregado {
    double totalDeVendas;
    double comisao;

    public EmpregadoComissionado(long matricula, String nome, double totalDeVendas, double commisao) {
        super(matricula, nome);
        // super é um método nesse exemplo, e faço assim pois ja tenho esses atributos
        // na outra classe
        this.totalDeVendas = totalDeVendas;
        this.comisao = commisao;
    }

    public String getDados(){
        DecimalFormat df = new DecimalFormat("#,##0.00");
      String aux = super.getDados();
      aux += "Total de vendas R$ " + df.format(totalDeVendas) + "\n";
      aux += "Comisão: " + df.format(comisao) + "%\n";
      return aux;
  }
    public double calcularSalario(){
        return totalDeVendas * comisao / 100;
    }


}
