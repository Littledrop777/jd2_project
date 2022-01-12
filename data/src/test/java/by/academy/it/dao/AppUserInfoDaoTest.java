package by.academy.it.dao;

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
    }

    @Test
    public void findAllTest() {
        cleanInsert(DATA_FILE);
        List<Info> all = infoDao.findAll();
        assertFalse(all.isEmpty());
        assertEquals(4, all.size());
        deleteDataset();
    }

    @Test
    public void findByIdTest() {
        cleanInsert(DATA_FILE);
        Info byId = infoDao.findById("2c93a0817dec3a6a017dec3a716c0001");
        assertNotNull(byId);
        deleteDataset();
    }

    @Test
    public void updateTest() {
        cleanInsert(DATA_FILE);
        Info infoFromDB = infoDao.findById("2c93a0817dec3a6a017dec3a716c0001");
        infoFromDB.setFirstname("Vasiliy");
        infoFromDB.setLastname("Ivanov");
        infoDao.update(infoFromDB);
        assertEquals("Vasiliy", infoFromDB.getFirstname());
        assertEquals("Ivanov", infoFromDB.getLastname());
        deleteDataset();
    }
}