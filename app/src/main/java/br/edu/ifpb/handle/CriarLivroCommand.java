package br.edu.ifpb.handle;

import br.edu.ifpb.domain.Livro;
import br.edu.ifpb.domain.Livros;
import br.edu.ifpb.infra.LivrosEmJDBC;
import br.edu.ifpb.web.Command;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

public class CriarLivroCommand implements Command {
    private Livros livros  = new LivrosEmJDBC();
    public String handle(HttpServletRequest request){
        String titulo = request.getParameter("titulo");
        Livro livro = new Livro(
                titulo, LocalDate.now()
        );
        livros.criar(livro);
        return "livros.listar.do";
    }
}
