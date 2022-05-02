package br.edu.ifpb.web;

import br.edu.ifpb.handle.CriarEditoraCommand;
import br.edu.ifpb.handle.ListarEditorasCommand;
import br.edu.ifpb.handle.ListarLivrosCommand;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "FrontController", urlPatterns = "*.do")
public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = requestToPath(request);//redicionar à página
        request.getRequestDispatcher(path)
                .forward(request, response); //mantendo a requisição original
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = requestToPath(request); //redicionar à página
        response.sendRedirect(path); //gerando uma nova requisição
    }
    private String requestToPath(HttpServletRequest request) {
        Command command = FactoryCommand.create(request.getRequestURI());
        return command.handle(request);
    }
}

