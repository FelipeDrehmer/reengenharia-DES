/**
 * Strategy: cada tipo de consulta tem a sua própria regra de cobrança.
 * Um novo tipo de consulta exige apenas uma nova implementação desta interface.
 */
public interface RegraDeCobranca {

    /**
     * Aplica descontos e taxas sobre o valor total dos procedimentos.
     *
     * @param valorTotal soma dos procedimentos realizados
     * @return valor final a ser cobrado
     */
    double aplicar(double valorTotal);
}
