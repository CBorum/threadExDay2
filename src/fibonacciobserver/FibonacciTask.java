package fibonacciobserver;


import java.util.ArrayList;
import java.util.List;

public class FibonacciTask extends Thread{
    private long tal;
    List<FibonacciObserver> observers = new ArrayList();
    
    public void registerFibonacciObserver(FibonacciObserver o){
      observers.add(o);
    }
    
    public FibonacciTask(long n) {
        this.tal = n;
    }
    @Override
    public void run() {
        tal = fibonacci(tal);
        //long tal = ......
        for(FibonacciObserver observer : observers){
          observer.dataReady(tal);
        }
    }
    
    public long fibonacci(long n) {
        if (n == 0 || n == 1) {return n;}
        else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    
}
