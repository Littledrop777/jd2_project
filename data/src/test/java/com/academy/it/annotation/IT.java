package com.academy.it.annotation;

import com.academy.it.config.TestConfiguration;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ContextConfiguration(classes = TestConfiguration.class)
@TestExecutionListeners(
        {DependencyInjectionTestExecutionListener.class,
                TransactionalTestExecutionListener.class,
                DbUnitTestExecutionListener.class})
@DatabaseSetup(value = "dataForTest.xml")
@DatabaseTearDown(value = "dataForTest.xml", type = DatabaseOperation.DELETE_ALL)
public @interface IT {
}
