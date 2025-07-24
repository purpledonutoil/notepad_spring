package app.databaseService;


import app.note.NoteService;

import java.sql.SQLException;

public class DatabaseInitService{

    public static void main(String[] args) throws SQLException {
        Database db = Database.getInstance();
        FlywayMigration flywayMigration = new FlywayMigration();
        flywayMigration.initDb(db.getConnURL());
    }
}
