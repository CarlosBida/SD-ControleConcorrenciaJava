public class Conta {
    public double saldo = 0;
    private ReadWriteLock lock = new ReentrantReadWriteLock();

    public Conta(double saldo) {
        this.saldo = saldo;
        System.out.println("Conta criada. Saldo inicial: R$" + saldo);
    }
    
    public double getSaldo() {
        lock.readLock().lock();
        try { 
            return this.saldo; 
        }finally { 
            lock.readLock.unlock(); 
        }
    }

    public double setSaldo(double saldo) {
        lock.writeLock().lock();
        try { 
            this.saldo = saldo; 
        }finally { 
            lock.writeLock.unlock(); 
        }
    }
}
