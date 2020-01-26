package pizzeriaPanucci;

public class ScontoPercentuale extends Sconto {
    private float soglia;
    private float percentuale;

    public ScontoPercentuale(String nome, int soglia, float percentuale) {
        this.nome=nome;
        this.soglia = soglia;
        this.percentuale = percentuale;
    }

    @Override
    public float calcolaImportoScontato(float totaleNonScontato) {
        if(totaleNonScontato>soglia){
            float totaleScontato=totaleNonScontato*(percentuale/100);
            return totaleScontato;
        }
        else return totaleNonScontato;

    }
}
