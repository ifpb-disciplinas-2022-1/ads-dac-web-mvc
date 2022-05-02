package br.edu.ifpb.handle;

import br.edu.ifpb.domain.Editora;
import br.edu.ifpb.domain.Editoras;
import br.edu.ifpb.infra.EditorasEmJDBC;
import br.edu.ifpb.web.Command;

import javax.servlet.http.HttpServletRequest;

public class CriarEditoraCommand implements Command {
    private Editoras editoras = new EditorasEmJDBC();
    public String handle(HttpServletRequest request){
        String localDeOrigem = request.getParameter("localDeOrigem");
        String nomeFantasia = request.getParameter("nomeFantasia");
        editoras.nova(new Editora(localDeOrigem, nomeFantasia));
        return "editoras.listar.do";
    }
}
