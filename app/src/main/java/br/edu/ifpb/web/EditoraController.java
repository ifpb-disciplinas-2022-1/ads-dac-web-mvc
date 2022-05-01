package br.edu.ifpb.web;

import br.edu.ifpb.domain.Editora;
import br.edu.ifpb.domain.Editoras;
import br.edu.ifpb.infra.EditorasEmJDBC;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditoraController", value = "/editora.do")
public class EditoraController extends HttpServlet {
    private Editoras editoras = new EditorasEmJDBC();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //atendendo ao processamento
        request.setAttribute("editoras",editoras.todas());
        //redicionar à página
        request.getRequestDispatcher("listar.jsp")
                .forward(request, response); //mantendo a requisição original
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //atendendo ao processamento
        String localDeOrigem = req.getParameter("localDeOrigem");
        String nomeFantasia = req.getParameter("nomeFantasia");
        editoras.nova(new Editora(localDeOrigem, nomeFantasia));
        //redicionar à página
        resp.sendRedirect("editora.do"); //gerando uma nova requisição
    }
}
