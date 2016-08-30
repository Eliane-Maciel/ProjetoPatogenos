import java.io.Serializable;
/**
 * Classe de objeto alerta, criado o objeto apartir de calculos, quando fica com a pontuação igual à 100. 
 * 
 * @author Eliane, Fernanda
 * @version 1.0
 */
public class Alerta implements Serializable
{
    private String data;
    private String mensagem;
    private boolean realizada;
    
    public Alerta(String data, String mensagem)
    {
        this.data = data;
        this.mensagem = mensagem;
        this.realizada = false;
    }
    
    public String getData(){
        return data;
    }
    
    public String getMensagem(){
        return mensagem;
    }
    
    public boolean getRealizada(){
        return realizada;
    }
    
    public void realizarPulverizacao(){
        this.realizada = true;
    }
    
    public String verAlerta(){
        String aviso = "";
        if(this.realizada){
            aviso = "Tarefa Realizada";
        }
        else{
            aviso = "Tarefa Pendente";
        }
        return this.data + ", "+ this.mensagem+ ", "+ aviso + ".";
    }
    
}
