package peaksoft;

import org.hibernate.Session;
import peaksoft.entity.Student;
import peaksoft.util.HibernateUtil;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
//        HibernateUtil.getSession();
//        Student student=new Student("Mishel","Obama","Java",45);
//        create(student);
//        System.out.println(getById(3));
//        getAllStudents();
//        for (Student student:getAllStudents()
//        ) {
//            System.out.println(student);
//        }
        delete(4);

    }
    public static int create(Student student) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        session.save(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully added : " + student);
        return student.getId();
    }

    public static Student getById(int id){
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Student student=session.get(Student.class,id);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    public static List<Student> getAllStudents() {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        List<Student> studentList = session.createQuery("from Student ").getResultList();
        session.getTransaction().commit();
        System.out.println("Finded: " + studentList.size() + " students ");
        return studentList;
    }

    public static void delete(int id) {
        Session session = HibernateUtil.getSession().openSession();
        session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        session.getTransaction().commit();
        session.close();
        System.out.println("Successfully deleted " + student);
    }
}
