package ua.stu.view;

import ua.stu.dao.*;
import ua.stu.entity.*;
import ua.stu.utils.HibernateSessionFactoryUtil;
import ua.stu.utils.PropertiesReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MainGui {
    private JRadioButton cardRadioButton;
    private JRadioButton patientRadioButton;
    private JRadioButton diseaseRadioButton;
    private JRadioButton departmentRadioButton;
    private JRadioButton doctorRadioButton;
    private JButton CREATEButton;
    private JButton UPDATEButton;
    private JButton DELETEButton;
    private JTextArea textArea1;
    private JPanel MainPanel;
    public JFrame frame;

    ButtonGroup buttonGroup = new ButtonGroup();

    public MainGui() {
        HibernateSessionFactoryUtil hibernate = new HibernateSessionFactoryUtil(new PropertiesReader());
        initialize();

    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(200, 200, 600, 400);
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(MainPanel);

        buttonGroup.add(cardRadioButton);
        buttonGroup.add(patientRadioButton);
        buttonGroup.add(departmentRadioButton);
        buttonGroup.add(diseaseRadioButton);
        buttonGroup.add(doctorRadioButton);

        CREATEButton.addActionListener(e -> {
            if(cardRadioButton.isSelected()){
                Card card = new Card();
                Doctor doctor = new Doctor();
                DoctorDao doctorDao = new DoctorDao();
                Patient patient = new Patient();
                PatientDao patientDao = new PatientDao();
                Disease disease = new Disease();
                DiseaseDao diseaseDao = new DiseaseDao();
                CardDao cardDao = new CardDao();
                int doctor_id, patient_id, disease_id;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    card.setReceipt_date(simpleDateFormat.parse(JOptionPane.showInputDialog(null, "Receipt date".trim())));
                    card.setDischarge_date(simpleDateFormat.parse(JOptionPane.showInputDialog(null, "Discharge date".trim())));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                /*doctor_id = Integer.parseInt(JOptionPane.showInputDialog(null, "Doctor's id".trim()));
                disease_id = Integer.parseInt(JOptionPane.showInputDialog(null, "Disease id".trim()));
                patient_id = Integer.parseInt(JOptionPane.showInputDialog(null, "Patient's id".trim()));
                doctor = doctorDao.getDoctor(doctor_id);
                disease = diseaseDao.getDisease(disease_id);
                patient = patientDao.getPatient(patient_id);
                card.setPatient(patient);
                card.setDisease(disease);
                card.setDoctor(doctor);*/
                cardDao.saveCard(card);
                textArea1.setText(cardDao.allCards());
            } else if(patientRadioButton.isSelected()){
                Patient patient = new Patient();
                PatientDao patientDao = new PatientDao();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                patient.setFirst_name(JOptionPane.showInputDialog(null, "Patient's first name"));
                patient.setLast_name(JOptionPane.showInputDialog(null, "Last name"));
                patient.setAddress(JOptionPane.showInputDialog(null, "Patient's address"));
                patient.setPhone_number(JOptionPane.showInputDialog(null, "Phone number"));
                patient.setStatus(JOptionPane.showInputDialog(null, "Patient's status"));
                try {
                    patient.setDate_of_birth(simpleDateFormat.parse(JOptionPane.showInputDialog(null, "Date of birth".trim())));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                patientDao.savePatient(patient);
                textArea1.setText(patientDao.allPatients());
            } else if(diseaseRadioButton.isSelected()){
                Disease disease = new Disease();
                DiseaseDao diseaseDao = new DiseaseDao();
                disease.setTitle(JOptionPane.showInputDialog(null, "Disease's title"));
                disease.setTreatment(JOptionPane.showInputDialog(null, "Treatment"));
                disease.setPrevention(JOptionPane.showInputDialog(null, "Prevention"));
                diseaseDao.saveDisease(disease);
                textArea1.setText(diseaseDao.allDiseases());
            }else if(departmentRadioButton.isSelected()){
                Department department = new Department();
                DepartmentDao departmentDao = new DepartmentDao();
                department.setTitle(JOptionPane.showInputDialog(null, "Title"));
                department.setCount_of_rooms(Integer.parseInt(JOptionPane.showInputDialog(null, "Count of rooms")));
                departmentDao.saveDepartment(department);
                textArea1.setText(departmentDao.allDepartments());
            }else if(doctorRadioButton.isSelected()){
                Doctor doctor = new Doctor();
                DoctorDao doctorDao = new DoctorDao();
                Department department = new Department();
                DepartmentDao departmentDao = new DepartmentDao();
                int department_id;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                doctor.setFirst_name(JOptionPane.showInputDialog(null, "First name"));
                doctor.setLast_name(JOptionPane.showInputDialog(null, "Last name"));
                doctor.setPosition(JOptionPane.showInputDialog(null, "Position"));
                department_id = Integer.parseInt(JOptionPane.showInputDialog(null, "Department id"));
                try {
                    doctor.setDate_of_birth(simpleDateFormat.parse(JOptionPane.showInputDialog(null, "Date of birth".trim())));
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                }
                department = departmentDao.getDepartment(department_id);
                doctor.setDepartment(department);
                doctorDao.saveDoctor(doctor);
                textArea1.setText(doctorDao.allDoctors());
            }else {
                JOptionPane.showMessageDialog(null, "Select a table");
            }
        });

        UPDATEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(cardRadioButton.isSelected()){
                    Card card = new Card();
                    CardDao cardDao = new CardDao();
                    Doctor doctor = new Doctor();
                    DoctorDao doctorDao = new DoctorDao();
                    Patient patient = new Patient();
                    PatientDao patientDao = new PatientDao();
                    Disease disease = new Disease();
                    DiseaseDao diseaseDao = new DiseaseDao();
                    int doctor_id, patient_id, disease_id;
                    textArea1.setText(cardDao.allCards());
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter id"));
                    card = cardDao.getCard(id);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    try {
                        card.setReceipt_date(simpleDateFormat.parse(JOptionPane.showInputDialog(null, "Receipt date".trim())));
                        card.setDischarge_date(simpleDateFormat.parse(JOptionPane.showInputDialog(null, "Discharge date".trim())));
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    doctor_id = Integer.parseInt(JOptionPane.showInputDialog(null, "Doctor's id".trim()));
                    disease_id = Integer.parseInt(JOptionPane.showInputDialog(null, "Disease id".trim()));
                    patient_id = Integer.parseInt(JOptionPane.showInputDialog(null, "Patient's id".trim()));
                    doctor = doctorDao.getDoctor(doctor_id);
                    disease = diseaseDao.getDisease(disease_id);
                    patient = patientDao.getPatient(patient_id);
                    card.setPatient(patient);
                    card.setDisease(disease);
                    card.setDoctor(doctor);
                    cardDao.updateCard(card);
                    textArea1.setText(cardDao.allCards());
                } else if(patientRadioButton.isSelected()){
                    Patient patient = new Patient();
                    PatientDao patientDao = new PatientDao();
                    textArea1.setText(patientDao.allPatients());
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter id"));
                    patient = patientDao.getPatient(id);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    patient.setFirst_name(JOptionPane.showInputDialog(null, "Patient's first name"));
                    patient.setLast_name(JOptionPane.showInputDialog(null, "Last name"));
                    patient.setAddress(JOptionPane.showInputDialog(null, "Patient's address"));
                    patient.setPhone_number(JOptionPane.showInputDialog(null, "Phone number"));
                    patient.setStatus(JOptionPane.showInputDialog(null, "Patient's status"));
                    try {
                        patient.setDate_of_birth(simpleDateFormat.parse(JOptionPane.showInputDialog(null, "Date of birth".trim())));
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    patientDao.updatePatient(patient);
                    textArea1.setText(patientDao.allPatients());
                } else if(diseaseRadioButton.isSelected()){
                    Disease disease = new Disease();
                    DiseaseDao diseaseDao = new DiseaseDao();
                    textArea1.setText(diseaseDao.allDiseases());
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter id"));
                    disease = diseaseDao.getDisease(id);
                    disease.setTitle(JOptionPane.showInputDialog(null, "Disease's title"));
                    disease.setTreatment(JOptionPane.showInputDialog(null, "Treatment"));
                    disease.setPrevention(JOptionPane.showInputDialog(null, "Prevention"));
                    diseaseDao.updateDisease(disease);
                    textArea1.setText(diseaseDao.allDiseases());
                }else if(departmentRadioButton.isSelected()){
                    Department department = new Department();
                    DepartmentDao departmentDao = new DepartmentDao();
                    textArea1.setText(departmentDao.allDepartments());
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter id"));
                    department = departmentDao.getDepartment(id);
                    department.setTitle(JOptionPane.showInputDialog(null, "Title"));
                    department.setCount_of_rooms(Integer.parseInt(JOptionPane.showInputDialog(null, "Count of rooms")));
                    departmentDao.updateDepartment(department);
                    textArea1.setText(departmentDao.allDepartments());
                }else if(doctorRadioButton.isSelected()){
                    Doctor doctor = new Doctor();
                    DoctorDao doctorDao = new DoctorDao();
                    Department department = new Department();
                    DepartmentDao departmentDao = new DepartmentDao();
                    int department_id;
                    textArea1.setText(doctorDao.allDoctors());
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter id"));
                    doctor = doctorDao.getDoctor(id);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    doctor.setFirst_name(JOptionPane.showInputDialog(null, "First name"));
                    doctor.setLast_name(JOptionPane.showInputDialog(null, "Last name"));
                    doctor.setPosition(JOptionPane.showInputDialog(null, "Position"));
                    department_id = Integer.parseInt(JOptionPane.showInputDialog(null, "Department id"));
                    try {
                        doctor.setDate_of_birth(simpleDateFormat.parse(JOptionPane.showInputDialog(null, "Date of birth".trim())));
                    } catch (ParseException parseException) {
                        parseException.printStackTrace();
                    }
                    department = departmentDao.getDepartment(department_id);
                    doctor.setDepartment(department);
                    doctorDao.updateDoctor(doctor);
                    textArea1.setText(doctorDao.allDoctors());
                }else {
                    JOptionPane.showMessageDialog(null, "Select a table");
                }
            }
        });

        DELETEButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(cardRadioButton.isSelected()){
                    Card card = new Card();
                    CardDao cardDao = new CardDao();
                    textArea1.setText(cardDao.allCards());
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter id"));
                    card = cardDao.getCard(id);
                    cardDao.deleteCard(card);
                    textArea1.setText(cardDao.allCards());
                } else if(patientRadioButton.isSelected()){
                    Patient patient = new Patient();
                    PatientDao patientDao = new PatientDao();
                    textArea1.setText(patientDao.allPatients());
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter id"));
                    patient = patientDao.getPatient(id);
                    patientDao.deletePatient(patient);
                    textArea1.setText(patientDao.allPatients());
                } else if(diseaseRadioButton.isSelected()){
                    Disease disease = new Disease();
                    DiseaseDao diseaseDao = new DiseaseDao();
                    textArea1.setText(diseaseDao.allDiseases());
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter id"));
                    disease = diseaseDao.getDisease(id);
                    diseaseDao.deleteDisease(disease);
                    textArea1.setText(diseaseDao.allDiseases());
                }else if(departmentRadioButton.isSelected()){
                    Department department = new Department();
                    DepartmentDao departmentDao = new DepartmentDao();
                    textArea1.setText(departmentDao.allDepartments());
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter id"));
                    department = departmentDao.getDepartment(id);
                    departmentDao.deleteDepartment(department);
                    textArea1.setText(departmentDao.allDepartments());
                }else if(doctorRadioButton.isSelected()){
                    Doctor doctor = new Doctor();
                    DoctorDao doctorDao = new DoctorDao();
                    textArea1.setText(doctorDao.allDoctors());
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter id"));
                    doctor = doctorDao.getDoctor(id);
                    doctorDao.deleteDoctor(doctor);
                    textArea1.setText(doctorDao.allDoctors());
                }else {
                    JOptionPane.showMessageDialog(null, "Select a table");
                }
            }
        });
    }
}
