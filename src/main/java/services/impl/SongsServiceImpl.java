package services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import annotations.Authorize;
import models.Song;
import repositories.SongRepository;
import services.SongService;

public class SongsServiceImpl implements SongService {
    private SongRepository songRepository = new SongRepository();

    @Authorize
    @Override
    public Song getSongById(String id) {
        return songRepository.getSongById(id);
    }
}
