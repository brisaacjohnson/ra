package ung.mccb.csci.csci3300.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class Alumni {
    private String firstname;
    private String lastname;
    private String gradYear;
    private String major;
    private String email;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGradYear() {
        return gradYear;
    }

    public void setGradYear(String gradYear) {
        this.gradYear = gradYear;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public int saveRecord(){
        int affectedRow=0;
        String query = "insert into alumni" + "(firstname, lastname, gradyear, major, email)"
                + "values(?,?,?,?,?)";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement sqlStatement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);) {

            sqlStatement.setString(1, getFirstname());
            sqlStatement.setString(2, getLastname());
            sqlStatement.setString(3, getGradYear());
            sqlStatement.setString(4, getMajor());
            sqlStatement.setString(5, getEmail());



            // get the number of return rows
            affectedRow = sqlStatement.executeUpdate();



        } catch (Exception e) {
            System.out.println("Status: operation failed due to " + e);

        }


        return affectedRow;

    }

}
