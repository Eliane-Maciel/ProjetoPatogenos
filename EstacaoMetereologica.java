import java.io.Serializable;
/**
 * classe EstacaoMetereologica, objeto que guarda o total de pontos.
 * 
 * @author Eliane, Fernanda
 * @version 1.0
 */
public class EstacaoMetereologica implements Serializable{
    private int pontos = 0;
    private String ultima_data = "";
    private String mensagem = "O produtor deve fazer a pulverização da plantação.";
    /**
     * Exemplo de método - substitua este comentário pelo seu próprio
     * 
     * @param  y   exemplo de um parâmetro de método
     * @return     a soma de x com y 
     */
    public int getPontos(){
        return pontos;
    }
    
    public void setPontos(int pontos){
        this.pontos = pontos;
    }
    
    public String getUltimaData(){
        return ultima_data;
    }
    
    public void setUltimaData(String data){
        this.ultima_data = data;
    }
    
     public String getMensagem(){
        return mensagem;
    }
    
    public void setMensagem(String mens){
        this.mensagem = mens;
    }
}
