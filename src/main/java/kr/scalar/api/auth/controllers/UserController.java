package kr.scalar.api.auth.controllers;

import kr.scalar.api.auth.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import kr.scalar.api.auth.domains.User;
import kr.scalar.api.auth.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * packageName: net.zerotodev.api.controllers
 * fileName   : UserController
 * author     : parkjungkwan
 * date       : 2022-05-03
 * desc       :
 * ================================
 * DATE        AUTHOR        NOTE
 * ================================
 * 2022-05-03   parkjungkwan  최초 생성
 */
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return service.login(user);
    }

    @GetMapping("/logout")
    public String logout() {
        return "";
    }
    @PutMapping("/update")
    public String update(@RequestBody User user) {
        return service.update(user);
    }

    // Embeded Methods
    @GetMapping("/findAll")
    public List<User> findAll() {
        return service.findAll();
    }

    @GetMapping("/findAll/sort")
    public List<User> findAll(Sort sort) {
        return service.findAll(sort);
    }

    @GetMapping("/findAll/pageable")
    public Page<User> findAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("/count")
    public long count() {
        return service.count();
    }

    @DeleteMapping("/delete")
    public String delete(@RequestBody User user) {
        return service.delete(user);
    }

    @PostMapping("/join")
    public String save(@RequestBody User user) {
        return service.save(user);
    }

    @GetMapping("/findById/{userid}")
    public Optional<User> findById(@PathVariable String userid) {
        return service.findById(userid);
    }

    @GetMapping("/existsById/{userid}")
    public boolean existsById(@PathVariable String userid) {
        return service.existsById(userid);
    }


}
