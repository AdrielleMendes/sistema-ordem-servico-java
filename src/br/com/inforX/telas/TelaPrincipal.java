

package br.com.inforX.telas;
import br.com.inforX.telas.TelaSobre;
import java.text.DateFormat;

import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;

public class TelaPrincipal extends javax.swing.JFrame{

       public TelaPrincipal() {
        initComponents();

}
       
       
       
       

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktop = new javax.swing.JDesktopPane();
        lblData = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        menCadCli = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        menCadUsu = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        menRelSer = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        menAjuSob = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        MenOpc = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("X-sistema para controle de ordem de serviço");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout desktopLayout = new javax.swing.GroupLayout(desktop);
        desktop.setLayout(desktopLayout);
        desktopLayout.setHorizontalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        desktopLayout.setVerticalGroup(
            desktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        lblData.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblData.setText("Data");

        lblUsuario.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        lblUsuario.setText("Usuário");

        menCadCli.setText("Cadastro");

        jMenuItem1.setText("Cliente");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menCadCli.add(jMenuItem1);

        menCadUsu.setText("OS");
        menCadUsu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menCadUsuActionPerformed(evt);
            }
        });
        menCadCli.add(menCadUsu);

        jMenuItem3.setText("Usuários");
        jMenuItem3.setEnabled(false);
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menCadCli.add(jMenuItem3);

        Menu.add(menCadCli);

        menRelSer.setText("Relatório");
        menRelSer.setEnabled(false);

        jMenuItem4.setText("Serviços");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menRelSer.add(jMenuItem4);

        Menu.add(menRelSer);

        menAjuSob.setText("Ajuda");

        jMenuItem5.setText("Sobre");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        menAjuSob.add(jMenuItem5);

        Menu.add(menAjuSob);

        MenOpc.setText("opções");
        MenOpc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenOpcActionPerformed(evt);
            }
        });

        jMenuItem6.setText("Sair");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        MenOpc.add(jMenuItem6);

        Menu.add(MenOpc);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario)
                    .addComponent(lblData))
                .addGap(0, 233, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktop)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblData)
                .addContainerGap(373, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
            // as linhas abaixo  substitui a label data lblData pela data atual 
     
        Date data = new Date();
        DateFormat formatador=DateFormat.getDateInstance(DateFormat.SHORT);
        lblData.setText(formatador.format(data));

 

    
        
        
    }//GEN-LAST:event_formWindowActivated

    private void MenOpcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenOpcActionPerformed

    }//GEN-LAST:event_MenOpcActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
    int sair = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Atenção", JOptionPane.YES_NO_OPTION);
    
    // Se o usuário clicar em "Sim" (YES), o programa fecha
    if (sair == JOptionPane.YES_OPTION) {
        System.exit(0);
    }

    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
      TelaSobre sobre= new  TelaSobre();
      sobre.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
      telaUsuario usuario = new telaUsuario();
      usuario.setVisible(true);
      desktop.add(usuario);
           
                  
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
     TelaCliente cliente = new TelaCliente();
     cliente.setVisible(true);
      desktop.add(cliente);
    
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menCadUsuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menCadUsuActionPerformed
        TelaOS os = new TelaOS();
        os.setVisible(true);
        desktop.add(os);
    }//GEN-LAST:event_menCadUsuActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed
public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new TelaPrincipal().setVisible(true);
        });
    }
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu MenOpc;
    private javax.swing.JMenuBar Menu;
    public javax.swing.JDesktopPane desktop;
    private javax.swing.JMenuItem jMenuItem1;
    public static javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JLabel lblData;
    public static javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu menAjuSob;
    private javax.swing.JMenu menCadCli;
    private javax.swing.JMenuItem menCadUsu;
    public static javax.swing.JMenu menRelSer;
    // End of variables declaration//GEN-END:variables
}

