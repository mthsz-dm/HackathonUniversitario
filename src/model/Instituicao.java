package model;

public abstract class Instituicao {
    private String nomeInstituicao;
    private String cnpj;

    public Instituicao(String nomeInstituicao, String cnpj) {
        this.nomeInstituicao = nomeInstituicao;
        this.cnpj = cnpj;
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
