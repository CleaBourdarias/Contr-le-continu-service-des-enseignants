package champollion;

import java.util.HashSet;
import java.util.Set;

public class Enseignant extends Personne {

    protected Set<ServicePrevu> listeServicesPrevus ;
    protected Set<Intervention> listeIntervention;

    // TODO : rajouter les autres méthodes présentes dans le diagramme UML

    public Enseignant(String nom, String email) {
        super(nom, email);
        listeServicesPrevus = new HashSet<>();
        listeIntervention = new HashSet<>();

    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        double c = 0;
        for (ServicePrevu sp : listeServicesPrevus){
            c = c + sp.getVolumeTD() + 1.5*sp.getVolumeCM() + 0.75*sp.getVolumeTP();
        }
        return (int) c;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        // TODO: Implémenter cette méthode
        //throw new UnsupportedOperationException("Pas encore implémenté");
        
        double c = 0;
        for (ServicePrevu sp : listeServicesPrevus){
            if (sp.UE.equals(ue)){
                c = c + sp.getVolumeTD() + 1.5*sp.getVolumeCM() + 0.75*sp.getVolumeTP();
            }
        }
        return (int) c;  
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        // TODO: Implémenter cette méthode
        ServicePrevu SV = new ServicePrevu(volumeCM,volumeTD,volumeTP, ue);
        listeServicesPrevus.add(SV);
        //throw new UnsupportedOperationException("Pas encore implémenté");
    }
    
    public void ajouterIntervention(Intervention i){
        listeIntervention.add(i);
    }
    
    public int resteAPlanifier(UE ue, TypeIntervention intervention){
        int c1 = 0;
        for (Intervention i : listeIntervention){
            if (i.intervention == intervention){
                c1++;
            }
        }
        int c2 = 0;
        for (ServicePrevu sp : listeServicesPrevus){
            if (sp.UE.equals(ue) && intervention == TypeIntervention.CM){
                c2 = sp.getVolumeCM();
            }
            if (sp.UE.equals(ue) && intervention == TypeIntervention.TD){
                c2 = sp.getVolumeTD();
            }
            if (sp.UE.equals(ue) && intervention == TypeIntervention.TP){
                c2 = sp.getVolumeTP();
            }
        }
        return (c2-c1);
        
    }
    
    public boolean enSousService(){
        if (this.heuresPrevues() < 192){
            return true;
        }else{
            return false;
        }
    }
}
