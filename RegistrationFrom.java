import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class RegistrationForm implements ActionListener {
    JFrame frame;
    String[] dept={"CS","EC","CIVIL","IT"};
    JLabel nameLabel=new JLabel("NAME");
    JLabel deptLabel=new JLabel("DEPT");
    JLabel bookNameLabel=new JLabel("BOOKNAME");
    JLabel dateIssuedLabel=new JLabel("DATE ISSUED");
    JLabel returnDateLabel=new JLabel("RETURN DATE");
    JLabel isbnLabel=new JLabel("ISBN NO");
    JLabel emailLabel=new JLabel("EMAIL");
    JTextField nameTextField=new JTextField();
    JComboBox deptComboBox=new JComboBox(dept);
    JTextField cityTextField=new JTextField();
    JTextField dateIssuedField=new JTextField();
    JTextField returnDateTextField=new JTextField();
    JTextField isbnTextField=new JTextField();
    JTextField emailTextField=new JTextField();
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");


    RegistrationForm()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(40,40,380,600);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
        nameLabel.setBounds(20,20,40,70);
        deptLabel.setBounds(20,70,80,70);
        bookNameLabel.setBounds(20,120,100,70);
        dateIssuedLabel.setBounds(20,170,100,70);
        returnDateLabel.setBounds(20,220,140,70);
        isbnLabel.setBounds(20,270,100,70);
        emailLabel.setBounds(20,320,100,70);
        nameTextField.setBounds(180,43,165,23);
        deptComboBox.setBounds(180,93,165,23);
        cityTextField.setBounds(180,143,165,23);
        dateIssuedField.setBounds(180,193,165,23);
        returnDateTextField.setBounds(180,243,165,23);
        isbnTextField.setBounds(180,293,165,23);
        emailTextField.setBounds(180,343,165,23);
        registerButton.setBounds(70,400,100,35);
        resetButton.setBounds(220,400,100,35);
    }
    public void addComponentsToFrame()
    {
        frame.add(nameLabel);
        frame.add(deptLabel);
        frame.add(bookNameLabel);
        frame.add(dateIssuedLabel);
        frame.add(returnDateLabel);
        frame.add(isbnLabel);
        frame.add(emailLabel);
        frame.add(nameTextField);
        frame.add(deptComboBox);
        frame.add(cityTextField);
        frame.add(dateIssuedField);
        frame.add(returnDateTextField);
        frame.add(isbnTextField);
        frame.add(emailTextField);
        frame.add(registerButton);
        frame.add(resetButton);
    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==registerButton)
        {
            try {
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase","root","root");
                PreparedStatement Pstatement=connection.prepareStatement("insert into student values(?,?,?,?,?,?,?)");
                Pstatement.setString(1,nameTextField.getText());
                Pstatement.setString(2,deptComboBox.getSelectedItem().toString());
                Pstatement.setString(3,cityTextField.getText());
                Pstatement.setString(4,dateIssuedField.getText());
                Pstatement.setString(5,returnDateTextField.getText());
                Pstatement.setString(6,isbnTextField.getText());
                Pstatement.setString(7,emailTextField.getText());
                System.out.println("Connected With the database successfully");
                } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        if(e.getSource()==resetButton)
        {
            nameTextField.setText("");
            deptComboBox.setSelectedItem("CS");
            cityTextField.setText("");
            dateIssuedField.setText("");
            returnDateTextField.setText("");
            isbnTextField.setText("");
            emailTextField.setText("");
        }

    }
}
