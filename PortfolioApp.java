import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PortfolioApp{
    static class Person{
        String name;
        String email;
        String phone;
        List<String> skills;
        List<String> achievements;
        public Person(String name, String email, String phone, List<String> skills, List<String> achievements){
            this.name = name;
            this.email = email;
            this.phone = phone;
            this.skills = skills;
            this.achievements = achievements;
        }
    }
    static Scanner scc = new Scanner(System.in);
    static List<Person> records = new ArrayList<>(); 
    public static void main(String[] args){
        System.out.println("Welcome to the Portfolio App");
        boolean adding = true;
        while(adding){
            addRecord();
            System.out.println("Do you want to add the another record?(y or n):");
            String ch = scc.nextLine().trim().toLowerCase();
            if(!ch.equals("y") && !ch.equals("yes")){
                adding = false;
            }
        }
        System.out.println("Adding records successfull.....");
        displayAllRecords();
        System.out.println("Thanks for using the Portfolio App");
    }
    static void addRecord(){
        System.out.println("Enter Name:");
        String name = scc.nextLine().trim();
        String email = "";
        while(true){
            System.out.println("Enter Email:");
            email = scc.nextLine().trim();
            if(validEmail(email))break;
            System.out.println("Invalid email....Re-Enter..");
        }
        String phone="";
        while(true){
            System.out.println("Enter Phone:");
            phone = scc.nextLine().trim();
            if(validPhone(phone))break;
            System.out.println("invalid Phone number...Re-Enter..");
        }      
        String skills;
        System.out.println("Enter Skills(comma separate):");
        skills = scc.nextLine().trim();
        List<String> skill = ConvertToList(skills);
        String achievements="";
        System.out.println("Enter Achievements(comma separate):");
        achievements = scc.nextLine().trim();
        List<String> achievement =  ConvertToList(achievements);
        Person p = new Person(name, email, phone, skill, achievement);
        records.add(p);
        System.out.println(name+"'s record saved....");
    }
    static void displayAllRecords(){
        int c=1;
        if(records.isEmpty()){
            System.out.println("No records available...");
            return;
        }
        for(Person p:records){
            for(int i=0;i<50;i++){
                System.err.print("*");
            }
            System.out.println();
            System.out.println("Record of "+c);
            c++;
            displaySinglePerson(p);
        }
        for(int i=0;i<50;i++){
                System.err.print("*");
        }
        System.out.println();
    }
    static void displaySinglePerson(Person p){
        System.out.println("\nPersonal Details");
        System.out.println("----------------");
        System.out.println("Name : " + (p.name.isEmpty() ? "-" : p.name));
        System.out.println("Email: " + p.email);
        System.out.println("Phone: " + p.phone);

        System.out.println("\nSkills");
        System.out.println("------");
        if (p.skills.isEmpty()) {
            System.out.println("- None -");
        } else {
            for (int i = 0; i < p.skills.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, p.skills.get(i));
            }
        }

        System.out.println("\nAchievements");
        System.out.println("------------");
        if (p.achievements.isEmpty()) {
            System.out.println("- None -");
        } else {
            for (int i = 0; i < p.achievements.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, p.achievements.get(i));
            }
        }
        System.out.println();
    }
    static boolean validEmail(String email){
        if(email==null)return false;
        int idx = email.indexOf('@');
        if(idx<=0)return false;
        if(email.indexOf('@',idx+1)!=-1)return false;
        return true;
    }
    static boolean validPhone(String phone){
        if(phone==null || phone.length()<10 || phone.length()>10 )return false;
        for(char c:phone.toCharArray()){
            if(!Character.isDigit(c))return false;
        }
        return true;
    }
    static List<String> ConvertToList(String content){
        List<String> list = new ArrayList<>();
        if(content==null || content.trim().isEmpty())return list;
        String []data = content.split(",");
        for(String str:data){
            String t = str.trim();
            list.add(t);
        }
        return list;
    }
}