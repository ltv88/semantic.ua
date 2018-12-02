package entity;

public class TableRow {

    private String name;
    private String status;
    private String notes;

    public TableRow(String name, String status, String notes){
        this.name = name;
        this.status = status;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getNotes() {
        return notes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString(){
        return "[ "+name+", "+status+", "+notes+" ]";
    }
}
