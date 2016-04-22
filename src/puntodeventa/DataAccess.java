package puntodeventa;

import java.math.BigDecimal;
import java.sql.*;

public class DataAccess {
    
    private Connection con = null;
    
    public  Connection conexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/SalesPoint","root","1549498");
            
        }catch(ClassNotFoundException | SQLException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("Conexion exitosa!");
        return con;
    }
    
    public void saveProduct(Double cost, String name, int units, String code){
        try{
            con = conexion();
            CallableStatement cmd = con.prepareCall("{CALL sp_saveProduct(?,?,?,?)}");
            cmd.setDouble("p_cost", cost);
            cmd.setString("p_name",name);
            cmd.setInt("p_units", units);
            cmd.setString("p_code", code);
            cmd.execute();
                
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Registro Guardado Correctamente!");   
    }
    
    public void RetrieveProductByCode(String code){
        String name = "";
        Double cost = 0.0;
        try{
            con = conexion();
            CallableStatement cmd = con.prepareCall("{CALL sp_getProductByCode(?,?,?)}");
            cmd.setString("p_code",code);
            cmd.registerOutParameter("p_name", Types.VARCHAR);
            cmd.execute();
            name = cmd.getString("p_name");  
            cost = cmd.getDouble("p_cost");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(name + " " + cost );
    }
}
