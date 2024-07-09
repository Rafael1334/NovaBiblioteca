package ABC;

public class Funcionario {

    private String nomeFuncionario;
    private String senha;
    private int idFuncionario;

    public Funcionario(String nomeFuncionario, String senha){
        this.nomeFuncionario = nomeFuncionario;
        this.senha = senha;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getSenha() {
        return senha;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setNomeFuncionario(String nome) {
        this.nomeFuncionario = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
