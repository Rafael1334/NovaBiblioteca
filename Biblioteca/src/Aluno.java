public class Aluno {

    private String nomeAluno;
    private int cmgAluno;
    private int idAluno;

    public Aluno(String nomeAluno, int cmgAluno){
        this.nomeAluno = nomeAluno;
        this.cmgAluno = cmgAluno;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public int getCmgAluno() {
        return cmgAluno;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public void setCmgAluno(int cmgAluno) {
        this.cmgAluno = cmgAluno;
    }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
}
