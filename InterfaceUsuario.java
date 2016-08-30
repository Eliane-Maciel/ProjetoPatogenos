import java.util.Scanner;
import java.io.*;
/**
 * classe InterfaceUsuario, menu para o usuário.
 * 
 * @author Eliane, Fernanda
 * @version 1.0
 */
public class InterfaceUsuario
{
    ListaProdutoresRurais listaprodutores = new ListaProdutoresRurais();
    EstacaoMetereologica estacao = new EstacaoMetereologica();
    InterfaceSistema inter = (new InterfaceSistema());
    PersistenciaProdutor persistencia = new PersistenciaProdutor();
    PersistenciaEstacao persiste_estacao = new PersistenciaEstacao();
    public void mostrarOMenuDeOpcoes()
    {
        ListaTabelaDados listadados = inter.leituraArquivo();
        inter.alertas();
        listaprodutores = persistencia.recuperaLista();
        Scanner entrada = new Scanner(System.in);
        System.out.println("0.Sair");
        System.out.println("1.Cadastrar um Produtor");
        System.out.println("2.Ver todos os Alertas");
        System.out.println("3.Ver os Alertas não realizados");
        System.out.println("4.Relizar pulverização");
        System.out.println("5.Ver a quantidade de pontos.");
        int opcao = entrada.nextInt();
        while(opcao != 0)
        {
            if(opcao == 1)
            {
                entrada.nextLine();
                System.out.println("Qual é o nome:");
                String nome = entrada.nextLine();
                System.out.println("Qual é o endereco:");
                String end = entrada.nextLine();
                System.out.println("Qual é o cpf:");
                int cpf = entrada.nextInt();
                ProdutorRural produtor = new ProdutorRural();
                produtor.setNome(nome) ;
                produtor.setCpf(cpf) ;
                produtor.setEndereco(end) ;
                if(listaprodutores.incluir(produtor)){
                    System.out.println("Produtor Cadastrado;");
                }
                else{
                    System.out.println("Lista de produtores cheia");
                }  
                // Guarda a lista de produtores para vericar os alertas;
                persistencia.guardaLista(listaprodutores);
            }
            else
            {
                if(opcao == 2){
                    entrada.nextLine();
                    System.out.println("Qual é o nome do Produtor:");
                    String nome = entrada.nextLine();
                    ProdutorRural produtor = listaprodutores.getPorNome(nome);
                    if (produtor != null){
                        ListaAlertas alert = new ListaAlertas();
                        alert = produtor.alertas;
                        for(int i=0; i<(alert.tamanho());i++){
                            String alert_srt = (produtor.alertas.get(i)).verAlerta();
                            System.out.println(alert);
                        }
                    }
                    else{
                        System.out.println("Produtor não encontrado.");
                    }
                }
                else{
                    if(opcao == 3){
                        entrada.nextLine();
                        System.out.println("Qual é o nome do Produtor:");
                        String nome = entrada.nextLine();
                        ProdutorRural produtor = listaprodutores.getPorNome(nome);
                        if (produtor != null){
                            ListaAlertas alertas = produtor.getAlertas();
                            if(alertas != null){
                                for(int i=0; i<(alertas.tamanho());i++){
                                    String alert = (alertas.get(i)).verAlerta();
                                    System.out.println(alert);
                                }
                            }
                            else{
                                System.out.println("Produtor não possui alertas pendentes.");
                            }
                        }
                    }
                    else{
                        if(opcao == 4){
                            entrada.nextLine();
                            System.out.println("Qual é o nome do Produtor:");
                            String nome = entrada.nextLine();
                            entrada.nextLine();
                            System.out.println("Qual é a data:");
                            String data = entrada.nextLine();
                            ProdutorRural produtor = listaprodutores.getPorNome(nome);
                            if (produtor != null){
                                Alerta alert = produtor.realizaAlerta(data);
                                if(alert != null){
                                    alert.realizarPulverizacao();
                                    System.out.println("Pulverização realizada.");
                                }
                                else{
                                    System.out.println("Não possui alerta com essa data.");
                                }
                            }
                            else{
                                System.out.println("Produtor não encontrado.");
                            }
                       }
                       else{
                            if(opcao == 5){
                                estacao = persiste_estacao.recuperaLista();
                                System.out.print("Total de pontos: ");
                                System.out.println(estacao.getPontos());
                            }
                        }
                    }
                }
            }
            System.out.println("0.Sair");
            System.out.println("1.Cadastrar um Produtor");
            System.out.println("2.Ver todos os Alertas");
            System.out.println("3.Ver os Alertas realizados");
            System.out.println("4.Relizar pulverização");
            System.out.println("5.Ver a quantidade de pontos.");
            opcao = entrada.nextInt();
        }
        persistencia.guardaLista(listaprodutores);
    }
}
