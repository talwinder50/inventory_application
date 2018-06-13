package services;

import java.util.Arrays;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.User;
import repository.UserRepository;
import vo.UserDTO;

@Service
public class UserService implements IUserService {
	@Autowired
	private UserRepository repository;

	@Transactional
	@Override
	public User registerNewUserAccount(UserDTO accountDto) throws EmailExistsException {

		if (emailExist(accountDto.getEmail())) {
			throw new EmailExistsException("There is an account with that email address:" + accountDto.getEmail());
		}
		User user = new User();
		user.setFirstName(accountDto.getFirstName());
		user.setLastName(accountDto.getLastName());
		user.setPassword(accountDto.getPassword());
		user.setEmail(accountDto.getEmail());
		//user.setRoles(Arrays.asList("ROLE_USER"));
		// user.setRoles(accountDto.);
		return repository.save(user);

		// the rest of the registration operation
	}

	private boolean emailExist(String email) {
		User user = repository.findByEmail(email);
		if (user != null) {
			return true;
		}
		return false;
	}
}