/**
 * Regra de cobrança para consultas por convênio:
 * desconto de 12% e, depois do desconto, taxa adicional fixa opcional.
 */
public class RegraConvenio implements RegraDeCobranca {

    private static final double DESCONTO_CONVENIO = 0.12;
    private static final double TAXA_ADICIONAL_CONVENIO = 15.50;

    private final boolean cobrarTaxaAdicional;

    public RegraConvenio(boolean cobrarTaxaAdicional) {
        this.cobrarTaxaAdicional = cobrarTaxaAdicional;
    }

    @Override
    public double aplicar(double valorTotal) {
        double valorComDesconto = valorTotal - (valorTotal * DESCONTO_CONVENIO);
        if (cobrarTaxaAdicional) {
            valorComDesconto += TAXA_ADICIONAL_CONVENIO;
        }
        return valorComDesconto;
    }
}
