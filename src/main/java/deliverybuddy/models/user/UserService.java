package deliverybuddy.models.user;

import deliverybuddy.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;

/*  TODO Make and implement PasswordEncoder */

    @Transactional
    @Override
    public User save(UserDto userDto) {

        User newUser = new User();
        newUser.setFullName(userDto.getFullName());
        newUser.setPassword(userDto.getPassword());
        newUser.setEmail(userDto.getEmail());
        return userRepo.save(newUser);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

}
