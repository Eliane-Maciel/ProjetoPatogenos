import java.io.Serializable;
/**
 * classe ListaProdutoresRurais, implementa lista de produtores rurais.
 * 
 * @author Eliane, Fernanda 
 * @version 1.0
 */
public class ListaProdutoresRurais implements Serializable
{
    private ProdutorRural[] lista_produtor = null ;
    private int quantas = 0 ;
    private int capacidade = 0 ;
    
    public ListaProdutoresRurais()
    {
        this.lista_produtor = new ProdutorRural[100] ;
        this.capacidade = 100 ;
    }


    public boolean incluir(ProdutorRural produtor){
        if(quantas < capacidade){
            lista_produtor[quantas] = produtor ;
            quantas ++;
            return true;
        }
        else{
            return false;
        }
    }
    
     public ProdutorRural get(int indice)
    {
        if((indice>=0) && (indice<quantas))
        {
            return lista_produtor[indice];
        }
        return null ;
    }

    public int tamanho()
    {
        return quantas;
    }
    
    public ProdutorRural getPorNome(String nome){
        for(int i=0; i<quantas; i++){
            if((lista_produtor[i].getNome()).equals(nome)){
                return lista_produtor[i];
            }
        }
        return null;
    }
}
