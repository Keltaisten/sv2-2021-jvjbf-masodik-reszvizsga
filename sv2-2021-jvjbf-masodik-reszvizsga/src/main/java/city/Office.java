package city;

public class Office extends Building {
    private String company;
    private int numberOfTablesPerLevel;

    public Office(int area, int levels, Address address, String company, int numberOfTablesPerLevel) {
        super(area, levels, address);
        this.company = company;
        if(checkIfHaveEnoughSpaceForTables(numberOfTablesPerLevel)){
            this.numberOfTablesPerLevel = numberOfTablesPerLevel;
        }
    }

    private boolean checkIfHaveEnoughSpaceForTables(int numberOfTablesPerLevel) {
        boolean isItOk = false;
        int areForTablesNeeded = getArea() / numberOfTablesPerLevel;
        if( areForTablesNeeded >= 2 && areForTablesNeeded <= 5){
            isItOk =true;
        }
        else{
            throw new IllegalArgumentException("Not the proper amount of space for the tables!");
        }
        return isItOk;
    }

    @Override
    public int calculateNumberOfPeopleCanFit() {
        return (getLevels() - 1) * numberOfTablesPerLevel;
    }

    public String getCompany() {
        return company;
    }

    public int getNumberOfTablesPerLevel() {
        return numberOfTablesPerLevel;
    }
}
