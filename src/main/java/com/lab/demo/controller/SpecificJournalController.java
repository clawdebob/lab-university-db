package com.lab.demo.controller;

import com.lab.demo.dao.SpecificJournalJdbc;
import com.lab.demo.model.SpecificJournal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpecificJournalController {
    private final SpecificJournalJdbc specificJournalJdbc;

    public SpecificJournalController(SpecificJournalJdbc specificJournalJdbc)
    {
        this.specificJournalJdbc = specificJournalJdbc;
    }

    @GetMapping("/journal")
    public List<SpecificJournal> getAllJournalRecords()
    {
        return specificJournalJdbc.getAll();
    }
}
