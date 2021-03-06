package com.academy.it.dao;

import com.academy.it.annotation.IT;
import com.academy.it.config.TestConfiguration;
import com.academy.it.dto.AppUserInfoDto;
import com.academy.it.dto.SearchUserResultDto;
import com.academy.it.dto.UserFriendDto;
import com.academy.it.entity.AppUser;
import com.academy.it.entity.Friend;
import com.academy.it.entity.Role;
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

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@IT
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class AppUserInfoDaoTest {

    @Autowired
    private AppUserDao userDao;
    @Autowired
    private FriendDao friendDao;

    @Test
    public void saveTest() {
        AppUser user = new AppUser();
        user.setLogin("test");
        user.setPassword("test");
        user.setRole(Role.USER);
        user.setCreateDate(Instant.now());

        UserInfo info = UserInfo.builder()
                .firstname("Катя")
                .lastname("Петрова")
                .email("test@mail.com")
                .birthday(LocalDate.of(1989, 12, 12))
                .build();

        user.setUserInfo(info);
        userDao.save(user);
        assertNotNull(user.getUserInfo().getId());
        assertNotNull(user.getId());
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
        userFromDB.getUserInfo().setFirstname("newName");
        Instant updateTime = Instant.now();
        userFromDB.setLogin("updateLogin");
        userFromDB.setUpdateDate(updateTime);
        userDao.update(userFromDB);
        assertEquals(updateTime, userFromDB.getUpdateDate());
    }

    @Test
    public void findUserWIthInfoByLoginTest() {
        AppUserInfoDto userFromDB = userDao
                .findUserWIthInfoById("2c93a0817dec3a6a017dec3a71200002");
        assertEquals("login2", userFromDB.getLogin());
        assertEquals("User1", userFromDB.getFirstname());
    }

    @Test
    public void findAllByCriteriaTest() {
        List<SearchUserResultDto> result = userDao.findAllByCriteria("L", 0, 3);
        assertNotNull(result);
    }

    @Test
    public void findFriendsByUserId(){
        List<UserFriendDto> friends = friendDao.findFriendsByUserId("2c93a0817dec3a6a017dec3a71200004", 0, 5);
        assertNotNull(friends);
        assertEquals(3, friends.size());
    }

    @Test
    public void findFriendById(){
        Friend friend = friendDao.findById("3c93a0817dec3a6a017dec3a720c0001");
        assertNotNull(friend);
        assertEquals("3c93a0817dec3a6a017dec3a720c0001", friend.getId());
    }
}