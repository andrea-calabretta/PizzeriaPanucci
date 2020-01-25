import javax.xml.crypto.Data;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Comanda {
    private int idComanda;
    private Date DataPrenotazione;
    private Date DataRitiro;
    private double importo;
    private String indirizzoConsegna;
    private String metodoPagamento;
    private List <RigaDiComanda> righeDiComanda;
    private Cliente cliente;



    public Comanda(Cliente cliente, String indirizzoConsegna, Date dataPrenotazione) {
        this.indirizzoConsegna=indirizzoConsegna;
        this.DataPrenotazione=dataPrenotazione;
        this.cliente=cliente;
        righeDiComanda=new LinkedList<RigaDiComanda>();

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

    public double getImporto() {
        return importo;
    }

    public String getIndirizzoConsegna() {
        return indirizzoConsegna;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
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
                ", metodoPagamento='" + metodoPagamento + '\'' +
                ", righeDiComanda=" + righeDiComanda +
                '}';
    }


    public float calcolaTotale() {
        float totale=0;
        for(RigaDiComanda rdc : this.righeDiComanda)
            totale+=rdc.CalcolaSubTotale();
        return totale;


    }
}
