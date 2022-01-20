package tml.centralapi.validatormain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tml.centralapi.validatormain.model.SpRowsByTable;
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
    List<SpTripsByLine> GetSpNumberOfTripsByLine() throws Exception {
        try {
            List<SpTripsByLine> list = entityManager.createStoredProcedureQuery("sp_number_of_trips_by_lines", SpTripsByLine.class).getResultList();
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<>();
    }

    @GetMapping("count-rows-by-table")
    public List<SpRowsByTable> countRowsTable() {
        try {
            List<SpRowsByTable> list = entityManager
                    .createStoredProcedureQuery("sp_get_rows_by_table", SpRowsByTable.class).getResultList();
            return list;
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ArrayList<>();
    }



}
