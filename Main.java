/**
 * Teste de manutenção de comportamento: o código reestruturado
 * precisa produzir exatamente os mesmos valores do sistema legado (x_Mgr_F).
 */
public class Main {

    public static void main(String[] args) {
        CalculadoraValorAtendimento calculadora = new CalculadoraValorAtendimento();

        // Simulação pedida no enunciado:
        // paciente tipo 1 (Convênio), procedimentos [200.0, 100.0], status verdadeiro.
        // Legado: 300 - (300 * 0.12) = 264.0 ; 264.0 + 15.50 = 279.5
        double valor = calculadora.calcularValorFinal(
                TipoConsulta.CONVENIO, new double[] {200.0, 100.0}, true);
        System.out.println("Convênio, [200.0, 100.0], taxa adicional = true -> " + valor);
        verificar(279.5, valor);

        System.out.println();
        System.out.println("Casos adicionais (valores esperados calculados com o código legado):");
        testar(calculadora, TipoConsulta.CONVENIO,   new double[] {200.0, 100.0}, false, 264.0);
        testar(calculadora, TipoConsulta.PARTICULAR, new double[] {300.0, 300.0}, false, 570.0);
        testar(calculadora, TipoConsulta.PARTICULAR, new double[] {500.0},        false, 500.0);
        testar(calculadora, TipoConsulta.PARTICULAR, new double[] {200.0, 100.0}, true,  300.0);
        testar(calculadora, TipoConsulta.CONVENIO,   new double[] {},             true,  15.5);
    }

    private static void testar(CalculadoraValorAtendimento calculadora, TipoConsulta tipo,
                               double[] procedimentos, boolean taxa, double esperado) {
        double obtido = calculadora.calcularValorFinal(tipo, procedimentos, taxa);
        System.out.print(tipo + ", " + java.util.Arrays.toString(procedimentos)
                + ", taxa adicional = " + taxa + " -> " + obtido + "  ");
        verificar(esperado, obtido);
    }

    private static void verificar(double esperado, double obtido) {
        if (Double.compare(esperado, obtido) == 0) {
            System.out.println("[OK] igual ao legado (" + esperado + ")");
        } else {
            System.out.println("[FALHOU] esperado " + esperado + ", obtido " + obtido);
        }
    }
}
