package util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Student;
import model.University;

import java.util.List;

public class JsonUtil {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    //запрещаем создание экземпляра класса
    private JsonUtil() {
        throw new AssertionError("У этого класса не может быть создан экземпляр.");
    }
    //сериализация студента в Json
    public static String studentToJson (Student student){
        return gson.toJson(student);
    }
    //сериализация университета в Json
    public static String universityToJson (University university){
        return gson.toJson(university);
    }
    //десериализация json в студента
    public static Student jsonToStudent (String json){
        return gson.fromJson(json, Student.class);
    }
    //десериализация json в университет
    public static University jsonToUniversity (String json){
        return gson.fromJson(json, University.class);
    }
    //сериализация списка студентов в Json
    public static String studentListToJson (List<Student> student){
        return gson.toJson(student);
    }
    //сериализация списка университетов в Json
    public static String universityListToJson (List<University> university){
        return gson.toJson(university);
    }
    //десериализация json в лист студентов
    public static List<Student> jsonToStudentList (String json){
        return gson.fromJson(json, new TypeToken<List<Student>>(){} .getType() );
    }
    //десериализация json в лист университетов
    public static List<University> jsonToUniversityList (String json){
        return gson.fromJson(json, new TypeToken<List<University>>(){}.getType());
    }

}
