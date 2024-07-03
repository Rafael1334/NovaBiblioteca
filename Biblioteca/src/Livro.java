public class Livro {

    private String nomeLivro;
    private String nomeAutor;
    private String anoLivro;
    private String codLivro;
    private String estanteLivro;
    private String prateleiraLivro;
    private int idLivro;

    public Livro(String nomeLivro, String nomeAutor, String anoLivro, String codLivro, String estanteLivro, String prateleiraLivro){
        this.nomeLivro = nomeLivro;
        this.nomeAutor = nomeAutor;
        this.anoLivro = anoLivro;
        this.codLivro = codLivro;
        this.estanteLivro = estanteLivro;
        this.prateleiraLivro = prateleiraLivro;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getAnoLivro() {
        return anoLivro;
    }

    public String getCodLivro() {
        return codLivro;
    }

    public String getEstanteLivro() {
        return estanteLivro;
    }

    public String getPrateleiraLivro() {
        return prateleiraLivro;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public void setAnoLivro(String anoLivro) {
        this.anoLivro = anoLivro;
    }

    public void setCodLivro(String codLivro) {
        this.codLivro = codLivro;
    }

    public void setEstanteLivro(String estanteLivro) {
        this.estanteLivro = estanteLivro;
    }

    public void setPrateleiraLivro(String prateleiraLivro) {
        this.prateleiraLivro = prateleiraLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }
}
