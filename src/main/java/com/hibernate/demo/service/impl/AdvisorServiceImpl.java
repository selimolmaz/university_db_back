package com.hibernate.demo.service.impl;

import com.hibernate.demo.dto.AdvisorDTO;
import com.hibernate.demo.mapper.AdvisorMapper;
import com.hibernate.demo.model.Advisor;
import com.hibernate.demo.repository.AdvisorRepository;
import com.hibernate.demo.service.AdvisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdvisorServiceImpl implements AdvisorService {
    private final AdvisorRepository advisorRepository;
    private final AdvisorMapper advisorMapper;  // Mapper

    @Autowired
    public AdvisorServiceImpl(AdvisorRepository advisorRepository, AdvisorMapper advisorMapper) {
        this.advisorRepository = advisorRepository;
        this.advisorMapper = advisorMapper;  // Mapper'ı enjekte et
    }

    @Override
    public List<AdvisorDTO> getAllAdvisors() {
        List<Advisor> advisors = advisorRepository.findAll();
        return advisors.stream()
                .map(advisorMapper::toDto)  // Varlıkları DTO'ya dönüştür
                .collect(Collectors.toList());
    }

    @Override
    public Optional<AdvisorDTO> getAdvisorById(String sId) {
        return advisorRepository.findById(sId)
                .map(advisorMapper::toDto);  // Varlığı DTO'ya dönüştür
    }

    @Override
    public AdvisorDTO saveAdvisor(AdvisorDTO advisorDTO) {
        Advisor advisor = advisorMapper.toEntity(advisorDTO);  // DTO'yu varlığa dönüştür
        Advisor savedAdvisor = advisorRepository.save(advisor);
        return advisorMapper.toDto(savedAdvisor);  // Kaydedilen varlığı DTO'ya dönüştür
    }

    @Override
    public AdvisorDTO updateAdvisor(String sId, AdvisorDTO advisorDTO) {
        // Danışmanı güncellemek için önce mevcut kaydı bul
        if (advisorRepository.existsById(sId)) {
            advisorDTO.setiId(sId);  // Güncelleme sırasında ID'yi ayarla
            Advisor advisor = advisorMapper.toEntity(advisorDTO);  // DTO'yu varlığa dönüştür
            Advisor updatedAdvisor = advisorRepository.save(advisor);
            return advisorMapper.toDto(updatedAdvisor);  // Güncellenen varlığı DTO'ya dönüştür
        }
        return null;  // Eğer danışman yoksa null döner
    }

    @Override
    public boolean deleteAdvisor(String sId) {
        if (advisorRepository.existsById(sId)) {
            advisorRepository.deleteById(sId);
            return true;  // Silme başarılı
        }
        return false;  // Eğer danışman yoksa false döner
    }
}
