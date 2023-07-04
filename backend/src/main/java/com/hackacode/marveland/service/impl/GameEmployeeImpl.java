package com.hackacode.marveland.service.impl;
import com.hackacode.marveland.model.dto.request.CustomerRequestDto;
import com.hackacode.marveland.model.dto.request.GameEmployeeRequestDto;
import com.hackacode.marveland.model.dto.response.GameEmployeeResponseDto;
import com.hackacode.marveland.model.entity.*;
import com.hackacode.marveland.model.mapper.GameEmployeeMapper;
import com.hackacode.marveland.repository.*;
import com.hackacode.marveland.service.IGameEmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class GameEmployeeImpl implements IGameEmployeeService {
	private final IUserRepository userRepository;
	private final IEmployeeRepository employeeRepository;
	private final PasswordEncoder passwordEncoder;
	private final IGameEmployeeRepository repository;
	private final GameEmployeeMapper mapper;
	private final IAdminEmployeeRepository adminEmployeeRepository;

	@Override
	public List<GameEmployee> All() {
		return repository.findAll();
	}
	@Override
	public List<GameEmployeeResponseDto> getAll() {
		return repository.findAll().stream()
				.map(gameEmployee -> mapper.entityToDto(gameEmployee))
				.collect(Collectors.toList());
	}
	@Transactional
	public GameEmployeeResponseDto create(GameEmployeeRequestDto request, String email) {
		AdminEmployee adminEmployee = adminEmployeeRepository.findByEmail(email);
		adminEmployeeRepository.save(adminEmployee);
		User user = User.builder()
				.username("liovnelmessi@gmail.com")
				.password(passwordEncoder.encode("21234"))
				.role("EMPLOYEE")
				.build();
		GameEmployee gameEmployee = mapper.dtoToEntity(request, adminEmployee);
		adminEmployee.setUser(user);
		repository.save(gameEmployee);
		userRepository.save(user);
		employeeRepository.save(adminEmployee);
		if (!userRepository.findByUsername(user.getUsername()).isPresent()) {
			userRepository.save(user);
			employeeRepository.save(adminEmployee);
		}
		return null;
	}
	@Override
	public void update(CustomerRequestDto request, Long id) {
	}
	@Override
	public void delete(Long id) {
	Optional<GameEmployee> gameEmployee=repository.findById(id);
		if (gameEmployee.isPresent()){
			repository.deleteById(id);
		}
		else {throw new RuntimeException("NOT DELETE");}
	}
}
