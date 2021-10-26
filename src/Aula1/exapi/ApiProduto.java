package Aula1.exapi;

public class ApiProduto {
    private Double desconto;


    public ApiProduto() {

    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double checkDesconto(String tipo){
        if(tipo.equals("latas")){
            this.setDesconto(10.00);
        }else{
            this.setDesconto(0.0);
        }
        return this.getDesconto();
    }

}
