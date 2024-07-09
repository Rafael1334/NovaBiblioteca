package ABC;

public class Aluno {

    private String nomeAluno;
    private String cmgAluno;
    private int idAluno;

    public Aluno(String nomeAluno, String cmgAluno){
        this.nomeAluno = nomeAluno;
        this.cmgAluno = cmgAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getCmgAluno() {
        return cmgAluno;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public void setCmgAluno(String cmgAluno) {
        this.cmgAluno = cmgAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
}
