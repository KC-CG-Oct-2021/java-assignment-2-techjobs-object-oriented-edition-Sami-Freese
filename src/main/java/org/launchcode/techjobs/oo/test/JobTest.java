package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    Job job_one;
    Job job_two;
    Job job_complete;
    Job job_incomplete;
    Job job_blank;

    @Before
    public void createJobOne() {
        job_one = new Job();
    }

    @Before
    public void createJobTwo() {
        job_two = new Job();
    }

    @Before
    public void createCompleteJob() {
        job_complete = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Before
    public void createIncompleteJob() {
        job_incomplete = new Job("Junior Dev", new Employer("Spredly"), new Location("Durham"), new PositionType("Developer"), new CoreCompetency());
    }

    @Before
    public void createBlankJob() {
        job_blank = new Job("", new Employer(), new Location(), new PositionType(), new CoreCompetency());
    }

    @Test
    public void testSettingJobID () {
        int idOne = job_one.getId();
        int idTwo = job_two.getId();
        assertNotEquals(idOne, idTwo);
        assertEquals(idTwo, idOne, 1);
    }

    @Test
    public void testJobConstructorSetsAllFields () {
        assert(job_complete.getName() instanceof String);
        assertEquals(job_complete.getName(), "Product tester");
        assert(job_complete.getEmployer() instanceof Employer);
        assertEquals(job_complete.getEmployer().toString(), "ACME");
        assert(job_complete.getLocation() instanceof  Location);
        assertEquals(job_complete.getLocation().toString(), "Desert");
        assert(job_complete.getPositionType() instanceof PositionType);
        assertEquals(job_complete.getPositionType().toString(), "Quality control");
        assert(job_complete.getCoreCompetency() instanceof CoreCompetency);
        assertEquals(job_complete.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobToStringSpacing () {
        assertEquals(job_complete.toString().charAt(0), '\n' );
        assertEquals(job_complete.toString().charAt(job_complete.toString().length() - 1), '\n');
    }

    @Test
    public void testJobStringContents () {
        assertTrue(job_complete.toString().contains("\nID:"));
        assertTrue(job_complete.toString().contains("\nName:"));
        assertTrue(job_complete.toString().contains("\nEmployer:"));
        assertTrue(job_complete.toString().contains("\nLocation:"));
        assertTrue(job_complete.toString().contains("\nPosition Type:"));
        assertTrue(job_complete.toString().contains("\nCore Competency:"));
    }

    @Test
    public void testJobStringIncomplete () {
        assertTrue(job_incomplete.toString().contains("Data not available"));
    }

    @Test
    public void testJobStringBlank() {
//        assertTrue(job_blank.getName().contains("Data not available"));
        assertTrue(job_blank.getEmployer().toString().contains("Data not available"));
        assertTrue(job_blank.getLocation().toString().contains("Data not available"));
        assertTrue(job_blank.getPositionType().toString().contains("Data not available"));
        assertTrue(job_blank.getCoreCompetency().toString().contains("Data not available"));
    }

    @Test
    public void testJobStringVoid() {
        assertEquals(job_blank.toString(), "OOPS! This job does not seem to exist.");
    }
}
