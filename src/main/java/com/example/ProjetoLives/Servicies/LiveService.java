package com.example.ProjetoLives.Servicies;

import com.example.ProjetoLives.Entities.Live;
import com.example.ProjetoLives.Repositories.LiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiveService {

    @Autowired
    LiveRepository liveRepository;

    public Optional<Live> findById(long id) {
        return liveRepository.findById(id);
    }

    public List<Live> findAll(Pageable pageable){
        return (List<Live>) liveRepository.findAll(pageable);
    }

    public Optional<Live> deleteById(long id){
        liveRepository.deleteById(id);
        return null;
    }

    public Live save(Live live){
        return liveRepository.save(live);
    }

    public boolean existsById(long id) {
        return liveRepository.existsById(id);
    }
}
