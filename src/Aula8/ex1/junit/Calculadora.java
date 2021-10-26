package Aula8.ex1.junit;

public class Calculadora {
    public double sum(double... numbers){
        double sum = 0;
        if(numbers.length > 0){
            for(double number: numbers){
                sum += number;
            }
        }
        return sum;
    }
}
