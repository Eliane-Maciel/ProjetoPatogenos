import java.io.Serializable;
/**
 * Esta classe servirá para cadastro de produtores rurais no sistema
 * 
 * @author Fernanda e Eliane
 * @version 1.0
 */
public class ProdutorRural implements Serializable{
    private String nome;
    private int telefone;
    private String endereco;
    private int cpf;
    ListaAlertas alertas = new ListaAlertas();
    
    public void setNome(String n)
    {
      nome = n;
    }
    
    public String getNome()
    {
     return nome;
    }
    
    public void setTelefone(int tel)
    {
     telefone = tel;
    }
    
    public int getTelefone()
    {
     return telefone;
    }
     public void setEndereco(String end)
    {
        endereco = end ;
    }

    public String getEndereco()
    {
        return endereco ;
    }

    public void setCpf(int c)
    {
        cpf = c ;
    }

    public int getCpf()
    {
        return cpf;
    }
    
    public ListaAlertas getAlertas(){
        ListaAlertas alert = new ListaAlertas();
        int count=0;
        for(int i=0; i<(this.alertas.tamanho());i++){
            if(!(this.alertas.get(i)).getRealizada()){
                alert.incluir(alertas.get(i));
                count ++;
            }
        }
        alert.setQuantas(count);
        return alert;
    }
    
    public Alerta realizaAlerta(String data){
        for(int i=0; i<(this.alertas.tamanho());i++){
            if(((this.alertas.get(i)).getData()).equals(data)){
                return this.alertas.get(i);
            }
        }
        return null;
    }
}
