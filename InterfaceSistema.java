import java.io.*;
public class InterfaceSistema
{
    ListaTabelaDados lista = new ListaTabelaDados();
    PersistenciaProdutor persiste = new PersistenciaProdutor();
    PersistenciaEstacao persiste_estacao = new PersistenciaEstacao();
    EstacaoMetereologica estacao = new EstacaoMetereologica();
    /**
    /**
     * Leitura de Arquivo - lê um arquivo csv, e cria objetos "DadoDia".
     * 
     * @param 
     * @return  Lista com os Dados
     */
    public ListaTabelaDados leituraArquivo(){
       try{
            BufferedReader leitor = new BufferedReader(new FileReader("lista1.csv"));
            String linha = leitor.readLine();
            String[] dado = linha.split(";");
            String data = dado[0];
            double temp = 0;
            double chuva = 0;
            int cont = 0;
            int foliar = 0;
            int horas_foliar = 0;
            int pont = 0;
            String str ="";
            String str1 ="";
            
            while(linha!=null)
            {
                dado = linha.split(";");
                if(data.equals(dado[0])){
                    data = dado[0];
                    str = dado[1].replaceAll(",",".");
                    temp += Double.parseDouble(str);
                    str1 = dado[2].replaceAll(",",".");
                    chuva += Double.parseDouble(str1);
                    cont ++;
                    foliar = Integer.parseInt(dado[3].trim());
                    if(foliar >  10){
                        horas_foliar += 2;
                    }
                }
                else{
                    temp = temp/cont;
                    DadoDia dia = new DadoDia(data, temp, chuva, horas_foliar);
                    pont = calculoPontos(dia);
                    dia.setPontos(pont);
                    lista.incluir(dia) ;
                    horas_foliar = 0;
                    chuva = 0;
                    temp = 0;
                    data = dado[0];
                    cont = 0;
                }
                linha = leitor.readLine();
                if(linha == null){
                    temp = temp/cont;
                    DadoDia dia = new DadoDia(data, temp, chuva, horas_foliar);
                    pont = calculoPontos(dia);
                    dia.setPontos(pont);
                    lista.incluir(dia) ;
                }
            }
       }
       catch(IOException e){
           System.out.println("erro de IO");
       }
       return lista;
    }
    
    /**
    /**
     * Calculo Pontos  - recebe um objeto do dia, e faz os testes para os pontos.
     * 
     * @param objeto DadoDia
     * @return  Lista com os Dados
     */
    public int calculoPontos(DadoDia dado){
        if(dado.getChuva() > 0.2){
            if(dado.getFoliar() >0){
                if((dado.getTemp() > 20) && (dado.getTemp()< 28.3)){
                    return 11;
                }
                else {
                    if(dado.getTemp() > 28.3){
                        return 8;
                    }
                    else {
                        if(dado.getTemp() < 20){
                            return 6;
                        }
                    }
                }
            }
            else{
                if((dado.getTemp() > 20) && (dado.getTemp()< 28.3)){
                    return 6;
                }
                else {
                    if(dado.getTemp() > 28.3){
                        return 4;
                    }
                    else{
                        if(dado.getTemp() < 20){
                            return 3;
                        }
                    }
                }
            }
        }
        else{
             if(dado.getFoliar() >0){
                if((dado.getTemp() > 20) && (dado.getTemp()< 28.3)){
                    return 6;
                }
                else {
                    if(dado.getTemp() > 28.3){
                        return 6;
                    }
  
                    else {
                        if(dado.getTemp() < 20){
                            return 4;
                        }
                    }
                }
            }
            else{
                if((dado.getTemp() > 20) && (dado.getTemp()< 28.3)){
                    return 3;
                }
                else {
                    if(dado.getTemp() > 28.3){
                        return 0;
                    }
                    else {
                        if(dado.getTemp() < 20){
                            return 0;
                        }
                    }
                }
            }
        }
        return 0;
    }
    
    /**
    /**
     * Alertas  - faz a soma de pontos, por dias. Quando chega a 100 pontos gera os objetos alertas.
     * 
     * @param -
     * @return  -
     */
    public void alertas(){
        int soma = 0;
        String data = "";
        boolean achou = false;
        for(int i=0; i<(lista.tamanho()); i++){
            soma += (lista.get(i)).getPontos();
            data = ((lista.get(i)).getData());
            if(soma >= 100){
                soma = 0;
                Alerta alert = new Alerta(data, estacao.getMensagem());
                gerarAlertas(alert);
            }
        }
        estacao.setPontos(soma);
        estacao.setUltimaData(data);
        persiste_estacao.guardaLista(estacao);
    }
    
    /**
    /**
     * Gerar Alertas  - recebe um objeto alerta e inclui na lista de alertas do produtor.
     * 
     * @param - object Alerta
     * @return  -
     */
    public void gerarAlertas(Alerta alerta){
        ListaProdutoresRurais lista = new ListaProdutoresRurais();
        lista = persiste.recuperaLista();
        int retorno;
        for(int i=0; i<lista.tamanho(); i++){
            retorno = (lista.get(i)).alertas.incluir(alerta);
            if (retorno == 0){
                System.out.println("deu algum problema");
            }
        }
    }
}