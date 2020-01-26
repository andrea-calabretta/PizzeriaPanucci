package pizzeriaPanucci;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Comanda {
    private int idComanda;
    private Date DataPrenotazione;
    private Date DataRitiro;
    private float importo;
    private String indirizzoConsegna;
    private String pagamento;
    private List <RigaDiComanda> righeDiComanda;
    private Cliente cliente;
    private Pagamento metodopagamento;
    private float prezzoScontato;
    private ScontoStrategyFactory scontostrategyfactory;



    public Comanda(Cliente cliente, String indirizzoConsegna, Date dataPrenotazione) {
        this.indirizzoConsegna=indirizzoConsegna;
        this.DataPrenotazione=dataPrenotazione;
        this.cliente=cliente;
        righeDiComanda=new LinkedList<RigaDiComanda>();
        scontostrategyfactory=ScontoStrategyFactory.getIstance();

    }


    public int getIdComanda() {
        return idComanda;
    }

    public Date getDataPrenotazione() {
        return DataPrenotazione;
    }

    public Date getDataRitiro() {
        return DataRitiro;
    }

    public float getImporto() {
        return importo;
    }

    public String getIndirizzoConsegna() {
        return indirizzoConsegna;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<RigaDiComanda> getRigheDiComanda() {
        return righeDiComanda;
    }

    public void addPizza(Pizza pizza, int quantita) {
        RigaDiComanda rdc=new RigaDiComanda(pizza, quantita);
        this.righeDiComanda.add(rdc);


    }
    @Override
    public String toString() {
        return "Comanda{" +
                "idComanda=" + idComanda +
                ", DataPrenotazione=" + DataPrenotazione +
                ", DataRitiro=" + DataRitiro +
                ", importo=" + importo +
                ", indirizzoConsegna='" + indirizzoConsegna + '\'' +
                ", metodoPagamento='" + pagamento + '\'' +
                ", righeDiComanda=" + righeDiComanda +
                '}';
    }


    public float calcolaTotale() {
        this.importo=0;
        for(RigaDiComanda rdc : this.righeDiComanda)
            this.importo+=rdc.CalcolaSubTotale();
        return importo;
    }


    public boolean effettuaPagamento(String metodoPagamento, String[] infoPagamento) {
        metodopagamento=Pagamento.getIstance();
        return metodopagamento.effettuaPagamento(metodoPagamento, infoPagamento, prezzoScontato);
    }

    public void setPrezzoScontato(float prezzoScontato) {
        this.prezzoScontato = importo;
    }

    public float associaSconto() {
        Sconto s=scontostrategyfactory.getSconto();
        prezzoScontato = s.calcolaImportoScontato(this.calcolaTotale());
        this.prezzoScontato=prezzoScontato;
        return prezzoScontato;
    }


}
