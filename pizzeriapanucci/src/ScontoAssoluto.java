public class ScontoAssoluto extends Sconto {

    private float soglia;
    private float riduzione;

    public ScontoAssoluto(String nome,  float soglia, float riduzione) {
        this.nome=nome;
        this.soglia=soglia;
        this.riduzione=riduzione;
    }

    @Override
    public float calcolaImportoScontato(float totaleNonScontato) {
        if(totaleNonScontato>soglia){
            float totaleScontato=totaleNonScontato-riduzione;
            return totaleScontato;
        }
        else return totaleNonScontato;
    }
}
