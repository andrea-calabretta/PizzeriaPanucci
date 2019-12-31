import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public class Comanda {
    private int idComanda;
    private Date DataPrenotazione;
    private Date DataRitiro;
    private double importo;
    private String indirizzoConsegna;
    private String metodoPagamento;
    private List <RigaDiComanda> righeDiComanda;

    public Comanda(int idComanda, Date DataPrenotazione, Date DataRitiro, double importo, String indirizzoConsegna, String metodoPagamento, List<RigaDiComanda> righeDiComanda) {
        this.idComanda=idComanda;
        this.righeDiComanda = righeDiComanda;
        this.DataPrenotazione=DataPrenotazione;
        this.DataRitiro= DataRitiro;
        this.importo=importo;
        this.indirizzoConsegna=indirizzoConsegna;
        this.metodoPagamento=metodoPagamento;
        this.righeDiComanda=righeDiComanda;
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
}
