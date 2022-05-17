package services;

import models.Song;
import repositories.SongRepository;

import javax.ws.rs.*;

@Path("/songs")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class SongService {

    private SongRepository songRepository = new SongRepository();

    @GET
    @Path("/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Song getSongById(@PathParam("id") String id) {
        return songRepository.getSongById(id);
    }
}
