package com.company;


import java.util.Scanner;
class admin
{
    private static final String Username = "admin"; //defining admin username
    private static final String Password = "123"; // defining admin passcode

    static boolean status=false;
    public void login()
    {
        System.out.print("Please Enter Username : ");
        Scanner in = new Scanner(System.in);
        String UN = in.nextLine(); // getting Username from the user
        System.out.print("Please Enter Password : ");
        Scanner inn = new Scanner(System.in);
        String PW = inn.nextLine(); // getting password from the user
        if (UN.equals(Username) && PW.equals(Password)) // checking the validity using if condition
        {
            status=true;
            System.out.println("\nLogin Successful !\n");
        }
        else {
            System.out.println("\nIncorrect Username or Password !\n");
        }
    }
    boolean mark()
    {
        return status;
    }
}
class doctor
{
    String did, dname, specilist, appoint, doc_qual; // used to define string type variables
    int droom; // used to define integer type doctor room varaible
    void doctor_info() // void is used to not to return a value
    {
        System.out.println(did + "\t" + dname + "  \t" + specilist + "     \t" + appoint + "  " +
                "  \t" + doc_qual + "       \t" + droom);
    }
}
class patient
{
    String pusername,passcode; // regular string is used to define patient user credentials variables
    String pid, pname, disease, sex, admit_status; // patient details
    int age;               // integer age
    void new_patient()
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Patient Id (Eg: 23) :- ");
        pid = input.nextLine();
        System.out.print("Enter Patient Name :- ");
        pname = input.nextLine();
        System.out.print("Enter Patient Disease :- ");
        disease = input.nextLine();
        System.out.print("Enter Patient Sex (Male/Female):- ");
        sex = input.nextLine();
        System.out.print("Enter Patient Age :- ");
        age = input.nextInt();
        input.nextLine();
        System.out.print("\n*** SET USERNAME AND PASSWORD ***\n\n");
        System.out.print("Enter Patient Username :- ");
        pusername = input.nextLine();
        System.out.print("Enter Patient Password :- ");
        passcode = input.nextLine();
    }
    void patient_info()
    {
        System.out.println(pid + "\t" + pname + " \t" + disease + "     \t" + sex + "     " +
                " \t" + age + "\t" + pusername);
    }
}
class NursingManagement
{
    static int back=1;
    public static void main(String[] args)
    {
        int count1 = 2, count2 = 2;
        System.out.println("\n--------------------------------------------------------------------------------");
        System.out.println("            *** Welcome to the Nursing Home Doctor Appointment System ***");
        System.out.println("--------------------------------------------------------------------------------");
        doctor[] d = new doctor[25]; // it defines number maximum size of the doctor array
        patient[] p = new patient[100]; // it defines number maximum size of the patient array
        int i;
        for (i = 0; i < 25; i++) d[i] = new doctor();
        for (i = 0; i < 100; i++) p[i] = new patient();
        d[0].did = "21";
        d[0].dname = "Dr.Kusal";
        d[0].specilist = "ENT";
        d[0].appoint = "5-11AM";
        d[0].doc_qual = "MBBS,MD";
        d[0].droom = 17;
        d[1].did = "32";
        d[1].dname = "Dr.Mendis";
        d[1].specilist = "Physician";
        d[1].appoint = "10-3AM";
        d[1].doc_qual = "MBBS,MD";
        d[1].droom = 45;
        p[0].pid = "12";
        p[0].pname = "Niroshan dickwella";
        p[0].disease = "Cancer";
        p[0].sex = "Male";
        p[0].age = 30;
        p[0].pusername = "niro";
        p[0].passcode = "fox1";
        p[1].pid = "13";
        p[1].pname = "Danushka Gunathilake";
        p[1].disease = "Cold";
        p[1].sex = "Male";
        p[1].age = 23;
        p[1].pusername = "gune";
        p[1].passcode = "daniel1";
        Scanner input = new Scanner(System.in);
        int choice, j, status = 1, s1 = 1;
        String logname,logpass;
        while (status == 1)
        {
            System.out.println("\n                                   LOGIN AS");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.println("             [1] Administrator                       [2] Patient");
            System.out.println("-----------------------------------------------------------------------------------");
            System.out.print("Enter Selection : ");
            choice = input.nextInt();
            System.out.println();
            switch (choice)
            {
                case 1:
                {
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("                     ** ADMINISTRATOR LOGIN **");
                    System.out.println("--------------------------------------------------------------------------------");
                    admin obj=new admin();
                    obj.login();
                    if (obj.mark())
                    {
                        s1=1;
                        while(s1==1)
                        {
                            System.out.println("\n[1] Add/Remove Patients\n[2] View Existing Patients\n[3] View Doctors list\n\n");
                            System.out.print("Enter Selection : ");
                            int select=input.nextInt();
                            System.out.println();
                            s1=1;
                            switch(select)
                            {
                                case 0: System.out.println("\n\n*** EXIT FROM ADMINISTRATOR PRIVILEGES  ***\n\n");back=0;break;
                                case 1:
                                {
                                    p[count2].new_patient();count2=count2+1;
                                    break;
                                }
                                case 2:
                                {
                                    System.out.println("--------------------------------------------------------------------------------");
                                    System.out.println("id \t Name \t Disease       Gender           Age   Username \t");
                                    System.out.println("--------------------------------------------------------------------------------");
                                    for (j = 0; j < count2; j++) {
                                        p[j].patient_info();
                                    }
                                    break;
                                }
                                case 3:
                                {
                                    System.out.println("--------------------------------------------------------------------------------");
                                    System.out.println("id \t Name          Specilist        Timing        Qualification \t Room No.");
                                    System.out.println("--------------------------------------------------------------------------------");
                                    for (int z = 0; z < count1; z++)
                                    {
                                        d[z].doctor_info();
                                    }
                                    break;
                                }
                            }
                            System.out.println("\nPress [1] to Go Back and [0] to Main Menu");
                            s1 = input.nextInt();
                        }
                    }
                    break;
                }
                case 2: // for patient selection
                {
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("                     ** PATIENT LOGIN **");
                    System.out.println("--------------------------------------------------------------------------------");
                    System.out.println("*** Login to refer booking status ***");
                    System.out.print("Go Back Press [1]\n\n");
                    Scanner t= new Scanner(System.in);
                    boolean con=true;
                    while(con==true)
                    {
                        System.out.print("Enter your User Name : ");
                        logname=t.nextLine();
                        System.out.print("Enter your Password : ");
                        logpass=t.nextLine();
                        if(logname=="1")
                        {
                            con=false;
                        }
                        System.out.println("\n** Your Login Details ** \n");
                        for (int z=0;z<100;z++){
                            if(logname.equals(p[z].pusername) && logpass.equals(p[z].passcode)){

                                System.out.println("--------------------------------------------------------------------------------");
                                System.out.println("id \t Name \t Disease       Gender           Age   Username \t");
                                System.out.println("--------------------------------------------------------------------------------");
                                System.out.println(p[z].pid + "\t" + p[z].pname + " \t" + p[z].disease + "     \t" + p[z].sex + "      \t" + p[z].age + "\t" + p[z].pusername);
                                con=false;
                            }
                        }
                    }
                }
            }
            System.out.println("\nReturn to Main Menu Press [1]");
            status = input.nextInt();
        }
    }
}


