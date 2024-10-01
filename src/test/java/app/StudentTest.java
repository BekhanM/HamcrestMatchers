package app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student s1, s2, s3;

    @BeforeEach
    void setUp() {
        s1 = new Student("Bekhan", 23, 4.0);
        s2 = new Student("Otto", 23, 2.0);
        s3 = new Student("Lars", 43, 20.0);

        s1.addFriend(s2);
        s1.addFriend(s3);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getName() {
        String expectedName = s1.getName();
        assertEquals("Bekhan", expectedName);
        assertThat(expectedName, is("Bekhan"));
    }

    @Test
    void getAge() {
        assertThat(s1.getAge(), greaterThanOrEqualTo(23));
    }

    @Test
    void getFriends() {
        List<Student> friendsOfBekhan = s1.getFriends();

        assertThat(friendsOfBekhan, hasSize(2));
        assertThat(friendsOfBekhan, containsInAnyOrder(s2, s3));
    }

    @Test
    void addFriend() {
        Student s4 = new Student("Tom Cruise", 22, 3.0);
        s1.addFriend(s4);

        List<Student> friendsOfBekhan = s1.getFriends();
        assertThat(friendsOfBekhan, hasSize(3));
        assertThat(friendsOfBekhan, hasItem(s4));
    }

    @Test
    void addFriend2() {
        Student s4 = new Student("Tom Cruise", 22, 3.0);

        assertThat(s2.getFriends(), empty());

        s2.addFriend(s4);

        assertThat(s2.getFriends(), hasSize(1));
        assertThat(s2.getFriends(), hasItem(s4));
    }

}
