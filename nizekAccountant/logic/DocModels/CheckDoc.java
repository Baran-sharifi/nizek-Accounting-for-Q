package nizekAccountant.logic.DocModels;

import nizekAccountant.logic.Date.DateNizek;
import nizekAccountant.logic.Date.TimeNizek;
import nizekAccountant.logic.Login.Costumer;


public class CheckDoc {
    private Costumer costumer;
    private String cost;
    private String description;
    private DateNizek dateNizek;
    private TimeNizek timeNizek;
    private boolean isCashed;
    private String payee;
    private String filePath = "checkFile.csv";
    private String cashedFilePath = "cashedCheck.csv";
    private String notCashedFilePath = "notCashedCheck.csv";

    private final int userID;


    public CheckDoc(String cost, String description, DateNizek dateNizek, TimeNizek timeNizek, boolean isCashed, Costumer costumer) {
        this.cost = cost;
        this.description = description;
        this.dateNizek = dateNizek;
        this.timeNizek = timeNizek;
        this.isCashed = isCashed;
        this.costumer = costumer;
        userID = costumer.getID();
        payee = costumer.getName();
        isCashed = false;
    }
    public String getPayee() {
      return this.payee;
    }
    public  static String statusIsCashed(String checkStatus) {
      String status = "";
      if (checkStatus.equals("true")) {
          status = "وصول شده";
      } else {
          status = "وصول نشده";
      }
      return status;
    }

    public int getUserID() {
        return userID;
    }

    public boolean isCashed() {
        return isCashed;
    }
    
    
    

    public Costumer getUser() {
        return costumer;
    }

    public String getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public DateNizek getDate() {
        return dateNizek;
    }

    public TimeNizek getTime() {
        return timeNizek;
    }

    public String getFilePath() {
        return filePath;
    }

    public String getCashedFilePath() {
        return cashedFilePath;
    }

    public String getNotCashedFilePath() {
        return notCashedFilePath;
    }

    public String convertCashed(boolean isCashed) {
        String result ="";
        if (isCashed) {
            result = "وصول شده";
        } else {
            result = "وصول نشده";
        }
        return result;
    }

    public void setCostumer(Costumer costumer) {
        this.costumer = costumer;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateNizek(DateNizek dateNizek) {
        this.dateNizek = dateNizek;
    }

    public void setTimeNizek(TimeNizek timeNizek) {
        this.timeNizek = timeNizek;
    }

    public void setIsCashed(boolean isCashed) {
        this.isCashed = isCashed;
    }

    

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s",
                getUser().getName(),
                getCost(),
                getDescription(),
                convertCashed(isCashed()),
                getDate().toString(),
                getTime().toString());
    }
}
