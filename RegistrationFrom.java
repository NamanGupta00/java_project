import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class RegistrationForm implements ActionListener {
    JFrame frame;
    String[] batch={"CS","CE","ME","EE"};
    JLabel nameLabel=new JLabel("Full Name");
    JLabel batchLabel=new JLabel("BATCH");
    JLabel bookNameLabel=new JLabel("Book Name");
    JLabel issuedDateLabel=new JLabel("Issued Date");
    JLabel returnDateLabel=new JLabel("Return Date");
    JLabel isbnLabel=new JLabel("ISBN");
    JLabel emailLabel=new JLabel("EMAIL");
    JTextField nameTF=new JTextField();
    JComboBox batchCB=new JComboBox(batch);
    JTextField bookNameTF=new JTextField();
    JTextField issuedDateTF=new JTextField();
    JTextField returnDateTF=new JTextField();
    JTextField isbnTF=new JTextField();
    JTextField emailTF=new JTextField();
    JButton resetButton=new JButton("RESET");
    JButton registerButton=new JButton("SUBMIT");
  

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
        batchLabel.setBounds(20,70,80,70);
        bookNameLabel.setBounds(20,120,100,70);
        issuedDateLabel.setBounds(20,170,100,70);
        returnDateLabel.setBounds(20,220,140,70);
        isbnLabel.setBounds(20,270,100,70);
        emailLabel.setBounds(20,320,100,70);
        nameTF.setBounds(180,43,165,23);
        batchCB.setBounds(180,93,165,23);
        bookNameTF.setBounds(180,143,165,23);
        issuedDateTF.setBounds(180,193,165,23);
        returnDateTF.setBounds(180,243,165,23);
        isbnTF.setBounds(180,293,165,23);
        emailTF.setBounds(180,343,165,23);
        resetButton.setBounds(70,400,100,35);
        registerButton.setBounds(220,400,100,35);
    }
    
    public void addComponentsToFrame()
    {
        frame.add(nameLabel);
        frame.add(batchLabel);
        frame.add(bookNameLabel);
        frame.add(issuedDateLabel);
        frame.add(returnDateLabel);
        frame.add(isbnLabel);
        frame.add(emailLabel);
        frame.add(nameTF);
        frame.add(batchCB);
        frame.add(bookNameTF);
        frame.add(issuedDateTF);
        frame.add(returnDateTF);
        frame.add(isbnTF);
        frame.add(emailTF);
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
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root");
                PreparedStatement Pstatement=connection.prepareStatement("insert into student1 values(?,?,?,?,?,?,?)");
                Pstatement.setString(1,nameTF.getText());
                Pstatement.setString(2,batchCB.getSelectedItem().toString());
                Pstatement.setString(3,bookNameTF.getText());
                Pstatement.setString(4,issuedDateTF.getText());
                Pstatement.setString(5,returnDateTF.getText());
                Pstatement.setString(6,isbnTF.getText());
                Pstatement.setString(7,emailTF.getText());
                int i=Pstatement.executeUpdate();
                JOptionPane.showMessageDialog(null,"Happy Study!");

            } catch (SQLException e1) {
                e1.printStackTrace();
            }


        }
        if(e.getSource()==resetButton)
        {
        	nameTF.setText("");
            batchCB.setSelectedItem("CS");
            bookNameTF.setText("");
            issuedDateTF.setText("");
            returnDateTF.setText("");
            isbnTF.setText("");
            emailTF.setText("");
        }

    }
}
