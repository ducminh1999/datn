/**
 * (C) Copyright of Fresher FPT Software Academy. All Rights Reserved
 *
 * @author Minh
 * @date Aug 15, 2021
 * @version 1.0
 */
package milkTea.admin.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import milkTea.admin.dto.User;
import milkTea.admin.entities.UserEntity;
import milkTea.admin.repositories.UserRepository;
import milkTea.admin.utils.ConvertUser;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;

	public List<User> findAll() {
		List<UserEntity> data = userRepo.findAll();
		List<User> result = data.stream().map((o) -> ConvertUser.convertDtoFromEntity(o))
				.collect(Collectors.toList());
		return result;
	}

	public User findOne(String email) {
		List<UserEntity> entity = userRepo.findByEmail(email);
		for (UserEntity userEntity : entity) {
			userEntity.toString();
		}
        if (entity.size() == 0) {
            return null;
        } else {
            User result = ConvertUser.convertDtoFromEntity(entity.get(0));
            result.toString();
            return result;
        }
	}

	public User findOne(int id) {
		Optional<UserEntity> data = userRepo.findById(id);
		if(data.isPresent()) {
			User user = ConvertUser.convertDtoFromEntity(data.get());
			return user;
		} else {
			return null;
		}
	}

	public boolean add(User user) {
		UserEntity userEntity = ConvertUser.convertDtoToEntity(user);
		userRepo.save(userEntity);
		return true;
	}

	public boolean update(User user) {
		UserEntity userEntity = ConvertUser.convertDtoToEntity(user);
		userRepo.save(userEntity);
		return true;
	}

	public boolean delete(int id) {
		userRepo.deleteById(id);
		return true;
	}

}
