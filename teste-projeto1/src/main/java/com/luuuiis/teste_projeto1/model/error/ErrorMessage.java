package com.luuuiis.teste_projeto1.model.error;

public class ErrorMessage {
    private String Titulo;
    private int Status;
    private String Mensagem;

    public ErrorMessage(String titulo, int status, String mensagem) {
        Titulo = titulo;
        Status = status;
        Mensagem = mensagem;
    }

    public String getTitulo() {
        return Titulo;
    }
    public void setTitulo(String titulo) {
        Titulo = titulo;
    }
    public int getStatus() {
        return Status;
    }
    public void setStatus(int status) {
        Status = status;
    }
    public String getMensagem() {
        return Mensagem;
    }
    public void setMensagem(String mensagem) {
        Mensagem = mensagem;
    }

    
}
