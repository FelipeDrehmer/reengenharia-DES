/**
 * Calcula o valor final de um atendimento.
 * Substitui a classe legada x_Mgr_F e o seu método calc.
 */
public class CalculadoraValorAtendimento {

    public double calcularValorFinal(TipoConsulta tipoConsulta,
                                     double[] procedimentosRealizados,
                                     boolean cobrarTaxaAdicional) {
        double valorTotal = somarProcedimentos(procedimentosRealizados);
        RegraDeCobranca regra = FabricaRegraDeCobranca.criar(tipoConsulta, cobrarTaxaAdicional);
        return regra.aplicar(valorTotal);
    }

    private double somarProcedimentos(double[] procedimentosRealizados) {
        double valorTotal = 0;
        for (double valorProcedimento : procedimentosRealizados) {
            valorTotal += valorProcedimento;
        }
        return valorTotal;
    }
}
