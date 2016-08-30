import java.io.Serializable;
/**
 * classe ListaTabelaDados, lista de objetos DadoDia.
 * 
 * @author Eliane, Fernanda 
 * @version 1.0
 */
public class ListaTabelaDados implements Serializable
{
    private DadoDia[] lista_tabela = null ;
    private int quantas = 0 ;
    private int capacidade = 0 ;
    
    public ListaTabelaDados()
    {
        this.lista_tabela = new DadoDia[1000] ;
        this.capacidade = 1000 ;
    }

    public void incluir(DadoDia dado){
        if(this.quantas < this.capacidade){
            this.lista_tabela[quantas] = dado ;
            this.quantas ++;
        }
    }
    
     public DadoDia get(int indice)
    {
        if((indice>=0) && (indice< this.quantas))
        {
            return lista_tabela[indice];
        }
        return null ;
    }

    public int tamanho()
    {
        return this.quantas;
    }
}
