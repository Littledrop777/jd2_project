package com.academy.it.dao;

import com.academy.it.annotation.IT;
import com.academy.it.config.TestConfiguration;
import com.academy.it.dto.ChatDto;
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

import static org.junit.Assert.*;

@IT
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ChatDaoImplTest {

    @Autowired
    private ChatDao chatDao;

    @Test
    public void findAllByUserChatId() {
        List<ChatDto> messages = chatDao.findAllByUserChatId("5c93a0817dec3a6a017dec3a840c0001",0, 5);
        assertEquals(5, messages.size());
        assertEquals("Buy", messages.get(0).getMessage());
        messages.forEach(System.out::println);
    }
}