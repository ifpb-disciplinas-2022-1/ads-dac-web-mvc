package br.edu.ifpb.handle;

import br.edu.ifpb.domain.Editoras;
import br.edu.ifpb.infra.EditorasEmJDBC;
import br.edu.ifpb.web.Command;

import javax.servlet.http.HttpServletRequest;

public class ListarEditorasCommand implements Command {
    private Editoras editoras = new EditorasEmJDBC();
    public String handle(HttpServletRequest request){
        request.setAttribute("editoras",editoras.todas());
        return "listar.jsp";
    }
}
