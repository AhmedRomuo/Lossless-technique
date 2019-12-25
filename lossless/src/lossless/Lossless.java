/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lossless;

import java.util.HashMap;

/**
 *
 * @author ahmed
 */
public class Lossless {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        run_length_encoding r = new run_length_encoding();
        r.setLocationRelativeTo(null);
        r.setVisible(true);
        
        ADC q = new ADC();
        q.setLocationRelativeTo(null);
        q.setVisible(true);
        

        Shannon_fano s = new Shannon_fano();
        s.setLocationRelativeTo(null);
        s.setVisible(true);

        Huffman h = new Huffman();
        h.setLocationRelativeTo(null);
        h.setVisible(true);


        Trans_Scall_rotat_for_2D t = new Trans_Scall_rotat_for_2D();
        t.setLocationRelativeTo(null);
        t.setVisible(true);
        
        //System.out.println(Math.cos(Math.toRadians(270)));

        LZW_frm l = new LZW_frm();
        l.setLocationRelativeTo(null);
        l.setVisible(true);
        
    


        //System.out.println(Integer.toBinaryString(2));
    }
    
}
