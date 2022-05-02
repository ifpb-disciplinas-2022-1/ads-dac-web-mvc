package br.edu.ifpb.handle;

import br.edu.ifpb.domain.Editora;
import br.edu.ifpb.domain.Editoras;
import br.edu.ifpb.infra.EditorasEmJDBC;
import br.edu.ifpb.web.Command;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class BuscarEditorasCommand implements Command {
    private Editoras editoras = new EditorasEmJDBC();
    public String handle(HttpServletRequest request) {
        String localDeOrigem = request.getParameter("localDeOrigem");
        List<Editora> lista = editoras.porLocalDeOrigem(localDeOrigem);
        // se não houver o parâmetro, lista todas as editoras
        if(localDeOrigem==null || "null".equals(localDeOrigem)){
            lista = editoras.todas();
        }
        request.setAttribute("editoras", lista);
        return "buscar.jsp";
    }
}
