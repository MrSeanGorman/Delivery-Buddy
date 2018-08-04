package deliverybuddy.models.user;

import deliverybuddy.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

/*  TODO Create and implement password encoding */

    @Transactional
    @Override
    public User save(UserDto userDto) {

        User newUser = new User();
        newUser.setFullName(userDto.getFullName());
        newUser.setPassword(userDto.getPassword());
        newUser.setEmail(userDto.getEmail());
        return userRepository.save(newUser);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
