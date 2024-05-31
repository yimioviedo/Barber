
package barber;

import Vista.PrincipalJFrame;

public class Barber {

       public static void main(String[] args) {
           java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new PrincipalJFrame().setVisible(true); 
        }
    });
}

        
}
    

