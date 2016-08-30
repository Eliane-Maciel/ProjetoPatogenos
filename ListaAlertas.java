import java.io.Serializable;
/**
 * classe ListaAlertas, guarda alertas;
 * 
 * @author Eliane, Fernanda
 * @version 1.0
 */
public class ListaAlertas implements Serializable{
    private Alerta[] lista_alerta = null ;
    private int quantas = 0 ;
    private int capacidade = 0 ;

    public ListaAlertas()
    {
        this.lista_alerta = new Alerta[1000] ;
        this.capacidade = 1000 ;
    }
    
    public int incluir(Alerta alerta){
        if(quantas < capacidade)
        {
            for(int i=0; i < quantas; i++){
                if(lista_alerta[i].equals(alerta)){
                    return 0;
                }
            }
            this.lista_alerta[quantas] = alerta ;
            this.quantas ++;
            return 1;
        }
        else{
            return 0;
        }
    }
    
     public Alerta get(int indice)
    {
        if((indice>=0) && (indice<quantas))
        {
            return lista_alerta[indice];
        }
        return null ;
    }

    public int tamanho()
    {
        return this.quantas;
    }

    public void setQuantas(int quantas){
        this.quantas = quantas;
    }
 
}
