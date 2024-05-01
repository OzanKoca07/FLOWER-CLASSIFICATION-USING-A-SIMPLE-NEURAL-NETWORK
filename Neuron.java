package neuron;

import java.util.ArrayList;
import java.util.Random;

public class Neuron {
    private ArrayList <Double> inputList = new ArrayList<>();
    private ArrayList <Double> weightList = new ArrayList<>();
    private String flower;

    
public void addArray(String[] string){//data setinden alınan verileri double tipine dönüştürüp 10 a bölüyoruz ve input listesine ekliyoruz
    for (int i = 0; i < 4; i++) {
        double input = Double.parseDouble(string[i]);
        input /= 10;
        this.inputList.add(input);
        
    }
}
public void Clearallinputs(){
    inputList.clear();
}

public Neuron(String string) {
    this.flower = string;
    Random rnd = new Random();
    double w1 = rnd.nextDouble(0,1);
    double w2 = rnd.nextDouble(0,1);
    double w3 = rnd.nextDouble(0,1);
    double w4 = rnd.nextDouble(0,1);
    this.weightList.add(w1);
    this.weightList.add(w2);
    this.weightList.add(w3);
    this.weightList.add(w4);
            
    }

    public String getFlower() {// sonuç çıktısını öğrenmek için kullanılan metod 
        return flower;
    }

public Double calculate(){
    double output = 0;
    for (int i = 0; i < 4; i++) {
        output += (inputList.get(i))*weightList.get(i);

    }
    return output;
}

public void subtraction(Double landa){// verilen denkleme göre sırayla ağırlıklardan o ağırlıkla ilgili inputun landayla çarpımının çıkarılması
    for (int i = 0; i < 4; i++) {
        double w = weightList.get(i);
        w -= inputList.get(i)*landa;
        weightList.remove(i);
        weightList.add(i, w);
    } 
}

public void addition(Double landa){
    for (int i = 0; i < 4; i++) {
        double w = weightList.get(i);
        w +=inputList.get(i)*landa;
        weightList.remove(i);
        weightList.add(i, w);
    } 
}

}