
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Os testes prontos servem de exemplo.
 * Complete os testes marcados com //TODO (Tarefas 4 e 5).
 */
public class MotoristaTest {

    private Motorista motorista;

    @BeforeEach
    void setUp() {
        motorista = new Motorista("Bia");
    }

    @Test
    void naoDeveAdicionarCodigoDuplicado() {
        assertTrue(motorista.adicionar(new Corrida("C1", 10, 30)));
        assertFalse(motorista.adicionar(new Corrida("C1", 5, 20)));
        assertEquals(1, motorista.quantidadeCorridas());
    }

    @Test
    void deveRegistrarConcluidaPorCodigo() {
        motorista.adicionar(new Corrida("C1", 10, 30));
        assertTrue(motorista.registrarConcluida("C1"));
        assertFalse(motorista.registrarConcluida("C1"), "já concluída");
        assertFalse(motorista.registrarConcluida("C9"), "inexistente");
    }

    @Test
    void deveSomarFaturamentoEKmApenasDeConcluidas() {
        motorista.adicionar(new Corrida("C1", 10, 30));
        motorista.adicionar(new Corrida("C2", 20, 50));
        motorista.registrarConcluida("C1");
        assertEquals(30.0, motorista.faturamentoBruto(), 0.001);
        assertEquals(10.0, motorista.kmRodados(), 0.001);
    }

    @Test
    void resumoDeveConterNomeECategoria() {
        motorista.adicionar(new Corrida("C1", 10, 30));
        String r = motorista.resumo();
        assertTrue(r.contains("Bia"), r);
        assertTrue(r.contains("BRONZE"), r);
    }

    @Test
    void deveDefinirCategoria() {
        assertEquals(Categoria.BRONZE, criar(4, 0).categoria);
        assertEquals(Categoria.BRONZE, new Motorista("Vazio").categoria();
        assertEquals(Categoria.BRONZE, criar(4, 2).categoria);
        assertEquals(Categoria.PRATA, criar(4, 0).categoria);
        assertEquals(Categoria.OURO, criar(4, 0).categoria);
        assertEquals(Categoria.DIAMANTE, criar(4, 0).categoria);
        
    }

    @Test
    void deveCalcularGanhoLiquido() {
        //TODO Tarefa 5: testar ganhoLiquido usando a comissão da categoria
        // e o desconto de comissão acima de 500 km
    }
}
