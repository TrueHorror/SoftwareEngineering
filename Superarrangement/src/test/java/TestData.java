import no.hiof.fredrivo.Data.DataHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestData {
    @Test
    public void testGetProfileIfProfileWithEmailAndPasswordExists(){
        //Metoden henter en Profil fra Json filen users.json
        //En profil med emailen testemail@email.com og passordet finnes Apekatt123
        assertNotNull(DataHandler.getProfile("testemail@email.com", "Apekatt123"));
    }

    @Test
    void testGetProfileIfProfileWithEmailAndPasswordDoNotExist(){
        //Metoden henter en Profil fra Json filen users.json
        //En profil med emailen testemail@email.com og passordet Apekatt123 finnes ikke i fil
        assertNull(DataHandler.getProfile("tullekopp@email.com", "Storfisktilmiddag123"));
    }
}
