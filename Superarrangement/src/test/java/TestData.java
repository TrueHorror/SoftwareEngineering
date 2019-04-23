import no.hiof.fredrivo.Data.DataHandler;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestData {
    @Test
    void testCreateNewProfileReturnsProfileObject(){
        assertEquals(DataHandler.createNewProfile("ingride@mail.com", "SterktPassord123","Ingrid"), DataHandler.getNewProfile());
    }

    @Test
    void testGetProfileIfProfileWithEmailAndPasswordExists(){
        //Metoden henter en Profil fra Json filen users.json
        //En profil med emailen testemail@email.com og passordet finnes Apekatt123
        assertNotNull(DataHandler.getProfile("testemail@email.com", "Apekatt123"));
    }

    @Test
    void testGetProfileIfProfileWithEmailAndPasswordDoNotExist(){
        //Metoden henter en Profil fra Json filen users.json
        //En profil med emailen tullekopp@email.com og passordet Storfisktilmiddag123 finnes ikke i filen users.json
        assertNull(DataHandler.getProfile("tullekopp@email.com", "Storfisktilmiddag123"));
    }

    @Test
    void tetsReadUsersFromJsonReturnsEmptyArrayListIfJsonFileIsEmpty(){
        assertEquals(DataHandler.readUsersFromJson("emptyfile.json"), new ArrayList<>());
    }
}
