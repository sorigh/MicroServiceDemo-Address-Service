package com.example.demo.service;

import com.example.demo.domain.entity.Address;
import com.example.demo.infrastructure.repository.AddressRepo;
import com.example.demo.domain.dto.AddressDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressService {

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper mapper;

    public AddressDTO findAddressByEmployeeId(int employeeId) {
        Optional<Address> addressByEmployeeId = addressRepo.findAddressByEmployeeId(employeeId);
        AddressDTO addressDTO = mapper.map(addressByEmployeeId, AddressDTO.class);
        return addressDTO;
    }

    public List<AddressDTO> getAllAddresses() {
        List<Address> addresses = addressRepo.findAll();
        return addresses.stream()
                .map(address -> mapper.map(address, AddressDTO.class))
                .collect(Collectors.toList());
    }

}