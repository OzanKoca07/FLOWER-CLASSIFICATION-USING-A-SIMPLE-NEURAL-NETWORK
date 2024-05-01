package neuron;
public class Main {
    public static void main(String[] args) {
        Neuron N1 = new Neuron("Iris-setosa");
        Neuron N2 = new Neuron("Iris-versicolor");
        Neuron N3 = new Neuron("Iris-virginica");
        Neuron_network network = new Neuron_network(N1,N2,N3);

        
        network.Train(0.01, 100);
        network.Outputs();
    }
}
