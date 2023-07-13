/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.nicova.hotel;

import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatDraculaContrastIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialDarkerIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialOceanicIJTheme;
import java.security.GeneralSecurityException;



/**
 *
 * @author jhoja
 */
public class Nicova {

    public static void main(String[] args) throws GeneralSecurityException {
        FlatMaterialOceanicIJTheme.setup();
        Login ventana = new Login();
        ventana.setVisible(true);
    }
}
