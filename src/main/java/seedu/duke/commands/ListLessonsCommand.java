package seedu.duke.commands;

import seedu.duke.exceptions.CommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.commands.DeleteLessonCommand.getLessonName;
import static seedu.duke.common.Messages.MESSAGE_LESSONS_FOR_MODULE_FORMAT;
import static seedu.duke.common.Messages.MESSAGE_PRINT_LESSONS_FORMAT;

public class ListLessonsCommand extends Command {

    public ListLessonsCommand() {
        Module module = ModuleList.getSelectedModule();
        String moduleCode = module.getModuleCode();
        System.out.println(String.format(MESSAGE_LESSONS_FOR_MODULE_FORMAT, moduleCode));
    }

    @Override
    public void execute(UI ui) throws CommandException {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Lesson> lessonList = module.getLessonList();
        printLessonsFromList(lessonList);
    }

    @Override
    public boolean isExit() {
        return false;
    }

    public static void printLessonsFromList(ArrayList<Lesson> lessonList) {
        int counter = 1;
        for (Lesson lesson : lessonList) {
            String lessonName = getLessonName(lesson);
            String lessonTime = lesson.getTime();
            String lessonOnlineLink = lesson.getOnlineLink();
            String teacherName = lesson.getTeachingStaff().getName();
            String teacherEmail = lesson.getTeachingStaff().getEmail();
            System.out.print(String.format(MESSAGE_PRINT_LESSONS_FORMAT, counter, lessonName, lessonTime,
                    lessonOnlineLink, teacherName, teacherEmail));
            counter++;
        }
    }
}
