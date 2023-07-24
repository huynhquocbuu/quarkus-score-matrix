package adapters.rest;


import adapters.rest.request.MatrixRequest;
import application.mapper.MatrixMapper;
import application.port.in.MatrixIO;
import application.port.in.data.Segment;
import io.smallrye.mutiny.Uni;
import org.mapstruct.factory.Mappers;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tuxs")
public class ScoreMatrixRest {
    @Inject MatrixIO usecase;

    MatrixMapper mapper = Mappers.getMapper(MatrixMapper.class);

    @Transactional
    @POST
    @Path("/matrix2")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Segment> segment(MatrixRequest req) {
        return Uni.createFrom()
            .item(req)
            .map(mapper::data)
            .flatMap(i -> usecase.evaluate(i));
    }
}
