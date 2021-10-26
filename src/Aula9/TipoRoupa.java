package Aula9;

public enum TipoRoupa {
    CALCA ("Calça"),
    CAMISA ("Camisa");

    private String desc;

    TipoRoupa(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}
