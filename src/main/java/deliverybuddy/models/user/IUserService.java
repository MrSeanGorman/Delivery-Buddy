package deliverybuddy.models.user;

import deliverybuddy.models.User;

public interface IUserService {

    public User save(UserDto userDto) /*throws TODO check if email exists*/;
    public User findByEmail(String email);

}
