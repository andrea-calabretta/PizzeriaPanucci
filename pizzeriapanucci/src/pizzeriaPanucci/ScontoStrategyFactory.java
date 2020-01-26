package pizzeriaPanucci;

public class ScontoStrategyFactory {
    private static ScontoStrategyFactory instance;
    private static final Object lock = ScontoStrategyFactory.class;
    private ScontoStrategyFactory() { }

    public static ScontoStrategyFactory getIstance(){
        synchronized (lock){
            if (instance == null){
                instance = new ScontoStrategyFactory();

            }
        }
        return instance;
    }


    public Sconto getSconto() {
        //prova torna scontoAssoluto, qui strategyfactory legge da configurazione e sceglie quale sconto creare
        Sconto s = new ScontoAssoluto("ScontoAssoluto", 40, 5);
        return s;
    }

}


