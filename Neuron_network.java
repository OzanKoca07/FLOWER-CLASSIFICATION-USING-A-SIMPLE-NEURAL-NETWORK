package neuron;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Neuron_network {
    private Neuron N1;
    private Neuron N2;
    private Neuron N3;

    public Neuron_network(Neuron N1, Neuron N2, Neuron N3) {
        this.N1 = N1;
        this.N2 = N2;
        this.N3 = N3;
    }
    
    
    
    
    public void Outputs(){
        try(Scanner scanner = new  Scanner( new FileReader("C:\\Users\\Afsin\\Documents\\NetBeansProjects\\neuron\\src\\neuron\\iris.data"))){
            double count = 0;
            while (scanner.hasNextLine()){
                
                String inputs = scanner.nextLine();
                String[] array = inputs.split(",");
                N1.addArray(array);
                N2.addArray(array);
                N3.addArray(array);
                  
                double N1output = N1.calculate();
                double N2output = N2.calculate();
                double N3output = N3.calculate();   
                Neuron max; 
                if(N1output > N2output && N1output > N3output){
                    max = N1;
                            }
                else if(N2output > N3output && N2output > N1output){
                    max = N2;
                             }
                else{
                    max = N3;}
                if (max.getFlower().equals(array[4])){// eğer beklenen sonuçla çıkan sonuç aynı ise sayacı bir arttırıyoruz.
                    count++;
                }
                
                N1.Clearallinputs();
                N2.Clearallinputs();
                N3.Clearallinputs();
                }
            
            System.out.println("Dogruluk degeri: %"+ 100*count/150);
   
        } catch (FileNotFoundException ex) {
            System.out.println("Dosya bulunamadi");
} 
       
    }
    
    public void Train(double landa, int repeat){
        for (int i = 0; i < repeat; i++) {
            try(Scanner scanner = new  Scanner( new FileReader("C:\\Users\\Afsin\\Documents\\NetBeansProjects\\neuron\\src\\neuron\\iris.data"))){
                while (scanner.hasNextLine()){
                
                String string = scanner.nextLine();
                String[] array = string.split(",");// data setindeki verileri virgüllerden ayırarak bir listeye ekliyoruz.
                
                N1.addArray(array);
                N2.addArray(array);
                N3.addArray(array);
                
                double N1output = N1.calculate();
                double N2output = N2.calculate();
                double N3output = N3.calculate();
                Neuron max;
                
                
                if(N1output > N2output && N1output > N3output){// basit bir şekilde en büyük çıktıyı veren nöronu buluyoruz.
                    max = N1;
        }
                else if(N2output > N3output && N2output > N1output){
                    max = N2;
        }
                else{
                    max = N3;
        }
        
                if(array[4].equals("Iris-setosa") && !max.getFlower().equals(array[4])){// eğer beklenen çıktı setosa iken çıkan sonuç setosa değilse ağırlık değişimi yapılır.
                    N1.addition(landa);
                    max.subtraction(landa);
        }
                else if(array[4].equals("Iris-versicolor") && !max.getFlower().equals(array[4])){// aynı mantık bu else if bloklarında kullanıldı.
                    N2.addition(landa);
                    max.subtraction(landa);}
        
                else if (array[4].equals("Iris-virginica") && !max.getFlower().equals(array[4])){
                    N3.addition(landa);
                    max.subtraction(landa);}
                N1.Clearallinputs();
                N2.Clearallinputs();
                N3.Clearallinputs();
                }
                
                
                
                
                
                
            
            
        }   catch (FileNotFoundException ex) {
                System.out.println("Dosya bulunamadı");
            }
            }
        }
    }
    
    
    
    

