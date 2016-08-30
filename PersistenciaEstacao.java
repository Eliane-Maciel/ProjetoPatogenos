import java.io.*;
/**
 * classe PersistenciaEstacao, guarda dados da como pontos, que serão usados para gerar os alertas.
 * 
 * @author Eliane, Fernanda 
 * @version 1.0
 */
public class PersistenciaEstacao
{
    public void guardaLista(EstacaoMetereologica estacao){
        try
        {
            FileOutputStream fos = new FileOutputStream("estacao.obj");
            ObjectOutputStream escreve = new ObjectOutputStream(fos);
            escreve.writeObject(estacao);
            escreve.close();
        }
        catch(IOException e)
        {
            System.out.println("erro de IO");
        }
    }

    public EstacaoMetereologica recuperaLista()
    {
        EstacaoMetereologica estacao = new EstacaoMetereologica();
        try
        {
            FileInputStream fis = new FileInputStream("estacao.obj");
            ObjectInputStream leitor = new ObjectInputStream(fis);
            estacao = (EstacaoMetereologica) leitor.readObject();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("arquivo nao encontrado");
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("erro de IO");
        }
        catch(IOException e)
        {
            System.out.println("erro de IO");
        }
        return  estacao;
    }
}
