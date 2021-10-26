package Aula9;

public class Roupa {
    private TipoRoupa tipoRoupa;
    private Tamanho tamanho;
    private Boolean eNovo;
    private Boolean importada;

    public Roupa(TipoRoupa tipoRoupa, Tamanho tamanho, Boolean eNovo, Boolean importada) {
        this.tipoRoupa = tipoRoupa;
        this.tamanho = tamanho;
        this.eNovo = eNovo;
        this.importada = importada;
    }
    public TipoRoupa getTipoRoupa() {
        return tipoRoupa;
    }

    public void setTipoRoupa(TipoRoupa tipoRoupa) {
        this.tipoRoupa = tipoRoupa;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Boolean geteNovo() {
        return eNovo;
    }

    public void seteNovo(Boolean eNovo) {
        this.eNovo = eNovo;
    }

    public Boolean getImportada() {
        return importada;
    }

    public void setImportada(Boolean importada) {
        this.importada = importada;
    }
}

