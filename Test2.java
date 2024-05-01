
package neuron;
public class Test2 {
    public static void main(String[] args) {
        Neuron N1 = new Neuron("Iris-setosa");
        Neuron N2 = new Neuron("Iris-versicolor");
        Neuron N3 = new Neuron("Iris-virginica");
        Neuron_network network1 = new Neuron_network(N1,N2,N3);
        network1.Train(0.025, 20);
        network1.Outputs();
        
        Neuron N4 = new Neuron("Iris-setosa");
        Neuron N5 = new Neuron("Iris-versicolor");
        Neuron N6 = new Neuron("Iris-virginica");
        Neuron_network network2 = new Neuron_network(N4,N5, N6);
        network2.Train(0.025, 50);
        network2.Outputs();
        
        
        Neuron N7 = new Neuron("Iris-setosa");
        Neuron N8 = new Neuron("Iris-versicolor");
        Neuron N9 = new Neuron("Iris-virginica");
        Neuron_network network3 = new Neuron_network(N7,N8, N9);
        network3.Train(0.025, 100);
        network3.Outputs();
    }
}
