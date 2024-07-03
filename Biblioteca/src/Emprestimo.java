public class Emprestimo {

    private String nomeLivro;
    private String codLivro;
    private String nomeAluno;
    private String cgmAluno;
    private int idEmprestimo;

    public Emprestimo(String nomeLivro, String codLivro, String nomeAluno, String cgmAluno){
        this.nomeLivro = nomeLivro;
        this.codLivro = codLivro;
        this.nomeAluno = nomeAluno;
        this.cgmAluno = cgmAluno;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public String getCodLivro() {
        return codLivro;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getCgmAluno() {
        return cgmAluno;
    }

    public int getIdEmprestimo() {
        return idEmprestimo;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public void setCodLivro(String codLivro) {
        this.codLivro = codLivro;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public void setCgmAluno(String cgmAluno) {
        this.cgmAluno = cgmAluno;
    }

    public void setIdEmprestimo(int idEmprestimo) {
        this.idEmprestimo = idEmprestimo;
    }
}
