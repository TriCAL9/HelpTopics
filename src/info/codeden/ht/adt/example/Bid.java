package info.codeden.ht.adt.example;


public interface Bid {

    /**
     * The name of bidding company who create this bid
     * @returns the name of the bidding company
     */
    String getBidder();

    /**
     * Accesses the description of the unit that a company
     * has a bid to install.
     * @return the AC unit description as String
     */
    String getUnitDescription();

    /**
     * Accesses the bid's AC unit performance detail placed by
     * the company.
     * @return performance of the unit String
     */
    String getUnitPerformance();

    /**
     * Accesses the cost of th AC unit for the bid made by the company.
     * @return the AC unit's cost in a float
     */
    Float getCostOfUnit();

    /**
     * Accesses the cost of installation for the AC unit by the company.
     * @return the installation cost of AC unit in a float
     */
    Float getCostOfInstallation();

    /**
     *
     * @param newUnitDescription
     * @param newUnitPerformance
     * @param newUnitCost
     * @param newInstallationCost
     * @return
     */
    Bid newBid(String newUnitDescription, String newUnitPerformance
    , float newUnitCost, float newInstallationCost);
}
