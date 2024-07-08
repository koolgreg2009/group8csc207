package entity;

import java.time.LocalDateTime;

public class Adoption {

    private final Integer userID;
    private final Integer petID;
    private final LocalDateTime adoptionDate;
    private final String ownerContract;
    private final String userContract;

    Adoption(Integer userID, Integer petID, LocalDateTime adoptionDate, String ownerContract, String userContract) {
        this.userID = userID;
        this.petID = petID;
        this.adoptionDate = adoptionDate;
        this.ownerContract = ownerContract;
        this.userContract = userContract;

    }

    @Override
    public Integer getUserID() { return userID; }

    @Override
    public Integer getPetID() { return petID; }

    @Override
    public LocalDateTime getAdoptionDate() { return adoptionDate; }

    @Override
    public String getOwnerContract() { return ownerContract; }

    @Override
    public String getUserContract() { return userContract; }

}
