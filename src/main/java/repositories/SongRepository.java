package repositories;

import models.Song;

public class SongRepository {
    public Song getSongById(String id) {
        return new Song(id, "Karma Police","4.00");
    }
}
