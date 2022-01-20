package by.academy.it.dao;

<<<<<<< HEAD
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
=======
import by.academy.it.config.BaseDBUnitTest;
import by.academy.it.config.TestConfiguration;
import by.academy.it.entity.AppUser;
import by.academy.it.entity.AppUserInfo;
import by.academy.it.entity.Info;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.Instant;
import java.util.List;

import static org.junit.Assert.*;

@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@Commit
public class AppUserInfoDaoTest extends BaseDBUnitTest {

    @Autowired
    Environment environment;


    private static final String DATA_FILE = "/by/academy/it/dao/InfoDaoTest.xml";
    @Autowired
    private AppUserDao userDao;
    @Autowired
    private InfoDao infoDao;
    @Autowired
    private AppUserInfoDao userInfoDao;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void saveTest() {
        System.out.println("db.url=" + environment.getProperty("db.url"));

        cleanInsert(DATA_FILE);
        AppUser user = userDao.findById("2c93a0817dec3a6a017dec3a71200004");
        Info info = infoDao.findById("2c93a0817dec3a6a017dec3a716c0003");
        AppUserInfo userInfo = new AppUserInfo();
        userInfo.setUser(user);
        userInfo.setInfo(info);
        userInfo.setCreateDate(Instant.now());
        userInfoDao.save(userInfo);
        assertNotNull(userInfo.getId());
        //deleteDataset();
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
    }

    @Test
    public void findAllTest() {
<<<<<<< HEAD
        List<AppUser> all = userDao.findAll();
        assertFalse(all.isEmpty());
        assertEquals(6, all.size());
=======
        cleanInsert(DATA_FILE);
        List<Info> all = infoDao.findAll();
        assertFalse(all.isEmpty());
        assertEquals(4, all.size());
        deleteDataset();
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
    }

    @Test
    public void findByIdTest() {
<<<<<<< HEAD
        AppUser byId = userDao
                .findById("2c93a0817dec3a6a017dec3a71200003");
        assertNotNull(byId);
        assertEquals("2c93a0817dec3a6a017dec3a71200003", byId.getId());
=======
        cleanInsert(DATA_FILE);
        Info byId = infoDao.findById("2c93a0817dec3a6a017dec3a716c0001");
        assertNotNull(byId);
        deleteDataset();
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
    }

    @Test
    public void updateTest() {
<<<<<<< HEAD
        AppUser userFromDB = userDao
                .findById("2c93a0817dec3a6a017dec3a71200002");
        Instant updateTime = Instant.now();
        userFromDB.setUpdateDate(updateTime);
        userDao.update(userFromDB);
        assertEquals(updateTime, userFromDB.getUpdateDate());
=======
        cleanInsert(DATA_FILE);
        Info infoFromDB = infoDao.findById("2c93a0817dec3a6a017dec3a716c0001");
        infoFromDB.setFirstname("Vasiliy");
        infoFromDB.setLastname("Ivanov");
        infoDao.update(infoFromDB);
        assertEquals("Vasiliy", infoFromDB.getFirstname());
        assertEquals("Ivanov", infoFromDB.getLastname());
        deleteDataset();
>>>>>>> d371dc854108c815d3bfbd39d1ded35b5dda9614
    }
}