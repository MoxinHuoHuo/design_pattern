package com.moxin.design_pattern.principle.demeter;



public class Boss {

    public void commandCheckNumber(TeamLeader teamLeader) {

        teamLeader.checkNumberOfCourses();
    }

}
