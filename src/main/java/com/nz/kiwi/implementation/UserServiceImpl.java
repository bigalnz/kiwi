package com.nz.kiwi.implementation;

import com.nz.kiwi.model.Person;
import com.nz.kiwi.repository.UserRepository;
import com.nz.kiwi.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public Person save(Person person) {
        return userRepository.save(person);
    }
}
