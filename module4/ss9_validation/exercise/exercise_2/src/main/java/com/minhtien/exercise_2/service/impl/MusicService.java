package com.minhtien.exercise_2.service.impl;

import com.minhtien.exercise_2.model.Music;
import com.minhtien.exercise_2.repository.IMusicRepository;
import com.minhtien.exercise_2.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public Page<Music> displayAll(Pageable pageable) {
        return musicRepository.findAll(pageable);
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id).orElse(null);
    }
}
