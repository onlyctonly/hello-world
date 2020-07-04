package com.example.demo.bootstrap;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapRunner implements CommandLineRunner {

    private final PersonRepository personRepository;

    public BootStrapRunner(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Person person0 = new Person("XiangYu", "Jia");
        Person person1 = new Person("Jia", "Zhou");
        Person person2 = new Person("YuYa", "Jia");
        personRepository.save(person0);
        personRepository.save(person1);
        personRepository.save(person2);

        Person person = personRepository.findByFirstname("Jia");
        System.out.println(person);

        System.out.println(personRepository.count());
    }
}
