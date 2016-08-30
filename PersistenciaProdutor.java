import java.io.*;
/**
 * classe PersistenciaProdutor, faz a persistencia de Produtor assim, ao final da execução gera um aquivo de objetos.
 * 
 * @author Eliane, Fernanda
 * @version 1.0
 */
public class PersistenciaProdutor
{
    public void guardaLista(ListaProdutoresRurais lista){
        try
        {
            FileOutputStream fos = new FileOutputStream("produtores.obj");
            ObjectOutputStream escreve = new ObjectOutputStream(fos);
            escreve.writeObject(lista);
            escreve.close();
        }
        catch(IOException e)
        {
            System.out.println("erro de IO");
        }
    }

    public ListaProdutoresRurais recuperaLista()
    {
        ListaProdutoresRurais lista = new ListaProdutoresRurais();
        try
        {
            FileInputStream fis = new FileInputStream("produtores.obj");
            ObjectInputStream leitor = new ObjectInputStream(fis);
            lista = (ListaProdutoresRurais) leitor.readObject();
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
        return  lista;
    }
}
