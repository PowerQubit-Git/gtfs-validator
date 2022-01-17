package tml.centralapi.validatormain.model;

public class TableResume {
    private String tableName;
    private String tableStatus;

    public TableResume() {
    }

    public TableResume(String tableName, String tableStatus) {
        this.tableName = tableName;
        this.tableStatus = tableStatus;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(String tableStatus) {
        this.tableStatus = tableStatus;
    }
}
