/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.inforX.telas;
import java.sql.*;
import br.com.inforX.dal.ModuloConexao;
import com.mysql.cj.x.protobuf.MysqlxExpr;
import javax.swing.JOptionPane; 

/**
 *
 * @author Pichau
 */
public class telaUsuario extends javax.swing.JInternalFrame {
   
   Connection conexao = null;
   PreparedStatement pst= null;
   ResultSet rs=null;
   
    /**
     * Creates new form telaUsuario
     */
    public telaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
        
    }
   private void consultar(){
    String sql = "select * from tbusuarios where iduser=?";
       try {
           pst=conexao.prepareStatement(sql);
           pst.setString(1,txtUsuId.getText());
           rs=pst.executeQuery();
           if (rs.next()) {
               jTextFieldm.setText(rs.getString(2));
               jTextField5.setText(rs.getString(3));
               jTextField3.setText(rs.getString(4));
               jTextField4.setText(rs.getString(5));
               jComboBox1.setSelectedItem(rs.getString(6));
               
            
           } else {
               
                JOptionPane.showMessageDialog(null, "usúario não Cadastrado");
                // limpar os campos 
                 jTextFieldm.setText(null);
                 jTextField5.setText(null);
                 jTextField3 .setText(null);
                 jTextField4 .setText(null);
                 jComboBox1.setSelectedItem(null);
           }
       } catch (Exception e) {
         JOptionPane.showMessageDialog(null, e);
       }
    
    
    }
// metodo para adicionar  usúarios 
   
   private void adicionar (){
      
        String sql = "insert into tbusuarios(iduser, usuario,fone, login, senha, perfil) values(?, ?, ?, ?,?,?)";
   
        try {
           
            pst=conexao.prepareStatement(sql);
            pst.setString(1, txtUsuId.getText());
            pst.setString(2, jTextFieldm.getText());
            pst.setString(3, jTextField5  .getText());
            pst.setString(4, jTextField3.getText());
            pst.setString(5,jTextField4.getText());
            pst.setString(6,jComboBox1.getSelectedItem().toString());// consverter o item selecionado em string 
            
            if (txtUsuId.getText().isEmpty() ||
                  jTextFieldm.getText().isEmpty() ||
                  jTextField5.getText().isEmpty() ||
                  jTextField3.getText().isEmpty() ||
                  jTextField4.getText().isEmpty() ||
                  jComboBox1.getSelectedItem() == null)
            {
            
                 JOptionPane.showMessageDialog(null, "Prencha todos os campos obrigatórios ");
                 
                
            } else {
                
            
            
            
            
            // atualiza a tabela usuario 
           // pst.executeUpdate();
            //A ESTRUTURA ABAIXO E USADA PARA CONFIMAR 
            int adicionado =pst.executeUpdate();
            
              System.out.println(adicionado);
            if (adicionado>0){
             JOptionPane.showMessageDialog(null, "Usúario adicionado com sucesso");
                
                 txtUsuId.setText(null);
                 jTextFieldm.setText(null);
                 jTextField5.setText(null);
                 jTextField3 .setText(null);
                 jTextField4 .setText(null);
                 jComboBox1.setSelectedItem(null); }
            }
            
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
       }
   
   
   
   }
   
   
   // criando o metodo para alterar dados do usuario 
   private void alterar(){
      String sql = "update tbusuarios set usuario=?, fone=?, login=?, senha=?, perfil=? where iduser=?";
    try {
        pst = conexao.prepareStatement(sql);
        // A ordem aqui deve corresponder à ordem dos campos na query SQL
        pst.setString(1, jTextFieldm.getText());
        pst.setString(2, jTextField5.getText());
        pst.setString(3, jTextField3.getText());
        pst.setString(4, jTextField4.getText());
        pst.setString(5, jComboBox1.getSelectedItem().toString());
        pst.setString(6, txtUsuId.getText()); // ID do usuário a ser alterado


            
         if (txtUsuId.getText().isEmpty() ||
                  jTextFieldm.getText().isEmpty() ||
                  jTextField5.getText().isEmpty() ||
                  jTextField3.getText().isEmpty() ||
                  jTextField4.getText().isEmpty() ||
                  jComboBox1.getSelectedItem() == null)
            {
            
                 JOptionPane.showMessageDialog(null, "Prencha todos os campos obrigatórios ");
                 
                
            } else {
                
            
            
            
            
            // atualiza a tabela usuario 
           // pst.executeUpdate();
            //A ESTRUTURA ABAIXO E USADA PARA CONFIMAR  a alteraçao do dados dos usuarios 
            int adicionado =pst.executeUpdate();
            
              System.out.println(adicionado);
            if (adicionado>0){
             JOptionPane.showMessageDialog(null, "Usúario dados dos usuários alterados  com sucesso");
                
                 txtUsuId.setText(null);
                 jTextFieldm.setText(null);
                 jTextField5.setText(null);
                 jTextField3 .setText(null);
                 jTextField4 .setText(null);
                 jComboBox1.setSelectedItem(null); }
            }
            
            
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
       }
   
   
           }
          
   
   // metodo resposavel pela remoção do usuario 
public void remover(){
    // Mostra um diálogo de confirmação antes de remover o usuário
    int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este usuário?", "Atenção", JOptionPane.YES_NO_OPTION);
    
    // Se o usuário clicar em "Sim" (YES_OPTION)
    if(confirma == JOptionPane.YES_OPTION){
        String sql = "delete from tbusuarios where iduser=?";
        try {
            // Prepara a instrução SQL
            pst = conexao.prepareStatement(sql);
            
            // Define o parâmetro '?' com o ID do usuário que você deseja remover
            pst.setString(1, txtUsuId.getText());
            
            // Executa a instrução e verifica se a remoção foi bem-sucedida
            int removido = pst.executeUpdate();
            
            if (removido > 0) {
                JOptionPane.showMessageDialog(null, "Usuário removido com sucesso!");
                // Limpa os campos após a remoção
                txtUsuId.setText(null);
                jTextFieldm.setText(null);
                jTextField5.setText(null);
                jTextField3.setText(null);
                jTextField4.setText(null);
                jComboBox1.setSelectedItem(null);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
    
    // * This method is called from within the constructor to initialize the form.
    // * WARNING: Do NOT modify this code. The content of this method is always
   //  * regenerated by the Form Editor.
   //  */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuId = new javax.swing.JTextField();
        jTextFieldm = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jLabel1.setText("* ID");

        jLabel2.setText(" * Nome");

        jLabel3.setText("* Login");

        jLabel4.setText("* Senha");

        jLabel5.setText("Perfil");

        txtUsuId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuIdActionPerformed(evt);
            }
        });

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "adm", "user" }));

        jLabel6.setText(" Fone");

        jButton3.setText("Alterar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Adicionar ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Consultar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel7.setText("*campos obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldm, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel5)
                                .addGap(27, 27, 27)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(149, 149, 149))))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton1)
                .addGap(83, 83, 83)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(63, 63, 63)
                .addComponent(jButton4)
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtUsuId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7)))
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(22, 22, 22))
        );

        setBounds(0, 0, 639, 481);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // chmando o metoso consultar 
     consultar();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // chamando o metodo adicionar 
        adicionar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // chamando o metodo alterar 
        alterar();
   
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       remover();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtUsuIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuIdActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextFieldm;
    private javax.swing.JTextField txtUsuId;
    // End of variables declaration//GEN-END:variables
}
