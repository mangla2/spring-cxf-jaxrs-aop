package services;

import models.Song;
import repositories.SongRepository;

import javax.ws.rs.*;

@Path("/songs")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public interface SongService {

    @GET
    @Path("/{id}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    public Song getSongById(@PathParam("id") String id);

}
