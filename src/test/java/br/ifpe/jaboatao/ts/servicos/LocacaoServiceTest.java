package br.ifpe.jaboatao.ts.servicos;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.ifpe.jaboatao.ts.entidades.Filme;
import br.ifpe.jaboatao.ts.entidades.Locacao;
import br.ifpe.jaboatao.ts.entidades.Usuario;
import br.ifpe.jaboatao.ts.exceptions.FilmesException;

public class LocacaoServiceTest {

    private LocacaoService service = new LocacaoService();

    @Test
    @DisplayName("Desconto de 10% para duas unidades")
    public void testeDesconto10Porcento() throws FilmesException {
        Usuario usuario = new Usuario();
        usuario.setNome("Adalberto");
        List<Filme> filmes = Arrays.asList(
            new Filme("Filme 1", 1, 5.0),
            new Filme("Filme 2", 1, 5.0)
        );

        Locacao locacao = service.alugarFilme(filmes, usuario);

        Assertions.assertEquals(9.0, locacao.getValorLocacao());
    }

    @Test
    @DisplayName("Desconto de 15% para três unidades")
    public void testeDesconto15Porcento() throws FilmesException {
        Usuario usuario = new Usuario();
        usuario.setNome("Adalberto");
        List<Filme> filmes = Arrays.asList(
            new Filme("Filme 1", 1, 5.0),
            new Filme("Filme 2", 1, 5.0),
            new Filme("Filme 3", 1, 5.0)
        );

        Locacao locacao = service.alugarFilme(filmes, usuario);

        Assertions.assertEquals(12.75, locacao.getValorLocacao());
    }

    @Test
    @DisplayName("Desconto de 25% para quatro unidades")
    public void testeDesconto25Porcento() throws FilmesException {
        Usuario usuario = new Usuario();
        usuario.setNome("Adalberto");
        List<Filme> filmes = Arrays.asList(
            new Filme("Filme 1", 1, 5.0),
            new Filme("Filme 2", 1, 5.0),
            new Filme("Filme 3", 1, 5.0),
            new Filme("Filme 4", 1, 5.0)
        );

        Locacao locacao = service.alugarFilme(filmes, usuario);

        Assertions.assertEquals(15.0, locacao.getValorLocacao());
    }

    @Test
    @DisplayName("Desconto de 50% para cinco ou mais unidades")
    public void testeDesconto50Porcento() throws FilmesException {
        Usuario usuario = new Usuario();
        usuario.setNome("Adalberto");
        List<Filme> filmes = Arrays.asList(
            new Filme("Filme 1", 1, 5.0),
            new Filme("Filme 2", 1, 5.0),
            new Filme("Filme 3", 1, 5.0),
            new Filme("Filme 4", 1, 5.0),
            new Filme("Filme 5", 1, 5.0)
        );

        Locacao locacao = service.alugarFilme(filmes, usuario);

        Assertions.assertEquals(12.5, locacao.getValorLocacao());
    }

    @Test
    @DisplayName("Verificar sem desconto para uma unidade")
    public void testeSemDesconto() throws FilmesException {
        Usuario usuario = new Usuario();
        usuario.setNome("Adalberto");
        List<Filme> filmes = Arrays.asList(
            new Filme("Filme 1", 1, 5.0)
        );

        Locacao locacao = service.alugarFilme(filmes, usuario);

        Assertions.assertEquals(5.0, locacao.getValorLocacao());
    }
}
