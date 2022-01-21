package by.academy.it.dao;

import by.academy.it.config.TestConfiguration;
import by.academy.it.entity.AppUser;
import by.academy.it.entity.Role;
import by.academy.it.entity.UserInfo;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(
        {DependencyInjectionTestExecutionListener.class,
                DbUnitTestExecutionListener.class})
@DatabaseSetup(value = "dataForTest.xml")
@DatabaseTearDown( value = "dataForTest.xml", type = DatabaseOperation.DELETE_ALL)
public class AppUserInfoDaoTest {

    @Autowired
    private AppUserDao userDao;

    @Test
    public void saveTest() {
        AppUser user = new AppUser();
        user.setLogin("test");
        user.setPassword("test");
        user.setRole(Role.USER);

        UserInfo info = UserInfo.builder()
                .firstname("Alica")
                .lastname("Jonson")
                .email("test@mail.com")
                .createDate(Instant.now())
                .birthday(LocalDate.of(1989, 12, 12))
                .build();

        user.setUserInfo(info);
        userDao.save(user);
        assertNotNull(user.getUserInfo().getId());
        assertNotNull(user.getId());
        userDao.delete(user.getId());
    }

    @Test
    public void findAllTest() {
        List<AppUser> all = userDao.findAll();
        assertFalse(all.isEmpty());
        assertEquals(6, all.size());
    }

    @Test
    public void findByIdTest() {
        AppUser byId = userDao
                .findById("2c93a0817dec3a6a017dec3a71200003");
        assertNotNull(byId);
        assertEquals("2c93a0817dec3a6a017dec3a71200003", byId.getId());
    }

    @Test
    public void updateTest() {
        AppUser userFromDB = userDao
                .findById("2c93a0817dec3a6a017dec3a71200002");
        Instant updateTime = Instant.now();
        userFromDB.setUpdateDate(updateTime);
        userDao.update(userFromDB);
        assertEquals(updateTime, userFromDB.getUpdateDate());
    }
}