import by.bsu.dao.impl.UserDAOImpl;
import by.bsu.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml", "classpath:dispatcher-servlet.xml"})
public class UserDAOTest {

        @Autowired
        private UserDAOImpl dao;

        @Test
        public void retrieveUserTest() {
            Assert.assertEquals(dao.retrieveUserByEmail("hansolo@gmail.com").getName(), "HanNNNNNNN");
        }

        @Test
        public void createUSerTest() {
                User user = new User();
                user.setEmail("email");
                user.setSurname("surname");
                user.setPassword("password");
                dao.create(user);
                User retrievedUser = dao.retrieveUserByEmail("email");
                Assert.assertEquals("aaaaaaaaaa", retrievedUser.getEmail());
                Assert.assertEquals(user.getSurname(), retrievedUser.getSurname());
                Assert.assertEquals(user.getPassword(), retrievedUser.getPassword());
        }

        @Test
        public void deleteUserTest(){
                User user = dao.retrieveUserByEmail("email");
                dao.delete(user.getId());
                Assert.assertNull(dao.retrieveUserByEmail(user.getEmail()).getEmail());
        }
}
