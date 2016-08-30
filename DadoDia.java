import java.io.Serializable;
/**
 * classe TabelaDados aqui, guarda os dados do arquivo csv.
 * 
 * @author Eliane, Fernanda 
 * @version 1.0
 */
public class DadoDia implements Serializable{
    private String data;
    private double media_temp;
    private double chuva_soma;
    private int foliar;
    private int pontos;
    
    /**
     * COnstrutor para objetos da classe TabelaDados
     */
    public DadoDia(String data, double media, double chuva, int foliar)
    {
        this.data = data;
        this.media_temp = media;
        this.chuva_soma = chuva;
        this.foliar = foliar;
    }

    public void setData(String data)
    {
        this.data = data;
    }

    public String getData()
    {
        return data;
    }

    public void setTemp(double temp)
    {
        this.media_temp = temp;
    }
    
    public double getTemp()
    {
        return media_temp;
    }

    public void setChuva(double chuva)
    {
        this.chuva_soma = chuva;
    }

    public double getChuva ()
    {
        return chuva_soma;
    }
    
    public void setFoliar(int fol)
    {
        this.foliar = fol;
    }

    public int getFoliar ()
    {
        return foliar;
    }
    
    public void setPontos(int numero)
    {
        int soma;
        soma = numero + pontos;
        this.pontos = soma;
    }

    public int getPontos ()
    {
        return pontos;
    }
}

