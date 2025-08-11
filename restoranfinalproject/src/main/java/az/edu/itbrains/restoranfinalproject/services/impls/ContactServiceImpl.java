package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.contact.*;
import az.edu.itbrains.restoranfinalproject.models.Contact;
import az.edu.itbrains.restoranfinalproject.repositories.ContactRepository;
import az.edu.itbrains.restoranfinalproject.services.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;
    private final ModelMapper modelMapper;

    public ContactServiceImpl(ContactRepository contactRepository, ModelMapper modelMapper) {
        this.contactRepository = contactRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void saveContact(ContactDto contactDto) {
        Contact contact = new Contact();
        contact.setName(contactDto.getName());
        contact.setEmail(contactDto.getEmail());
        contact.setSubject(contactDto.getSubject());
        contact.setMessage(contactDto.getMessage());
        contactRepository.save(contact);
    }

    @Override
    public List<ContactGetAllDto> getAllContact() {
        List<ContactGetAllDto> getAllContact = contactRepository.findAll().stream().map(contact -> modelMapper.map(contact, ContactGetAllDto.class)).collect(Collectors.toList());
        return getAllContact;
    }

    @Override
    public ContactGetIdDto getContactId(Long id) {
        Contact contact = contactRepository.findById(id).orElseThrow();
        ContactGetIdDto result = new ContactGetIdDto();
        result.setName(contact.getName());
        result.setEmail(contact.getEmail());
        result.setSubject(contact.getSubject());
        result.setMessage(contact.getMessage());
        return result;
    }

}
