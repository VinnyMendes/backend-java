package Aula9;

public enum Tamanho {
    XS ("Minúscula"),
    S ("Pequena"),
    M ("Normal"),
    L ("Grande"),
    XL ("Grandona");

    private String tam;
    Tamanho(String tam) {
        this.tam = tam;
    }

    public String getTam() {
        return tam;
    }
}

