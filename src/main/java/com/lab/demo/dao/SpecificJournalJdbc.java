package com.lab.demo.dao;

import com.lab.demo.model.JournalRecord;
import com.lab.demo.model.SpecificJournal;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SpecificJournalJdbc {
    private final JdbcTemplate jdbcTemplate;

    public SpecificJournalJdbc(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<SpecificJournal> getAll()
    {
        return jdbcTemplate.queryForObject("with EXTENDED_JOURNAL as (select CONCAT(SURNAME, ' ', STUDENT.NAME, ' ', SECOND_NAME) as NAME, STUDY_GROUP_ID, SUBJECT.NAME as SUBJECT, SUBJECT.ID as SUBJECT_ID, MARK.NAME as MARK, JOURNAL.COUNT AS ATTEMPTS from\n" +
                "((((JOURNAL\n" +
                "inner join STUDENT on JOURNAL.STUDENT_ID = STUDENT.ID)\n" +
                "inner join MARK on MARK_ID = MARK.ID)\n" +
                "inner join STUDY_PLAN on STUDY_PLAN_ID = STUDY_PLAN.ID)\n" +
                "inner join SUBJECT on STUDY_PLAN.SUBJECT_ID = SUBJECT.ID))\n" +
                "\n" +
                "select PRIS.NAME as NAME,\n" +
                "       PRIS.STUDY_GROUP_ID as STUDY_GROUP,\n" +
                "       PRIS.MARK as PRIS_MARK,\n" +
                "       PRIS.ATTEMPTS as PRIS_ATTEMPTS,\n" +
                "       SII.MARK as SII_MARK,\n" +
                "       SII.ATTEMPTS as SII_ATTEMPTS\n" +
                "from EXTENDED_JOURNAL PRIS, EXTENDED_JOURNAL SII\n" +
                "where PRIS.SUBJECT_ID = 1 and SII.SUBJECT_ID = 2 and PRIS.NAME = SII.NAME;", this::mapAllJournalRecords);
    }

    private List<SpecificJournal> mapAllJournalRecords(@NotNull ResultSet rs, int i) throws SQLException
    {
        List<SpecificJournal> journalRecordList = new ArrayList<>();

        do
        {
            journalRecordList.add(new SpecificJournal(
                        rs.getString("name"),
                        rs.getInt("study_group"),
                        rs.getString("pris_mark"),
                        rs.getInt("pris_attempts"),
                        rs.getString("sii_mark"),
                        rs.getInt("sii_attempts")
                    )
            );

        }
        while (rs.next());

        return journalRecordList;
    }
}
