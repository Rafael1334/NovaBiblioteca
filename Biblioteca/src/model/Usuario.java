package model;

public class Usuario {

    private String nomeUsuario;
    private String nomeResponsavel;
    private int idUsuario;

    public Usuario(String nomeUsuario, String nomeResponsavel) {
        this.nomeUsuario = nomeUsuario;
        this.nomeResponsavel = nomeResponsavel;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public String getNomeResponsavel() {
        return nomeResponsavel;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public void setNomeResponsavel(String nomeResponsavel) {
        this.nomeResponsavel = nomeResponsavel;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
