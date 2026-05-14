/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.inforX.telas;
import java.sql.*;
import br.com.inforX.dal.ModuloConexao;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pichau
 */
public class TelaCliente extends javax.swing.JInternalFrame {
Connection conexao=null;
PreparedStatement pst=null;
ResultSet rs=null;

      
    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
        conexao=ModuloConexao.conector();
    } //
    // metodo para adicionar clientes
    private void adicionar (){
      
        String sql = "insert into tbclientes(nomecli, endcli,fonecli,emailcli) values(?, ?, ?, ?)";
   
        try {
           
            pst=conexao.prepareStatement(sql);       //
            pst.setString(1, jTextField2.getText());
            pst.setString(2, jTextField3.getText());
            pst.setString(3, jTextField4.getText());
            pst.setString(4, jTextField5.getText());
            
            if (jTextField2.getText().isEmpty() || jTextField4.getText().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
} else {

 
            
            
            
            
            // atualiza a tabela usuario 
           // pst.executeUpdate();
            //A ESTRUTURA ABAIXO E USADA PARA CONFIMAR 
            int adicionado =pst.executeUpdate();
            
              System.out.println(adicionado);
            if (adicionado>0){
             JOptionPane.showMessageDialog(null, "cliente  adicionado com sucesso");
                
                 jTextField2.setText(null);
                 jTextField3.setText(null);
                 jTextField4.setText(null);
                 jTextField5 .setText(null);
                 jButton1.setEnabled(true);
              
                 }
            }
            
       } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
       }
   
   
   
   }
   
   // método para pesquisar clientes 
    private void pesquisar_cliente() {
        String sql = "select idcli as Id, nomecli as Nome, endcli as Endereço, fonecli as Fone, emailcli as Email from tbclientes where nomecli like ?";
        try {
            pst = conexao.prepareStatement(sql);
            // Passando o conteúdo da caixa de pesquisa para o ?
            pst.setString(1, jTextField1.getText() + "%");
            rs = pst.executeQuery();

            // Configura o modelo da sua tabela tblCliente
            DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
            modelo.setNumRows(0); // Limpa a tabela antes de preencher

            while (rs.next()) {
                // Adiciona as linhas pegando os dados do banco de dados
                modelo.addRow(new Object[]{
                    rs.getString(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    // Método para preencher os campos de texto com os dados da tabela selecionada
public void setar_campos() {
    int setar = tblCliente.getSelectedRow();
    
    // Verificamos se há uma linha selecionada para evitar erros
    if (setar >= 0) {
        jTextField6.setText(tblCliente.getModel().getValueAt(setar, 0).toString());
        jTextField2.setText(tblCliente.getModel().getValueAt(setar, 1).toString());
        jTextField3.setText(tblCliente.getModel().getValueAt(setar, 2).toString());
        jTextField4.setText(tblCliente.getModel().getValueAt(setar, 3).toString());

     
   
        if (tblCliente.getColumnCount() > 4) {
            Object email = tblCliente.getModel().getValueAt(setar, 4);
            jTextField5.setText(email != null ? email.toString() : "");
        } else {
            
            jTextField5.setText(""); 
        }


        jButton1.setEnabled(false);
    }
}
// metodo para alterar dados do cliente 
private void alterar() {
    // 1. CORREÇÃO: Removida a vírgula antes do WHERE
    String sql = "update tbclientes set nomecli=?, endcli=?, fonecli=?, emailcli=? where idcli=?";
    
    try {
        pst = conexao.prepareStatement(sql);
        
        // Validação
        if (jTextField2.getText().isEmpty() || jTextField4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Preencha todos os campos obrigatórios");
        } else {
            // 2. CORREÇÃO: Alinhamento dos parâmetros (1 a 5)
            pst.setString(1, jTextField2.getText()); // novo nome
            pst.setString(2, jTextField3.getText()); // endereço
            pst.setString(3, jTextField4.getText()); // telefone
            pst.setString(4, jTextField5.getText()); // email
            pst.setString(5, jTextField6.getText()); 

         
            int adicionado = pst.executeUpdate();
            
            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Dados do cliente alterados com sucesso");
                limpar();
                // Limpeza dos campos
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
            } else {
                // Caso o nome digitado no WHERE não exista no banco
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            }
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro ao alterar: " + e);
    }
}
    /**
     *
     */// método para a exclusão de clientes

// Método para limpar os campos e reativar o botão Adicionar
private void limpar() {
    jTextField1.setText(""); // pesquisa
    jTextField2.setText("");
    jTextField3.setText("");
    jTextField4.setText("");
    jTextField5.setText("");
    jTextField6.setText("");
    ((DefaultTableModel) tblCliente.getModel()).setNumRows(0);
    jButton1.setEnabled(true); // REABILITA O BOTÃO AQUI
} 

private void remover() {
    int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este cliente?", "Atenção", JOptionPane.YES_NO_OPTION);
    if (confirma == JOptionPane.YES_OPTION) {
        // CORREÇÃO: Usar idcli em vez de iduser para a tabela tbclientes
        String sql = "delete from tbclientes where idcli=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, jTextField6.getText());
            int apagado = pst.executeUpdate();
            if (apagado > 0) {
                JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
                limpar(); // Chama o método para resetar a tela e o botão
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();

        jLabel1.setText("*Fone");

        jLabel2.setText("*Nome");

        jLabel3.setText("Endereço");

        jLabel4.setText("Email");

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Editar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Deletar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jLabel5.setText("*Campos obrigatórios");

        tblCliente = new javax.swing.JTable() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; // Bloqueia a edição de todas as células
            }
        };
        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Endereço", "Fone", "Endereço"
            }
        ));
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);

        jLabel6.setText("ID Cliente");

        jTextField6.setEnabled(false);
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(57, 57, 57))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(56, 56, 56)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(58, 58, 58)
                                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(69, 69, 69)
                                .addComponent(jButton2)
                                .addGap(61, 61, 61)
                                .addComponent(jButton3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(423, 423, 423))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(387, 387, 387))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addGap(261, 261, 261))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      alterar();  // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    remover();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // metodo para adicionar clientes:
        adicionar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
    pesquisar_cliente();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
      setar_campos();  // TODO add your handling code here:
    }//GEN-LAST:event_tblClienteMouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTable tblCliente;
    // End of variables declaration//GEN-END:variables
}
