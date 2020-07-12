package com.example.demo.bootstrap;

import com.example.demo.domain.Gender;
import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class BootStrapRunner implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(BootStrapRunner.class);
    private final PersonRepository personRepository;

    @Autowired
    private final JdbcTemplate jdbcTemplate;

    public BootStrapRunner(PersonRepository personRepository, JdbcTemplate jdbcTemplate) {
        this.personRepository = personRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
//        Person person0 = new Person("XiangYu", "Jia", Gender.M, new SimpleDateFormat("yyyy-MM-dd").parse("1983-06-25"));
//        Person person1 = new Person("Jia", "Zhou", Gender.F,new SimpleDateFormat("yyyy-MM-dd").parse("1984-12-25"));
//        Person person2 = new Person("YuYa", "Jia", Gender.F,new SimpleDateFormat("yyyy-MM-dd").parse("2017-05-11"));
//        personRepository.save(person0);
//        personRepository.save(person1);
//        personRepository.save(person2);

        Person person = personRepository.findByFirstname("Jia");
        System.out.println(person);

        System.out.println(personRepository.count());
        jdbcTemplate.query("select * from person",
                (rs, rowNum) -> new Person(rs.getString("firstname"), rs.getString("lastname"),rs.getDate("birthday"))
        ).forEach(customer -> log.info(customer.toString()));
    }
}
