package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.contact.*;

import java.util.List;

public interface ContactService {

    void saveContact(ContactDto contactDto);

    List<ContactGetAllDto> getAllContact();

    ContactGetIdDto getContactId(Long id);

    void createContact(ContactCreateDto contactCreateDto);
    void updateContact(ContactUpdateDto contactUpdateDto, Long id);
    void deleteContact(Long id);
}
