package services;

import model.User;
import vo.UserDTO;

public interface IUserService {

	User registerNewUserAccount(UserDTO accountDto) throws EmailExistsException;

}
