class Aluno {
    private String nome;
    private String cpf;
    private String matricula;
    private String polo;

    public Aluno(String nome, String cpf, String matricula, String polo) {
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.polo = polo;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getPolo() {
        return polo;
    }

    public void setPolo(String polo) {
        this.polo = polo;
    }
}