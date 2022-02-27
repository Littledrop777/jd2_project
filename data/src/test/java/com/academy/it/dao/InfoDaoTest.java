package com.academy.it.dao;

import com.academy.it.config.TestConfiguration;
import com.academy.it.entity.UserInfo;
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
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@ContextConfiguration(classes = TestConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
@DatabaseSetup("dataForTest.xml")
@DatabaseTearDown(value = "dataForTest.xml", type = DatabaseOperation.DELETE_ALL)
@Transactional
public class InfoDaoTest {

    @Autowired
    private UserInfoDao infoDao;


    @Test
    public void findAllTest() {
        List<UserInfo> all = infoDao.findAll();
        assertFalse(all.isEmpty());
        assertEquals(5, all.size());
    }

    @Test
    public void findByIdTest() {
        UserInfo byId = infoDao.findById("2c93a0817dec3a6a017dec3a716c0001");
        assertNotNull(byId);
    }

    @Test
    public void updateTest() {
        UserInfo infoFromDB = infoDao.findById("2c93a0817dec3a6a017dec3a716c0001");
        UserInfo updatedInfo = infoDao.findById("2c93a0817dec3a6a017dec3a716c0001");
        updatedInfo.setId("2c93a0817dec3a6a017dec3a716c0001");
        updatedInfo.setFirstname("Vasiliy");
        updatedInfo.setLastname("Ivanov");
        infoDao.update(updatedInfo);
        assertEquals(infoFromDB, updatedInfo);
    }

    @Test
    public void pageCount() {

    }
}