package tml.centralapi.validatormain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tml.centralapi.validatormain.model.SpTripsByLine;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class PostGresFunctionsController {
    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("trips-by-line")
    List GetSpNumberOfTripsByLine() throws Exception {
        try {
            List<SpTripsByLine> list = entityManager.createStoredProcedureQuery("sp_number_of_trips_by_lines", SpTripsByLine.class).getResultList();
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<>();
    }

//    CREATE OR REPLACE FUNCTION public.sp_number_of_trips_by_lines()
//    RETURNS TABLE(total bigint, line_id varchar(50))
//    LANGUAGE plpgsql
//    AS $function$
//    BEGIN
//    RETURN QUERY select count(*), cast(rio.line_id as varchar(50)) from stop_times stio
//    inner join trips tio on stio.trip_id = tio.trip_id
//    inner join routes rio on rio.route_id = tio.route_id
//    where stio.stop_sequence = 1
//    group by rio.line_id;
//    END;
//    $function$
//    ;


}
