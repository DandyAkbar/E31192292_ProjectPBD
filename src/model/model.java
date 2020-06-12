/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ASUS TUF
 */
public class model {
     public DefaultTableModel transaksi(){
    Object[] kolom = {"Kode Barang", "Nama Barang", "Harga", "Jumlah","Sub Total"};
        DefaultTableModel sampel = new DefaultTableModel(null, kolom);
        try {
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/fckharisma" ,"root" ,"");
            ResultSet rs = cn.createStatement().executeQuery("SELECT * FROM tb_transaksi");
          
            while (rs.next()) {
                String kode = rs.getString("Kode");
                String nama = rs.getString("Nama");
                String harga = rs.getString("Harga");
                String jumlah = rs.getString("Jumlah");
                
                String sub = rs.getString("SubTotal");
                
                Object row[] = {kode, nama, harga, jumlah, sub};
                sampel.addRow(row);
            }
        } catch (SQLException E) {
            System.out.println("gagal dicetak karena :" + E);
        }
        return sampel;
    }
}
