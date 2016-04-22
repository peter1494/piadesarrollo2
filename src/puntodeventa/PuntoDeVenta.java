/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package puntodeventa;

/**
 *
 * @author peter
 */
public class PuntoDeVenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        DataAccess da2;
        da2 = new DataAccess();
        da2.RetrieveProductByCode("GSM12KSDJ");
        
    }
    
}
