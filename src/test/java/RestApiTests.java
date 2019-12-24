import com.spring.liquibase_rest_api.entities.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@Slf4j
public class RestApiTests {
    private static final String URL_FIND_ALL_USERS = "http://localhost:8080/users/findAllUsers";
    private static final String URL_FIND_USER_BY_ID = "http://localhost:8080/users/{id}";
    private static final String URL_CREATE_USER = "http://localhost:8080/users/";
    private static final String URL_UPDATE_USER = "http://localhost:8080/users/{id}";
    private static final String URL_DELETE_USER = "http://localhost:8080/users/{id}";

    RestTemplate restTemplate;

    @Before
    public void setUp(){
        restTemplate = new RestTemplate();
    }

    @Test
    public void findAllUsersTest(){
        log.info("Testing find all users:");
        User[] users = restTemplate.getForObject(URL_FIND_ALL_USERS, User[].class);
        assertNotNull(users);
        listSingers(users);
    }

    @Test
    public void findUserByIdTest(){
        log.info("Testing find user by id : 1");
        User user = restTemplate.getForObject(URL_FIND_USER_BY_ID, User.class, 1);
        assertNotNull(user);
        log.info(user.toString());
    }

    @Test
    public void createUserTest(){
        log.info("Testing create user:");
        User user = new User();
        user.setFirstName("Kevin");
        user.setLastName("Systrom");
        user.setBirthDate(new Date(new GregorianCalendar(1983,11, 30).getTime().getTime()));
        user.setEmail("insta@mail.com");
        user.setPassword("KevinSystrom");
        user = restTemplate.postForObject(URL_CREATE_USER, user, User.class);
        log.info("User created successfully! " + user);
    }

    @Test
    public void updateUserTest(){
        log.info("Testing update user:");
        User user = restTemplate.getForObject(URL_UPDATE_USER, User.class, 1);
        user.setFirstName("Chewbacca");
        user.setLastName("Ararar");
        user.setEmail("arar@mail.com");
        user.setPassword("arararar");
        restTemplate.put(URL_UPDATE_USER, user, 1);
        log.info("User updating successfully!");
    }

    @Test
    public void deleteUserTest(){
        log.info("Testing delete user:");
        restTemplate.delete(URL_DELETE_USER,2);
        User[] users = restTemplate.getForObject(URL_FIND_ALL_USERS, User[].class);
        Boolean found = false;
        for (User user: users){
            if (user.getId()==2){
                found = true;
            }
        }
        assertFalse(found);
        listSingers(users);
    }

    private void listSingers(User[] users) {
        Arrays.stream(users).forEach(user -> log.info(user.toString()));
    }
}
