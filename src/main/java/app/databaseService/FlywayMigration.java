package app.databaseService;

import org.flywaydb.core.Flyway;

public class FlywayMigration {
    public void initDb(String connectionUrl){
        Flyway flyway = Flyway
                .configure()
                .dataSource(connectionUrl, "", "")
                .load();
        flyway.migrate();
    }

    public static void main(String[] args) {
        Database db = Database.getInstance();
        FlywayMigration flywayMigration = new FlywayMigration();
        flywayMigration.initDb(db.getConnURL());
    }
}