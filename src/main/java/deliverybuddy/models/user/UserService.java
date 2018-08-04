package deliverybuddy.models.user;

import deliverybuddy.models.User;

public interface UserService {

    public User save(UserDto userDto) throws EmailExistsException;
    public User findByEmail(String email);

}
