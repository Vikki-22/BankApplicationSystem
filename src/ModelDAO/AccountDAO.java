package ModelDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import Entity.account;
import Entity.patients;
import modelsDAO.DBUtil;


public class AccountDAO {

    Connection con;
    PreparedStatement pst=null;
	PreparedStatement pst2=null;

    //Add Account
    public void AddAccount(account a) {

       
        try {
            con = DBUtil.makeConnection();

            String query = "insert into account(name, accountNumber, pin, balance) values(?,?,?,?)";

            pst = con.prepareStatement(query);

            pst.setString(1, a.getName());
            pst.setString(2, a.getAccountNumber());
            pst.setString(3, a.getPin());
            pst.setDouble(4, a.getBalance());

            int i= pst.executeUpdate();

            if (i > 0) {
                
                System.out.println("Account Added Successfully...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    //Delete Account
    public void DeleteAccount(account a){
        try {
            con = DBUtil.makeConnection();

            String query = "delete from account where accountNumber =?";

            pst = con.prepareStatement(query);

            pst.setString(1, a.getAccountNumber());
            
            int i= pst.executeUpdate();

            if (i > 0) {
                
                System.out.println("Account Deleted Successfully...");
            }
            else {
            	System.out.println("you enter the wrong account number...");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Transfer Amount
    
    public static void TransferAmount()
    {
        Connection con = DBUtil.makeConnection();

        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;

        Scanner sc = new Scanner(System.in);

        int debitid;
        int creditid;
        double amount;

        System.out.print("Enter Debit Account ID : ");
        debitid = sc.nextInt();

        System.out.print("Enter Credit Account ID : ");
        creditid = sc.nextInt();

        System.out.print("Enter Amount : ");
        amount = sc.nextDouble();

        try {

            con.setAutoCommit(false);

            // Debit
            pst1 = con.prepareStatement(
                "update account set balance = balance - ? where id = ?"
            );

            pst1.setDouble(1, amount);
            pst1.setInt(2, debitid);

            // Credit
            pst2 = con.prepareStatement(
                "update account set balance = balance + ? where id = ?"
            );

            pst2.setDouble(1, amount);
            pst2.setInt(2, creditid);

            int i = pst1.executeUpdate();

            int j = pst2.executeUpdate();

            if(i != 0 && j != 0)
            {
                con.commit();

                System.out.println("Transaction Successfully...");
            }
            else
            {
                con.rollback();

                System.out.println("Something Went Wrong...");
            }

        } catch (Exception e) {

            try {

                if(con != null)
                {
                    con.rollback();
                }

            } catch (SQLException e1) {

                e1.printStackTrace();
            }

            e.printStackTrace();
        }
    }    
    // Deposite Amount
    
    public static void DepositAmount(account a)
    {
        Connection con = DBUtil.makeConnection();

        PreparedStatement pst1 = null;

        Scanner sc = new Scanner(System.in);

        double amount;

        System.out.println("Enter Deposit Amount : ");
        amount = sc.nextDouble();

        try {

            con.setAutoCommit(false);

            pst1 = con.prepareStatement(
                "update account set balance = balance + ? where id = ?"
            );

            pst1.setDouble(1, amount);

            pst1.setInt(2, a.getId());

            int i = pst1.executeUpdate();

            if(i != 0)
            {
                con.commit();

                System.out.println("Deposit Successfully...");
            }
            else
            {
                con.rollback();

                System.out.println("Something Went Wrong...");
            }

        }
        catch (Exception e)
        {
            try {

                if(con != null)
                {
                    con.rollback();
                }

            } catch (SQLException e1) {

                e1.printStackTrace();
            }

            e.printStackTrace();
        }
    }
    
    // Withdraw Amount
    
    public static void WithdrawAmount(account a)
    {
        Connection con = DBUtil.makeConnection();

        PreparedStatement pst1 = null;

        Scanner sc = new Scanner(System.in);

        double amount;

        System.out.println("Enter Withdraw Amount : ");

        amount = sc.nextDouble();

        try {

            con.setAutoCommit(false);

            if(a.getBalance() <= amount)
            {

                pst1 = con.prepareStatement(
                    "update account set balance = balance - ? where id = ?"
                );

                pst1.setDouble(1, amount);

                pst1.setInt(2, a.getId());

                int i = pst1.executeUpdate();

                if(i != 0)
                {
                    con.commit();

                    System.out.println("Withdraw Successfully...");
                }
                else
                {
                    con.rollback();

                    System.out.println("Something Went Wrong...");
                }
            }
            else
            {
                System.out.println("Insufficient Balance...");
            }

        }
        catch (Exception e)
        {
            try {

                if(con != null)
                {
                    con.rollback();
                }

            } catch (SQLException e1) {

                e1.printStackTrace();
            }

            e.printStackTrace();
        }
    }
    
    
// Change Pin
    
    public static void PinChange(account a)
    {
        Connection con = DBUtil.makeConnection();

        PreparedStatement pst1 = null;

        Scanner sc = new Scanner(System.in);

        String newpin;

        System.out.println("Enter New Pin : ");

        newpin = sc.next();

        try {

            con.setAutoCommit(false);

            pst1 = con.prepareStatement(
                "update account set pin = ? where id = ?"
            );

            pst1.setString(1, newpin);

            pst1.setInt(2, a.getId());

            int i = pst1.executeUpdate();

            if(i != 0)
            {
                con.commit();

                System.out.println("Pin Changed Successfully...");
            }
            else
            {
                con.rollback();

                System.out.println("Something Went Wrong...");
            }

        }
        catch (Exception e)
        {
            try {

                if(con != null)
                {
                    con.rollback();
                }

            } catch (SQLException e1) {

                e1.printStackTrace();
            }

            e.printStackTrace();
        }
    }
    
   
    
    // View Account Holder Details

    public static void ViewAccountHolder(account a)
    {
        Connection con = DBUtil.makeConnection();

        PreparedStatement pst = null;

        ResultSet rs = null;

        try {

            pst = con.prepareStatement(
                "select * from account where id = ?"
            );

            pst.setInt(1, a.getId());

            rs = pst.executeQuery();

            if(rs.next())
            {
                System.out.println("\n===== Account Details =====");
                System.out.println("ID : " + rs.getInt("id"));
                System.out.println("Name : " + rs.getString("name"));
                System.out.println("Account Number : " + rs.getString("accountNumber"));
                System.out.println("Pin : " + rs.getString("pin"));
                System.out.println("Balance : " + rs.getDouble("balance"));
            }
            else
            {
                System.out.println("Account Not Found...");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
    
    // view all account holder details....
    public List<account> ViewAlldata()
    {
        List<account> list = new LinkedList<>();

        try {

            Connection con = DBUtil.makeConnection();

            PreparedStatement pst = con.prepareStatement(
                "select * from account"
            );

            ResultSet rs = pst.executeQuery();

            while(rs.next())
            {
                list.add( new account(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("accountNumber"),
                        rs.getString("pin"),
                        rs.getDouble("balance")));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return list;
    }
    
}