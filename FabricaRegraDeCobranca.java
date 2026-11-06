/**
 * Factory: escolhe a regra de cobrança adequada ao tipo de consulta.
 * É o único ponto do sistema que conhece todas as regras.
 */
public final class FabricaRegraDeCobranca {

    private FabricaRegraDeCobranca() {
    }

    public static RegraDeCobranca criar(TipoConsulta tipoConsulta, boolean cobrarTaxaAdicional) {
        switch (tipoConsulta) {
            case CONVENIO:
                return new RegraConvenio(cobrarTaxaAdicional);
            case PARTICULAR:
                return new RegraParticular();
            default:
                throw new IllegalArgumentException("Tipo de consulta não suportado: " + tipoConsulta);
        }
    }
}
