package online.store.services;

import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import online.store.model.Address;
import online.store.model.DTO.AddressDTO;
import online.store.model.constants.ErrorMessages;
import online.store.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@Slf4j
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;


    public Address saveTheAddress(final AddressDTO addressDTO) {

        Address address = new Address();
        address.setShippingAddress(addressDTO.getShippingAddress());
        address.setClientAddress(addressDTO.getClientAddress());
        address.setCity(addressDTO.getCity());
        address.setCountry(addressDTO.getCountry());
        address.setZipCode(addressDTO.getZipCode());
        address.setPhone(addressDTO.getPhone());
        AddressService.log.info("Addres saved successfully");
        return this.addressRepository.save(address);
    }

    public Address updateTheAddress(final AddressDTO addressDTO, final Long id) throws NotFoundException {
        Address address = this.addressRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(ErrorMessages.ID_NOT_FOUND_EXCEPTION));
        address.setShippingAddress(addressDTO.getShippingAddress());
        address.setClientAddress(addressDTO.getClientAddress());
        address.setCity(addressDTO.getCity());
        address.setCountry(addressDTO.getCountry());
        address.setZipCode(addressDTO.getZipCode());
        address.setPhone(addressDTO.getPhone());
        return address;

    }


}
