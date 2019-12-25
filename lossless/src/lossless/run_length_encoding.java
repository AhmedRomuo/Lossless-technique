/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lossless;

import javax.swing.JOptionPane;

/**
 *
 * @author ahmed
 */
public class run_length_encoding extends javax.swing.JFrame {

    /**
     * Creates new form run_length_encoding
     */
    public run_length_encoding() {
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

        btn_group = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txt_message = new javax.swing.JTextField();
        rbtn_string = new javax.swing.JRadioButton();
        rbtn_binary = new javax.swing.JRadioButton();
        lbl_result = new javax.swing.JLabel();
        btn_decompression = new javax.swing.JButton();
        btn_compression1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Text : ");

        txt_message.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_group.add(rbtn_string);
        rbtn_string.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbtn_string.setText("String");

        btn_group.add(rbtn_binary);
        rbtn_binary.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbtn_binary.setText("Binary");

        btn_decompression.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_decompression.setText("DEComperssion");
        btn_decompression.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_decompressionActionPerformed(evt);
            }
        });

        btn_compression1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_compression1.setText("Comperssion");
        btn_compression1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_compression1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_result)
                    .addComponent(txt_message, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtn_binary)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_decompression)
                            .addComponent(rbtn_string))))
                .addContainerGap(61, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(btn_compression1)
                    .addContainerGap(227, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_message, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtn_binary)
                    .addComponent(rbtn_string))
                .addGap(29, 29, 29)
                .addComponent(btn_decompression)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(lbl_result)
                .addGap(71, 71, 71))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(157, Short.MAX_VALUE)
                    .addComponent(btn_compression1)
                    .addGap(118, 118, 118)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_compression1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_compression1ActionPerformed
        String msg = txt_message.getText().toString();
        if (msg.length() <= 0) {
            JOptionPane.showMessageDialog(null, "put a message", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } else {
            if (rbtn_binary.isSelected() && (msg.contains("0") || msg.contains("1"))) {
                lbl_result.setText("Result : " + binaryCompression(msg));
            } else if (rbtn_string.isSelected()) {
                lbl_result.setText("Result : " + textCompression(msg));
            } else {
                JOptionPane.showMessageDialog(null, "Check binary or string", "Alert", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_compression1ActionPerformed

    private void btn_decompressionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_decompressionActionPerformed
        String msg = txt_message.getText().toString();
        if (msg.length() <= 0) {
            JOptionPane.showMessageDialog(null, "put a message", "Alert", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                if (rbtn_binary.isSelected()) {
                    lbl_result.setText("Result : " + binaryDeCompression(msg));
                } else if (rbtn_string.isSelected()) {
                    lbl_result.setText("Result : " + textDeCompression(msg));
                } else {
                    JOptionPane.showMessageDialog(null, "Check binary or string", "Alert", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Wrong input", "Alert", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_btn_decompressionActionPerformed

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
            java.util.logging.Logger.getLogger(run_length_encoding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(run_length_encoding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(run_length_encoding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(run_length_encoding.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new run_length_encoding().setVisible(true);
            }
        });
    }

    //to compression the string message
    public String textCompression(String msg) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            int len = 1;
            while (i + 1 < msg.length() && msg.charAt(i) == msg.charAt(i + 1)) {
                len++;
                i++;
            }
            stringBuilder.append(msg.charAt(i)).append(",").append(len).append(" ");
        }

        return stringBuilder.toString();
    }

    //to decompression the string message
    public String textDeCompression(String msg) {
        String[] data = msg.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (String temp : data) {
            String[] ch = temp.split(",");
            for (int i = 0; i < Integer.parseInt(ch[1]); i++) {
                stringBuilder.append(ch[0]);
            }
        }

        return stringBuilder.toString();
    }

    //to compression the binary message 
    public String binaryCompression(String msg) {
        StringBuilder stringBuilder = new StringBuilder();

        if (msg.charAt(0) != '0') {
            stringBuilder.append("0 ");
        }

        for (int i = 0; i < msg.length(); i++) {
            int len = 1;
            while (i + 1 < msg.length() && msg.charAt(i) == msg.charAt(i + 1)) {
                len++;
                i++;
            }
            stringBuilder.append(len).append(" ");
        }

        return stringBuilder.toString();
    }

    // to decompression the binart message
    public String binaryDeCompression(String msg) {
        String[] data = msg.split(" ");
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            int x = Integer.parseInt(data[i]);
            for (int j = 0; j < x; j++) {
                if (i % 2 == 0) {
                    stringBuilder.append("0");
                } else {
                    stringBuilder.append("1");
                }
            }
        }
        return stringBuilder.toString();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_compression1;
    private javax.swing.JButton btn_decompression;
    private javax.swing.ButtonGroup btn_group;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbl_result;
    private javax.swing.JRadioButton rbtn_binary;
    private javax.swing.JRadioButton rbtn_string;
    private javax.swing.JTextField txt_message;
    // End of variables declaration//GEN-END:variables
}
