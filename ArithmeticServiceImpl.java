// ArithmeticServiceImpl.java
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ArithmeticServiceImpl extends UnicastRemoteObject implements ArithmeticService {
    public ArithmeticServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int subtract(int a, int b) throws RemoteException {
        return a - b;
    }

    @Override
    public int multiply(int a, int b) throws RemoteException {
        return a * b;
    }

    @Override
    public double divide(int a, int b) throws RemoteException {
        if (b == 0) {
            throw new RemoteException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        try {
            int registryPort = 1098; // Use a different port
            ArithmeticService arithmeticService = new ArithmeticServiceImpl();
            java.rmi.registry.LocateRegistry.createRegistry(registryPort);
            java.rmi.Naming.rebind("//localhost:" + registryPort + "/ArithmeticService", arithmeticService);
            System.out.println("ArithmeticService is ready on port " + registryPort + ".");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
