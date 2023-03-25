import com.example.webappmvcservlet.models.Person;
import com.example.webappmvcservlet.models.User;
import com.example.webappmvcservlet.services.PersonService;
import com.example.webappmvcservlet.services.UserService;
import org.junit.jupiter.api.Test;

public class UnitTest {
@Test
public void  SavePersonVieService(){

var userSer=new UserService();
    try {
        var isAdd=userSer.save(new User("USER T23EST", "P2A5S".getBytes()));
        System.out.println(isAdd);
        if(isAdd>=0){
            System.out.println("cool");
        }else{
            System.out.println("not cool");
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}

        @Test
        public void  PersonServiceTestSavePerson(){

            var personService=new PersonService();
            try {
                var personList=personService.findAll();
                if(personList.size()>0){
                personList.forEach(person -> System.out.println(person.name));

                }else{
                    System.out.println("is empty");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

        }
}
