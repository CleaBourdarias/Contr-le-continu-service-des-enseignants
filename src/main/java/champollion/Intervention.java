/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package champollion;

import java.util.Date;

/**
 *
 * @author cleab
 */
public class Intervention {
    
    protected Date date;
    protected int duree;
    protected boolean annulee;
    private int heureDebut;
    protected TypeIntervention intervention;
    protected UE ue;

    public Intervention(Date date, int duree, int heureDebut, TypeIntervention intervention,UE ue) {
        this.date = date;
        this.duree = duree;
        this.heureDebut = heureDebut;
        this.annulee = false;
        this.intervention = intervention;
        this.ue = ue;
    }
    
    
    
}
