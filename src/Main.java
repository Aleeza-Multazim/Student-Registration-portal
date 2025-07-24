import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
class Registration implements ActionListener {
    JFrame frame = new JFrame("Registration_From");
    JLabel NameLabel = new JLabel("Name");
    JTextField NameTextField = new JTextField();
    JLabel PhoneLabel = new JLabel("Phone_No");
    JTextField PhoneField = new JTextField();

    JLabel DepartLabel = new JLabel("Department");
    JTextField DepartField = new JTextField();

    JLabel emailLabel = new JLabel("Email");

    JTextField emailField = new JTextField();

    JLabel GenderLabel = new JLabel("Gender");

    JRadioButton R1 = new JRadioButton("Male");


    JRadioButton R2 = new JRadioButton("Female");




    JButton Submitbutton = new JButton("Submit");
    JButton insertbutton = new JButton("Insert");
    JButton updatebutton = new JButton("Update");

    JButton deletebutton = new JButton("Delete");

    Registration() {
        frame.setSize(500, 400);
        frame.setLocationRelativeTo(null);
        frame.getContentPane().setLayout(new GridLayout(15, 2, 10, 10));
        frame.setResizable(false);

        NameLabel.setBounds(40, 120, 100, 50);
        NameLabel.setFont(new Font("Arial", Font.BOLD, 17));

        PhoneLabel.setBounds(40, 190, 100, 50);
        PhoneLabel.setFont(new Font("Arial", Font.BOLD, 17));

        DepartLabel.setBounds(40, 260, 100, 50 );
        DepartLabel.setFont(new Font("Arial", Font.BOLD, 17));

       NameTextField.setBounds(180, 135, 150, 25);
        NameTextField.setFont(new Font("Arial", Font.BOLD, 15));

        PhoneField.setBounds(180, 200, 150, 25);
        PhoneField.setFont(new Font("Arial", Font.BOLD, 15));

        DepartField.setBounds(180,265,150,15);
        DepartField.setFont(new Font("Arial", Font.BOLD, 15));



        insertbutton.setBounds(40, 280, 130, 35);
        insertbutton.setFont(new Font("Arial", Font.BOLD, 15));
        insertbutton.setBackground(Color.magenta);
        insertbutton.setFocusable(false);

        Submitbutton.setBounds(40, 280, 130, 35);
        Submitbutton.setFont(new Font("Arial", Font.BOLD, 15));
        Submitbutton.setBackground(Color.green);
        Submitbutton.setFocusable(false);

        updatebutton.setBounds(40, 280, 130, 35);
        updatebutton.setFont(new Font("Arial", Font.BOLD, 15));
        updatebutton.setBackground(Color.YELLOW);
        updatebutton.setFocusable(false);

        deletebutton.setBounds(40, 280, 130, 35);
        deletebutton.setFont(new Font("Arial", Font.BOLD, 15));
        deletebutton.setBackground(Color.pink);
        deletebutton.setFocusable(false);


        frame.add(NameLabel);
        frame.add(NameTextField);
        frame.add(PhoneLabel);
        frame.add(PhoneField);
        frame.add(DepartLabel);
        frame.add(DepartField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(GenderLabel);
        frame.add(R1);
        frame.add(R2);


        frame.add(Submitbutton);
        frame.add(insertbutton);
        frame.add(updatebutton);
        frame.add(deletebutton);


        Submitbutton.addActionListener(this);
        insertbutton.addActionListener(this);
        updatebutton.addActionListener(this);
        deletebutton.addActionListener(this);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Submitbutton) {


            //creation

            try {
                String driver = "com.mysql.cj.jdbc.Driver";
                String databaseurl = "jdbc:mysql://localhost:3306/login_form";
                String UN = "root";
                String PS = "aleeza12345";
                String Name = NameTextField.getText();
                String Phone_No = PhoneField.getText();
                String Department = DepartField.getText();
                String Email = emailField.getText();
                String Gender = "";
                if(R1.isSelected()){
                    Gender="Male";
                } else if (R2.isSelected()) {
                    Gender="Female";
                }
                Connection c = DriverManager.getConnection(databaseurl, "root", "aleeza12345");
                System.out.println("Connected to selected database");

                Statement stmt = c.createStatement();
                //stmt.executeUpdate("Drop table if exists person");
                //System.out.println("Table created");

                stmt.executeUpdate("CREATE TABLE login_form(Name VARCHAR(50), Phone_No int not null, Department VARCHAR(50), Email VARCHAR(225), Gender VARCHAR(25))");
                JOptionPane.showMessageDialog(null, "Table created successfully");

            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        //insertion

            if (e.getSource() == insertbutton){

                try {
                    String driver = "com.mysql.cj.jdbc.Driver";
                    String databaseurl = "jdbc:mysql://localhost:3306/login_form";
                    String UN = "root";
                    String PS = "aleeza12345";
                    String Name = NameTextField.getText();
                    String Phone_No = PhoneField.getText();
                    String Department = DepartField.getText();
                    String Email = emailField.getText();
                    String Gender = "";
                    if(R1.isSelected()){
                        Gender="Male";
                    } else if (R2.isSelected()) {
                        Gender="Female";
                    }
                    Connection c = DriverManager.getConnection(databaseurl, "root", "aleeza12345");
                    System.out.println("Connected to selected database");

                    PreparedStatement insertStatement = c.prepareStatement("INSERT INTO login_form(Name, Phone_No, Department, Email, Gender) VALUES (?, ?, ?, ?, ?)");
                    insertStatement.setString(1, String.valueOf(Name));
                    insertStatement.setInt(2, Integer.valueOf(Phone_No));
                    insertStatement.setString(3, String.valueOf(Department));
                    insertStatement.setString(4, String.valueOf(Email));
                    insertStatement.setString(5, String.valueOf(Gender));
                    insertStatement.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Record inserted successfully");

                } catch (SQLException ex) {
                    System.out.println(ex);
                }
        }
//upgradation

            if (e.getSource() == updatebutton){

                try {
                    String driver = "com.mysql.cj.jdbc.Driver";
                    String databaseurl = "jdbc:mysql://localhost:3306/login_form";
                    String UN = "root";
                    String PS = "aleeza12345";
                    String Name = NameTextField.getText();
                    String Phone_No = PhoneField.getText();
                    String Department = DepartField.getText();
                    String Email = emailField.getText();
                    String Gender = "";
                    if(R1.isSelected()){
                        Gender="Male";
                    } else if (R2.isSelected()) {
                        Gender="Female";
                    }
                    Connection c = DriverManager.getConnection(databaseurl, UN, PS);
                    System.out.println("Database Connected");

                    PreparedStatement updateStatement = c.prepareStatement("UPDATE login_form SET Name= ?, Phone_No = ?, Department = ? WHERE Email = ?");
                    updateStatement.setString(1, String.valueOf(Name));
                    updateStatement.setInt(2, Integer.valueOf(Phone_No));
                    updateStatement.setString(3, String.valueOf(Department));
                    updateStatement.setString(4, String.valueOf(Email));
                    //updateStatement.setString(5, String.valueOf(Gender));


                    updateStatement.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Record updated successfully");

                } catch (SQLException ex) {
                    System.out.println(ex);
                }
        }
        //deletion
       {
            if (e.getSource() == deletebutton)
      try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String databaseurl= "jdbc:mysql://localhost:3306/login_form";
            String UN="root";
            String PS="aleeza12345";
          String Name = NameTextField.getText();
          String Phone_No = PhoneField.getText();
          String Department = DepartField.getText();
          String Email = emailField.getText();
          String Gender = "";
          if(R1.isSelected()){
              Gender="Male";
          } else if (R2.isSelected()) {
              Gender="Female";
          }
            Connection c = DriverManager.getConnection(databaseurl, UN, PS);
            System.out.println("Database Connected");

            PreparedStatement deleteStatement = c.prepareStatement("Delete from login_form WHERE Email = ?");
            deleteStatement.setString(1, String.valueOf(Email));

            // Provide the appropriate Email for the record you want to delete
            deleteStatement.executeUpdate();

            JOptionPane.showMessageDialog(null, "Record deleted successfully");

        } catch (SQLException ex) {
            System.out.println(ex);
        }


        }
    }
}
class miss {
    public static void main(String[] args)
    {
        Registration Ri = new Registration();
    }
}
