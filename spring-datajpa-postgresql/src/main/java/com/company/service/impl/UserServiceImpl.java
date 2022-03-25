package com.company.service.impl;

import com.company.dto.UserDto;
import com.company.entity.Address;
import com.company.entity.User;
import com.company.repo.AddressRepository;
import com.company.repo.UserRepository;
import com.company.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    public UserDto save(UserDto userDto) {
       // Assert.isNull(userDto.getName(),"Name field required!");

        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        final User userDb = userRepository.save(user);

        List<Address> list = new ArrayList<>();
        userDto.getAllAddressList().forEach(item ->{
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.OTHER);
            address.setStatus(true);
            address.setUser(userDb);
            list.add(address);
        });
        addressRepository.saveAll(list);
        userDto.setId(userDb.getId());
        return userDto;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();

        users.forEach(user -> {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setName(user.getName());
            userDto.setSurname(user.getSurname());
            userDto.setAllAddressList(user.getAllAddressList().stream().map(Address::getAddress)
                    .collect(Collectors.toList()));
            userDtos.add(userDto);
        });
        return userDtos;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        return null;
    }
}
