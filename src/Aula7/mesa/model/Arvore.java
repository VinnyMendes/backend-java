package Aula7.mesa.model;

public class Arvore {
    private Integer altura;
    private Integer largura;
    private String cor;
    private static Integer contador=0;

    public Arvore(Integer altura, Integer largura, String cor) {
        this.altura = altura;
        this.largura = largura;
        this.cor = cor;
        contador++;
        System.out.println(contador);
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getLargura() {
        return largura;
    }

    public void setLargura(Integer largura) {
        this.largura = largura;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
