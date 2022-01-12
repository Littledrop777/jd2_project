package by.academy.it.dao;

import by.academy.it.config.BaseDBUnitTest;
import by.academy.it.dao.impl.AppUserDaoImpl;
import by.academy.it.dao.impl.InfoDaoImpl;
import by.academy.it.entity.Info;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class InfoDaoTest extends BaseDBUnitTest {

    public static final String DATA_FILE = "/by/academy/it/dao/InfoDaoTest.xml";
    private AppUserDao userDao;
    private InfoDao infoDao;

    @Before
    public void setUp() throws Exception {
        userDao = new AppUserDaoImpl();
        infoDao = new InfoDaoImpl();
    }

    @After
    public void tearDown() throws Exception {
        userDao = null;
        infoDao = null;
    }

    @Test
    public void saveTest() {
        /*AppUser user = new AppUser();
        user.setLogin("Littledrop");
        user.setPassword("123456");
        user.setRole(Role.USER);

        userDao.save(user);*/

        Info info = Info.builder()
                .firstname("Nastya")
                .lastname("Plehanova")
                .email("Littledrop@mail.com")
                .birthday(LocalDate.of(1989, 8, 12))
                .build();
        infoDao.save(info);
        assertNotNull(info.getId());
        infoDao.delete(info.getId());
    }

    @Test
    public void findAllTest() {
        cleanInsert(DATA_FILE);
        List<Info> all = infoDao.findAll();
        assertFalse(all.isEmpty());
        assertEquals(4, all.size());
    }

    @Test
    public void findByIdTest() {
        cleanInsert(DATA_FILE);
        Info byId = infoDao.findById("2c93a0817dec3a6a017dec3a716c0001");
        assertNotNull(byId);
    }

    @Test
    public void updateTest() {
        cleanInsert(DATA_FILE);
        Info infoFromDB = infoDao.findById("2c93a0817dec3a6a017dec3a716c0001");
        Info updatedInfo = infoDao.findById("2c93a0817dec3a6a017dec3a716c0001");
        updatedInfo.setId("2c93a0817dec3a6a017dec3a716c0001");
        updatedInfo.setFirstname("Vasiliy");
        updatedInfo.setLastname("Ivanov");
        infoDao.update(updatedInfo);
        assertEquals(infoFromDB, updatedInfo);
    }

}