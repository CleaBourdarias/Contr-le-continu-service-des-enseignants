package champollion;

import java.util.Date;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");	
                
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}
        
        @Test
        public void testHeurePrevues() {
            double c = 0;
            for (ServicePrevu sp : untel.listeServicesPrevus){
                c = c + sp.getVolumeTD() + 1.5*sp.getVolumeCM() + 0.75*sp.getVolumeTP();
            }
            assertEquals(c, untel.heuresPrevues());
        }
        
        @Test
        public void testAjouterIntervention() {
            int longueur = untel.listeIntervention.size();
            untel.ajouterIntervention(new Intervention(new Date(), 3, 15, TypeIntervention.CM, java));
            assertEquals(untel.listeIntervention.size(), longueur+1);
        }
        
        @Test
        public void testAjouterEnseignements() {
            int longueur = untel.listeServicesPrevus.size();
            untel.ajouteEnseignement(java,3,4,5);
            assertEquals(untel.listeServicesPrevus.size(), longueur+1);
        }
        
        @Test
        public void testEnSousService(){
            int h = untel.heuresPrevues();
            assertTrue(untel.enSousService());   
        }
        
        @Test
        public void testNonEnSousService(){
            untel.ajouteEnseignement(java,192,4,5);
            int h = untel.heuresPrevues();
            assertFalse(untel.enSousService());   
        }
        
        
        
        

	
}
