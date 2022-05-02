package br.edu.ifpb.web;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    public String handle(HttpServletRequest request);
}
