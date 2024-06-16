/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Mendes
 */
public class TelaCalculo extends javax.swing.JInternalFrame {

    /**
     * Creates new form TelaCalculo
     */
    public TelaCalculo() {
        initComponents();
        gerarAleatorio();   
    }
        
        public void salvarArquivo(int num01,int num02, String operacao,String resposta,String horaResposta){
                
        String content = "Resposta :"+num01+";"+operacao+";"+num02+";"+resposta+";"+horaResposta+".";
       
        String directoryPath = "C:/pastaLog";
        String filePath = directoryPath + "/arquivo.txt";

        // Cria a pasta se ela não existir
        Path directory = Paths.get(directoryPath);
        if (Files.notExists(directory)) {
            try {
                Files.createDirectories(directory);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        // Converte o conteúdo para uma lista de strings
        List<String> lines = List.of(content);

        try {
            // Adiciona o conteúdo ao arquivo existente ou cria um novo arquivo
            Files.write(Paths.get(filePath), lines, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            System.out.println("Conteúdo adicionado com sucesso em " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }            
    }
    
    //Gerador de numeros aleatorios.
    public void gerarAleatorio (){
        
        int num01 = gerarSequencia();
        int num02 = gerarSequencia();
        String op = gerarOperacao();
        
        //contornad possiveis erros em divisão
        if(op.equals("/") && num02 > 0 && num02 <= num01 ){
            
        jTextNum01.setText(String.valueOf(num01));
        jTextNum02.setText(String.valueOf(num02));
        jLabelOperacao.setText(op);
        
        }
        if(!op.equals("/")){
        jTextNum01.setText(String.valueOf(num01));
        jTextNum02.setText(String.valueOf(num02));
        jLabelOperacao.setText(op);
        }else{
        //chamando o proprio metodo caso encontre erro
        gerarAleatorio();     
        }
       
    }
    
    //Limpar campos de texto.
    public void limprarTela (){
        jTextNum01.setText("");
        jTextNum02.setText("");
        jTextResposta.setText("");
    }
    //Contadores Acerto e Erro.
    int contAcertos = 0;
    int contErros = 0;   
    //Validar numero digitado no campo de texto. 
    public boolean isNumero (String jResposta){
        try {
            Integer.parseInt(jResposta);
        return true;
        } catch (NumberFormatException e) {
        return false;
        }   
    }   
    //Gerador de numero aleatorio.  
    public int gerarSequencia (){
           Random rand = new Random();
            int tamanhoSequencia = 10; // Define o tamanho da sequencia 
            int numero = 0;
            for (int i = 0; i < tamanhoSequencia; i++){
               numero = rand.nextInt(10) + 1; // Gera o numero aleatorio          
            }
            return numero; 
    }
    //Gerador de operação matematica.
    public String gerarOperacao (){
        String op = "";
         Random rand = new Random();
            int tamanhoSequencia = 10; // Define tamanho da sequencia
            for (int i = 0; i < tamanhoSequencia; i++){
                int escolha = rand.nextInt(4); // Gerando um numero aleatorio entre 0 e              
                //  Dependendo do numero gerado, seleciona o simbolo correspondente     
                switch (escolha){              
                    case 0 : op = "+"; // Adição
                              break;
                    case 1 : op = "-"; // Subtração
                              break;  
                    case 2 : op = "/"; // Divisão
                              break; 
                    case 3 : op = "*"; // Multiplicação
                              break;
                }
            }
    return op;
    }   
    //Validação de calculos
    public int isResultado (int num01,int num02,String operacao ){
            
        int op = 0;
        
    if(operacao.equals("+")){
         op = num01 + num02;
     }
    if(operacao.equals("-")){
         op = num01 - num02;
     }
    if(operacao.equals("*")){
        op = num01 * num02;
    }
    if(operacao.equals("/") & num02 !=0 ){
    if(num02 <= num01){
     op = num01/num02; 
    } 
    limprarTela();
    gerarAleatorio();
    } 
    return op;
    }
       
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextNum01 = new javax.swing.JTextField();
        jTextNum02 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextResposta = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabelOperacao = new javax.swing.JLabel();
        jLabelRespostaAcertos = new javax.swing.JLabel();
        jLabelRespostaErros = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText(" Libera com 10 acertos.");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTextNum01.setEditable(false);

        jTextNum02.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("  =");

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton2.setText("Responder");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton2KeyPressed(evt);
            }
        });

        jLabelOperacao.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelOperacao.setText("+");

        jLabelRespostaAcertos.setText("Numero de acertos");

        jLabelRespostaErros.setText("Numero de erros");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextResposta)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelOperacao))
                        .addGap(28, 28, 28)
                        .addComponent(jTextNum02, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNum01, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelRespostaAcertos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelRespostaErros)
                        .addGap(33, 33, 33))
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextNum01, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextNum02, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelOperacao, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTextResposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRespostaAcertos)
                    .addComponent(jLabelRespostaErros))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(0, 0, 352, 334);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        // Obter o timestamp atual
        Instant now = Instant.now();
        
        // Formatar o timestamp
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());
        String formattedDate = formatter.format(now);
                     
        int num01 = Integer.parseInt(jTextNum01.getText());
        int num02 = Integer.parseInt(jTextNum02.getText());
        String op = jLabelOperacao.getText();
                
        // metodo que recebe informações da tela calcula e devolve resultado para comparar com a resposta do usuario.                 
        if(isNumero(jTextResposta.getText())){
        
        if(Integer.parseInt(jTextResposta.getText()) == isResultado(num01, num02, op)){
            contAcertos = contAcertos + 1;
            jLabelRespostaAcertos.setText("Acertos "+contAcertos);
            //Salvar log das respostas  
            salvarArquivo(num01,num02,op," = "+jTextResposta.getText()+" Certo",formattedDate);
        }else{
            contErros = contErros + 1;
            jLabelRespostaErros.setText("Erros "+contErros);
            //Salvar log das respostas  
            salvarArquivo(num01,num02,op," = "+jTextResposta.getText()+" Errado",formattedDate);
        }
        }else{
         JOptionPane.showMessageDialog(rootPane,"Erro! Você não digitou um número valido.");
        }  
        
        limprarTela();
        gerarAleatorio();
        
        if(contAcertos == 10 ){
            JOptionPane.showMessageDialog(rootPane,"Parabéns, você conseguiu acertou "+contAcertos+" respostas.");
            System.exit(0);
        }       
    }//GEN-LAST:event_jButton2ActionPerformed
    
    private void jButton2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyPressed
        // TODO add your handling code here:
        int num01 = Integer.parseInt(jTextNum01.getText());
        int num02 = Integer.parseInt(jTextNum02.getText());
        String operacao = jLabelOperacao.getText();
                
        // metodo que recebe informações da tela calcula e devolve resultado para comparar com a resposta do usuario. 
        
        if(isNumero(jTextResposta.getText())){
              
        if(Integer.parseInt(jTextResposta.getText()) == isResultado(num01, num02, operacao)){
            contAcertos = contAcertos + 1;
            jLabelRespostaAcertos.setText("Acertos "+contAcertos);
        }else{
             contErros = contErros + 1;
            jLabelRespostaErros.setText("Erros "+contErros);
        }
        }else{
         JOptionPane.showMessageDialog(rootPane,"Erro! Você não digitou um número valido.");
        }  
        
        limprarTela();
        gerarAleatorio();
        
        if(contAcertos == 10 ){
            JOptionPane.showMessageDialog(rootPane,"Parabéns, você conseguiu acertou "+contAcertos+" respostas pode ir Jogar.");
            System.exit(0);
        }       
    }//GEN-LAST:event_jButton2KeyPressed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelOperacao;
    private javax.swing.JLabel jLabelRespostaAcertos;
    private javax.swing.JLabel jLabelRespostaErros;
    private javax.swing.JTextField jTextNum01;
    private javax.swing.JTextField jTextNum02;
    private javax.swing.JTextField jTextResposta;
    // End of variables declaration//GEN-END:variables
}
