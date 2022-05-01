
package br.edu.ifpb.web;

import br.edu.ifpb.domain.Livro;
import br.edu.ifpb.domain.Livros;
import br.edu.ifpb.infra.LivrosEmJDBC;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(name = "LivroController",urlPatterns = {"/livros.do"})
public class LivroController extends HttpServlet {
//    private Livros livros  = new LivrosEmMemoria();
    private Livros livros  = new LivrosEmJDBC();

    @Override
    protected void doPost(HttpServletRequest req,HttpServletResponse resp) 
        throws ServletException,IOException {
        String titulo = req.getParameter("titulo");
        livros.criar(
            new Livro(titulo,LocalDate.now())
        );
        resp.sendRedirect("livros.do");
    }
    

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)
        throws ServletException,IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LivroController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listagem de Livros</h1>");
            for( Livro livro: livros.todos()){
                out.println("<p>"+livro+"</p>")    ;
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
 
@Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
    }
}
