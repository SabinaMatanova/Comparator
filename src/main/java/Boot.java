import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;
import io.XlsReader;
import io.XlsWriter;
import model.Statistics;
import model.Student;
import model.University;
import util.ComparatorUtil;
import util.JsonUtil;
import util.StatisticUtil;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Boot {

    private static final Logger logger = Logger.getLogger(Boot.class.getName());

    public static void main(String[] args) throws IOException {

        try {
            LogManager.getLogManager().readConfiguration(
                    Boot.class.getResourceAsStream("/logging.proprties"));
        } catch (IOException e){
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        logger.log(Level.INFO, "Application started, Logger configured");


        List<University> universities =
                XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        UniversityComparator universityComparator =
                ComparatorUtil.getUniversityComparator(UniversityComparatorType.YEAR);
        universities.sort(universityComparator);

        List<Student> students =
                XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        StudentComparator studentComparator =
                ComparatorUtil.getStudentComparator(StudentComparatorType.AVG_EXAM_SCORE);
        students.sort(studentComparator);


        List<Statistics> statisticsList = StatisticUtil.creatStatistics(students, universities);
        XlsWriter.writeXlsStatistics(statisticsList, "statistics.xlsx");

        logger.log(Level.INFO, "Application finished");

    }
}
