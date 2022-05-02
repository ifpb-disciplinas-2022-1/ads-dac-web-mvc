package br.edu.ifpb.web;

import br.edu.ifpb.handle.*;

import java.util.HashMap;
import java.util.Map;

class FactoryCommand {
    private static Map<String, Command> map = new HashMap<>();
    static {
        map.put("/app/editoras.listar.do", new ListarEditorasCommand());
        map.put("/app/editoras.buscar.do", new BuscarEditorasCommand());
        map.put("/app/editoras.criar.do", new CriarEditoraCommand());
        map.put("/app/livros.listar.do", new ListarLivrosCommand());
        map.put("/app/livros.criar.do", new CriarLivroCommand());
    }
    public static Command create(String path){
        return map.get(path);
    }
    /**
    public static Command create(String path){
        System.out.println("Estou no FactoryCommand...");
            if("/app/editoras.listar.do".equals(path)){
                return new ListarEditorasCommand();
            }
            if("/app/editoras.criar.do".equals(path)){
                return new CriarEditoraCommand();
            }
            if("/app/livros.listar.do".equals(path)){
                return new ListarLivrosCommand();
            }
            if("/app/livros.criar.do".equals(path)){
                return new CriarLivroCommand();
            }
            return null;
    } **/

}
