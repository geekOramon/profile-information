package oramon.saiyans.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping
    public Iterable<User> getAllUsers(){

        final Iterable<User> all = userRepository.findAll();
        return all;
    }

    @GetMapping(path = "/{email:.+}")
    public User getUser(@PathVariable(value = "email") String email){
        User user = userRepository.getUserByEmail(email);
        return user;
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        userRepository.save(user);
        return user;

    }

//    @GetMapping(path = "/{email}")
//    @ResponseBody
//    public String getUser(@PathVariable String email){
//        userRepository.
//    }


}
