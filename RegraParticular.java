/**
 * Regra de cobrança para consultas particulares:
 * desconto de 5% sobre o total, somente quando o total for maior que 500.
 */
public class RegraParticular implements RegraDeCobranca {

    private static final double DESCONTO_PARTICULAR = 0.05;
    private static final double LIMITE_DESCONTO_PARTICULAR = 500.0;

    @Override
    public double aplicar(double valorTotal) {
        if (valorTotal > LIMITE_DESCONTO_PARTICULAR) {
            return valorTotal - (valorTotal * DESCONTO_PARTICULAR);
        }
        return valorTotal;
    }
}
