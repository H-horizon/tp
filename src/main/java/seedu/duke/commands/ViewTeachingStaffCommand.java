package seedu.duke.commands;

import seedu.duke.exceptions.CommandException;
import seedu.duke.lesson.Lesson;
import seedu.duke.module.Module;
import seedu.duke.module.ModuleList;
import seedu.duke.ui.UI;

import java.util.ArrayList;

import static seedu.duke.common.Messages.MESSAGE_PRINT_LESSONS_TEACHING_STAFF_FORMAT;
import static seedu.duke.common.Messages.MESSAGE_VIEW_TEACHING_STAFF_FOR_MODULE_FORMAT;

public class ViewTeachingStaffCommand extends Command {

    public ViewTeachingStaffCommand() {
        Module module = ModuleList.getSelectedModule();
        String moduleCode = module.getModuleCode();
        System.out.println(String.format(MESSAGE_VIEW_TEACHING_STAFF_FOR_MODULE_FORMAT, moduleCode));
    }

    @Override
    public void execute(UI ui) throws CommandException {
        Module module = ModuleList.getSelectedModule();
        ArrayList<Lesson> lessonList = module.getLessonList();
        int counter = 1;
        for (Lesson lesson : lessonList) {
            String teacherName = lesson.getTeachingStaff().getName();
            String teacherEmail = lesson.getTeachingStaff().getEmail();
            System.out.print(String.format(MESSAGE_PRINT_LESSONS_TEACHING_STAFF_FORMAT, counter, teacherName,
                    teacherEmail));
            counter++;
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
