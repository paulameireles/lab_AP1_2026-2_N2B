
/**
 * Categoria do motorista.
 * Cada categoria tem um percentual de comissão cobrado pela plataforma:
 * BRONZE 25%; PRATA 20%; OURO 15%; DIAMANTE 10%.
 */
public enum Categoria {
    BRONZE(0.25), PRATA(0.20), OURO(0.15), DIAMANTE(0.10);

    private final double comissao;
    
    Categoria(double comissao){
        this.comissao = comissao;
    }

    public double getcomissao(){
        return comissao;
    }

    //TODO Tarefa 1: associar a cada constante sua comissão (0.25, 0.20, 0.15, 0.10)
    // (atributo, construtor e método getComissao())
}
