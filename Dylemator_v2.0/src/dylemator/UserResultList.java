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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author nanker
 */
public final class UserResultList extends javax.swing.JDialog {

    
    /**
     * Creates new form UserList
     */
    List<String[]> exportData;
    private String selectedFilename;
    
    public UserResultList(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        codeTable.removeAll();
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

        codePane = new javax.swing.JScrollPane();
        codeTable = new javax.swing.JTable();
        bottomPanel = new javax.swing.JPanel();
        filenameCombo = new javax.swing.JComboBox();
        exportButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        detailsPane = new javax.swing.JTabbedPane();
        infoPane = new javax.swing.JScrollPane();
        infoTable = new javax.swing.JTable();
        resultsPane = new javax.swing.JScrollPane();
        resultsTable = new javax.swing.JTable();
        codeLabel = new javax.swing.JLabel();
        removeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);

        codeTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        codeTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        codeTable.setAutoscrolls(false);
        codeTable.setFocusable(false);
        codeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                codeTableMouseClicked(evt);
            }
        });
        codeTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                codeTableKeyPressed(evt);
            }
        });
        codePane.setViewportView(codeTable);

        bottomPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        filenameCombo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        filenameCombo.setToolTipText("");
        filenameCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filenameComboActionPerformed(evt);
            }
        });

        exportButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        exportButton.setText("Eksportuj");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Plik z wynikami");

        javax.swing.GroupLayout bottomPanelLayout = new javax.swing.GroupLayout(bottomPanel);
        bottomPanel.setLayout(bottomPanelLayout);
        bottomPanelLayout.setHorizontalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filenameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(exportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bottomPanelLayout.setVerticalGroup(
            bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bottomPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filenameCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(exportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        infoTable.setFocusable(false);
        infoPane.setViewportView(infoTable);

        detailsPane.addTab("Informacje", infoPane);

        resultsTable.setFocusable(false);
        resultsPane.setViewportView(resultsTable);

        detailsPane.addTab("Wyniki", resultsPane);

        codeLabel.setText("Badane osoby");

        removeButton.setText("Usuń z listy");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(codePane, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(codeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(detailsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(removeButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(codeLabel)
                        .addGap(10, 10, 10)
                        .addComponent(codePane, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(detailsPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removeButton)
                .addGap(15, 15, 15)
                .addComponent(bottomPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filenameComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filenameComboActionPerformed
        Object item = this.filenameCombo.getSelectedItem();
        exportData = new ArrayList<String[]>();
        File file = new File(item.toString());
        if(file.exists()){
            this.selectedFilename = item.toString();
            String datePattern = "(\\d+-\\d+-\\d+)";
            Pattern r = Pattern.compile(datePattern);
            Matcher m = r.matcher(file.getName());
            String fileDate;
            if(m.find()){
                fileDate = m.group(0);
            }
            else
                fileDate = new Date(file.lastModified()).toString();
          
           DefaultTableModel codeModel = (DefaultTableModel) this.codeTable.getModel();
           DefaultTableModel infoModel = (DefaultTableModel) this.infoTable.getModel();
           DefaultTableModel resultsModel = (DefaultTableModel) this.resultsTable.getModel();
           codeModel.setRowCount(0);
           codeModel.setColumnCount(0);
           infoModel.setRowCount(0);
           infoModel.setColumnCount(2);
           resultsModel.setRowCount(0);
           resultsModel.setColumnCount(2);
           
            try {
                    InputStreamReader input = new FileReader(file);
                    BufferedReader bufferReader;
                    bufferReader = new BufferedReader(input);
                    // headers
                    String headerLine = bufferReader.readLine();
                    String[] headers = headerLine.split(";",-1);
                    
                    codeModel.addColumn(headers[0]);                       
                    exportData.add((String[]) headers);
                    
                    String line;                    
                    while((line = bufferReader.readLine()) != null){
                       String[] fields = line.split(";",-1);
                       exportData.add((String[]) fields);
                       codeModel.addRow(new String[]{fields[0]});
                    }
                    
                    bufferReader.close();
            }   
            catch (FileNotFoundException ex) {
                        Logger.getLogger(FindDialog.class.getName()).log(Level.SEVERE, null, ex);
            } 
            catch (IOException ex) {
                        Logger.getLogger(FindDialog.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_filenameComboActionPerformed

    private void codeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_codeTableMouseClicked
        int row = this.codeTable.getSelectedRow();
        DefaultTableModel infoModel = (DefaultTableModel) this.infoTable.getModel();
        DefaultTableModel resultsModel = (DefaultTableModel) this.resultsTable.getModel();
        String[] headers = exportData.get(0);
        String[] values = exportData.get(row + 1);
        infoModel.setRowCount(0);
        resultsModel.setRowCount(0);
        
        for (int i = 0; i < 15; i++) {
            infoModel.addRow(new String[]{headers[i],values[i]});
          }
       for (int i = 15; i < headers.length; i++) {
             resultsModel.addRow(new String[]{headers[i],values[i]});
          }
        
    }//GEN-LAST:event_codeTableMouseClicked

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        if(this.filenameCombo.getSelectedIndex() == 0)
                return;
            String sheetName = (String) this.filenameCombo.getSelectedItem();
            Workbook wb = new XSSFWorkbook();
            Sheet sheet = wb.createSheet(sheetName);
            Row headerRow = sheet.createRow(0);
            String[] headers = exportData.get(0);
            int numOfColumns = headers.length;
            for (int i = 0,j = 0; i < numOfColumns; i++){
                if(i == 1 || i == 2 || i == 3)  // opuszcz. date, imie, nazwisko
                    continue;
                Cell cell = headerRow.createCell(j++);
                cell.setCellValue(headers[i]);
            }   
            
            int rowCount = exportData.size();
            for (int rownum = 1; rownum < rowCount; rownum++){
                Row row = sheet.createRow(rownum);
                String[] values = exportData.get(rownum);
                for (int i = 0,j = 0; i < numOfColumns; i++){
                    if(i == 1 || i == 2 || i == 3)  // opuszcz. date, imie, nazwisko
                        continue;
                    Cell cell = row.createCell(j++);
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
            Logger.getLogger(UserResultList.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(UserResultList.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_exportButtonActionPerformed

    private void codeTableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_codeTableKeyPressed
        
    }//GEN-LAST:event_codeTableKeyPressed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        int row = this.codeTable.getSelectedRow();
        if(row == -1)
            return;
        String[] values = exportData.get(row + 1);
        int dialogResult = JOptionPane.showConfirmDialog (null, "Usunąć wyniki użytkownika " + values[0] + "?","Warning",JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            exportData.remove(row + 1);
            DefaultTableModel m = (DefaultTableModel) codeTable.getModel();
            m.setRowCount(0);
            for(int i = 1; i < exportData.size(); i++){
                m.addRow(new String[]{exportData.get(i)[0]});
            }
            DefaultTableModel n = (DefaultTableModel) infoTable.getModel();
            DefaultTableModel o = (DefaultTableModel) resultsTable.getModel();
            n.setRowCount(0);
            o.setRowCount(0);
            try {
                OutputStreamWriter output = new FileWriter(this.selectedFilename);
                BufferedWriter bufferWriter = new BufferedWriter(output);
                for(String[] v:exportData){
                    String s = StringUtils.join(v, ";");
                    bufferWriter.write(s + "\n");
                }
                bufferWriter.flush();
                bufferWriter.close();
            } catch (IOException ex) {
                Logger.getLogger(UserResultList.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            
        }

    }//GEN-LAST:event_removeButtonActionPerformed

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
            java.util.logging.Logger.getLogger(UserResultList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserResultList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserResultList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserResultList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                UserResultList dialog = new UserResultList(new javax.swing.JFrame(), true);
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
    private javax.swing.JLabel codeLabel;
    private javax.swing.JScrollPane codePane;
    private javax.swing.JTable codeTable;
    private javax.swing.JTabbedPane detailsPane;
    private javax.swing.JButton exportButton;
    private javax.swing.JComboBox filenameCombo;
    private javax.swing.JScrollPane infoPane;
    private javax.swing.JTable infoTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton removeButton;
    private javax.swing.JScrollPane resultsPane;
    private javax.swing.JTable resultsTable;
    // End of variables declaration//GEN-END:variables
}