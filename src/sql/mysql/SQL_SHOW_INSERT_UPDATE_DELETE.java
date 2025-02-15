/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;

import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author jagan kishor
 */
public class SQL_SHOW_INSERT_UPDATE_DELETE extends javax.swing.JFrame {

    /**
     * Creates new form SQL_SHOW_INSERT_UPDATE_DELETE
     */
    
    TableModel tm;
    Vector data;
    
    public SQL_SHOW_INSERT_UPDATE_DELETE() {
        initComponents();
        table_update();
        
        DefaultTableModel tm = (DefaultTableModel)formtable.getModel();
        data = tm.getDataVector();
        
    }

    private void table_update()
        {
            try {
                
            // Establishing the connection   not registers already done
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "");

             // Create a Statement object
            Statement st = con.createStatement();

            // SQL SELECT query
            ResultSet rs = st.executeQuery("SELECT * FROM student_table");

            // Get the metadata
            ResultSetMetaData RSMD = rs.getMetaData();

            // Get column count
            int CC = RSMD.getColumnCount();

            // Get the table model from your form table
            DefaultTableModel DFT = (DefaultTableModel) formtable.getModel();

            // Clear existing columns and data
            DFT.setRowCount(0);
            DFT.setColumnCount(0);

            // Add column names to the table model
            for (int i = 1; i <= CC; i++) {
                DFT.addColumn(RSMD.getColumnName(i));
            }

            // Process the result set and add rows to the table model
            while (rs.next()) 
            {
                Vector v2 = new Vector();
                for (int i = 1; i <= CC; i++) 
                {
                    v2.add(rs.getString(i));
                }
                DFT.addRow(v2);
            }
        } 
            catch (Exception e) 
            {
                System.out.println("Exception: " + e);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        select = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        rollno = new javax.swing.JTextField();
        city = new javax.swing.JTextField();
        insert = new javax.swing.JButton();
        update = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        result = new javax.swing.JLabel();
        nrb = new javax.swing.JRadioButton();
        rrb = new javax.swing.JRadioButton();
        crb = new javax.swing.JRadioButton();
        clear = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        whererollno = new javax.swing.JTextField();
        addtoJtable = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        formtable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("NAME");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ROLL NO");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("CITY");

        select.setBackground(new java.awt.Color(51, 102, 255));
        select.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        select.setText("SELECT * FROM");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });

        name.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        rollno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rollno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollnoActionPerformed(evt);
            }
        });

        city.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        insert.setBackground(new java.awt.Color(255, 51, 255));
        insert.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        insert.setText("INSERT INTO");
        insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertActionPerformed(evt);
            }
        });

        update.setBackground(new java.awt.Color(102, 255, 51));
        update.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        update.setText("UPDATE");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        delete.setBackground(new java.awt.Color(255, 0, 0));
        delete.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });

        result.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        result.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        result.setText("RESULT");
        result.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        nrb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        nrb.setText("N");

        rrb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        rrb.setText("R");

        crb.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        crb.setText("C");

        clear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("WHERE ROLL NO");

        whererollno.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        addtoJtable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        addtoJtable.setText("ADD TO J TABLE");
        addtoJtable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addtoJtableActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("SQL QUERY");

        formtable.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        formtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAMES", "ROLL NO", "CITY"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        formtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formtableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(formtable);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setText("REFRESH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(33, 33, 33)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(rollno)))
                            .addComponent(clear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addtoJtable, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(select, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(nrb)
                                                .addGap(33, 33, 33)
                                                .addComponent(rrb))
                                            .addComponent(jLabel5))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(whererollno, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(crb))))
                                    .addComponent(result, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addGap(29, 29, 29))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(select)
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(insert)
                            .addComponent(jLabel2)
                            .addComponent(rollno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(update)
                            .addComponent(nrb)
                            .addComponent(rrb)
                            .addComponent(crb)
                            .addComponent(jLabel3)
                            .addComponent(city, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(delete)
                    .addComponent(clear)
                    .addComponent(jLabel5)
                    .addComponent(whererollno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(result)
                    .addComponent(addtoJtable)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rollnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rollnoActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        // TODO add your handling code here:
        
        name.setText("");
        rollno.setText("");
        city.setText("");
        
    }//GEN-LAST:event_clearActionPerformed

    private void addtoJtableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addtoJtableActionPerformed
        // TODO add your handling code here:
        
        Vector row = new Vector();
       
        row.add(name.getText());
        row.add(rollno.getText());
        row.add(city.getText());
        
        data.add(row);
        
        formtable.updateUI();
        
        name.setText("");
        rollno.setText("");
        city.setText("");
        
    }//GEN-LAST:event_addtoJtableActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
        // TODO add your handling code here:
        
        try 
        {
            // Register MySQL JDBC driver
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

            // EstablishQA the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "");

            // Create a Statement object
            Statement st = con.createStatement();
            
            // SQL SELECT query
            ResultSet rs = st.executeQuery("SELECT * FROM student_table");
           
            // Process the result set and populate the table
            while (rs.next()) 
            {
                
                Vector row = new Vector();
                
                row.add(rs.getString("SNAME"));
                row.add(rs.getInt("ROLLNO"));
                row.add(rs.getString("CITY"));
                
                data.add(row);
                
                // Update the table UI
                formtable.updateUI();
            }
            result.setText("A SQL Select Query Execute successfully!");
            System.out.println("A SQL Select Query Execute successfully!");

        } 
        
        catch (Exception e) 
            {
                System.out.println("Exception: " + e);
            }
        
     
    }//GEN-LAST:event_selectActionPerformed

    private void insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertActionPerformed
        // TODO add your handling code here:
        
        try 
            {
                // Register MySQL JDBC driver
                DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

                // EstablishQA the connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "");

                // Create a Statement object
                Statement st = con.createStatement();

                // SQL INSERT query
                String insertSql = "INSERT INTO student_table (SNAME, ROLLNO, CITY) VALUES ('"+name.getText()+"',"+rollno.getText()+",'"+city.getText()+"') ";
                                                                                            //('name',rollno,'city');
                int rowsAffected = st.executeUpdate(insertSql);
                
                table_update(); //metadata
                
                result.setText("A new row was inserted successfully!");
                System.out.println("A new row was inserted successfully!");

                name.setText("");
                rollno.setText("");
                city.setText("");

            } 

        catch (Exception e) 
            {
                System.out.println("Exception: " + e);
            }
        
    }//GEN-LAST:event_insertActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
       
        
        if(nrb.isSelected())
        {
            try 
                {
                    // Register MySQL JDBC driver
                    DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

                    // EstablishQA the connection
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "");

                    // Create a Statement object
                    Statement st = con.createStatement();

                    // SQL UPDATE query
                    String updateSql = " UPDATE student_table SET SNAME = '"+name.getText()+"' WHERE ROLLNO = "+whererollno.getText()+" ";

                    int rowsAffected = st.executeUpdate(updateSql);

                    result.setText("A Name was updated successfully!");
                    System.out.println("A Name was updated successfully!");

                    name.setText("");
                    rollno.setText("");
                    city.setText("");

                } 
        
            catch (Exception e) 
                {
                    System.out.println("Exception: " + e);
                }
            
        }
        
        else if (rrb.isSelected())
        {
            
            try 
            {
                // Register MySQL JDBC driver
                DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

                // EstablishQA the connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "");

                // Create a Statement object
                Statement st = con.createStatement();

                // SQL UPDATE query
                String updateSql = "UPDATE student_table SET ROLLNO = '"+rollno.getText()+"' WHERE ROLLNO = "+whererollno.getText()+";";

                int rowsAffected = st.executeUpdate(updateSql);

                result.setText("A Roll No was updated successfully!");
                System.out.println("A Roll No was updated successfully!");

                name.setText("");
                rollno.setText("");
                city.setText("");

            } 
        catch (Exception e) 
            {
                System.out.println("Exception: " + e);
            }
        }
        
        else if(crb.isSelected())
        {
            try 
            {
                // Register MySQL JDBC driver
                DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

                // EstablishQA the connection
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "");

                // Create a Statement object
                Statement st = con.createStatement();

                // SQL UPDATE query
                String updateSql = "UPDATE student_table SET CITY = '"+city.getText()+"' WHERE ROLLNO = "+whererollno.getText()+";";

                int rowsAffected = st.executeUpdate(updateSql);

                result.setText("A City was updated successfully!");
                System.out.println("A City was updated successfully!");

                name.setText("");
                rollno.setText("");
                city.setText("");
            } 
        
            catch (Exception e) 
                {
                    System.out.println("Exception: " + e);
                }
            
        }
       
        else
        {
            
        }
        
    }//GEN-LAST:event_updateActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
        
        try {
            // Register MySQL JDBC driver
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance());

            // EstablishQA the connection
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydata", "root", "");

            // Create a Statement object
            Statement st = con.createStatement();
            
            // SQL UPDATE query
            String updateSql = "DELETE FROM student_table WHERE ROLLNO = "+whererollno.getText()+";";
                                                                                        
            int rowsAffected = st.executeUpdate(updateSql);

            result.setText("A Row was Deleted successfully!");
            System.out.println("A Row was Deleted successfully!");

        } 
        
        catch (Exception e) 
            {
                System.out.println("Exception: " + e);
            }
        
    }//GEN-LAST:event_deleteActionPerformed

    private void formtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formtableMouseClicked
        // TODO add your handling code here:
        
        // Get the table model from your form table
        DefaultTableModel model = (DefaultTableModel) formtable.getModel();
        int selectedIndex = formtable.getSelectedRow();
        
        name.setText(model.getValueAt(selectedIndex, 0).toString());
        rollno.setText(model.getValueAt(selectedIndex, 1).toString());
        whererollno.setText(model.getValueAt(selectedIndex, 1).toString());
        city.setText(model.getValueAt(selectedIndex, 2).toString());
        
    }//GEN-LAST:event_formtableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        dispose();
        
        SQL_SHOW_INSERT_UPDATE_DELETE obj = new SQL_SHOW_INSERT_UPDATE_DELETE();
        obj.show();
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SQL_SHOW_INSERT_UPDATE_DELETE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SQL_SHOW_INSERT_UPDATE_DELETE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SQL_SHOW_INSERT_UPDATE_DELETE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SQL_SHOW_INSERT_UPDATE_DELETE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SQL_SHOW_INSERT_UPDATE_DELETE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addtoJtable;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField city;
    private javax.swing.JButton clear;
    private javax.swing.JRadioButton crb;
    private javax.swing.JButton delete;
    private javax.swing.JTable formtable;
    private javax.swing.JButton insert;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField name;
    private javax.swing.JRadioButton nrb;
    private javax.swing.JLabel result;
    private javax.swing.JTextField rollno;
    private javax.swing.JRadioButton rrb;
    private javax.swing.JButton select;
    private javax.swing.JButton update;
    private javax.swing.JTextField whererollno;
    // End of variables declaration//GEN-END:variables
}
