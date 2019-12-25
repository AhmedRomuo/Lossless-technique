/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lossless;


import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ahmed
 */
public class Shannon_fano extends javax.swing.JFrame {

    /**
     * Creates new form Shannon_fano
     */
    public Shannon_fano() {
        initComponents();
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
        txt_num_sampols = new javax.swing.JTextField();
        btn_insert_prop_sampols = new javax.swing.JButton();
        btn_solve = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabl_data = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Enter num of sampols : ");

        btn_insert_prop_sampols.setText("Insert prop");
        btn_insert_prop_sampols.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insert_prop_sampolsActionPerformed(evt);
            }
        });

        btn_solve.setText("Solve");
        btn_solve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_solveActionPerformed(evt);
            }
        });

        tabl_data.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chars", "Prob", "Code"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabl_data);
        if (tabl_data.getColumnModel().getColumnCount() > 0) {
            tabl_data.getColumnModel().getColumn(0).setResizable(false);
            tabl_data.getColumnModel().getColumn(1).setResizable(false);
            tabl_data.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_solve)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_num_sampols, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(btn_insert_prop_sampols))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_num_sampols, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_insert_prop_sampols))
                .addGap(18, 18, 18)
                .addComponent(btn_solve)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_insert_prop_sampolsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insert_prop_sampolsActionPerformed
        
        
        this.ch = new String[Integer.parseInt(this.txt_num_sampols.getText())];
        this.prob = new float[Integer.parseInt(this.txt_num_sampols.getText())];
        for (int i = 0; i < Integer.parseInt(this.txt_num_sampols.getText()); i++) {
            this.ch[i] = JOptionPane.showInputDialog(null, "Enter sampole(" + (i+1) + ")", "input", JOptionPane.INFORMATION_MESSAGE);
            this.prob[i] = Float.parseFloat(JOptionPane.showInputDialog(null, "Enter prob sample(" + ch[i] + ")", "input", JOptionPane.INFORMATION_MESSAGE));
        }
        
        int n = this.prob.length; 
        for (int i = 0; i < n-1; i++) 
            for (int j = 0; j < n-i-1; j++) 
                if (this.prob[j] < this.prob[j+1]) 
                { 
                    // swap arr[j+1] and arr[i] 
                    float temp = this.prob[j]; 
                    this.prob[j] = this.prob[j+1]; 
                    this.prob[j+1] = temp; 
                    
                    // swap the chars
                    String s = this.ch[j];
                    this.ch[j] = this.ch[j+1];
                    this.ch[j+1] = s;
                }
//        System.out.println(this.prob[0]);
//        System.out.println(this.prob[1]);
//        System.out.println(this.prob[2]);
//        System.out.println(this.ch[0]);
//        System.out.println(this.ch[1]);
//        System.out.println(this.ch[2]);

        
    }//GEN-LAST:event_btn_insert_prop_sampolsActionPerformed

    private void btn_solveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_solveActionPerformed
        this.map = new HashMap();
        for (int i = 0; i < this.prob.length; i++) 
            this.map.put(this.ch[i].charAt(0), this.prob[i]);
        Shannon sh = new Shannon();
        HashMap m = new HashMap();
        m = sh.compress(this.map);
        DefaultTableModel model = (DefaultTableModel) this.tabl_data.getModel();
        for (int i = 0; i < this.ch.length; i++) {
            model.addRow(new Object[]{ch[i], prob[i], m.get(ch[i].charAt(0))});
        }
        
    }//GEN-LAST:event_btn_solveActionPerformed
    
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Shannon_fano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Shannon_fano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Shannon_fano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Shannon_fano.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Shannon_fano().setVisible(true);
            }
        });
    }
    
    public String ch[];
    public float[] prob;
    HashMap<Character, Float> map; 
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_insert_prop_sampols;
    private javax.swing.JButton btn_solve;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabl_data;
    private javax.swing.JTextField txt_num_sampols;
    // End of variables declaration//GEN-END:variables
}
