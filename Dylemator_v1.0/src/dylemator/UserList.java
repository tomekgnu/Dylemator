/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dylemator;
// POI

import java.io.FileOutputStream;

//
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang.ArrayUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author nanker
 */
public final class UserList extends javax.swing.JDialog {

    /**
     * Creates new form UserList
     */
    List<String[]> exportData;
    
    public UserList(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        personsTable.removeAll();
        filenameCombo.addItem("Wybierz z listy");
        filenameCombo.setSelectedIndex(0);
        updateFileList();
        
    }
    
    void updateFileList(){
        File dir = new File(".");
        File[] files = dir.listFiles();
        for(File f:files){
            if(f.isDirectory())
                continue;
            String filename = f.getName();
            if(filename.startsWith("Odpowiedzi_")){
               filenameCombo.addItem(filename);
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
        java.awt.GridBagConstraints gridBagConstraints;

        tablePane = new javax.swing.JScrollPane();
        personsTable = new javax.swing.JTable();
        bottomPanel = new javax.swing.JPanel();
        exportButton = new javax.swing.JButton();
        fileLabel = new javax.swing.JLabel();
        filenameCombo = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        personsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        personsTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        personsTable.setFocusable(false);
        tablePane.setViewportView(personsTable);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 488;
        gridBagConstraints.ipady = 120;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 0, 12);
        getContentPane().add(tablePane, gridBagConstraints);

        bottomPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        exportButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        exportButton.setText("Eksportuj");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        fileLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        fileLabel.setText("Plik z wynikami");

        filenameCombo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        filenameCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filenameComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(exportButton)
                .addGap(18, 18, 18)
                .addComponent(filenameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fileLabel)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(exportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filenameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fileLabel))
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 12, 12);
        getContentPane().add(bottomPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filenameComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filenameComboActionPerformed
        Object item = this.filenameCombo.getSelectedItem();
        exportData = new ArrayList<String[]>();
        File file = new File(item.toString());
        if(file.exists()){
            String datePattern = "(\\d+-\\d+-\\d+)";
            Pattern r = Pattern.compile(datePattern);
            Matcher m = r.matcher(file.getName());
            String fileDate;
            if(m.find()){
                fileDate = m.group(0);
            }
            else
                fileDate = new Date(file.lastModified()).toString();
          
           DefaultTableModel model = (DefaultTableModel) this.personsTable.getModel();
           model.setRowCount(0);
           model.setColumnCount(0);
            try {
                    InputStreamReader input = new FileReader(file);
                    BufferedReader bufferReader;
                    bufferReader = new BufferedReader(input);
                    // headers
                    String headerLine = bufferReader.readLine();
                    String[] headers = headerLine.split(";");
                    // kod osoby i data badania
                    String[] userHeaders = new String[]{headers[0],headers[1]};
                    String[] valueHeaders = Arrays.copyOfRange(headers, 4, headers.length);
                    Object[] allHeaders = ArrayUtils.addAll(userHeaders,valueHeaders);
                    
                    for(int header = 0;header < allHeaders.length;header++){
                        model.addColumn(allHeaders[header]);
                        
                    }
                    exportData.add((String[]) allHeaders);
                    
                    String line;                    
                    while((line = bufferReader.readLine()) != null){
                       String[] fields = line.split(";");
                       String[] userFields = new String[]{fields[0],fileDate};
                       String[] valueFields = Arrays.copyOfRange(fields, 4, fields.length);
                       Object[] allValues = ArrayUtils.addAll(userFields,valueFields);
                       model.addRow(allValues);
                       exportData.add((String[]) allValues);
                    }
            }   
            catch (FileNotFoundException ex) {
                        Logger.getLogger(FindDialog.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (IOException ex) {
                        Logger.getLogger(FindDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_filenameComboActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
            if(this.filenameCombo.getSelectedIndex() == 0)
                return;
            String sheetName = (String) this.filenameCombo.getSelectedItem();
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet(sheetName);
            Row headerRow = sheet.createRow(0);
            String[] headers = exportData.get(0);
            int numOfColumns = headers.length;
            for (int i = 0; i < numOfColumns; i++){
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);
            }   
            
            int rowCount = exportData.size();
            for (int rownum = 1; rownum < rowCount; rownum++){
                Row row = sheet.createRow(rownum);
                String[] values = exportData.get(rownum);
                for (int i = 0; i < numOfColumns; i++){
                    Cell cell = row.createCell(i);
                    cell.setCellValue(values[i]);
                } 
            }
        
       String defaultFilename = "Export.xlsx";
       JFileChooser f = new JFileChooser(System.getProperty("user.dir"));
       f.setSelectedFile(new File(defaultFilename));
       f.setDialogTitle("Wybierz nazwę dla pliku eksportu");
       f.setFileSelectionMode(JFileChooser.FILES_ONLY);
       FileFilter ff = new FileFilter() {
            @Override
            public boolean accept(File file) {
                if(file.getName().endsWith(".xlsx"))
                    return true;
                return false;
            }

            @Override
            public String getDescription() {
                return "";
            }
        };
       f.setFileFilter(ff);
       
       
       File file = null;
       int save = f.showSaveDialog(this);
       if (save == JFileChooser.APPROVE_OPTION)
           file = f.getSelectedFile();
       else 
           return;
       
        FileOutputStream out;
        try {
            out = new FileOutputStream(file);
            wb.write(out);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UserList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserList.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }//GEN-LAST:event_exportButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserList dialog = new UserList(new javax.swing.JFrame(), true);
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
    private javax.swing.JPanel bottomPanel;
    private javax.swing.JButton exportButton;
    private javax.swing.JLabel fileLabel;
    private javax.swing.JComboBox filenameCombo;
    private javax.swing.JTable personsTable;
    private javax.swing.JScrollPane tablePane;
    // End of variables declaration//GEN-END:variables
}
