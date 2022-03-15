package com.academy.it.dao;

import com.academy.it.annotation.IT;
import com.academy.it.dto.UserChatDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@IT
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class UserChatDaoImplTest {

    @Autowired
    private UserChatDao userChatDao;

    @Test
    public void findAllByUserId() {
        List<UserChatDto> dialogs = userChatDao.findAllByUserId("2c93a0817dec3a6a017dec3a71200002", 0,  3);
        dialogs.forEach(System.out::println);
    }
}