package com.minhtien.exercise_2.service;

import com.minhtien.exercise_2.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService {
    Page<Music> displayAll(Pageable pageable);
    void save(Music music);
    Music findById(int id);
}
