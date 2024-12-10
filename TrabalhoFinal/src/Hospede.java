class Hospede {
    private String nome;
    private String endereco;
    private String quarto;
    private String foto;

    public Hospede(String nome, String endereco, String quarto, String foto) {
        this.nome = nome;
        this.endereco = endereco;
        this.quarto = quarto;
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getQuarto() {
        return quarto;
    }

    public String getFoto() {
        return foto;
    }
}