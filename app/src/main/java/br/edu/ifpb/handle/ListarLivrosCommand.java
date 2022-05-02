package br.edu.ifpb.handle;

import br.edu.ifpb.domain.Livros;
import br.edu.ifpb.infra.LivrosEmJDBC;
import br.edu.ifpb.web.Command;

import javax.servlet.http.HttpServletRequest;

public class ListarLivrosCommand implements Command {
    private Livros livros  = new LivrosEmJDBC();
    public String handle(HttpServletRequest request){
        System.out.println("Estou no ListarLivrosCommand...");
        request.setAttribute("livros",livros.todos());
        return "listarlivros.jsp";
    }
}
