package tml.centralapi.validatormain.controller;

import org.springframework.web.bind.annotation.*;
import tml.centralapi.validatormain.model.RowsByTable;
import tml.centralapi.validatormain.model.SpTripsByLine;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
public class PostGresFunctionsController {
    @PersistenceContext
    EntityManager entityManager;

    @GetMapping("trips-by-line")
    List<SpTripsByLine> GetSpNumberOfTripsByLine() throws Exception {
        try {
            List<SpTripsByLine> list = entityManager.createStoredProcedureQuery("sp_number_of_trips_by_lines", SpTripsByLine.class).getResultList();
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<>();
    }

    @GetMapping("count-rows-by-table/{feedId}")
    public List<RowsByTable> countRowsTable(@PathVariable String feedId) {
        try {
            StoredProcedureQuery query = entityManager.createStoredProcedureQuery( "sp_get_rows_by_table" );
            List<RowsByTable> list = query.registerStoredProcedureParameter( feedId,  RowsByTable.class, ParameterMode.IN ).getResultList();
            query.setParameter( 1, 1L );
            query.execute();
            return list;
        }
        finally {
            entityManager.close();
            return new ArrayList<>();
        }

    }

//    @GetMapping("count-rows-by-table/{feedId}")
//    public List<RowsByTable> countRowsTable(@PathVariable String feedId) {
//        try {
//            List<RowsByTable> list = entityManager
//                    .createStoredProcedureQuery("sp_get_rows_by_table", RowsByTable.class).getResultList();
//            return list;
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        return new ArrayList<>();
//    }



}
