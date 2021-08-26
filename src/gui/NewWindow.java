package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.WindowEvent;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NewWindow {
    private JFrame frame;
    private JLabel lb_title;
    private JPanel container;

    // Form
    private JPanel formPanel;
    private JPanel formLabels;
    private JPanel formInputs;

    private JLabel lb_name;
    private JTextField tf_name;

    private JLabel lb_address;
    private JTextField tf_address;

    private JLabel lb_category;
    private JComboBox<String> cb_category;

    private JLabel lb_gender;
    private ButtonGroup btng_gender;
    private JRadioButton rb_male;
    private JRadioButton rb_female;
    private JPanel gender_panel;

    // obs
    private JLabel lb_obs;
    private JTextArea ta_obs;
    private JScrollPane sp_obs;

    // password
    private JLabel lb_password;
    private JPasswordField pf_password;

    // image
    private JPanel panel2;
    private JLabel image;

    // buttons
    private JPanel buttonsPanel;
    private JButton btn_save;
    private JButton btn_cancel;

    public NewWindow() {
        beforeAll();
        // header
        lb_title = new JLabel("Registro de Clientes");
        lb_title.setFont(new Font("Arial", Font.ITALIC, 36));
        lb_title.setForeground(Color.BLUE);
        frame.add("North", lb_title);

        // form

        // panels setup
        formPanel = new JPanel();
        formLabels = new JPanel();
        formInputs = new JPanel();

        formPanel.setLayout(new BorderLayout(10, 0));
        formLabels.setLayout(new GridLayout(6, 1, 10, 10));
        formInputs.setLayout(new GridLayout(6, 1, 10, 10));

        formPanel.setSize(400, 300);
        formPanel.add("West", formLabels);
        formPanel.add("Center", formInputs);

        // name
        lb_name = new JLabel("Nome: ");
        tf_name = new JTextField();

        formLabels.add(lb_name);
        formInputs.add(tf_name);

        // address
        lb_address = new JLabel("Endereço: ");
        tf_address = new JTextField();

        formLabels.add(lb_address);
        formInputs.add(tf_address);

        // category
        lb_category = new JLabel("Categoria: ");
        String[] options = { "Corporate", "Advanced", "Enterprise" };
        cb_category = new JComboBox<String>(options);

        formLabels.add(lb_category);
        formInputs.add(cb_category);

        // gender
        lb_gender = new JLabel("Gênero:");
        rb_male = new JRadioButton("Masculino");
        rb_female = new JRadioButton("Feminino", true);
        btng_gender = new ButtonGroup();
        btng_gender.add(rb_male);
        btng_gender.add(rb_female);
        gender_panel = new JPanel();
        gender_panel.setLayout(new GridLayout(1, 2, 5, 10));

        formLabels.add(lb_gender);
        gender_panel.add(rb_female);
        gender_panel.add(rb_male);
        formInputs.add(gender_panel);

        // obs
        lb_obs = new JLabel("Obs: ");
        ta_obs = new JTextArea();
        sp_obs = new JScrollPane(ta_obs);
        formLabels.add(lb_obs);
        formInputs.add(sp_obs);

        // password
        lb_password = new JLabel("Password: ");
        pf_password = new JPasswordField();
        pf_password.setEchoChar('#');
        formLabels.add(lb_password);
        formInputs.add(pf_password);

        // image
        panel2 = new JPanel();
        image = new JLabel(new ImageIcon("background.jpeg"));
        panel2.add(image);

        // center
        container = new JPanel();
        container.setLayout(new GridLayout(0, 2, 10, 0));
        container.add(formPanel);
        container.add(panel2);
        frame.add("Center", container);

        // buttons
        btn_save = new JButton("Gravar");
        btn_cancel = new JButton("Cancelar");

        btn_save.setBackground(Color.GREEN);
        btn_cancel.setBackground(Color.RED);

        buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        buttonsPanel.add(btn_save);
        buttonsPanel.add(btn_cancel);

        btn_save.addActionListener(e -> handleSave());

        btn_cancel.addActionListener((e) -> {
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        });

        frame.add("South", buttonsPanel);

        afterAll();
    }

    private void beforeAll() {
        frame = new JFrame();
        frame.setSize(600, 400);
        frame.setTitle("Clientes");
        frame.setLayout(new BorderLayout());
    }

    private void afterAll() {
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    private void handleSave() {
        // String gender = btng_gender.getSelection().
        String name = tf_name.getText();
        String address = tf_address.getText();
        String category = (cb_category.getSelectedItem().toString());
        String obs = ta_obs.getText();
        String password = pf_password.getText();

        System.out.println("name: " + name);
        System.out.println("address: " + address);
        System.out.println("category: " + category);
        System.out.println("obs: " + obs);
        System.out.println("password: " + password);
    }

}
