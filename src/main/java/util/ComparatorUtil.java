package util;

import comparator.*;
import enums.StudentComparatorType;
import enums.UniversityComparatorType;

import java.util.Comparator;

public class ComparatorUtil {
    public ComparatorUtil() {

    }
    public static StudentComparator getStudentComparator(StudentComparatorType studentComparatorType) {
        switch (studentComparatorType){
            case UNIVERSITY_ID:
                return new StudentUniversityIdCompare();
            case FULL_NAME:
                return new StudentFullNameComparator();
            case COURSE:
                return new StudentCourseComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            default:
                return new StudentFullNameComparator();
        }
    }

    public static UniversityComparator getUniversityComparator(UniversityComparatorType universityComparatorType){
        switch (universityComparatorType){
            case ID:
                return new UniversityIdComparator();
            case FULL_NAME:
                return new UniversityFullNameComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case PROFILE:
                return new UniversityProfileComparator();
            case YEAR:
                return new UniversityYearComparator();
            default:
                return new UniversityFullNameComparator();
        }
    }
}
