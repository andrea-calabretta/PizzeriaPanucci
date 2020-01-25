import java.util.Arrays;

public class Pagamento{
    private float importo;
    private MetodoPagamento metodoDiPagamento;

    public boolean effettuaPagamento(String metodoPagamento, String[] infoPagamento, float totaleDaPagare) {
        this.importo = totaleDaPagare;
        if(metodoPagamento == "cartadebito") {
            if(infoPagamento.length > 4 || Arrays.asList(infoPagamento).contains(null))	return false;
            metodoDiPagamento = new CartaDiDebito(infoPagamento[0], infoPagamento[1], infoPagamento[2], infoPagamento[3]);
            return metodoDiPagamento.paga(totaleDaPagare);
        }else if(metodoPagamento == "paypal"){
            if(infoPagamento.length > 2 || Arrays.asList(infoPagamento).contains(null))	return false;
            metodoDiPagamento = new PayPal(infoPagamento[0], infoPagamento[1]);
            return metodoDiPagamento.paga(totaleDaPagare);
        }else if(metodoPagamento == "cartacredito" ) {
            if(infoPagamento.length > 4 || Arrays.asList(infoPagamento).contains(null))	return false;
            metodoDiPagamento = new CartaDiCredito(infoPagamento[0], infoPagamento[1], infoPagamento[2], infoPagamento[3]);
            return metodoDiPagamento.paga(totaleDaPagare);
        }else {
            return false;
        }
    }

}