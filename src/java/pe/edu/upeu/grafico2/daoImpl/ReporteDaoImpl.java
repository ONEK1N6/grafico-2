/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.grafico2.daoImpl;

import java.util.List;
import pe.edu.upeu.grafico2.dao.ReportesDao;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.upeu.grafico2.config.Conexion;

/**
 *
 * @author KING SERPA
 */
public class ReporteDaoImpl implements ReportesDao {
    private PreparedStatement ps;
private ResultSet rs;
private Connection cx= null;
    @Override
    public List<String> getCategoria() {
        String SQL  = "select c.nombre as categoria, p.cantidad as cantidad, p.idproducto from producto as p " +
                      "inner join categoria as c on p.idcategoria=c.idcategoria " +
                      "group by c.nombre, p.idproducto ";
        List<String> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                lista.add(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }

    @Override
    public List<Integer> getCantidadCategoria() {
        String SQL  = "select c.nombre as categoria, p.cantidad as cantidad, p.idproducto from producto as p " +
                      "inner join categoria as c on p.idcategoria=c.idcategoria " +
                      "group by c.nombre, p.idproducto;";
        List<Integer> lista = new ArrayList<>();
        try {
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                lista.add(rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
}
