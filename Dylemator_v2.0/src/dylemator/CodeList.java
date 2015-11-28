/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dylemator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nanker
 */
public class CodeList extends javax.swing.JDialog {

    ArrayList<String> codes;
    /**
     * Creates new form CodeList
     * @param parent
     * @param modal
     */
    public CodeList(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        this.codes = new ArrayList<String>();
        initComponents();
        loadUserCodes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        removeCodeButton = new javax.swing.JButton();
        codeScrollPane = new javax.swing.JScrollPane();
        codeTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        removeCodeButton.setText("Usuń kod");
        removeCodeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeCodeButtonActionPerformed(evt);
            }
        });

        codeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kod osoby"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        codeTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codeTableKeyPressed(evt);
            }
        });
        codeScrollPane.setViewportView(codeTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(codeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(removeCodeButton)
                .addContainerGap(68, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(codeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeCodeButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void codeTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeTableKeyPressed
        
    }//GEN-LAST:event_codeTableKeyPressed

    private void removeCodeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeCodeButtonActionPerformed
        int row = codeTable.getSelectedRow();
        if(row == -1)
            return;
        codes.remove(row);
        OutputStreamWriter output;
        try {
            output = new FileWriter("Kody_osob.txt");
            BufferedWriter bufferWriter;
            bufferWriter = new BufferedWriter(output);
            for(String code:codes){
                bufferWriter.write(code + '\n');
            }
            bufferWriter.flush();
            bufferWriter.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FindDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FindDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.loadUserCodes();
        
    }//GEN-LAST:event_removeCodeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(CodeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CodeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CodeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CodeList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CodeList dialog = new CodeList(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane codeScrollPane;
    private javax.swing.JTable codeTable;
    private javax.swing.JButton removeCodeButton;
    // End of variables declaration//GEN-END:variables

    private void loadUserCodes() {
        File codeFile = new File("Kody_osob.txt");
        DefaultTableModel m = (DefaultTableModel) this.codeTable.getModel();
        m.setRowCount(0);
        codes.clear();
//        m.setColumnCount(1);
//        m.addColumn("Kod osoby");
        if(codeFile.exists() == false){
            try {
                codeFile.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(FindDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        InputStreamReader input;
        try {
            input = new FileReader(codeFile);
            BufferedReader bufferReader;
            bufferReader = new BufferedReader(input);
            String line;
            while((line = bufferReader.readLine()) != null){
                m.addRow(new String[]{line});
                codes.add(line);
            }
            bufferReader.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FindDialog.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FindDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
