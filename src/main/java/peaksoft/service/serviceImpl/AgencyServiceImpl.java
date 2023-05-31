package peaksoft.service.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entity.Agency;
import peaksoft.repository.AgencyRepository;
import peaksoft.service.AgencyService;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class AgencyServiceImpl implements AgencyService {
    private final AgencyRepository agencyRepository;
    @Override
    public void saveAgency(Agency agency) {
        agencyRepository.save(agency);
    }
    @Override
    public Agency getAgencyById(Long id) {
        return agencyRepository.findById(id).orElseThrow(()-> new NullPointerException("Agency with id: "+id+" is not found!"));
    }
    @Override
    public List<Agency> getAllAgencies() {
        return agencyRepository.findAll();
    }
    @Override
    public void updateAgency(Long id, Agency agency) {
        Agency agency1 = agencyRepository.findById(id).
                orElseThrow(()-> new NullPointerException
                        ("Agency with id: "+id+" is not found!"));
        agency1.setName(agency.getName());
        agency1.setImage(agency.getImage());
        agency1.setEmail(agency.getEmail());
        agency1.setCountry(agency.getCountry());
        agency1.setPhoneNumber(agency.getPhoneNumber());
        agencyRepository.save(agency1);
    }
    @Override
    public void deleteAgencyById(Long id) {
        if (agencyRepository.existsById(id)) {
            agencyRepository.deleteById(id);
        }
        else throw new NullPointerException("Agency with id: " + id + " is not found");
    }
}
